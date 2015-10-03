/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.module.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author iftikhar
 */
@ManagedBean
@RequestScoped
public class LogoutBean {

    /**
     * Creates a new instance of LogoutBean
     */
    public LogoutBean() {
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "logout";
    }
}
