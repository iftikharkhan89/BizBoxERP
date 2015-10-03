/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.module.security;

import bb.common.BizBoxServer;
import bb.common.BizboxUserVO;
import bb.common.Configure;
import bb.common.RoleListResult;
import bb.gui.ServerActionException;
import bb.gui.server.ServerActionUtil;
import com.act.module.login.LoginConstants;
import java.io.Serializable;
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
public class AddUserBean implements Serializable{

    private BizboxUserVO user;
    private String confirmPassword;
    private BizboxUserVO currentUser;
    private RoleListResult [] userRoles;
    private List<RoleListResult> allRoles;
    private RoleDataModel roleDataModel;
    
   // private Map sessionMap;
    
    private boolean edit;
    /**
     * Creates a new instance of AddUserBean
     */
    public AddUserBean() {
            user = new BizboxUserVO();
            currentUser = user;
            //userRoles = new ArrayList<RoleListResult>();
            loadRoles();
            roleDataModel = new RoleDataModel(allRoles);
           // userRoles = new RoleListResult[allRoles.size()];
    }

    public BizboxUserVO getUser() {
        return user;
    }

    public void setUser(BizboxUserVO user) {
        this.user = user;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public BizboxUserVO getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(BizboxUserVO currentUser) {
        this.currentUser = currentUser;
    }

    public RoleListResult [] getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(RoleListResult []  userRoles) {
        this.userRoles = userRoles;
    }
    
    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public List<RoleListResult> getAllRoles() {
        return allRoles;
    }

    public void setAllRoles(List<RoleListResult> allRoles) {
        this.allRoles = allRoles;
    }

    public RoleDataModel getRoleDataModel() {
        return roleDataModel;
    }

    public void setRoleDataModel(RoleDataModel roleDataModel) {
        this.roleDataModel = roleDataModel;
    }
         
    public String addUser(){
        
        Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        BizBoxServer server = (BizBoxServer) sessionMap.get(LoginConstants.SERVER_INSTANCE);
        if (server != null) {
            try {
                ServerActionUtil.setTargetServer(server);
                Object params [] = {user};
                BizboxUserVO userVO = (BizboxUserVO) ServerActionUtil.invoke(Configure.Module.SECURITY, "addUser", params);
                if (userVO != null) {
                    setCurrentUser(currentUser);
                    addRolesToUser(server);
                    FacesContext.getCurrentInstance().addMessage("Info!!", new FacesMessage("New User is Created!!!"));
                }
                return "addUserSuccess";
            } catch (ServerActionException ex) {
                Logger.getLogger(AddUserBean.class.getName()).log(Level.SEVERE, null, ex);
                return "addUserfailure";
            }
        }
       return "addUserfailure";       
    }
    
    private void addRolesToUser(BizBoxServer server) {
        ServerActionUtil.setTargetServer(server);
        if (userRoles != null) {
            for (int index = 0; index < userRoles.length; index++) {
                RoleListResult role = userRoles[index];
                Object param [] = {role.RoleId,currentUser.getUserName()};
                try {
                    ServerActionUtil.invoke(Configure.Module.SECURITY, "addRoleToUser", param);
                } catch (ServerActionException ex) {
                    Logger.getLogger(AddUserBean.class.getName()).log(Level.SEVERE, null, ex);
                    FacesContext.getCurrentInstance().addMessage("Error!!", new FacesMessage(ex.getMessage()));
                }           
            }
       }
    }
    
    public String reset() {        
        return "cancel";
    }
    
    public void validate(){
        if (!getConfirmPassword().equals(user.getPassword())) {
            FacesContext.getCurrentInstance().addMessage("Validation Error", new FacesMessage("Password & Confirm Password fields do not match!!!."));
        }
    }
    
    private void findUserById(String userId) {
        
    }
    
    private void loadRoles() {
        Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        BizBoxServer server = (BizBoxServer) sessionMap.get(LoginConstants.SERVER_INSTANCE);
        String lang  = (String)sessionMap.get(LoginConstants.SELECTED_LANGUAGE);
        Object param2 [] = {lang,0,50};
        ServerActionUtil.setTargetServer(server);
        try {           
            allRoles = (List<RoleListResult>) ServerActionUtil.invoke(Configure.Module.SECURITY, "findAllRoles", param2);
        } catch (ServerActionException ex) {
            Logger.getLogger(AddUserBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage("Error!", new FacesMessage(ex.getMessage()));
        }
    }
    private void refresh() {
        
    }
}
