/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.util;

import bb.common.BizBoxServer;
import bb.gui.ServerActionException;
import bb.gui.server.ServerActionUtil;
import com.act.module.engineering.partmaster.AddPartMasterBean;
import com.act.module.login.LoginConstants;
import com.act.module.security.AddUserBean;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iftikhar.Khan
 */
public class BizboxAPIHelper {
    
    public static Object invokeAPI(Map sessionMap,String module,String method,Object param[]){
      BizBoxServer server = (BizBoxServer) sessionMap.get(LoginConstants.SERVER_INSTANCE);
      ServerActionUtil.setTargetServer(server);      
        if (server != null) {
            try {         
                    Object returnedObject = ServerActionUtil.invoke(module, method, param);
                    return returnedObject;
                } 
            catch (ServerActionException ex) {
                    Logger.getLogger(AddUserBean.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                 
            } catch (Exception ex) {
                Logger.getLogger(AddPartMasterBean.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return null;
    }
}
