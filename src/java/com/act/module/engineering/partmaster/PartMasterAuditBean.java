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
public class PartMasterAuditBean {

    private String filterKey;
    /**
     * Creates a new instance of PartMasterAuditBean
     */
    public PartMasterAuditBean() {
    }
    
    public void doAuditPart(String action) {
        
    }

    public String getFilterKey() {
        return filterKey;
    }

    public void setFilterKey(String filterKey) {
        this.filterKey = filterKey;
    }
    
}
