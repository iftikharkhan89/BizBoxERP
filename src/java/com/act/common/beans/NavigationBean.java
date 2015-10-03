/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.common.beans;

import com.act.core.classes.NavigationConstants;
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;

/**
 *
 * @author iftikhar
 */
@ManagedBean
@RequestScoped
public class NavigationBean {
private String page;
private String extension;
private String path;
private String url;
private String leftTab;
private String topTab;

    /**
     * Creates a new instance of NavigationBean
     */
    public NavigationBean() {
        this.setUrl("Welcome.xhtml");
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
   
    public String getUrl() {
        return url;
    }

    private void setUrl(String url) {
        this.url = url;
    }

    public String getLeftTab() {
        return leftTab;
    }

    public void setLeftTab(String leftTab) {
        this.leftTab = leftTab;
    }

    public String getTopTab() {
        return topTab;
    }

    public void setTopTab(String topTab) {
        this.topTab = topTab;
    }
    
    public void handleNavigation(ActionEvent e) {
        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
        if (requestMap == null) {
            requestMap = new HashMap<String,String>();
        }
        MenuItem menuItemClicked = (MenuItem) e.getComponent();
        Submenu parent = (Submenu) menuItemClicked.getParent();
        FacesContext fctx = FacesContext.getCurrentInstance();
        Application application = fctx.getApplication();
        NavigationHandler navHandler = application.getNavigationHandler();
        if (parent != null) {
            if (parent.getLabel().equalsIgnoreCase("SECURITY")) {
                navHandler.handleNavigation(fctx,null, "security");
                if (menuItemClicked.getValue().toString().equalsIgnoreCase("USER")) {
                    requestMap.put(NavigationConstants.LEFT_TAB, 0);
                    requestMap.put(NavigationConstants.TOP_TAB, 0);
                }
                else if (menuItemClicked.getValue().toString().equalsIgnoreCase("ROLE")) {
                     requestMap.put(NavigationConstants.LEFT_TAB, 1);
                     requestMap.put(NavigationConstants.TOP_TAB, 0);
                }
                else {
                     requestMap.put(NavigationConstants.LEFT_TAB, 0);
                     requestMap.put(NavigationConstants.TOP_TAB, 0); 
                }
            }
            else if (parent.getLabel().equalsIgnoreCase("ENGINEERING")) {
                navHandler.handleNavigation(fctx,null, "engineering");
            }
            else {
                navHandler.handleNavigation(fctx,null, "welcome");
            }
        }
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(menuItemClicked.getValue()+" MENUITEM!","Clicked!!!" ));
    }
   
}
