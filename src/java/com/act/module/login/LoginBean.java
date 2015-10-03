/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.module.login;

import bb.common.BizBoxServer;
import bb.common.BizboxUserVO;
import bb.common.Configure;
import bb.gui.ServerActionException;
import bb.gui.server.ServerActionUtil;
import com.act.db.entity.Dbname;
import com.act.db.entity.Hostname;
import com.act.util.BizBoxClientUtil;
import com.act.util.EntityManagerHelper;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

/**
 *
 * @author iftikhar
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
private String targetServerIP;
private String targetServerPort;
private String company;
private String companyList[];
private String userName;
private String password;
private String language;
private String [] servers;
private String [] languages = {"en","ch"};

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        loadSettingsFromDb();
    }

    public String getTargetServerIP() {
        return targetServerIP;
    }

    public void setTargetServerIP(String targetServerIP) {
        this.targetServerIP = targetServerIP;
    }

    public String getTargetServerPort() {
        return targetServerPort;
    }

    public void setTargetServerPort(String targetServerPort) {
        this.targetServerPort = targetServerPort;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String[] getServers() {
        return servers;
    }

    public void setServers(String[] servers) {
        this.servers = servers;
    }

    public String[] getCompanyList() {
        return companyList;
    }

    public void setCompanyList(String companyList[]) {
        this.companyList = companyList;
    }
      
    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }
    
    public String login(){
        Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        String loginUser = (String)sessionMap.get(LoginConstants.USER_NAME);
        if (loginUser != null && loginUser.equals(getUserName())) {
            return "success";
        }
        String lang = getLanguage();
        if (lang.equals("en"))
            lang = "en_US";
        
        BizBoxServer server = new BizBoxServer(getTargetServerIP(), getTargetServerPort(), getCompany(), getUserName(), getPassword(), lang);
        ServerActionUtil.setTargetServer(server);
        Object parameters [] = {};
        Object user = null;
        try {
            user =  ServerActionUtil.invoke(Configure.Module.SECURITY, "getUserBySelf",parameters);
        } 
        catch (ServerActionException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        BizboxUserVO  userVO = (BizboxUserVO)user;
        if (user != null && userVO.getUserName().equalsIgnoreCase(getUserName())) {         
            sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            sessionMap.put(LoginConstants.SERVER_INSTANCE, server);
            sessionMap.put(LoginConstants.TARGET_SERVER_IP, getTargetServerIP());
            sessionMap.put(LoginConstants.TARGET_SERVER_PORT, getTargetServerPort());
            sessionMap.put(LoginConstants.USER_NAME, getUserName());
            sessionMap.put(LoginConstants.USER_PASSWORD, getPassword());
            sessionMap.put(LoginConstants.COMPANY_NAME, getCompany());
            sessionMap.put(LoginConstants.SELECTED_LANGUAGE, lang);
            // Get User Role List from Server and save it in session.
            String roles [] = BizBoxClientUtil.getUserRoleFromServer(sessionMap);
            sessionMap.put(LoginConstants.USER_ROLE_BASED_UI, roles);
            // Save Host and Database name if login is successful
            saveHostAndDatabase();
            
            return "success";      
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR!","Login ERROR!!!" ));
            return "failure";
        }
    }
    
    private void saveHostAndDatabase() {
        
        Query query = EntityManagerHelper.getEntityManager().createQuery("SELECT h FROM Hostname h WHERE h.hostnamevalue ='"+this.getTargetServerIP()+"'");
        Query query2 = EntityManagerHelper.getEntityManager().createQuery("SELECT d FROM Dbname d WHERE d.dbnamevalue ='"+this.getCompany()+"'");
        List hosts =  query.getResultList();
        List dbs =    query2.getResultList();
        if (hosts != null && hosts.isEmpty()) {
            Hostname host = new Hostname();
            host.setHostnamevalue(this.getTargetServerIP());
            EntityManagerHelper.getEntityManager().getTransaction().begin();
            EntityManagerHelper.getEntityManager().persist(host);
            EntityManagerHelper.getEntityManager().getTransaction().commit();
        }
        
        if (dbs != null && dbs.isEmpty()) {
            Dbname db = new Dbname();
            db.setDbnamevalue(this.getCompany());
            EntityManagerHelper.getEntityManager().getTransaction().begin();
            EntityManagerHelper.getEntityManager().persist(db);
            EntityManagerHelper.getEntityManager().getTransaction().commit();
        }      
    }
    
    private void loadSettingsFromDb() {
        Query query = EntityManagerHelper.getEntityManager().createQuery("SELECT h FROM Hostname h");
        Query query2 = EntityManagerHelper.getEntityManager().createQuery("SELECT d FROM Dbname d");
        List hostList = query.getResultList();
        List companies = query2.getResultList();
        
        if (hostList != null) {
            String [] hostNames = new String [hostList.size()];
            for (int index =0; index < hostNames.length; index++) {
                Hostname host = (Hostname) hostList.get(index);
                hostNames[index] = host.getHostnamevalue();
            }
            this.setServers(hostNames);
        }
        if (companies != null && !companies.isEmpty()) {
            String companyNames [] = new String [companies.size()];
            for (int index = 0; index < companyNames.length; index++) {
                Dbname dbname = (Dbname) companies.get(index);
                companyNames[index] = dbname.getDbnamevalue();
            }
            this.setCompanyList(companyNames);
        }    
    }
    
    public void handleSessionTimeout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    
    public void navigateToLoginPage() {
        FacesContext fctx = FacesContext.getCurrentInstance();
        Application application = fctx.getApplication();
        NavigationHandler navHandler = application.getNavigationHandler();
        navHandler.handleNavigation(fctx, null, "sessionTimeOut");
    }
    
    public void logout(){
        handleSessionTimeout();
        navigateToLoginPage();
    }
}
