/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.module.engineering.partmaster;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Iftikhar.Khan
 */
@ManagedBean
@RequestScoped
public class PartsMasterReportsBean {

    private int listPriceAdjustPercent;
    private String commodityCode;
    private String billNumber;
    private String selectedPartType;
    
    /**
     * Creates a new instance of PartsMasterReportsBean
     */
    public PartsMasterReportsBean() {
    }
    
    public void searchPartsOnHold() {
        
    }
    public void searchPartsWithBOM() {
        
    }
    public void searchPartsWithWorkInstruction() {
        
    }
    public void searchInactiveParts() {
        
    }

    public void batchUpdatePartListPrice() {
        
    }
    public void searchBOMItemByBOMNumber() {
        
    }
    public int getListPriceAdjustPercent() {
        return listPriceAdjustPercent;
    }

    public void setListPriceAdjustPercent(int listPriceAdjustPercent) {
        this.listPriceAdjustPercent = listPriceAdjustPercent;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public String getSelectedPartType() {
        return selectedPartType;
    }

    public void setSelectedPartType(String selectedPartType) {
        this.selectedPartType = selectedPartType;
    }
    
    
}
