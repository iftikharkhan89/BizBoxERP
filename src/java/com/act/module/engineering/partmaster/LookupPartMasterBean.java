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
public class LookupPartMasterBean {

    private String partNumber;
    private String selectedType;
    /**
     * Creates a new instance of LookupPartMasterBean
     */
    public LookupPartMasterBean() {
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(String selectedType) {
        this.selectedType = selectedType;
    }
    
    public void lookupPartMaster() {
        
    }
    public void lookupPartMasterWhereUsed() {
        
    }
}
