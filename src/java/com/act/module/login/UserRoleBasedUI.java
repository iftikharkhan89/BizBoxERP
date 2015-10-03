/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.module.login;

import com.act.util.BizBoxClientUtil;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author iftikhar
 * This class is a container class for holding the List of UI Interfaces associated with Login User Roles.
 */
@ManagedBean
@SessionScoped
public class UserRoleBasedUI {
    
    private List<String> UIList;
    private static UserRoleBasedUI instance;
    /**
     * 
     */
    private UserRoleBasedUI(){
        
    }
    /**
     * 
     * @param session
     * @return 
     */
    public static List<String> getUserRoleBasedUI(Map session){
        
        if (instance == null){
            instance = new UserRoleBasedUI();
            // First check if it is already exists in session, otherwise get from server.
            String [] roles = (String[])session.get(LoginConstants.USER_ROLE_BASED_UI);
            if (roles == null) {
                roles = BizBoxClientUtil.getUserRoleFromServer(session);
            }
            List<String> listOfUI = BizBoxClientUtil.getUIRoleBasedMapping(roles);
            instance.setUIList(listOfUI);
            return instance.getUIList();
        }
        else {
            return instance.getUIList();
        }
    }
    /**
     * 
     * @return 
     */
    private List<String> getUIList() {
        return UIList;
    }
    /**
     * 
     * @param UIList 
     */
    private void setUIList(List<String> UIList) {
        this.UIList = UIList;
    }
    
}
