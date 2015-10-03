/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.menu.beans;

import com.act.core.classes.UIConstants;
import com.act.core.object.ERPMenu;
import com.act.module.login.UserRoleBasedUI;
import com.act.util.BizBoxClientUtil;
import com.act.util.BizBoxERPMenuUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

/**
 *
 * @author iftikhar
 */
@ManagedBean
@RequestScoped
public class AccordionMenuBean implements Serializable{

    private List<ERPMenu> options;
    private MenuModel panelMenuModel;
    private Map sessionMap;
    private List optionsList;
    
    /**
     * Creates a new instance of AccordionMenuBean
     */
    public AccordionMenuBean() {
        sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        optionsList = new ArrayList();
        initializeAccordionData();
        filterAccordionOptions();
        buildPanelMenuModel();
        makeSubListsOfOptionsList();
        
    }

    public List<ERPMenu> getOptions() {
        return options;
    }

    private void setOptions(List<ERPMenu> options) {
        this.options = options;
    }

    public MenuModel getPanelMenuModel() {
        return panelMenuModel;
    }

    private void setPanelMenuModel(MenuModel panelMenuModel) {
        this.panelMenuModel = panelMenuModel;
    }
    /**
     * 
     */
    
    private void initializeAccordionData() {
        options = new ArrayList<ERPMenu>();
    }
    /**
     * 
     */
    private void filterAccordionOptions() {
      String []  roles  = BizBoxClientUtil.getUserRoleFromServer(sessionMap);
      System.out.println(roles);
      for (int index =0; index < roles.length; index++){
          String role = roles[index];
          if (role.equals("SUPER_USER") | role.equals("SYSTEM_ADMINISTRATOR")) {
              addAllOptions();
              return;
          }     
      }
      List<String> UI =  UserRoleBasedUI.getUserRoleBasedUI(sessionMap);
      Iterator listIterator = UI.iterator();
      while (listIterator.hasNext()) {
          String interfaceName = (String) listIterator.next();
          if (interfaceName.equals(UIConstants.ENGINEERING_INTERFACE_NAME)) {
              options.add(BizBoxERPMenuUtil.addEngineeringBoxMenu());
          }
          else if (interfaceName.equals(UIConstants.PURCHASING_INTERFACE_NAME)) {
              options.add(BizBoxERPMenuUtil.addPurchasingBoxMenu());
          }
          else if (interfaceName.equals(UIConstants.SALES_INTERFACE_NAME)) {
              options.add(BizBoxERPMenuUtil.addSalesBoxMenu());
          }
          else if (interfaceName.equals(UIConstants.MANUFACTURING_INTERFACE_NAME)) {
              options.add(BizBoxERPMenuUtil.addManufecturingBoxMenu());
          }
          else if (interfaceName.equals(UIConstants.WORKORDER_INTERFACE_NAME)) {
              options.add(BizBoxERPMenuUtil.addWorkOrderBoxMenu());
          }
          else if (interfaceName.equals(UIConstants.QUALITY_INTERFACE_NAME)) {
              options.add(BizBoxERPMenuUtil.addQualityBoxMenu());
          }
          else if (interfaceName.equals(UIConstants.WAREHOUSE_INTERFACE_NAME)) {
              options.add(BizBoxERPMenuUtil.addWarehouseBoxMenu());
          }
          else if (interfaceName.equals(UIConstants.ACCOUNTING_INTERFACE_NAME)) {
              options.add(BizBoxERPMenuUtil.addAccountingBoxMenu());
          }
          else if (interfaceName.equals(UIConstants.ADDRESSBOOK_INTERFACE_NAME)) {
              options.add(BizBoxERPMenuUtil.addAddressBookBoxMenu());
          }
          else if (interfaceName.equals(UIConstants.HUMANRESOURCE_INTERFACE_NAME)) {
              options.add(BizBoxERPMenuUtil.addHRBoxMenu());
          }
          else if (interfaceName.equals(UIConstants.PLANNING_INTERFACE_NAME)) {
              options.add(BizBoxERPMenuUtil.addPlanningBoxMenu());
          }
          else if (interfaceName.equals(UIConstants.CUSTOMERSERVICE_INTERFACE_NAME)) {
              options.add(BizBoxERPMenuUtil.addCustomerServiceBoxMenu());
          }
          else if (interfaceName.equals(UIConstants.SECURITY_INTERFACE_NAME)) {
              options.add(BizBoxERPMenuUtil.addSecurityBoxMenu());
          }
          else if (interfaceName.equals(UIConstants.DOCUMENT_INTERFACE_NAME)) {
              options.add(BizBoxERPMenuUtil.addDocumentBoxMenu());
          }
          else if (interfaceName.equals(UIConstants.CONTROLPANEL_INTERFACE_NAME)) {
              options.add(BizBoxERPMenuUtil.addControlPanelBoxMenu());
          }
      }
    }
    /**
     * 
     */
    private void addAllOptions(){
       options.add(BizBoxERPMenuUtil.addEngineeringBoxMenu());
       options.add(BizBoxERPMenuUtil.addPurchasingBoxMenu());
       options.add(BizBoxERPMenuUtil.addSalesBoxMenu());
       options.add(BizBoxERPMenuUtil.addManufecturingBoxMenu());
       options.add(BizBoxERPMenuUtil.addWorkOrderBoxMenu());
       options.add(BizBoxERPMenuUtil.addQualityBoxMenu());
       options.add(BizBoxERPMenuUtil.addWarehouseBoxMenu());
       options.add(BizBoxERPMenuUtil.addAccountingBoxMenu());
       options.add(BizBoxERPMenuUtil.addAddressBookBoxMenu());
       options.add(BizBoxERPMenuUtil.addHRBoxMenu());
       options.add(BizBoxERPMenuUtil.addPlanningBoxMenu());
       options.add(BizBoxERPMenuUtil.addCustomerServiceBoxMenu());
       options.add(BizBoxERPMenuUtil.addSecurityBoxMenu());
       options.add(BizBoxERPMenuUtil.addDocumentBoxMenu());
       options.add(BizBoxERPMenuUtil.addControlPanelBoxMenu());
                   
    }
    /**
     * 
     */
    private void buildPanelMenuModel() {
        panelMenuModel = new DefaultMenuModel();
        for (ERPMenu erpMenu:options) {
            Submenu sub = new Submenu();
            sub.setLabel(erpMenu.getHeadItem());            
            for (String menuItemTitle:erpMenu.getSubItems()) {
                MenuItem menuItem = new MenuItem();
                menuItem.setTitle(menuItemTitle);
                menuItem.setValue(menuItemTitle);
                menuItem.addActionListener(BizBoxERPMenuUtil.createActionListener("#{navigationBean.handleNavigation}"));
                menuItem.setAjax(false);
                sub.getChildren().add(menuItem);
            }
           panelMenuModel.addSubmenu(sub); 
        }        
    }
    
    private void makeSubListsOfOptionsList() {
        
        int numberOfSubList = options.size()/3;
        int startIndex = 0;
        int endIndex = 2;
        for (int index = 0; index < numberOfSubList;index++) {
            List<ERPMenu> subList = options.subList(startIndex, endIndex);
            optionsList.add(subList);
            startIndex+=3;
            endIndex+=3;
        }
        
        int lastSubListItemCount = options.size() % 3;
        List<ERPMenu> lastSubList = null;
        if (lastSubListItemCount != 0) {
         startIndex =   options.size() - lastSubListItemCount; 
         endIndex = options.size()-1;
         lastSubList = options.subList(--startIndex,endIndex );
         optionsList.add(lastSubList);
        }
    }
}
