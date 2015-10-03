/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.menu.beans.security;

import com.act.core.classes.NavigationConstants;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author iftikhar
 */
@ManagedBean
@RequestScoped
public class SecurityPanelBean {
    private int leftTabIndex;
    private int topTabIndex;

    public SecurityPanelBean() {
       boolean leftTabParam =  FacesContext.getCurrentInstance().getExternalContext().getRequestMap().containsKey(NavigationConstants.LEFT_TAB);
       boolean topTabParam =   FacesContext.getCurrentInstance().getExternalContext().getRequestMap().containsKey(NavigationConstants.TOP_TAB);
       
       if(leftTabParam & topTabParam) {
          leftTabIndex =  Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(NavigationConstants.LEFT_TAB).toString());
          topTabIndex =    Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(NavigationConstants.TOP_TAB).toString());
       }      
    }

    public int getLeftTabIndex() {
        return leftTabIndex;
    }

    public void setLeftTabIndex(int leftTabIndex) {
        this.leftTabIndex = leftTabIndex;
    }

    public int getTopTabIndex() {
        return topTabIndex;
    }

    public void setTopTabIndex(int topTabIndex) {
        this.topTabIndex = topTabIndex;
    }
    
    
}
