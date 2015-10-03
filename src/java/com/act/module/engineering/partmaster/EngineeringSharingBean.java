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
public class EngineeringSharingBean {

    private int selectedButton;
    /**
     * Creates a new instance of EngineeringSharingBean
     */
    public EngineeringSharingBean() {
        selectedButton = 1;
    }

    public int getSelectedButton() {
        return selectedButton;
    }

    public void setSelectedButton(int selectedButton) {
        this.selectedButton = selectedButton;
    }
    
}
