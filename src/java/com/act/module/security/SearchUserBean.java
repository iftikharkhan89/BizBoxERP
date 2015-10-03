/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.module.security;

import bb.common.BizBoxServer;
import bb.common.BizboxUserListResult;
import bb.common.Configure;
import bb.gui.ServerActionException;
import bb.gui.server.ServerActionUtil;
import com.act.menu.beans.security.UserBean;
import com.act.menu.beans.security.UserDataModel;
import com.act.util.BizBoxClientUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author iftikhar
 */
@ManagedBean
@RequestScoped
public class SearchUserBean {

    private String search;
    private String searchBy;
    private List<BizboxUserListResult> filteredUsers;   
    private List<BizboxUserListResult> users;   
    private BizboxUserListResult selectedUser;  
    private UserDataModel userDataModel;
    private String showSearch;
    /**
     * Creates a new instance of SearchUserBean
     */
    public SearchUserBean() {
        users = new ArrayList<BizboxUserListResult>();
        showSearch = "hidden";
    }

    public void searchUser() {
        if (searchBy != null) {
            this.showSearch = "visible";
            if (searchBy.equalsIgnoreCase("EMPLOYEEID")) {
                List<BizboxUserListResult> userVOs =  populateUsersFromServer("findUsersByEmployeeId");
                userDataModel = new UserDataModel(userVOs);
            }
            else if (searchBy.equalsIgnoreCase("USERNAME")) {
                List<BizboxUserListResult> userVOs =  populateUsersFromServer("findUsersByUserName");
                userDataModel = new UserDataModel(userVOs);
            }
        }
        else {
            this.showSearch = "hidden";
        }
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
    
    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
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

    public List<BizboxUserListResult> getUsers() {
        return users;
    }

    public UserDataModel getUserDataModel() {
        return userDataModel;
    }

    public String getShowSearch() {
        return showSearch;
    }
 
    private List<BizboxUserListResult> populateUsersFromServer(String method) {           
        Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        BizBoxServer server = BizBoxClientUtil.getServerInstanceFromSession(sessionMap);
        if (server != null) {
            ServerActionUtil.setTargetServer(server);
             Object [] param = {search,0,100};
             Object result;
            try {
                result = ServerActionUtil.invoke(Configure.Module.SECURITY, method, param);
                List<BizboxUserListResult> userList = (java.util.List<BizboxUserListResult>)result;
                return userList;
            } catch (ServerActionException ex) {
                Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }           
        }
        return null;
    }
    
    public void refresh() {
        searchUser();
    }
    
    public void delete() {
        if (selectedUser != null){
            Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            BizBoxServer server = BizBoxClientUtil.getServerInstanceFromSession(sessionMap);
            if (server != null) {
                ServerActionUtil.setTargetServer(server);
                Object [] param = {selectedUser.getUserName()};
                try {
                     ServerActionUtil.invoke(Configure.Module.SECURITY, "deleteUser", param);
                    } 
                catch (ServerActionException ex) {
                    Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
                }           
        }
      }
        else {
             // Error Message to select a user from table
             FacesContext.getCurrentInstance().addMessage("Error!!", new FacesMessage("Please select a User!!!"));
        }  
    }
}
