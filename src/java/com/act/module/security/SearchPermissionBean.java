/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.module.security;

import bb.common.BizBoxServer;
import bb.common.Configure;
import bb.common.PermissionVO;
import bb.gui.ServerActionException;
import bb.gui.server.ServerActionUtil;
import com.act.util.BizBoxClientUtil;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author iftikhar
 */
@ManagedBean
@RequestScoped
public class SearchPermissionBean {

    /**
     * Creates a new instance of SearchPermissionBean
     */
    public SearchPermissionBean() {
        showResult = "hidden";
    }
    
    private String permissionId;
    private List<PermissionVO> allPermissions;
    private PermissionVO selectedPermission;
    private String showResult;
    private PermissionDataModel permissionDataModel;

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public List<PermissionVO> getAllPermissions() {
        return allPermissions;
    }

    public void setAllPermissions(List<PermissionVO> allPermissions) {
        this.allPermissions = allPermissions;
    }

    public PermissionVO getSelectedPermission() {
        return selectedPermission;
    }

    public void setSelectedPermission(PermissionVO selectedPermission) {
        this.selectedPermission = selectedPermission;
    }

    public String getShowResult() {
        return showResult;
    }

    public void setShowResult(String showResult) {
        this.showResult = showResult;
    }

    public PermissionDataModel getPermissionDataModel() {
        return permissionDataModel;
    }

    public void setPermissionDataModel(PermissionDataModel permissionDataModel) {
        this.permissionDataModel = permissionDataModel;
    }
    
   public void searchPermissions() {
        String searchMethod = null;
        Object [] param;
        if (permissionId == null || permissionId.equals("")) {
            searchMethod = "findAllPermission";
            param = new Object[3];
            param[0] = true;
            param[1] = 0;
            param[2] = 1000;
        }
        else {
            searchMethod = "findPermissionsById";
            param = new Object[4];
            param[0] = this.permissionId;
            param[1] = "en";
            param[2] = 0;
            param[3] = 10;
        }
            List<PermissionVO> permissionVos = null;
            permissionVos = getPermissionListFromServer(searchMethod,param);
            permissionDataModel = new PermissionDataModel(permissionVos);
            showResult = "visible";
    }
    
    private List<PermissionVO> getPermissionListFromServer(String methodName,Object[] param) {
        Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        BizBoxServer server = BizBoxClientUtil.getServerInstanceFromSession(sessionMap);
        if (server != null) {
            ServerActionUtil.setTargetServer(server);
             Object result;
            try {
                result = ServerActionUtil.invoke(Configure.Module.SECURITY, methodName, param);
                List<PermissionVO> permissionsList = (java.util.List<PermissionVO>)result;
                return permissionsList;
            } catch (ServerActionException ex) {
                Logger.getLogger(SearchPermissionBean.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }           
        }
        return null;
    }
    
}
