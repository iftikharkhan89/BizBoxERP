/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.menu.beans;

import com.act.core.classes.UIConstants;
import com.act.module.login.UserRoleBasedUI;
import com.act.util.BizBoxClientUtil;
import com.act.util.BizBoxTopMenuUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

/**
 *
 * @author iftikhar
 */
@ManagedBean
@RequestScoped
public class TopMenuBean {
    private MenuModel menuModel;
    private Map sessionMap;
    /**
     * Creates a new instance of TopMenuBean
     */
    public TopMenuBean() {
        //menuModel = new DefaultMenuModel();
        sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        initializeTopMenu();
        BizBoxTopMenuUtil.addSystemMenu(menuModel,false);
        filterTopMenu();
    }
    /**
     * 
     */
    private void initializeTopMenu() {
         menuModel = new DefaultMenuModel();
    }
    /**
     * 
     */
    private void filterTopMenu(){
      String []  roles  = BizBoxClientUtil.getUserRoleFromServer(sessionMap);
      System.out.println(roles);
      for (int index =0; index < roles.length; index++){
          String role = roles[index];
          if (role.equals("SUPER_USER") | role.equals("SYSTEM_ADMINISTRATOR")) {
              addAllMenus();
              return;
          }     
      }
      List<String> UI =  UserRoleBasedUI.getUserRoleBasedUI(sessionMap);
      Iterator listIterator = UI.iterator();
      while (listIterator.hasNext()) {
          String interfaceName = (String) listIterator.next();
          if (interfaceName.equals(UIConstants.ENGINEERING_INTERFACE_NAME)) {
              BizBoxTopMenuUtil.addEngineeringMenu(menuModel);
          }
          else if (interfaceName.equals(UIConstants.PURCHASING_INTERFACE_NAME)) {
              BizBoxTopMenuUtil.addPurchasingMenu(menuModel);
          }
          else if (interfaceName.equals(UIConstants.SALES_INTERFACE_NAME)) {
              BizBoxTopMenuUtil.addSalesMenu(menuModel);
          }
          else if (interfaceName.equals(UIConstants.MANUFACTURING_INTERFACE_NAME)) {
             BizBoxTopMenuUtil.addManufacturingMenu(menuModel); 
          }
          else if (interfaceName.equals(UIConstants.WORKORDER_INTERFACE_NAME)) {
              BizBoxTopMenuUtil.addWorkOrderMenu(menuModel);
          }
          else if (interfaceName.equals(UIConstants.QUALITY_INTERFACE_NAME)) {
              BizBoxTopMenuUtil.addQualityMenu(menuModel);
          }
          else if (interfaceName.equals(UIConstants.WAREHOUSE_INTERFACE_NAME)) {
              BizBoxTopMenuUtil.addWarehouseMenu(menuModel);
          }
          else if (interfaceName.equals(UIConstants.ACCOUNTING_INTERFACE_NAME)) {
              BizBoxTopMenuUtil.addAccountingMenu(menuModel);
          }
          else if (interfaceName.equals(UIConstants.ADDRESSBOOK_INTERFACE_NAME)) {
              BizBoxTopMenuUtil.addAddressBookMenu(menuModel);
          }
          else if (interfaceName.equals(UIConstants.HUMANRESOURCE_INTERFACE_NAME)) {
              BizBoxTopMenuUtil.addHRMenu(menuModel);
          }
          else if (interfaceName.equals(UIConstants.PLANNING_INTERFACE_NAME)) {
              BizBoxTopMenuUtil.addPlanningMenu(menuModel);
          }
          else if (interfaceName.equals(UIConstants.CUSTOMERSERVICE_INTERFACE_NAME)) {
              BizBoxTopMenuUtil.addCustomerServiceMenu(menuModel);
          }
          else if (interfaceName.equals(UIConstants.SECURITY_INTERFACE_NAME)) {
              BizBoxTopMenuUtil.addSecurityMenu(menuModel);
          }
          else if (interfaceName.equals(UIConstants.DOCUMENT_INTERFACE_NAME)) {
              BizBoxTopMenuUtil.addDocumentMenu(menuModel);
          }              
          else if (interfaceName.equals(UIConstants.CONTROLPANEL_INTERFACE_NAME)) {
              BizBoxTopMenuUtil.addControlPanelMenu(menuModel);
          }
      }
      
    }
    /**
     * 
     * @param summary 
     */  
    public void addMessage(String summary) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }
    /**
     * 
     * @return 
     */
    public MenuModel getMenuModel() {
        return menuModel;
    }
    /**
     * 
     */
    private void addAllMenus() {         
              BizBoxTopMenuUtil.addEngineeringMenu(menuModel);     
              BizBoxTopMenuUtil.addPurchasingMenu(menuModel);    
              BizBoxTopMenuUtil.addSalesMenu(menuModel);
              BizBoxTopMenuUtil.addManufacturingMenu(menuModel); 
              BizBoxTopMenuUtil.addWorkOrderMenu(menuModel);
              BizBoxTopMenuUtil.addQualityMenu(menuModel);
              BizBoxTopMenuUtil.addWarehouseMenu(menuModel);
              BizBoxTopMenuUtil.addAccountingMenu(menuModel);
              BizBoxTopMenuUtil.addAddressBookMenu(menuModel);
              BizBoxTopMenuUtil.addHRMenu(menuModel);
              BizBoxTopMenuUtil.addPlanningMenu(menuModel);
              BizBoxTopMenuUtil.addCustomerServiceMenu(menuModel);
              BizBoxTopMenuUtil.addSecurityMenu(menuModel);
              BizBoxTopMenuUtil.addDocumentMenu(menuModel);
              BizBoxTopMenuUtil.addControlPanelMenu(menuModel);      
    }
    
    public String handleNavigation(ActionEvent e) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("MENUITEM!","Clicked!!!" ));
        return "AddUser";
    }
    public String handleNavigation() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("MENUITEM!","Clicked!!!" ));
        return "AddUser";
    }
}
