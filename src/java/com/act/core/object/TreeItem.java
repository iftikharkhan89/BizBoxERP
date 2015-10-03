/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.core.object;

/**
 *
 * @author iftikhar
 */
public class TreeItem extends UserMenu{
  
    private boolean rootNode;
    private boolean childNode;
    private TreeItem parent;

    public TreeItem(UserMenu userMenu,boolean rootNode, boolean childNode, TreeItem parent) {
        setId(userMenu.getId());
        setName(userMenu.getName());
        setVisible(userMenu.isVisible());
        this.rootNode = rootNode;
        this.childNode = childNode;
        this.parent = parent;
    }
    public TreeItem(UserMenu userMenu) {
        this(userMenu,true,false,null);
    }
    
    public boolean isRootNode() {
        return rootNode;
    }

    public void setRootNode(boolean rootNode) {
        this.rootNode = rootNode;
    }

    public boolean isChildNode() {
        return childNode;
    }

    public void setChildNode(boolean childNode) {
        this.childNode = childNode;
    }

    public TreeItem getParent() {
        return parent;
    }

    public void setParent(TreeItem parent) {
        this.parent = parent;
    }

    
}
