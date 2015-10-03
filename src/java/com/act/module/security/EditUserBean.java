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
public class EditUserBean {

    private BizboxUserListResult currentUser;
    /**
     * Creates a new instance of EditUserBean
     */
    public EditUserBean() {
      Object id =   FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("userId");
      if (id != null) {
          findUserInBizBox(id.toString());
      }
    }

    public BizboxUserListResult getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(BizboxUserListResult currentUser) {
        this.currentUser = currentUser;
    }
    
    private void findUserInBizBox(String userId) {
        Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        BizBoxServer server = BizBoxClientUtil.getServerInstanceFromSession(sessionMap);
        if (server != null) {
            ServerActionUtil.setTargetServer(server);
             Object [] param = {userId,0,5};
             Object result;
            try {
                result = ServerActionUtil.invoke(Configure.Module.SECURITY, "findUsersByUserName", param);
                List<BizboxUserListResult> userList = (java.util.List<BizboxUserListResult>)result;
                
                if (userList != null && !userList.isEmpty()) {
                    currentUser = userList.get(0);
                }
            } catch (ServerActionException ex) {
                Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
                
            }           
        }
    }
    
    private void loadUserRoles() {
        
    }
}
