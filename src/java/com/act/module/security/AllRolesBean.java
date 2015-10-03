/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.module.security;

import bb.common.BizBoxServer;
import bb.common.Configure;
import bb.common.RoleListResult;
import bb.gui.ServerActionException;
import bb.gui.server.ServerActionUtil;
import com.act.module.login.LoginConstants;
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
public class AllRolesBean {
    private RoleListResult selectedRole;
    private List<RoleListResult> allRoles;
    private RoleDataModel roleDataModel;
    /**
     * Creates a new instance of AllRolesBean
     */
    public AllRolesBean() {
        loadRoles();
        roleDataModel = new RoleDataModel(allRoles);
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

    public RoleListResult getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(RoleListResult selectedRole) {
        this.selectedRole = selectedRole;
    }
        
    private void loadRoles() {
        Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        BizBoxServer server = (BizBoxServer) sessionMap.get(LoginConstants.SERVER_INSTANCE);
        String lang  = (String)sessionMap.get(LoginConstants.SELECTED_LANGUAGE);
        Object param [] = {lang,0,50};
        ServerActionUtil.setTargetServer(server);
        try {           
            allRoles = (List<RoleListResult>) ServerActionUtil.invoke(Configure.Module.SECURITY, "findAllRoles", param);
        } 
        catch (ServerActionException ex) {
            Logger.getLogger(AddUserBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage("Error!", new FacesMessage(ex.getMessage()));
        }
    }
    
    public void update() {
        
    }
    public void delete() {
        
    }
    
    public void reload() {
        
    }
    
}
