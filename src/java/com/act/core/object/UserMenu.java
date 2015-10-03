/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.core.object;

/**
 *
 * @author iftikhar
 */
public class UserMenu implements UIInterface{
    private String id;
    private String name;
    private boolean visible;

    public UserMenu() {
        
    }
    public UserMenu(String id, String name, boolean visible) {
        this.id = id;
        this.name = name;
        this.visible = visible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
}
