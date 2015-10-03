/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.util;

import com.act.core.object.ERPMenu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.MethodExpressionActionListener;

/**
 *
 * @author iftikhar
 */
public class BizBoxERPMenuUtil {
       public static ERPMenu addEngineeringBoxMenu() {
           String subMenuTitles [] = {"Part Master","Bill Of Material","Drawing","Engineering Change Notice","Engineering Change Request","Engineering Design Control","Traceable","Material"};
           return buildMenu("Engineering", subMenuTitles);
    }
    /**
     * 
     * @param node 
     */
    public static ERPMenu addPurchasingBoxMenu() {
           String subMenuTitles [] = {"Purchase Order","Request for Quote","Swap Order","Return to Vendor","Purchasing Work Sheet","Material Requirements Planing","Vendor Contract Price"};
           return buildMenu("Purchasing", subMenuTitles);
    }
    /**
     * 
     * @param node 
     */
    public static ERPMenu addSalesBoxMenu() {
           String subMenuTitles [] = {"Sales Order","Quote","Return Material Authorization","Customer Contract Price"};
           return buildMenu("Sales", subMenuTitles);
    }
/**
 * 
 * @param node 
 */
    public static ERPMenu addManufecturingBoxMenu() {
           String subMenuTitles [] = {"Tool Master","Tool List","Shop Floor","MFG Time System","Equipment","Work Center",
                                      "Work Instruction","Calibration","Manufacturing Purchasing","Menufacturing RFQ","MECN","MECR",
                                      "Menufacturing BOM","Lean Manufacturing"};
           return buildMenu("Manufacturing", subMenuTitles);
    }
    /**
     * 
     * @param node 
     */
    public static ERPMenu addWorkOrderBoxMenu() {
           String subMenuTitles [] = {"Work Order","Work Sheet","Disassembled Work Order"};
           return buildMenu("Work Order", subMenuTitles);
    }
    /**
     * 
     * @param node 
     */
    public static ERPMenu addQualityBoxMenu() {
           String subMenuTitles [] = {"Serial Number","Certificate","Tracking","NCR","IR","CAR","PAR","NC Code","Vendor QA","Quality Group"};
           return buildMenu("Quality", subMenuTitles);
    }
    /**
     * 
     * @param node 
     */
    public static ERPMenu addAccountingBoxMenu() {
           String subMenuTitles [] = {"Account Receivable","Account Receivable Prepay","Account Receivalbe Cashier","Credit Memo",
                                      "Account Payable","Account Payable Prepay","Account Payable Cashier","Debit Memo","PA","GL",
                                      "Inventory","Asset","Budget"};
           return buildMenu("Accounting", subMenuTitles);
    }
    /**
     * 
     * @param node 
     */
    public static ERPMenu addHRBoxMenu() {
           String subMenuTitles [] = {"Employee Card","Temporary Worker","Address Book"};
           return buildMenu("Human Resource", subMenuTitles);
    }
    /**
     * 
     * @param node 
     */
    public static ERPMenu addPlanningBoxMenu() {
           String subMenuTitles [] = {"Planning Home","Ship List"};
           return buildMenu("Planning", subMenuTitles);
    }
    /**
     * 
     * @param node 
     */
    public static ERPMenu addWarehouseBoxMenu() {
           String subMenuTitles [] = {"Warehouse Home","Shipping","Ship List","Receiving","On Loan","Inventory","Transfer Order",
                                      "Non Productive Order","Physical Inventory","Proforma Shipper","Pick List","Label","Vendor Group"};
           return buildMenu("Warehouse", subMenuTitles);
    }
    /**
     * 
     * @param node 
     */
    public static ERPMenu addCustomerServiceBoxMenu() {
           String subMenuTitles [] = {"Customer Service Incident","Customer Service Feedback","RMA"};
           return buildMenu("Customer Service", subMenuTitles);
    }
    /**
     * 
     * @param node 
     */
    public static ERPMenu addAddressBookBoxMenu() {
           String subMenuTitles [] = {"Customer","Vendor","Manufacturer"};
           return buildMenu("Address Book", subMenuTitles);
    }
    /**
     * 
     * @param node 
     */
    public static ERPMenu addSecurityBoxMenu() {
           String subMenuTitles [] = {"User","Role","Permission","Operating Log"};
           return buildMenu("Security", subMenuTitles);
    }
    /**
     * 
     * @param node 
     */
    public static ERPMenu addDocumentBoxMenu() {
           String subMenuTitles [] = {"Part Document","Misc Document"};
           return buildMenu("Document", subMenuTitles);
    }
    /**
     * 
     * @param node 
     */
    public static ERPMenu addControlPanelBoxMenu() {
           String subMenuTitles [] = {"Control Panel"};
           return buildMenu("Control Panel", subMenuTitles);
    }
    
    private static ERPMenu buildMenu(String categoryName, String [] subMenuTitles) {
         ERPMenu category = new ERPMenu();
           category.setHeadItem(categoryName);
           List<String> subItems = new ArrayList<String>();
           subItems.addAll(Arrays.asList(subMenuTitles));      
           category.setSubItems(subItems);
           category.setVisible(true);
           return category;
    }
    
    public static MethodExpressionActionListener createActionListener(String actionListenerExpression) {
            FacesContext context = FacesContext.getCurrentInstance();
            return new MethodExpressionActionListener(context.getApplication().getExpressionFactory()
            .createMethodExpression(context.getELContext(), actionListenerExpression, null, new Class[] {ActionEvent.class}));
    }
}
 

