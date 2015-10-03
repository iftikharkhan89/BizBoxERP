/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.core.object;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author iftikhar
 */
public class ERPMenu implements Serializable{
    private String headItem;
    private List<String> subItems;
    private boolean visible;

    public String getHeadItem() {
        return headItem;
    }

    public void setHeadItem(String headItem) {
        this.headItem = headItem;
    }

    public List<String> getSubItems() {
        return subItems;
    }

    public void setSubItems(List<String> subItems) {
        this.subItems = subItems;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
}
