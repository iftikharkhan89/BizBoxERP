/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.module.engineering.partmaster;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Iftikhar.Khan
 */
@ManagedBean
@RequestScoped
public class PartMasterBean {
private List partTypes;
    private List allUOM;
    /**
     * Creates a new instance of PartMasterBean
     */
    public PartMasterBean() {
        partTypes = new ArrayList();
        partTypes.add("P/A");
        partTypes.add("TECH_SHEET");
        partTypes.add("ENGINEERING_DOC");
        partTypes.add("QUALITY_DOC");
        partTypes.add("MANUAL");
        partTypes.add("OVERVIEW");
        partTypes.add("TROUBLESHOOTING");
        
        allUOM = new ArrayList();
        allUOM.add("EA");
    }

    public List getPartTypes() {
        return partTypes;
    }

    public void setPartTypes(List partTypes) {
        this.partTypes = partTypes;
    }

    public List getAllUOM() {
        return allUOM;
    }

    public void setAllUOM(List allUOM) {
        this.allUOM = allUOM;
    }
    
}
