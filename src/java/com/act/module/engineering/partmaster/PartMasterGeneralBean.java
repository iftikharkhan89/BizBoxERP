/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.module.engineering.partmaster;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Iftikhar.Khan
 */
@ManagedBean
@RequestScoped
public class PartMasterGeneralBean {

private List<String> selectedOptions;
private int selectedButton;

    /**
     * Creates a new instance of PartMasterGeneralBean
     */
    public PartMasterGeneralBean() {
        selectedButton = 1;
        
    }

    public List<String> getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(List<String> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    public int getSelectedButton() {
        return selectedButton;
    }

    public void setSelectedButton(int selectedButton) {
        this.selectedButton = selectedButton;
    }
}
