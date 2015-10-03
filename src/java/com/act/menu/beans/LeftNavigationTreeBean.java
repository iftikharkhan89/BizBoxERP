/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.menu.beans;

import com.act.core.classes.UIConstants;
import com.act.module.login.UserRoleBasedUI;
import com.act.util.BizBoxClientUtil;
import com.act.util.BizBoxTreeMenuUtil;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author iftikhar
 */
@ManagedBean
@RequestScoped
public class LeftNavigationTreeBean implements Serializable {

    /**
     * Creates a new instance of LeftNavigationTreeBean
     */
    private TreeNode root;
    private Map sessionMap;
    
    /**
     * 
     */
    public LeftNavigationTreeBean() {
        sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        initializeTree();
        filterTreeItems();      
    }  
    /**
     * 
     * @return 
     */
    public TreeNode getRoot() {  
        return root;  
    }
    /**
     * 
     */
    private void initializeTree() {
        root = new DefaultTreeNode("2BizboxERP", null); 
    }
    /**
     * 
     */
    private void filterTreeItems() {
      String []  roles  = BizBoxClientUtil.getUserRoleFromServer(sessionMap);
      System.out.println(roles);
      for (int index =0; index < roles.length; index++){
          String role = roles[index];
          if (role.equals("SUPER_USER") | role.equals("SYSTEM_ADMINISTRATOR")) {
              addAllTreeNodes();
              return;
          }     
      }
      List<String> UI =  UserRoleBasedUI.getUserRoleBasedUI(sessionMap);
      Iterator listIterator = UI.iterator();
      while (listIterator.hasNext()) {
          String interfaceName = (String) listIterator.next();
          if (interfaceName.equals(UIConstants.ENGINEERING_INTERFACE_NAME)) {
              BizBoxTreeMenuUtil.addEngineeringBoxNode(root);
          }
          else if (interfaceName.equals(UIConstants.PURCHASING_INTERFACE_NAME)) {
              BizBoxTreeMenuUtil.addPurchasingBoxNode(root);
          }
          else if (interfaceName.equals(UIConstants.SALES_INTERFACE_NAME)) {
              BizBoxTreeMenuUtil.addSalesBoxNode(root);
          }
          else if (interfaceName.equals(UIConstants.MANUFACTURING_INTERFACE_NAME)) {
              BizBoxTreeMenuUtil.addManufecturingBoxNode(root);
          }
          else if (interfaceName.equals(UIConstants.WORKORDER_INTERFACE_NAME)) {
              BizBoxTreeMenuUtil.addWorkOrderBoxNode(root);
          }
          else if (interfaceName.equals(UIConstants.QUALITY_INTERFACE_NAME)) {
              BizBoxTreeMenuUtil.addQualityBoxNode(root);
          }
          else if (interfaceName.equals(UIConstants.WAREHOUSE_INTERFACE_NAME)) {
              BizBoxTreeMenuUtil.addWarehouseBoxNode(root);
          }
          else if (interfaceName.equals(UIConstants.ACCOUNTING_INTERFACE_NAME)) {
              BizBoxTreeMenuUtil.addAccountingBoxNode(root);
          }
          else if (interfaceName.equals(UIConstants.ADDRESSBOOK_INTERFACE_NAME)) {
              BizBoxTreeMenuUtil.addAddressBookBoxNode(root);
          }
          else if (interfaceName.equals(UIConstants.HUMANRESOURCE_INTERFACE_NAME)) {
              BizBoxTreeMenuUtil.addHRBoxNode(root);
          }
          else if (interfaceName.equals(UIConstants.PLANNING_INTERFACE_NAME)) {
              BizBoxTreeMenuUtil.addPlanningBoxNode(root);
          }
          else if (interfaceName.equals(UIConstants.CUSTOMERSERVICE_INTERFACE_NAME)) {
              BizBoxTreeMenuUtil.addCustomerServiceBoxNode(root);
          }
          else if (interfaceName.equals(UIConstants.SECURITY_INTERFACE_NAME)) {
              BizBoxTreeMenuUtil.addSecurityBoxNode(root);
          }
          else if (interfaceName.equals(UIConstants.DOCUMENT_INTERFACE_NAME)) {
              BizBoxTreeMenuUtil.addDocumentBoxNode(root);
          }
          else if (interfaceName.equals(UIConstants.CONTROLPANEL_INTERFACE_NAME)) {
              BizBoxTreeMenuUtil.addControlPanelBoxNode(root);
          }
      }
    }
    /**
     * 
     */
    private void addAllTreeNodes(){
        
              BizBoxTreeMenuUtil.addEngineeringBoxNode(root);       
              BizBoxTreeMenuUtil.addPurchasingBoxNode(root);                
              BizBoxTreeMenuUtil.addSalesBoxNode(root);                
              BizBoxTreeMenuUtil.addManufecturingBoxNode(root);        
              BizBoxTreeMenuUtil.addWorkOrderBoxNode(root);        
              BizBoxTreeMenuUtil.addQualityBoxNode(root);        
              BizBoxTreeMenuUtil.addWarehouseBoxNode(root);                
              BizBoxTreeMenuUtil.addAccountingBoxNode(root);                
              BizBoxTreeMenuUtil.addAddressBookBoxNode(root);                
              BizBoxTreeMenuUtil.addHRBoxNode(root);                
              BizBoxTreeMenuUtil.addPlanningBoxNode(root);                
              BizBoxTreeMenuUtil.addCustomerServiceBoxNode(root);                
              BizBoxTreeMenuUtil.addSecurityBoxNode(root);                
              BizBoxTreeMenuUtil.addDocumentBoxNode(root);                
              BizBoxTreeMenuUtil.addControlPanelBoxNode(root);        
    }
    
    public void handleTreeSelection(){
        
    }
    
}