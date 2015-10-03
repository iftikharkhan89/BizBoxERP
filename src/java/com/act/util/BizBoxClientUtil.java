/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.util;

import bb.common.BizBoxServer;
import bb.common.Configure;
import bb.common.RoleListResult;
import bb.gui.ServerActionException;
import bb.gui.server.ServerActionUtil;
import com.act.db.entity.Roleuirel;
import com.act.module.login.LoginConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;

/**
 *
 * @author iftikhar
 */
public class BizBoxClientUtil {
   
    /**
     * 
     * @param sessionMap
     * @return 
     */
    public static BizBoxServer getServerInstanceFromSession(Map sessionMap){
        return (BizBoxServer) sessionMap.get(LoginConstants.SERVER_INSTANCE);
    }
    /**
     * 
     * @param sessionMap
     * @return 
     */
    public static String getUserFromSession(Map sessionMap) {       
        return (String)sessionMap.get(LoginConstants.USER_NAME);
    }
    /**
     * 
     * @param session
     * @return 
     */
    public static String [] getUserRoleFromServer(Map session) {
        BizBoxServer server = getServerInstanceFromSession(session);
        if (server != null) {
            ServerActionUtil.setTargetServer(server);
            try {
                    Object [] param = new Object[3];
                    param[0] = "en";
                    param[1] = 0;
                    param[2] = 100;
                    Object result = ServerActionUtil.invoke(Configure.Module.SECURITY, "findRolesBySelf", param);
                    java.util.Collection<RoleListResult> userRolesList = (java.util.Collection<RoleListResult>)result;
                    String roleIds [] = new String[userRolesList.size()];
                    int index = 0;
                    for (RoleListResult r:userRolesList){
                        roleIds[index] = r.getRoleId();
                        index++;
                    }
                 return roleIds;
                } catch (ServerActionException ex) {
                        Logger.getLogger(BizBoxClientUtil.class.getName()).log(Level.SEVERE, null, ex);
                        return null;
                }
        }
        else {
            return null;
        }       
    }
    /**
     * 
     * @param roleIds
     * @return 
     */
    public static List<String> getUIRoleBasedMapping(String [] roleIds) {
        List<String> uiList = new ArrayList<String>();
        for (String roleId:roleIds) {
            List<String> uiInterfaces = getMappingFromDB(roleId);
            uiList.addAll(uiInterfaces);
        }       
        uiList = addWithNoDuplicateUI(uiList);
        return uiList;
    }
    /**
     * 
     * @param roleId
     * @return 
     */
    private static List<String> getMappingFromDB(String roleId) {
        Query query  =   EntityManagerHelper.getEntityManager().createQuery("SELECT s from Roleuirel s where s.roleuirelPK.roleId = :roleId").setParameter("roleId", roleId);
        List<Roleuirel> result = query.getResultList();
        List<String> interfaceIds = new ArrayList<String>();
        for (Roleuirel rel:result) {
            String interfaceId = rel.getRoleuirelPK().getUiinterfaceId();
            interfaceIds.add(interfaceId);
        }
        return interfaceIds;
    }
    /**
     * 
     * @param UIList
     * @return 
     */
    private static List<String> addWithNoDuplicateUI(List<String> UIList) {
        List<String> filteredList = new ArrayList<String>();
        for (String s:UIList) {
            if (!filteredList.contains(s)) {
                filteredList.add(s);
            }
        }
     return filteredList;
    }
}
