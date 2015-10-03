/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.util;

import com.act.core.object.TreeItem;
import com.act.core.object.UserMenu;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author iftikhar
 */
public class BizBoxTreeMenuUtil {
    /**
     * 
     * @param node 
     */
    public static void addEngineeringBoxNode (TreeNode node) {
        TreeNode engineering = new DefaultTreeNode(new TreeItem(new UserMenu("engineering","Engineering Box",true)), node);
        engineering.setSelectable(false);
        TreeNode partMaster = new DefaultTreeNode(new TreeItem(new UserMenu("partMaster","Part Master",true)), engineering);
        TreeNode bom = new DefaultTreeNode(new TreeItem(new UserMenu("bom","BOM",true)), engineering);
        TreeNode drawing = new DefaultTreeNode(new TreeItem(new UserMenu("drawing","Drawing",true)), engineering);  
        TreeNode ecn = new DefaultTreeNode(new TreeItem(new UserMenu("ecn","ECN",true)), engineering); 
        TreeNode edc = new DefaultTreeNode(new TreeItem(new UserMenu("edc","EDC",true)), engineering);  
        TreeNode traceable = new DefaultTreeNode(new TreeItem(new UserMenu("traceable","Tracable",true)), engineering);  
        TreeNode material = new DefaultTreeNode(new TreeItem(new UserMenu("meterial","Material",true)), engineering);  
    }
    /**
     * 
     * @param node 
     */
    public static void addPurchasingBoxNode(TreeNode node) {
        TreeNode purchasing = new DefaultTreeNode(new TreeItem(new UserMenu("purchasing","Purchasing Box",true)), node);
        purchasing.setSelectable(false);
        TreeNode po = new DefaultTreeNode(new TreeItem(new UserMenu("purchaseOrder","Purchase Order",true)), purchasing);  
        TreeNode rfq = new DefaultTreeNode(new TreeItem(new UserMenu("rfq","Request for Quote",true)), purchasing);  
        TreeNode so = new DefaultTreeNode(new TreeItem(new UserMenu("swapOrder","Swap Order",true)), purchasing);
        TreeNode rtc = new DefaultTreeNode(new TreeItem(new UserMenu("rtc","RTC",true)), purchasing);  
        TreeNode worksheet = new DefaultTreeNode(new TreeItem(new UserMenu("worksheet","Work Sheet",true)), purchasing);
        TreeNode mrp = new DefaultTreeNode(new TreeItem(new UserMenu("mrp","MRP",true)), purchasing);  
        TreeNode vendorContractPrice = new DefaultTreeNode(new TreeItem(new UserMenu("vendorContractPrice","Vendor Contract Price",true)), purchasing);  
    }
    /**
     * 
     * @param node 
     */
    public static void addSalesBoxNode(TreeNode node) {
        TreeNode sales = new DefaultTreeNode(new TreeItem(new UserMenu("sales","Sales Box",true)), node);
        sales.setSelectable(false);
        TreeNode salesOrder = new DefaultTreeNode(new TreeItem(new UserMenu("salesOrder","Sales Order",true)), sales);  
        TreeNode quote = new DefaultTreeNode(new TreeItem(new UserMenu("quote","Quote",true)), sales);  
        TreeNode rma = new DefaultTreeNode(new TreeItem(new UserMenu("rma","RMA",true)), sales);  
        TreeNode customerContractPrice = new DefaultTreeNode(new TreeItem(new UserMenu("customerContractPrice","Customer Contract Price",true)), sales);  
    }
/**
 * 
 * @param node 
 */
    public static void addManufecturingBoxNode(TreeNode node) {
        TreeNode manufacturing = new DefaultTreeNode(new TreeItem(new UserMenu("manufacturingBox","Manufacturing Box",true)), node);
        manufacturing.setSelectable(false);
        
        TreeNode toolMaster = new DefaultTreeNode(new TreeItem(new UserMenu("toolMaster","Tool Master",true)), manufacturing);
        TreeNode toolList = new DefaultTreeNode(new TreeItem(new UserMenu("toolList","Tool List",true)), manufacturing);
        TreeNode shopFloor = new DefaultTreeNode(new TreeItem(new UserMenu("shopFloor","Shop Floor",true)), manufacturing);
        TreeNode mfgTimeSystem = new DefaultTreeNode(new TreeItem(new UserMenu("mfgTimeSystem","MFG Time System",true)), manufacturing);
        TreeNode equipment = new DefaultTreeNode(new TreeItem(new UserMenu("equipment","Equipment",true)), manufacturing);
        TreeNode workCenter = new DefaultTreeNode(new TreeItem(new UserMenu("workCenter","Work Center",true)), manufacturing);
        TreeNode workInstruction = new DefaultTreeNode(new TreeItem(new UserMenu("workInstruction","Work Instruction",true)), manufacturing);
        TreeNode calibration = new DefaultTreeNode(new TreeItem(new UserMenu("calibration","Calibration",true)), manufacturing);
        TreeNode manufacturingPurchasing = new DefaultTreeNode(new TreeItem(new UserMenu("manufacturingPurchasing","Manufacturing Purchasing",true)), manufacturing);
        TreeNode manufacturingRfq = new DefaultTreeNode(new TreeItem(new UserMenu("manufacturingrfq","Manufacturing RFQ",true)), manufacturing);
        TreeNode mecn = new DefaultTreeNode(new TreeItem(new UserMenu("mecn","MECN",true)), manufacturing);
        TreeNode mecr = new DefaultTreeNode(new TreeItem(new UserMenu("mecr","MECR",true)), manufacturing);
        TreeNode manufacturingBom = new DefaultTreeNode(new TreeItem(new UserMenu("manufacturingBom","Manufacturing BOM",true)), manufacturing);
        TreeNode leanManufacturing = new DefaultTreeNode(new TreeItem(new UserMenu("leanManufacturing","Lean Manufacturing",true)), manufacturing);
    }
    /**
     * 
     * @param node 
     */
    public static void addWorkOrderBoxNode(TreeNode node) {
        TreeNode workOrderBox = new DefaultTreeNode(new TreeItem(new UserMenu("workOrderBox","Work Order Box",true)), node);
        workOrderBox.setSelectable(false);
        
        TreeNode workOrder = new DefaultTreeNode(new TreeItem(new UserMenu("workOrder","Work Order",true)), workOrderBox);
        TreeNode workSheet = new DefaultTreeNode(new TreeItem(new UserMenu("worksheet","Work Sheet",true)), workOrderBox);
        TreeNode disassembledWorkOrder = new DefaultTreeNode(new TreeItem(new UserMenu("disassembledWorkOrder","Disassembled Work Order",true)), workOrderBox);
    }
    /**
     * 
     * @param node 
     */
    public static void addQualityBoxNode(TreeNode node) {
        TreeNode qualityBox = new DefaultTreeNode(new TreeItem(new UserMenu("qualityBox","Quality Box",true)), node);
        qualityBox.setSelectable(false);
        
        TreeNode serial = new DefaultTreeNode(new TreeItem(new UserMenu("serial","Serial#",true)), qualityBox);
        TreeNode certificate = new DefaultTreeNode(new TreeItem(new UserMenu("certificate","Certificate",true)), qualityBox);
        TreeNode tracking = new DefaultTreeNode(new TreeItem(new UserMenu("tracking","Tracking",true)), qualityBox);
        TreeNode ncr = new DefaultTreeNode(new TreeItem(new UserMenu("ncr","NCR",true)), qualityBox);
        TreeNode ir = new DefaultTreeNode(new TreeItem(new UserMenu("ir","IR",true)), qualityBox);
        TreeNode car = new DefaultTreeNode(new TreeItem(new UserMenu("car","CAR",true)), qualityBox);
        TreeNode par = new DefaultTreeNode(new TreeItem(new UserMenu("par","PAR",true)), qualityBox);
        TreeNode ncCode = new DefaultTreeNode(new TreeItem(new UserMenu("ncCode","NC Code",true)), qualityBox);
        TreeNode vendorQA = new DefaultTreeNode(new TreeItem(new UserMenu("vendorQA","Vendor QA",true)), qualityBox);
        TreeNode qualityGroup = new DefaultTreeNode(new TreeItem(new UserMenu("qualityGroup","Quality Group",true)), qualityBox);
    }
    /**
     * 
     * @param node 
     */
    public static void addAccountingBoxNode(TreeNode node) {
        TreeNode accountingBox = new DefaultTreeNode(new TreeItem(new UserMenu("accountingBox","Accounting Box",true)), node);
        accountingBox.setSelectable(false);      
 
        TreeNode ar = new DefaultTreeNode(new TreeItem(new UserMenu("ar","AR",true)), accountingBox);
        TreeNode arPrepay = new DefaultTreeNode(new TreeItem(new UserMenu("arPrepay","AR Prepay",true)), accountingBox);
        TreeNode arCashier = new DefaultTreeNode(new TreeItem(new UserMenu("arCachier","AR Cashier",true)), accountingBox);
        TreeNode creditMemo = new DefaultTreeNode(new TreeItem(new UserMenu("creditMemo","Credit Memo",true)), accountingBox);
        TreeNode ap = new DefaultTreeNode(new TreeItem(new UserMenu("ap","AP",true)), accountingBox);
        TreeNode apPrepay = new DefaultTreeNode(new TreeItem(new UserMenu("apPrepay","AP Prepay",true)), accountingBox);
        TreeNode apCashier = new DefaultTreeNode(new TreeItem(new UserMenu("apCashier","AP Cashier",true)), accountingBox);
        TreeNode debitMemo = new DefaultTreeNode(new TreeItem(new UserMenu("debitMemo","Debit Memmo",true)), accountingBox);
        TreeNode pa = new DefaultTreeNode(new TreeItem(new UserMenu("pa","PA",true)), accountingBox);
        TreeNode gl = new DefaultTreeNode(new TreeItem(new UserMenu("gl","GL",true)), accountingBox);
        TreeNode inventory = new DefaultTreeNode(new TreeItem(new UserMenu("inventory","Inventory",true)), accountingBox);
        TreeNode asset = new DefaultTreeNode(new TreeItem(new UserMenu("asset","Asset",true)), accountingBox);
        TreeNode budget = new DefaultTreeNode(new TreeItem(new UserMenu("budget","Budget",true)), accountingBox);
    }
    /**
     * 
     * @param node 
     */
    public static void addHRBoxNode(TreeNode node) {
        TreeNode hrBox = new DefaultTreeNode(new TreeItem(new UserMenu("hrBox","HR Box",true)), node);
        hrBox.setSelectable(false);
        
        TreeNode employeeCard = new DefaultTreeNode(new TreeItem(new UserMenu("employeeCard","Employee Card",true)), hrBox);
        TreeNode tempWork = new DefaultTreeNode(new TreeItem(new UserMenu("tempWork","temporary Worker",true)), hrBox);
        TreeNode companyAddressBook = new DefaultTreeNode(new TreeItem(new UserMenu("companyAddressBook","Company Address Book",true)), hrBox);
    }
    /**
     * 
     * @param node 
     */
    public static void addPlanningBoxNode(TreeNode node) {
        TreeNode planningBox = new DefaultTreeNode(new TreeItem(new UserMenu("planningBox","Planning Box",true)), node);
        planningBox.setSelectable(false);
        TreeNode planningHome = new DefaultTreeNode(new TreeItem(new UserMenu("planningHome","Planning Home",true)), planningBox);
        TreeNode shipList = new DefaultTreeNode(new TreeItem(new UserMenu("shipList","Ship List",true)), planningBox);
    }
    /**
     * 
     * @param node 
     */
    public static void addWarehouseBoxNode(TreeNode node) {
        TreeNode warehouseBox = new DefaultTreeNode(new TreeItem(new UserMenu("warehouseBox","Warehouse Box",true)), node);
        warehouseBox.setSelectable(false);
        
        TreeNode warehouseHome = new DefaultTreeNode(new TreeItem(new UserMenu("warehouseHome","Warehouse Home",true)), warehouseBox);
        TreeNode shipping = new DefaultTreeNode(new TreeItem(new UserMenu("shipping","Shipping",true)), warehouseBox);
        TreeNode shipList = new DefaultTreeNode(new TreeItem(new UserMenu("shipList","Ship List",true)), warehouseBox);
        TreeNode receiving = new DefaultTreeNode(new TreeItem(new UserMenu("receiving","Receiving",true)), warehouseBox);
        TreeNode onLoan = new DefaultTreeNode(new TreeItem(new UserMenu("onLoan","On Loan",true)), warehouseBox);
        TreeNode inventory = new DefaultTreeNode(new TreeItem(new UserMenu("inventory","Inventory",true)), warehouseBox);
        TreeNode transferOrder = new DefaultTreeNode(new TreeItem(new UserMenu("transferOrder","Transfer Order",true)), warehouseBox);
        TreeNode nonProductivePicking = new DefaultTreeNode(new TreeItem(new UserMenu("nonProductiveOrder","Non Productive Order",true)), warehouseBox);
        TreeNode physicalInventory = new DefaultTreeNode(new TreeItem(new UserMenu("physicalInventory","Physical Inventory",true)), warehouseBox);
        TreeNode proformaShipper = new DefaultTreeNode(new TreeItem(new UserMenu("proformaShipper","Proforma Shipper",true)), warehouseBox);
        TreeNode pickList = new DefaultTreeNode(new TreeItem(new UserMenu("pickList","Pick List",true)), warehouseBox);
        TreeNode label = new DefaultTreeNode(new TreeItem(new UserMenu("label","Label",true)), warehouseBox);
        TreeNode vendorGroup = new DefaultTreeNode(new TreeItem(new UserMenu("vendorGroup","Vendor Group",true)), warehouseBox);       
    }
    /**
     * 
     * @param node 
     */
    public static void addCustomerServiceBoxNode(TreeNode node) {
        TreeNode customerServiceBox = new DefaultTreeNode(new TreeItem(new UserMenu("customerServiceBox","Customer Service Box",true)), node);
        customerServiceBox.setSelectable(false);
        
        TreeNode customerServiceIncident = new DefaultTreeNode(new TreeItem(new UserMenu("customerServiceIncident","Customer Service Incident",true)), customerServiceBox);
        TreeNode customerFeedback = new DefaultTreeNode(new TreeItem(new UserMenu("customerFeedback","Customer Feedback",true)), customerServiceBox);
        TreeNode rma = new DefaultTreeNode(new TreeItem(new UserMenu("rma","RMA",true)), customerServiceBox);
    }
    /**
     * 
     * @param node 
     */
    public static void addAddressBookBoxNode(TreeNode node) {
        TreeNode addressBookBox = new DefaultTreeNode(new TreeItem(new UserMenu("addressBookBox","Address Book Box",true)), node);
        addressBookBox.setSelectable(false);
        
        TreeNode customerAndVendor = new DefaultTreeNode(new TreeItem(new UserMenu("customerAndVendor","Customer & Vendor",true)), addressBookBox);
        TreeNode manufacturer = new DefaultTreeNode(new TreeItem(new UserMenu("manufacturer","Manufacturer",true)), addressBookBox);
    }
    /**
     * 
     * @param node 
     */
    public static void addSecurityBoxNode(TreeNode node) {
        TreeNode securityBox = new DefaultTreeNode(new TreeItem(new UserMenu("securityBox","Security Box",true)), node);
        securityBox.setSelectable(false);
        TreeNode user = new DefaultTreeNode(new TreeItem(new UserMenu("user","User",true)), securityBox);
        TreeNode role = new DefaultTreeNode(new TreeItem(new UserMenu("role","Role",true)), securityBox);
        TreeNode permission = new DefaultTreeNode(new TreeItem(new UserMenu("permission","Permission",true)), securityBox);
        TreeNode operatingLog = new DefaultTreeNode(new TreeItem(new UserMenu("operatingLog","Operating Log",true)), securityBox);
    }
    /**
     * 
     * @param node 
     */
    public static void addDocumentBoxNode(TreeNode node) {
        TreeNode documentBox = new DefaultTreeNode(new TreeItem(new UserMenu("documentBox","Document Box",true)), node);
        documentBox.setSelectable(false);
        
        TreeNode partDocument = new DefaultTreeNode(new TreeItem(new UserMenu("partDocument","Part Document",true)), documentBox);
        TreeNode miscDocument = new DefaultTreeNode(new TreeItem(new UserMenu("partDocument","Miscellaneous Document",true)), documentBox);
    }
    /**
     * 
     * @param node 
     */
    public static void addControlPanelBoxNode(TreeNode node) {
       TreeNode controlPanelBox = new DefaultTreeNode(new TreeItem(new UserMenu("controlPanelBox","Control Panel",true)), node); 
    }
}
