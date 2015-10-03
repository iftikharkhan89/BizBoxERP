/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.util;

import javax.el.MethodExpression;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.MethodExpressionActionListener;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.separator.Separator;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.MenuModel;

/**
 *
 * @author iftikhar
 */
public class BizBoxTopMenuUtil {
    
    public static void addSystemMenu(MenuModel model, boolean isAdmin) {
       Submenu system = new Submenu();
       system.setLabel("System");
       system.setIcon("");
       
       String menuItems []= {"Company Address Book","Change Password","Logout","Exit"};
       createMenuItems(system, system, menuItems);
       model.addSubmenu(system);
    }
   /**
    * 
    * @param model 
    */
    public static void addEngineeringMenu(MenuModel model) {
       
       String partMasterItems [] = {"Add Part","",
                                    "Look Part","Lookup Where Used","",
                                    "Replace Part Type","Batch Update Part List Price","",
                                    "Search Part","",
                                    "Search BOM Item by BOM #","",
                                    "All Parts on Hold","All Parts on WI","All Inactive Parts","All Parts on BOM","",
                                    "Add Engineering Sharing","Engineering Info Box","All Engineering Sharing"};
       String bomItems [] = {"Add BOM","",
                             "Lookup BOM","",
                             "Replace Part in BOM","",
                             "Search BOM","",
                             "All BOMs"};
       String drawingItems [] = {"Upload MFG Drawing","",
                                 "Search MFG Drawing","",
                                 "MFG Drawing Setting","ENG Drawing Setting"};
       String ecnItems [] = {"Add ECN","Lookup ECN","",
                             "Search ECN","",
                             "Open ECN","Past due ECN","",
                             "Add ECN Approval","ECN Approval"};
       String ecrItems [] = {"Add ECR","Lookup ECR","",
                             "Search ECR","",
                             "Open ECR","Past due ECR","",
                             "Add ECR Approval","ECR Approval"};  
       String edcItems [] = {"Add EDC","Lookup EDC","",
                             "Search EDC","",
                             "Open EDC","Past due EDC"};
       String tracableItems [] = {"Set Part Traceable","Lookup Traceable by PN","",
                                  "Search Traceable","Search Categories and Specifications"};
       String materialItems [] = {"Add Material","Lookup Material","Looup Where used with Material Info",
                                  "Search Material","Search by BOM","Search Material's by PN"};
       Submenu engineering = new Submenu();
       engineering.setLabel("Engineering");
       engineering.setIcon("");
       
       Submenu partMaster = new Submenu();
       partMaster.setLabel("Part Master");
       createMenuItems(engineering, partMaster, partMasterItems);
       engineering.getChildren().add(partMaster);
       
       Submenu bom = new Submenu();
       bom.setLabel("BOM");
       createMenuItems(engineering, bom, bomItems);
       engineering.getChildren().add(bom);
       
       Submenu drawing = new Submenu();
       drawing.setLabel("Drawing");
       createMenuItems(engineering, drawing, drawingItems);
       engineering.getChildren().add(drawing);
       
       Submenu ecn = new Submenu();
       ecn.setLabel("ECN");
       createMenuItems(engineering,ecn, ecnItems);
       engineering.getChildren().add(ecn);
       
       Submenu ecr = new Submenu();
       ecr.setLabel("ECR");
       createMenuItems(engineering, ecr, ecrItems);
       engineering.getChildren().add(ecr);
       
       Submenu edc = new Submenu();
       edc.setLabel("EDC");
       createMenuItems(engineering, edc, edcItems);
       engineering.getChildren().add(edc);
       
       Submenu traceable = new Submenu();
       traceable.setLabel("Traceable");
       createMenuItems(engineering, traceable, tracableItems);
       engineering.getChildren().add(traceable);
       
       Submenu material = new Submenu();
       material.setLabel("Material");
       createMenuItems(engineering, material, materialItems);
       engineering.getChildren().add(material);
       
       model.addSubmenu(engineering);
    }
    /**
     * 
     * @param model 
     */
    public static void addPurchasingMenu(MenuModel model) {
        String poItems [] = {"Add PO","Add PO from RFQ","",
                             "Lookup PO","Search PO","",
                             "Add PO Approval","Lookup by Employee ID","Lookup by User Name","All PO Approvals","",
                             "Print PO","",
                             "Purchasing Info Box"};
        String rfqItems [] = {"Add RFQ","Lookup RFQ","",
                              "Search RFQ","",
                              "RFQ Check List","Past due RFQs","Open RFQs"};
        String swapOrderItems [] = {"Add Swap Order","Lookup Swap Order","Search Swap Order","Add Swap Order Approval",
                                    "Lookup SWO Approval","All Swap Order Approvals"};
        String rtvItems [] = {"Add RTV","Lookup RTV","",
                              "Search RTV","",
                              "RTV Check List","Past due RTVs","Open RTVs","",
                              "Add RTV Approval","Lookup by Employee Id","All RTV Approvals",};
        String poWorkSheetItems [] = {"Add PO Work Sheet","My PO Work Sheet"};
        String mrpItems [] = {"Lookup MRP by Part#","Run MRP","WO onDemand Report","SO onDemand Report"};
        String vcpbItems [] = {"Add Vendor Contract Price","Lookup Vendor Contract Price",
                               "Search by Contract Number","Search VCP by Vendor ID","All Vendor Contract Price"};
        String vgItems [] = {"Add VG User","Search VG User","",
                             "Search PO Message","",
                             "Search RFQ Message"};
        String poBoilerplateItems [] = {"Add PO Boilerplate","Lookup PO Boilerplate","Search PO BoilerPlate"};
        String buyerCodeItems [] = {"Search Buyer Codes"};
        String reportsItems [] = {"Open POs","Past due POs","Search Check List by PO#",
                                  "Search PO by Acknowledged=NO","Serach PO Statistics by Conditions",
                                  "Search Total Amount in PO by Project","Search PO on Time delivery Rate",
                                  "Search Vendor Purchases by Date","Search Total Amount in PO by related Doc",
                                  "Search Total Amount in PO by RF Doc"};
        
       Submenu purchasing = new Submenu();
       purchasing.setLabel("Purchasing");
       purchasing.setIcon("");
       
       Submenu po = new Submenu();
       po.setLabel("Purchase Order");
       createMenuItems(purchasing, po, poItems);
       purchasing.getChildren().add(po);
       
       Submenu rfq = new Submenu();
       rfq.setLabel("RFQ");
       createMenuItems(purchasing, rfq, rfqItems);
       purchasing.getChildren().add(rfq);
       
       Submenu swapOrder = new Submenu();
       swapOrder.setLabel("Swap Order");
       createMenuItems(purchasing, swapOrder, swapOrderItems);
       purchasing.getChildren().add(swapOrder);
       
       Submenu rtv = new Submenu();
       rtv.setLabel("RTV");
       createMenuItems(purchasing, rtv, rtvItems);
       purchasing.getChildren().add(rtv);
       
       Submenu poWorkSheet = new Submenu();
       poWorkSheet.setLabel("PO Worksheet");
       createMenuItems(purchasing, poWorkSheet, poWorkSheetItems);
       purchasing.getChildren().add(poWorkSheet);
       
       Submenu mrp = new Submenu();
       mrp.setLabel("MRP");
       createMenuItems(purchasing, mrp, mrpItems);
       purchasing.getChildren().add(mrp);
       
       Submenu vcpb = new Submenu();
       vcpb.setLabel("Vendor Contract Price");
       createMenuItems(purchasing,vcpb, vcpbItems);
       purchasing.getChildren().add(vcpb);
       
       Submenu vg = new Submenu();
       vg.setLabel("VG");
       createMenuItems(purchasing, vg, vgItems);
       purchasing.getChildren().add(vg);
       
       Submenu poBoilerplate = new Submenu();
       poBoilerplate.setLabel("PO BoilerPlate");
       createMenuItems(purchasing, poBoilerplate, poBoilerplateItems);
       purchasing.getChildren().add(poBoilerplate);
       
       Submenu buyerCode = new Submenu();
       buyerCode.setLabel("Buyer Code");
       createMenuItems(purchasing, buyerCode, buyerCodeItems);
       purchasing.getChildren().add(buyerCode);
       
       Submenu reports = new Submenu();
       reports.setLabel("Reports");
       createMenuItems(purchasing, reports, reportsItems);
       purchasing.getChildren().add(reports);
       
       model.addSubmenu(purchasing);

        
    }
    /**
     * 
     * @param model 
     */
    public static void addSalesMenu(MenuModel model) {
        String soItems [] = {"Add Sales Order","Lookup Sales Order","",
                             "Search Sales Order",""
                            ,"Add Sales Order Reviews","All Sales Order Approvals"};
        String quoteItems [] = {"Add Quote","Lookup Quote","",
                                "Search Quote","",
                                "Add Quote Boilerplate","Lookup Quote Boilerplate","Search Quote Boilerplate"};
        String rmaItems [] = {"Add RMA","Lookup RMA","",
                              "Search RMA","",
                              "Past due RMAs","Open RMAs","RMA Check List","",
                              "Add RMA Review","Lookup RMA Review by Employee","All RMA Approvals",};
        String customerContractPriceItems [] = {"Add Contract Price","Lookup Contract Price","Search by ID","All Contrat Price"};
        String controlItems [] = {"Add Incoterm","All Incterms","",
                                  "Add Sales Code","Search Sales code","Add Discount Code","Search All Discount Code","",
                                  "Add Project","Lookup Project","Search Project"};
        String salesBOMPartListItems [] = {"Lookup Sales X BOM by PN ","Lookup Sales Part List by PN"};
        String soBoilerPlateItems [] = {"Add SO BoilerPlate","Lookup SO BoilerPlate","Search BoilerPlate by ID"};
        String supplyChainPartsItems [] = {"Add Supply Chain Part","Search Supply Chain Parts"};
        String soReportsItems [] = {"SO not Reviewed","SO Past Due","SO Open","SO Open by Cost",
                                    "Search Parts to Sell","Search My SO Print List","Search SO on Time Delivery Rate",
                                    "Search Customer SO month stat Report","",
                                    "Number of the Month","Sales Info Report"};
        
       Submenu sales = new Submenu();
       sales.setLabel("Sales");
       sales.setIcon("");
       
       Submenu so = new Submenu();
       so.setLabel("Sales Order");
       createMenuItems(sales, so, soItems);
       sales.getChildren().add(so);
       
       Submenu quote = new Submenu();
       quote.setLabel("Quote");
       createMenuItems(sales, quote, quoteItems);
       sales.getChildren().add(quote);
       
       Submenu rma = new Submenu();
       rma.setLabel("RMA");
       createMenuItems(sales, rma, rmaItems);
       sales.getChildren().add(rma);
       
       Submenu customerContractPrice = new Submenu();
       customerContractPrice.setLabel("Customer Contract Price");
       createMenuItems(sales, customerContractPrice, customerContractPriceItems);
       sales.getChildren().add(customerContractPrice);
       
       Submenu control = new Submenu();
       control.setLabel("Control");
       createMenuItems(sales, control, controlItems);
       sales.getChildren().add(control);
       
       Submenu salesBOMPartList = new Submenu();
       salesBOMPartList.setLabel("Sales BOM/Part List");
       createMenuItems(sales,salesBOMPartList, salesBOMPartListItems);
       sales.getChildren().add(salesBOMPartList);
       
       Submenu soBoilerPlate = new Submenu();
       soBoilerPlate.setLabel("SO BoilerPlate");
       createMenuItems(sales, soBoilerPlate, soBoilerPlateItems);
       sales.getChildren().add(soBoilerPlate);
       
       Submenu supplyChainParts = new Submenu();
       supplyChainParts.setLabel("Supply Chain Parts");
       createMenuItems(sales, supplyChainParts, supplyChainPartsItems);
       sales.getChildren().add(supplyChainParts);
       
       Submenu soReports = new Submenu();
       soReports.setLabel("Reports");
       createMenuItems(sales, soReports, soReportsItems);
       sales.getChildren().add(soReports);
       
       model.addSubmenu(sales);
    }
    /**
     * 
     * @param model 
     */
    public static void addManufacturingMenu(MenuModel model) {
        String []toolMasterItems = {"Add Tool","Lookup Tool","",
                                    "Search Tool","",
                                    "Tool on Hold","Tool with Tool List","Tool with WI","Tool with Drawing","Inactive Tool"};
        String []toolListItems = {"Add Tool List","Lookup Tool List","Serach Tool List"};
        String []shopFloorItems = {"Setup Job by WO","Setup Job by PN","",
                                   "Search Setup","Search WC by PN"};
        String []mfgTimeSystemItems = {"Add MFG Time","Lookup by Employee ID","",
                                       "Search MFG Time System"};
        String []equipmentItems = {"Add Equipment","Lookup Equipment","Search Equipment"};
        String []workCenterItems = {"Add Work Center","Lookup Work Center","Search Work Center"};
        String []workInstructionItems = {"Add Work Instruction","Lookup Work Instruction","",
                                         "Copy Work Instruction","Update Work Instruction","Audit WI AVG Hrs","",
                                         "Search Work Instruction","Search Open WO's WI by due date","",
                                         "Add WI Approval","All WI Approvals"};
        String []calibrationItems = {"Search Calibration","Calibration's Past due"};
        String []manufacturingPurshasingItems = {"Add MPO","Lookup MPO","Search MPO","",
                                                 "Search by TN","Search MPO without Approval","All Check List",
                                                 "","Add MPO from MRFQ"};
        String []manufacturingrfqItems = {"Add MRFQ","Lookup MRFQ","Search MRFQ","Open MRFQ","MRFQ Check List","Past due MRFQ"};
        String []mecenItems = {"Add MECEN","Lookup MECEN","Search MECEN"};
        String []mecrItems = {"Add MECR","Lookup MECR","Search MECR"};
        String []manufacturingBomItems = {"Lookup MFG BOM Asm Seq","Search MFG BOM"};
        String []wiRfcItems = {"Add WI RFC","Lookup WI RFC","Search WI RFC","Open WI RFC","WI RFC's Past due"};
        String []leanManufacturingItems = {"Lookup PFEP"};

       Submenu manufacturing = new Submenu();
       manufacturing.setLabel("Manufacturing");
       manufacturing.setIcon("");
       
       Submenu toolMaster = new Submenu();
       toolMaster.setLabel("Tool Master");
       createMenuItems(manufacturing, toolMaster, toolMasterItems);
       manufacturing.getChildren().add(toolMaster);
       
       Submenu toolList = new Submenu();
       toolList.setLabel("Tool List");
       createMenuItems(manufacturing, toolList, toolListItems);
       manufacturing.getChildren().add(toolList);
       
       Submenu shopFloor = new Submenu();
       shopFloor.setLabel("Shop Floor");
       createMenuItems(manufacturing, shopFloor, shopFloorItems);
       manufacturing.getChildren().add(shopFloor);
       
       Submenu mfgTimeSystem = new Submenu();
       mfgTimeSystem.setLabel("MFG Time System");
       createMenuItems(manufacturing, mfgTimeSystem, mfgTimeSystemItems);
       manufacturing.getChildren().add(mfgTimeSystem);
       
       Submenu equipment = new Submenu();
       equipment.setLabel("Equipment");
       createMenuItems(manufacturing, equipment, equipmentItems);
       manufacturing.getChildren().add(equipment);
       
       Submenu workCenter = new Submenu();
       workCenter.setLabel("Work Center");
       createMenuItems(manufacturing, workCenter, workCenterItems);
       manufacturing.getChildren().add(workCenter);
       
       Submenu workInstruction = new Submenu();
       workInstruction.setLabel("Work Instruction");
       createMenuItems(manufacturing, workInstruction, workInstructionItems);
       manufacturing.getChildren().add(workInstruction);
       
       Submenu calibration = new Submenu();
       calibration.setLabel("Calibration");
       createMenuItems(manufacturing, calibration, calibrationItems);
       manufacturing.getChildren().add(calibration);
       
       Submenu manufacturingPurshasing = new Submenu();
       manufacturingPurshasing.setLabel("Manufacturing Purchase");
       createMenuItems(manufacturing, manufacturingPurshasing, manufacturingPurshasingItems);
       manufacturing.getChildren().add(manufacturingPurshasing);
       
       Submenu manufacturingrfq = new Submenu();
       manufacturingrfq.setLabel("Manufacturing RFQ");
       createMenuItems(manufacturing, manufacturingrfq, manufacturingrfqItems);
       manufacturing.getChildren().add(manufacturingrfq);
       
       Submenu mecen = new Submenu();
       mecen.setLabel("MECEN");
       createMenuItems(manufacturing, mecen, mecenItems);
       manufacturing.getChildren().add(mecen);
       
       Submenu mecr = new Submenu();
       mecr.setLabel("MECR");
       createMenuItems(manufacturing, mecr, mecrItems);
       manufacturing.getChildren().add(mecr);
       
       Submenu manufacturingBom = new Submenu();
       manufacturingBom.setLabel("Manufacturing BOM");
       createMenuItems(manufacturing, manufacturingBom, manufacturingBomItems);
       manufacturing.getChildren().add(manufacturingBom);
       
       Submenu wiRfc = new Submenu();
       wiRfc.setLabel("WI RFC");
       createMenuItems(manufacturing, wiRfc, wiRfcItems);
       manufacturing.getChildren().add(wiRfc);
       
       Submenu leanManufacturing = new Submenu();
       leanManufacturing.setLabel("Lean Manufacturing");
       createMenuItems(manufacturing, leanManufacturing, leanManufacturingItems);
       manufacturing.getChildren().add(leanManufacturing);
       
       model.addSubmenu(manufacturing);

        
    }
    /**
     * 
     * @param model 
     */
    public static void addWorkOrderMenu(MenuModel model) {
        String woItems [] = {"Add WO","Lookup WO","Search WO","",
                             "Add WO Approval","All WO Approvals"};
        String issuePartsItems [] = {"Issue Parts to WO","",
                                     "Search WO Item","Search Part"};
        String workSheetItems [] = {"Add Worksheet","My WO Worksheet"};
        String disassembledWoItems [] = {"Add DWO","Lookup DWO","Search DWO","",
                                         "Add DWO Approval","All DWO Approvals","",
                                         "Issue DWO","All DWO","",
                                         "DWO Receiving","Search Part Received"};
        String woBPItems [] = {"Add WO BP","Lookup WO BP","Search WO BP"};
        String reportsItems [] = {"Search Master WO","Search WO on Time Delivery Rate","Search no Setup WO",
                                  "WO Issue Report","WO Status Report","WO Issue Parts Cost Report","Open WO's",
                                  "Past due WO's","WO's Check List"};
        String infoCenterItems [] = {"Monthly WO Chart(Recent)","Monthly WO Chart(Issued)","WO info Box","WO Fiscal Year Chart"};
        
       Submenu workOrder = new Submenu();
       workOrder.setLabel("Work Order");
       workOrder.setIcon("");
       
       Submenu wo = new Submenu();
       wo.setLabel("Work Order");
       createMenuItems(workOrder, wo, woItems);
       workOrder.getChildren().add(wo);
       
       Submenu issueParts = new Submenu();
       issueParts.setLabel("Issue Parts");
       createMenuItems(workOrder, issueParts, issuePartsItems);
       workOrder.getChildren().add(issueParts);
       
       Submenu workSheet = new Submenu();
       workSheet.setLabel("Work Sheet");
       createMenuItems(workOrder, workSheet, workSheetItems);
       workOrder.getChildren().add(workSheet);
       
       Submenu disassembledWo = new Submenu();
       disassembledWo.setLabel("Disassembled WO");
       createMenuItems(workOrder, disassembledWo, disassembledWoItems);
       workOrder.getChildren().add(disassembledWo);
       
       Submenu woBP = new Submenu();
       woBP.setLabel("WO BP");
       createMenuItems(workOrder, woBP, woBPItems);
       workOrder.getChildren().add(woBP);
       
       Submenu reports = new Submenu();
       reports.setLabel("Reports");
       createMenuItems(workOrder, reports, reportsItems);
       workOrder.getChildren().add(reports);
       
       Submenu infoCenter = new Submenu();
       infoCenter.setLabel("Work Instruction");
       createMenuItems(workOrder, infoCenter, infoCenterItems);
       workOrder.getChildren().add(infoCenter);
       
       model.addSubmenu(workOrder);
    }
    /**
     * 
     * @param model 
     */
    public static void addQualityMenu(MenuModel model) {
        String serialNumItems [] = {"Add Serial#","Search Serial# by Serial#","",
                                    "Quality Info Box"};
        String certificateItems [] = {"Add Certificate","",
                                      "Search Certificate","",
                                      "Add Certificate Description","Search Certificate Description"};
        String trackingItems [] = {"Search Tracking"};
        String ncrItems [] = {"Add NCR","Lookup NCR","",
                              "Search NCR","Part in QA without NCR","",
                              "NCR's Past due","NCR's Open","Create Scrape GL","Close Open NCRs","",
                              "Add NCR Approval","Lookup NCR Approval","All NCR Approvals"};
        String irItems [] = {"Add IR","Lookup IR","",
                             "Search IR","Search Part Inspection","All Inspection Type",
                             "Search Part with Inspection Type"};
        String carItems [] = {"Add CAR","Lookup CAR","",
                              "Search CAR","",
                              "CARs Past Due","Open CARs"};
        String parItems [] = {"Add PAR","Lookup PAR","",
                              "Search PAR","",
                              "Search Past due PARs","Search Open PARs"};
        String ncCodeItems [] = {"Add NC Code","Lookup NC Code","",
                                 "All NC Codes","Search NC Code Reject Rate"};
        String vendorQAItems [] = {"Lookup Vendor","","Search Vendor","Searchi Expired Doc"};
        String qualityGroupItems [] = {"Add Quality Group User","All Quality Group Users"};
        
       Submenu quality = new Submenu();
       quality.setLabel("Quality");
       quality.setIcon("");
       
       Submenu serialNum = new Submenu();
       serialNum.setLabel("Serial#");
       createMenuItems(quality, serialNum, serialNumItems);
       quality.getChildren().add(serialNum);
       
       Submenu certificate = new Submenu();
       certificate.setLabel("Certificate");
       createMenuItems(quality, certificate, certificateItems);
       quality.getChildren().add(certificate);
       
       Submenu tracking = new Submenu();
       tracking.setLabel("Tracking");
       createMenuItems(quality, tracking, trackingItems);
       quality.getChildren().add(tracking);
       
       Submenu ncr = new Submenu();
       ncr.setLabel("NCR");
       createMenuItems(quality, ncr, ncrItems);
       quality.getChildren().add(ncr);
       
       Submenu ir = new Submenu();
       ir.setLabel("IR");
       createMenuItems(quality, ir, irItems);
       quality.getChildren().add(ir);
       
       Submenu car = new Submenu();
       car.setLabel("CAR");
       createMenuItems(quality, car, carItems);
       quality.getChildren().add(car);
       
       Submenu par = new Submenu();
       par.setLabel("PAR");
       createMenuItems(quality, par, parItems);
       quality.getChildren().add(par);
       
       Submenu ncCode = new Submenu();
       ncCode.setLabel("NC Code");
       createMenuItems(quality, ncCode, ncCodeItems);
       quality.getChildren().add(ncCode);
       
       Submenu vendorQA = new Submenu();
       vendorQA.setLabel("Vendor QA");
       createMenuItems(quality, vendorQA, vendorQAItems);
       quality.getChildren().add(vendorQA);
       
       Submenu qualityGroup = new Submenu();
       qualityGroup.setLabel("Quality Group");
       createMenuItems(quality, qualityGroup, qualityGroupItems);
       quality.getChildren().add(qualityGroup);
       
       model.addSubmenu(quality);
        
    }
    /**
     * 
     * @param model 
     */
    public static void addWarehouseMenu(MenuModel model) {
        String warehouseHomeItems [] = {"Make Inventory List","Lookup Stock Transaction","Lookup On Hand by Part#",
                                        "Lookup MRP by Part#","",
                                        "Negative OnHand Report","Warehouseing Info Center","Audit Last Inventory","",
                                        "Add New Warehouse","Init Warehouse","Search all Warehouse","Batch Move Location"};
        String shippingItems [] = {"Ship Sales Order","Issue Part to WO","Issue Disassembled WO","",
                                   "Search Work Order","Search Sales Order","All DWO","",
                                   "Lookup Shipper","Search Shipper","",
                                   "My Shipper Print List","",
                                   "Ship RTV","Lookup RTV Shipper","","Search RTV"};
        String receivingItems [] = {"Receive from WO","Receive from PO","DWO Receiving","Lookup Receiver","",
                                    "Search Receiver","",
                                    "My Receiving Print List","",
                                    "Receive from RMA","Search RMA"};
        String shipListHomeItems [] = {"Add Ship List","Lookup Ship List","Search Ship List","",
                                       "Add Ship List Owner","Lookup Ship List Owner","Search Ship List Owner"};
        String onLoanItems [] = {"Add OnLoan","Lookup OnLoan","Search OnLoan","Check List","",
                                 "Ship OnLoan","Search OnLoan Shipper","",
                                 "Receive from OnLoan Shipper","Search OnLoan shipper for Receive","Search OnLoan Receiver","",
                                 "Add onLoan Review","Search OnLoan Approvals"};
        String inventoryItems [] = {"Reset Avg Cost","Cycle Count Work Sheet","",
                                    "Search Inventory","Search High Usage Part","Search Part in WIP","",
                                    "Search Inventory Log"};
        String swapOrderItems [] = {"Add Swap Order","Lookup Swap Order","Serach Swap Order","Search SO Approval","Lookup SO Approval","All SO Approvals","",
                                    "Ship Swap Order","Serach SO Shipper","",
                                    "Receive from Swap Shipper","Search Swap Shipper","Lookup Swap Shipper","Searh Swap Receiver Items"};
        String transferOrderItems [] = {"Add Transfer Order","Lookup Transfer Order","Search Transfer Order","Search Transfer Order Items","",
                                        "Add Transfer Order Approval","Lookup Transfer Order Approval","All Transfer Order Approvals","",
                                        "Ship Transfer Order","Lookup Tranfer Shipper","Search Transfer Shipper","",
                                        "Receive from Transfer Shipper","Lookup Transfer Receiver"};
        String nonProductivePickingItems [] = {"Add Nonproductive Picking","Lookup Nonproductive picking","Search Nonproductive Picking","",
                                               "Nonproductive Picking Type","NonProductive Picking Approval","",
                                               "Ship NonProductive Picking","Search Part Issued for WO"};
        String physicalInventoryItems [] = {"New Physical Inventory","Lookup Physical Inventory","Changed Physical Inventory","",
                                            "Search Physical Inventory","Final Commit Inventory","",
                                            "New Cycle Count","Lookup Cycle Count","Search Cycle Count","Change Cycle Count","Final Commit Cycle Count","",
                                            "Add Part Class","Lookup Part Class","Search Part Class"};
        String proformaShippingItems [] = {"Add Proforma Shipper","Lookup PB","Lookup PF","",
                                           "Search","",
                                           "All Open Proforma Shipper","Close proforma Shipper"};
        String pickListItems [] = {"BOM Pick List","SO Pick List","WO Pick List"};
        String labelItems [] = {"Make Part Label","Make Shipping Label","Make OEM Part Label","",
                                "Add Label Template","Search Label Template","Print Label Template"};
        String vendorGroupItems [] = {"Add Proforma Receiver","Lookup proforma Receiver","Serach Proforma Receiver","",
                                      "Add Supply Chain Part","Search Supply Chain Part"};
        String reportsItems [] = {"Search Reports","Inventory Reports"};
        
       Submenu warehouse = new Submenu();
       warehouse.setLabel("Warehouse");
       warehouse.setIcon("");
       
       Submenu warehouseHome = new Submenu();
       warehouseHome.setLabel("Warehouse Home");
       createMenuItems(warehouse, warehouseHome, warehouseHomeItems);
       warehouse.getChildren().add(warehouseHome);
       
       Submenu shipping = new Submenu();
       shipping.setLabel("Shipping");
       createMenuItems(warehouse, shipping, shippingItems);
       warehouse.getChildren().add(shipping);
       
       Submenu receiving = new Submenu();
       receiving.setLabel("Receiving");
       createMenuItems(warehouse, receiving, receivingItems);
       warehouse.getChildren().add(receiving);
       
       Submenu shipListHome = new Submenu();
       shipListHome.setLabel("Ship List Home");
       createMenuItems(warehouse, shipListHome, shipListHomeItems);
       warehouse.getChildren().add(shipListHome);
       
       Submenu onLoan = new Submenu();
       onLoan.setLabel("OnLoan");
       createMenuItems(warehouse, onLoan, onLoanItems);
       warehouse.getChildren().add(onLoan);
       
       Submenu inventory = new Submenu();
       inventory.setLabel("Inventory");
       createMenuItems(warehouse, inventory, inventoryItems);
       warehouse.getChildren().add(inventory);
       
       Submenu swapOrder = new Submenu();
       swapOrder.setLabel("Swap Order");
       createMenuItems(warehouse, swapOrder, swapOrderItems);
       warehouse.getChildren().add(swapOrder);
       
       Submenu transferOrder = new Submenu();
       transferOrder.setLabel("Transfer Order");
       createMenuItems(warehouse, transferOrder, transferOrderItems);
       warehouse.getChildren().add(transferOrder);
       
       Submenu nonProductivePicking = new Submenu();
       nonProductivePicking.setLabel("NonProductive Picking");
       createMenuItems(warehouse, nonProductivePicking, nonProductivePickingItems);
       warehouse.getChildren().add(nonProductivePicking);
       
       Submenu physicalInventory = new Submenu();
       physicalInventory.setLabel("Physical Inventory");
       createMenuItems(warehouse, physicalInventory, physicalInventoryItems);
       warehouse.getChildren().add(physicalInventory);
       
       Submenu proformaShipping = new Submenu();
       proformaShipping.setLabel("Proforma Shipping");
       createMenuItems(warehouse, proformaShipping, proformaShippingItems);
       warehouse.getChildren().add(proformaShipping);
       
       Submenu pickList = new Submenu();
       pickList.setLabel("Pick List");
       createMenuItems(warehouse, pickList, pickListItems);
       warehouse.getChildren().add(pickList);
       
       Submenu label = new Submenu();
       label.setLabel("Label");
       createMenuItems(warehouse, label, labelItems);
       warehouse.getChildren().add(label);
       
       Submenu vendorGroup = new Submenu();
       vendorGroup.setLabel("Vendor Group");
       createMenuItems(warehouse, vendorGroup, vendorGroupItems);
       warehouse.getChildren().add(vendorGroup);
       
       Submenu reports = new Submenu();
       reports.setLabel("Reports");
       createMenuItems(warehouse, reports, reportsItems);
       warehouse.getChildren().add(reports);
       
       model.addSubmenu(warehouse);
        
    }
    /**
     * 
     * @param model 
     */
    public static void addAccountingMenu(MenuModel model) {
        String arItems [] = {"Add Account Receivable","Lookup Account Receivable","",
                             "Search Invoice","Search AR","Search Shipper without AR","Search Zip code Tax",
                             "AR Aging","",
                             "Lookup Statement","Customers on Credit Hold","",
                             "Search Sales Tax","Gross Margin","Monthly AR Statement","",
                             "Print AR","My AR Print List"};
        String arPrepayItems [] = {"Make AR Prepay for SO","Lookup AR Prepay","",
                                   "Search AR Prepay","Search SO's to Make AR Prepay"};
        String creditMemoItems [] = {"Add Credit Memo","Lookup Credit Memo","Search Credit Memo"};
        String apItems [] = {"Add AP","Lookup AP","Search AP","",
                             "AP Aging","Search Commission","Commission Report","Search Vendor Purchases","Zip Code Tax by AP","",
                             "Print"};
        String apAccuralItems [] = {"Add PA with Receiver Items","Lookup PA","Search PA","Overcarring PA Material Variance"};
        String apPrepayItems [] = {"Sarch AP Prepay","Lookup AP Prepay","Make AP Prepay for PO","Search POs to make AP Prepay"};
        String debitMemoItems [] = {"Lookup Debit Memo","Search Debit Memo"};
        String cashierItems [] = {"Add AR Payment Run","Add Wire Transfer","Add AR Prepament Run","Add Wire Transfer Prepayment","",
                                  "Lookup AR Payment Run","All Payment Run","",
                                  "Search Payment","Search Payment Run","",
                                  "Add Single Check","Add Prepament Single Check","Add Prepayment Wire Transfer","Add Check Run",
                                  "Add Prepayment Check Run","",
                                  "Lookup Check","Search Check","Search Check Run","All Check Run"};
        String glItems [] = {"Add GL Transaction","Lookup GL","Search GL","Create GL for DWO Receiving","",
                             "Period End Exchange Rate","Overcarring Material Price Variance","",
                             "Lookup GL Transaction","Search Current Balance","Search Check Register",};
        String accountBookItems [] = {"Chart of Account","chart of Account for CU","Transaction Type"};
        String accountingReportItems [] = {"Balance Sheet Account Category Management","Profit loss Account Category Managment","",
                                           "Search NCR's to Create Scrap GL","NCR Scrapped Report","",
                                           "Backup Document by Fiscal Year","Search Account Document","Search Profit loss Document","",
                                           "WO Item in WIP Report","Search WO Item in WIP Log"};
        String accountBPItems [] = {"Add AR BP","Search","Lookup","All AR BP"};
        String inventoryItems [] = {"Update Inventory by Part#","Reset Avg Cost","",
                                    "Search Inventory","Search Inventory Adjust","Search Historical Inventory","Search Inventory Log",
                                    "Search Cost Variance","Search Part Issue for WO","Search High Usage Part","Lookup MRP by Part#",
                                    "Search Inventory by Location","Search Part in WIP by Vendor","Search Inventory not used by Month","Search Inventory not used by Date",
                                    "Cycle Count Worksheet","",
                                    "Add Cost Roll up Worksheet","Search Cost Roll up Worksheet","Add Std Cost Change Worksheet",
                                    "Search Std Cost Change Worksheet","Roll up Std Cost"};
        String assetsItems [] = {"Add Asset","Lookup by Asset#","",
                                 "Search Assets","All Assets","All Assets Type","",
                                 "Asset Depriciation","Asset Depricaition yearly Report","",
                                 "Fixed Assets Disposals","Fixed Assets Addition","Search Depriciation"};
        String budgetItems [] = {"Cash Flow Budget","Fiscal Year Budget","Monthly Budget & YDT Report"};
        String reportsItems [] = {"Search Reports","Inventory Reports","Search All Part in SIP","Search All Part in QA"};
        
       Submenu accounting = new Submenu();
       accounting.setLabel("Accounting");
       accounting.setIcon("");
       
       Submenu ar = new Submenu();
       ar.setLabel("AR");
       createMenuItems(accounting, ar, arItems);
       accounting.getChildren().add(ar);
       
       Submenu arPrepay = new Submenu();
       arPrepay.setLabel("AR Prepay");
       createMenuItems(accounting, arPrepay, arPrepayItems);
       accounting.getChildren().add(arPrepay);
       
       Submenu creditMemo = new Submenu();
       creditMemo.setLabel("Credit Memo");
       createMenuItems(accounting, creditMemo, creditMemoItems);
       accounting.getChildren().add(creditMemo);
       
       Submenu ap = new Submenu();
       ap.setLabel("Account Payable");
       createMenuItems(accounting, ap, apItems);
       accounting.getChildren().add(ap);
       
       Submenu apAccural = new Submenu();
       apAccural.setLabel("AP Accural");
       createMenuItems(accounting, apAccural, apAccuralItems);
       accounting.getChildren().add(apAccural);
       
       Submenu apPrepay = new Submenu();
       apPrepay.setLabel("AP Prepay");
       createMenuItems(accounting, apPrepay, apPrepayItems);
       accounting.getChildren().add(apPrepay);
       
       Submenu debitMemo = new Submenu();
       debitMemo.setLabel("Debit Memo");
       createMenuItems(accounting, debitMemo, debitMemoItems);
       accounting.getChildren().add(debitMemo);
       
       Submenu cashier = new Submenu();
       cashier.setLabel("Cashier");
       createMenuItems(accounting, cashier, cashierItems);
       accounting.getChildren().add(cashier);
       
       Submenu gl = new Submenu();
       gl.setLabel("GL");
       createMenuItems(accounting, gl, glItems);
       accounting.getChildren().add(gl);
       
       Submenu accountBook = new Submenu();
       accountBook.setLabel("Account Book");
       createMenuItems(accounting, accountBook, accountBookItems);
       accounting.getChildren().add(accountBook);
       
       Submenu accountingReport = new Submenu();
       accountingReport.setLabel("Accounting Report");
       createMenuItems(accounting, accountingReport, accountingReportItems);
       accounting.getChildren().add(accountingReport);
       
       Submenu accountBP = new Submenu();
       accountBP.setLabel("Account BP");
       createMenuItems(accounting, accountBP, accountBPItems);
       accounting.getChildren().add(accountBP);
       
       Submenu inventory = new Submenu();
       inventory.setLabel("Inventory");
       createMenuItems(accounting, inventory, inventoryItems);
       accounting.getChildren().add(inventory);
       
       Submenu assets = new Submenu();
       assets.setLabel("Assets");
       createMenuItems(accounting, assets, assetsItems);
       accounting.getChildren().add(assets);
       
       Submenu budget = new Submenu();
       budget.setLabel("Budget");
       createMenuItems(accounting, budget, budgetItems);
       accounting.getChildren().add(budget);
       
       Submenu reports = new Submenu();
       reports.setLabel("Reports");
       createMenuItems(accounting, reports, reportsItems);
       accounting.getChildren().add(reports);
       
       MenuItem accountingInfoCenter = new MenuItem();
       accountingInfoCenter.setValue("Accounting Info Center");
       accountingInfoCenter.setUrl("#");
       accounting.getChildren().add(accountingInfoCenter);
       
       model.addSubmenu(accounting);
    }
    /**
     * 
     * @param model 
     */
    public static void addAddressBookMenu(MenuModel model) {
        String customerItems [] = {"Add Customer","Lookup Customer","",
                                   "Search Customer","",
                                   "Add Customer Type","Search Customer Type","Init Address Type","Search by Expiry Date"};
        String vendorItems [] = {"Add Vendor","Lookup Vendor","",
                                 "Search Vendor","",
                                 "Add Vendor Type","Search Vendor Type","Add Vendor Category","Search Vendor Categories","",
                                 "Add Vendor Critcal Level","All Vendor Critical Level"};
        String departmentItems [] = {"Add Department","Lookup Department","Search Department"};
        String manufacturerItems [] = {"Add Manufacturer","Lookup Manufacturer","Search Manufacturer"};
        
       Submenu addressBook = new Submenu();
       addressBook.setLabel("Address Book");
       addressBook.setIcon("");
       
       Submenu vendor = new Submenu();
       vendor.setLabel("Vendor");
       createMenuItems(addressBook, vendor, vendorItems);
       addressBook.getChildren().add(vendor);
       
       Submenu customer = new Submenu();
       customer.setLabel("Customer");
       createMenuItems(addressBook, customer, customerItems);
       addressBook.getChildren().add(customer);
       
       Submenu department = new Submenu();
       department.setLabel("Department");
       createMenuItems(addressBook, department, departmentItems);
       addressBook.getChildren().add(department);
       
       Submenu manufacturer = new Submenu();
       manufacturer.setLabel("Manufacturer");
       createMenuItems(addressBook, manufacturer, manufacturerItems);
       addressBook.getChildren().add(manufacturer);
       
        model.addSubmenu(addressBook);
    }
    /**
     * 
     * @param model 
     */
    public static void addHRMenu(MenuModel model) {
        String empCardItems [] = {"Add Employee","Lookup Employee","",
                                  "Search Employee","Search Records"};
        String tempWorkerItems [] = {"Add Temporary Card","Lookup Temporary Card","Search Records","Search Temporary Card"};

       Submenu hr = new Submenu();
       hr.setLabel("HR");
       hr.setIcon("");
       
       Submenu empCard = new Submenu();
       empCard.setLabel("Employee Card");
       createMenuItems(hr, empCard, empCardItems);
       hr.getChildren().add(empCard);
       
       Submenu tempWorker = new Submenu();
       tempWorker.setLabel("Temporary Worker");
       createMenuItems(hr, tempWorker, tempWorkerItems);
       hr.getChildren().add(tempWorker);
       
       MenuItem companyAddressBook = new MenuItem();
       companyAddressBook.setValue("Company Address Book");
       companyAddressBook.setUrl("#");
       hr.getChildren().add(companyAddressBook);
       
        model.addSubmenu(hr);
    }
    /**
     * 
     * @param model 
     */
    public static void addPlanningMenu(MenuModel model) {
        String planningItems [] = {"Lookup Part Master","Lookup where Used","Lookup BOM Cost","Project Status Report"};
        String shipListItems [] = {"Add Ship List","Lookup Ship List","Search","Search by Owner","",
                                   "Add Ship List Owner","Lookup Ship List Owner","Search Ship List Owner"};
        
       Submenu planning = new Submenu();
       planning.setLabel("Planning");
       planning.setIcon("");
       
       Submenu planningItem = new Submenu();
       planningItem.setLabel("Planning");
       createMenuItems(planning, planningItem, planningItems);
       planning.getChildren().add(planningItem);
       
       Submenu shipList = new Submenu();
       shipList.setLabel("Ship List");
       createMenuItems(planning, shipList, shipListItems);
       planning.getChildren().add(shipList);
       
        model.addSubmenu(planning);
    }
    /**
     * 
     * @param model 
     */
    public static void addCustomerServiceMenu(MenuModel model) {
        String customerServiceIncidentItems [] = {"Add Incident","Lookup Incident","Search Incident","Open Incidents"};
        String customerFeedbackItems [] = {"Add Feedback","Lookup Feedback","Search Feedback","All Feedback","",
                                           "Add Question","Lookup Question","All Question"};
        String rmaItems [] = {"Add RMA","Lookup RMA","",
                              "Search RMA","Past Due RMAs","Open RMAs","RMA Check List","",
                              "Add RMA Review","Lookup RMA Review","All RMA Approvals"};
        
       Submenu customerService = new Submenu();
       customerService.setLabel("Customer Service");
       customerService.setIcon("");
       
       Submenu customerServiceIncident = new Submenu();
       customerServiceIncident.setLabel("CS Incident");
       createMenuItems(customerService, customerServiceIncident, customerServiceIncidentItems);
       customerService.getChildren().add(customerServiceIncident);
       
       Submenu customerFeedback = new Submenu();
       customerFeedback.setLabel("Customer Feedback");
       createMenuItems(customerService, customerFeedback, customerFeedbackItems);
       customerService.getChildren().add(customerFeedback);
       
       Submenu rma = new Submenu();
       rma.setLabel("RMA");
       createMenuItems(customerService, rma, rmaItems);
       customerService.getChildren().add(rma);
       
        model.addSubmenu(customerService);
    }
    /**
     * 
     * @param model 
     */
    public static void addSecurityMenu(MenuModel model) {
        String userItems [] = {"Add User","All Users","All Online Users","",
                               "Reset All Expired Dates","",
                               "Search by User Name","Search by employee ID","Search by Permissions"};
        String roleItems [] = {"Add Role","All Roles","Search by Role ID"};
        String permissionItems [] = {"All Permissions","Search by Permission ID"};
        String operationLogItems [] = {"Search by Date","Search by Last Name","Search by User Name","Searcy by Legal Name",
                                       "Search by Target","Search by Action"};
       Submenu security = new Submenu();
       security.setLabel("Security");
       security.setIcon("");
       
       Submenu user = new Submenu();
       user.setLabel("User");
       createMenuItems(security, user, userItems);
       security.getChildren().add(user);
       
       Submenu role = new Submenu();
       role.setLabel("Role");
       createMenuItems(security, role, roleItems);
       security.getChildren().add(role);
       
       Submenu permission = new Submenu();
       permission.setLabel("Permission");
       createMenuItems(security, permission, permissionItems);
       security.getChildren().add(permission);
       
       Submenu operationLog = new Submenu();
       operationLog.setLabel("Operation Log");
       createMenuItems(security, operationLog, operationLogItems);
       security.getChildren().add(operationLog);
       
        model.addSubmenu(security);
    }
    /**
     * 
     * @param model 
     */
    public static void addDocumentMenu(MenuModel model) {
        String partDocumentItems [] = {"Upload Part Document","Search Document","Search Part Document Log"};
        String documentSettingsItems [] = {"Add Misc Document Setting","Search All","Search by Date"};

       Submenu document = new Submenu();
       document.setLabel("Document");
       document.setIcon("");
       
       Submenu partDocument = new Submenu();
       partDocument.setLabel("Part Document");
       createMenuItems(document, partDocument, partDocumentItems);
       document.getChildren().add(partDocument);
       
       Submenu documentSettings = new Submenu();
       documentSettings.setLabel("Document Setting");
       createMenuItems(document, documentSettings, documentSettingsItems);
       document.getChildren().add(documentSettings);
       
        model.addSubmenu(document);
    }
    /**
     * 
     * @param model 
     */
    public static void addControlPanelMenu(MenuModel model) {
        String generalSettingItems [] = {"Company Setting","Security Policy","ENG Drawing Setting","MFG Drawing Setting",
                                         "Setup Mail Server","Custom Properties","",
                                         "All Weight UOM","Add Part Type","All Part tool UOM","Search Part Type","Searcy Buyer Codes","All Print Logos","All Term & Conditions"};
        String accountingSettingItems [] = {"Search Currency","All Terms","All Tax Accounts","All Zip Codes","",
                                            "Company Accounting Setting","Initialize Account Balances","",
                                            "Tax Account Setup"};
        String schedularManagmentItems [] = {"Schedular Management","Search Schedular Task Log"};
        String approvalManagmentItems [] = {"All PO Approvals","All RTV Approvals","All SO Approvals","All WO Approvals",
                                            "All WI Approvals","All RMA Approvals","",
                                            "All Swap Order Approvals","All NCR Approval","All OnLoan Approvals","All Transfer Order Approvals"};
        String auditCenterItems [] = {"Audit Part BOM Flag","Audit Part/Tool Drawing Flag","Audit Part WI Flag","Audit Part Picture Flg",
                                      "",
                                      "Search Part Inventory by Backup","Search Part InSIP","Audit Part onHand by Location","",
                                      "Clear BOM without Items","Audit Recursive BOM","",
                                      "Search AR","Search AP","Audit AR without Tracking#","",
                                      "Search WI Seq with 0 Runtime Hour","Audit WI Avg Hour","Audit WIP/OnOrder/OnDemand/Qtr Usage/Yearly Usage","",
                                      "Search Part OnHand<= Min Qty","Audit Last Inventory","",
                                      "Search Part Inventory from Worksheet","Search Part Inventory QA"};
        String companyUnitItems [] = {"Add Compnay Unit","All Company Unit","Structure","Search"};
        String infoCenterItems [] = {"Sales","Engineering","Accounting","Work Order","Purchasing","Quality","Warehouse"};
        String noticeUserGroupItems [] = {"Add User Group","All User Group","",
                                          "Add System User Group","All System User Group"};
        String documentSettingItems [] = {"Add Misc Document Setting","All Misc Document Setting","Search by Date"};
        String importDataItems [] = {"Import Part","Import BOM","Import Part Inventory","Import NC Code","Import Customer",
                                     "Import Vendor","Import Department","Import Employee","Import Manufacturer","Import MPN",
                                     "Import Material","Part Inventory Basic Info","Import Tool Master","Tool Master Inventory"};
        String appExtensionsItems [] = {};
        
       Submenu controlPanel = new Submenu();
       controlPanel.setLabel("Control Panel");
       controlPanel.setIcon("");
       
       Submenu generalSetting = new Submenu();
       generalSetting.setLabel("General Setting");
       createMenuItems(controlPanel, generalSetting, generalSettingItems);
       controlPanel.getChildren().add(generalSetting);
       
       Submenu accountingSetting = new Submenu();
       accountingSetting.setLabel("Accounting Setting");
       createMenuItems(controlPanel, accountingSetting, accountingSettingItems);
       controlPanel.getChildren().add(accountingSetting);
       
       Submenu schedularManagment = new Submenu();
       schedularManagment.setLabel("Schedular Managment");
       createMenuItems(controlPanel, schedularManagment, schedularManagmentItems);
       controlPanel.getChildren().add(schedularManagment);
       
       Submenu approvalManagment = new Submenu();
       approvalManagment.setLabel("Approval Managment");
       createMenuItems(controlPanel, approvalManagment, approvalManagmentItems);
       controlPanel.getChildren().add(approvalManagment);
       
       Submenu auditCenter = new Submenu();
       auditCenter.setLabel("Audit Center");
       createMenuItems(controlPanel, auditCenter, auditCenterItems);
       controlPanel.getChildren().add(auditCenter);
       
       Submenu companyUnit = new Submenu();
       companyUnit.setLabel("Company Unit");
       createMenuItems(controlPanel, companyUnit, companyUnitItems);
       controlPanel.getChildren().add(companyUnit);
       
       Submenu infoCenter = new Submenu();
       infoCenter.setLabel("Info Center");
       createMenuItems(controlPanel, infoCenter, infoCenterItems);
       controlPanel.getChildren().add(infoCenter);
       
       Submenu noticeUserGroup = new Submenu();
       noticeUserGroup.setLabel("Notice User Group");
       createMenuItems(controlPanel, noticeUserGroup, noticeUserGroupItems);
       controlPanel.getChildren().add(noticeUserGroup);
       
       Submenu documentSetting = new Submenu();
       documentSetting.setLabel("Document Setting");
       createMenuItems(controlPanel, documentSetting, documentSettingItems);
       controlPanel.getChildren().add(documentSetting);
       
       Submenu importData = new Submenu();
       importData.setLabel("Import Data");
       createMenuItems(controlPanel, importData, importDataItems);
       controlPanel.getChildren().add(importData);
       
       Submenu appExtensions = new Submenu();
       appExtensions.setLabel("App Extensions");
       createMenuItems(controlPanel, appExtensions, appExtensionsItems);
       controlPanel.getChildren().add(appExtensions);
       
       MenuItem about = new MenuItem();
       about.setValue("About");
       about.setUrl("#");
       controlPanel.getChildren().add(about);
       
       model.addSubmenu(controlPanel);
        
    }
    
    private static void createMenuItems(Submenu parent, Submenu subMenu, String [] titles) {
        for (String title:titles) {
            if (title.equals("")) {
                Separator sp = new Separator();
                sp.setStyle("width:170px;height:1px");
                subMenu.getChildren().add(sp);
            }
            else {
                MenuItem menuItem = new MenuItem();
                menuItem.setValue(title);              
                String id = createComponentId(parent.getLabel(), subMenu.getLabel(), title);
                menuItem.setId(id);
               // menuItem.addActionListener(createActionListener("#{navigationBean.handleNavigation}"));
               // menuItem.setUpdate("contentPanel");
                menuItem.setAjax(false);                
                subMenu.getChildren().add(menuItem);
            }
        }
    }
      
     /**
      * 
      * @param actionExpression
      * @param returnType
      * @return 
      */
     public static MethodExpression createAction(String actionExpression, Class<?> returnType) {
            FacesContext context = FacesContext.getCurrentInstance();
            return context.getApplication().getExpressionFactory()
            .createMethodExpression(context.getELContext(), actionExpression, returnType, new Class[0]);
    }
    /**
     * 
     * @param actionListenerExpression
     * @return 
     */ 
    public static MethodExpressionActionListener createActionListener(String actionListenerExpression) {
            FacesContext context = FacesContext.getCurrentInstance();
            return new MethodExpressionActionListener(context.getApplication().getExpressionFactory()
            .createMethodExpression(context.getELContext(), actionListenerExpression, null, new Class[] {ActionEvent.class}));
    }
    
    public static String createComponentId(String topCategory,String subCategory,String itemLabel) {
        // remove spaces
        topCategory = topCategory.replaceAll("\\s", "");
        subCategory = subCategory.replaceAll("\\s", "");
        itemLabel = itemLabel.replaceAll("\\s", "");
        //now remove All special Charaters
        topCategory = topCategory.replaceAll("[^a-zA-Z0-9]+", "");
        subCategory = subCategory.replaceAll("[^a-zA-Z0-9]+", "");
        itemLabel = itemLabel.replaceAll("[^a-zA-Z0-9]+", "");
        
        // now concate all with _ separated.
        String id = topCategory+"_"+subCategory+"_"+itemLabel;
        return id;
        
    }

}
