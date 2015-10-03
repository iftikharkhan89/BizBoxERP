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
public class SearchPartMasterBean {

    private String partNumber;
    private String selectedPartType;
    private String description;
    private String language;
    private String model;
    private String commodityCode;
    private String productCode;
    private String makeBuy;
    private String criteria;
    
    /**
     * Creates a new instance of SearchPartMasterBean
     */
    public SearchPartMasterBean() {
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getSelectedPartType() {
        return selectedPartType;
    }

    public void setSelectedPartType(String selectedPartType) {
        this.selectedPartType = selectedPartType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getMakeBuy() {
        return makeBuy;
    }

    public void setMakeBuy(String makeBuy) {
        this.makeBuy = makeBuy;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }
   
    public void searchPart() {
        
    }
}
