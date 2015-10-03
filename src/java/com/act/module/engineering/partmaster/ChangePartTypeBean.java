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
public class ChangePartTypeBean {
    private String partNumber;
    private String oldSelectedType;
    private String newSelectedType;
    /**
     * Creates a new instance of ChangePartTypeBean
     */
    public ChangePartTypeBean() {
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getOldSelectedType() {
        return oldSelectedType;
    }

    public void setOldSelectedType(String oldSelectedType) {
        this.oldSelectedType = oldSelectedType;
    }

    public String getNewSelectedType() {
        return newSelectedType;
    }

    public void setNewSelectedType(String newSelectedType) {
        this.newSelectedType = newSelectedType;
    }
    public void changeType(){
        
    }
}
