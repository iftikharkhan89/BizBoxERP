/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.menu.beans.security;

import bb.common.BizBoxServer;
import bb.common.BizboxUserListResult;
import bb.common.Configure;
import bb.gui.ServerActionException;
import bb.gui.server.ServerActionUtil;
import com.act.core.classes.NavigationConstants;
import com.act.util.BizBoxClientUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author iftikhar
 */
@ManagedBean
@RequestScoped
public class UserBean implements Serializable { 
    private List<BizboxUserListResult> filteredUsers;   
    private List<BizboxUserListResult> users;   
    private BizboxUserListResult selectedUser;  
    private UserDataModel userDataModel;
  
    public UserBean() {  
        users = new ArrayList<BizboxUserListResult>();  
        List<BizboxUserListResult> userVOs =  populateUsersFromServer("findAllUsers");
        userDataModel = new UserDataModel(userVOs);
    }  
  
    public BizboxUserListResult getSelectedUser() {  
        return selectedUser;  
    }  
  
    public void setSelectedUser(BizboxUserListResult selectedUser) {  
        this.selectedUser = selectedUser;  
    }  
     
    public List<BizboxUserListResult> getFilteredUsers() {  
        return filteredUsers;  
    }  
  
    public void setFilteredUsers(List<BizboxUserListResult> filteredUsers) {  
        this.filteredUsers = filteredUsers;  
    }  
  
    public List<BizboxUserListResult> getUsers() {  
        return users;  
    }

    public UserDataModel getUserDataModel() {
        return userDataModel;
    }

    public void setUsers(List<BizboxUserListResult> users) {
        this.users = users;
    }

    public void setUserDataModel(UserDataModel userDataModel) {
        this.userDataModel = userDataModel;
    }
    
    private List<BizboxUserListResult> populateUsersFromServer(String method) {           
        Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        BizBoxServer server = BizBoxClientUtil.getServerInstanceFromSession(sessionMap);
        if (server != null) {
            ServerActionUtil.setTargetServer(server);
             Object [] param = {0,100};
             Object result;
            try {
                result = ServerActionUtil.invoke(Configure.Module.SECURITY, "findAllUsers", param);
                List<BizboxUserListResult> userList = (java.util.List<BizboxUserListResult>)result;
                return userList;
            } catch (ServerActionException ex) {
                Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }           
        }
        return null;
    }
    
    public void edit(){
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(NavigationConstants.LEFT_TAB, 0);
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(NavigationConstants.TOP_TAB, 1);
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("userId", this.selectedUser.getUserName());
        Navigate("edituser");       
    }
    
    public void delete() {
        
    }
    
    public void  refresh() {
        List<BizboxUserListResult> userVOs =  populateUsersFromServer("findAllUsers");
        userDataModel = new UserDataModel(userVOs);
    }
    
    private void Navigate(String navCase) {
        FacesContext fctx = FacesContext.getCurrentInstance();
        Application application = fctx.getApplication();
         NavigationHandler navHandler = application.getNavigationHandler();
         navHandler.handleNavigation(fctx,null, navCase);
    }
}
