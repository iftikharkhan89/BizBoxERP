/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.module.security;

import bb.common.BizBoxServer;
import bb.common.Configure;
import bb.common.PermissionVO;
import bb.common.RoleVO;
import bb.gui.ServerActionException;
import bb.gui.server.ServerActionUtil;
import com.act.module.login.LoginConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author iftikhar
 */
@ManagedBean
@RequestScoped
public class AddRoleBean {

    private String roleId;
    private String roleName;
    private String description;
    private boolean editable;
    private TreeNode root;
    private ArrayList selectedNodes;
  
    /**
     * Creates a new instance of AddRoleBean
     */
    public AddRoleBean() {
        buildTree();     
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEditable() {
        return editable;
    }
    
    public String save(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(roleId, "Role is Saved.!!!"));
        return null;
   /*     Set permissions = new HashSet();
        permissions.addAll(this.selectedNodes);
        RoleVO vo = new RoleVO();
        vo.setRoleId(this.getRoleId());
        vo.setSystem(false);
        vo.setRolePermissions(permissions);
        Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        BizBoxServer server = (BizBoxServer) sessionMap.get(LoginConstants.SERVER_INSTANCE);
        if (server != null) {
            try {
                ServerActionUtil.setTargetServer(server);
                Object params [] = {vo};
                RoleVO roleVO = (RoleVO) ServerActionUtil.invoke(Configure.Module.SECURITY, "addRole", params);
                if (roleVO != null) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(roleId, "Role is Saved.!!!"));
                }
                return "addRoleSuccess";
            } catch (ServerActionException ex) {
                Logger.getLogger(AddUserBean.class.getName()).log(Level.SEVERE, null, ex);
                return "addRolefailure";
            }
        }
       return "addRolefailure";
        */
    }
    
    public void update() {
        
    }
    public void reset() {
        
    }

    /**
     * @return the treeRoot
     */
    public TreeNode getRoot() {
       return root;
    }

    /**
     * @param treeRoot the treeRoot to set
     */
    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * @return the selectedNodes
     */
    public ArrayList getSelectedNodes() {
        return selectedNodes;
    }

    /**
     * @param selectedNodes the selectedNodes to set
     */
    public void setSelectedNodes(ArrayList selectedNodes) {
        this.selectedNodes = selectedNodes;
    }
    
    private void buildTree() {
        Collection<PermissionVO> allPermissions = findAllPermissions();
        Collection<PermissionVO> level0 = new ArrayList<PermissionVO>();
        Collection<PermissionVO> level1 = new ArrayList<PermissionVO>();
        Collection<PermissionVO> level2 = new ArrayList<PermissionVO>();
        Collection<PermissionVO> level3 = new ArrayList<PermissionVO>();
        Collection<PermissionVO> level4 = new ArrayList<PermissionVO>();
        Iterator iterator = allPermissions.iterator();
        while (iterator.hasNext()) {
            PermissionVO vo = (PermissionVO) iterator.next();
            int level = vo.getLevel();
            switch (level) {
                case 0:
                    level0.add(vo);
                    break;
                case 1:
                    level1.add(vo);
                    break;
                case 2:
                    level2.add(vo);
                    break;
                case 3:
                    level3.add(vo);
                    break;
                case 4:
                    level4.add(vo);
                    break;
            }
        }
      // create root node
      Iterator rootIterator = level0.iterator();
      while (rootIterator.hasNext()) {
          PermissionVO vo = (PermissionVO) rootIterator.next();
          root = new DefaultTreeNode(vo.getPermissionId(),null);
          //root.setSelectable(vo.isPermission());
      }
      // create level 1 node
      Iterator level1Iterator = level1.iterator();
      Collection<TreeNode> level1Nodes = new ArrayList<TreeNode>();
      while (level1Iterator.hasNext()) {
          PermissionVO vo = (PermissionVO)level1Iterator.next();
          TreeNode node = new DefaultTreeNode(vo.getPermissionId(),root);
         // node.setSelectable(vo.isPermission());
          level1Nodes.add(node);
      }
      
      // Create level 2 nodes
      Iterator level2Iterator = level2.iterator();
      Collection<TreeNode> level2Nodes = new ArrayList<TreeNode>();
      while(level2Iterator.hasNext()) {
          PermissionVO vo = (PermissionVO) level2Iterator.next();
          TreeNode node = new DefaultTreeNode(vo.getPermissionId(),findParentNode(level1Nodes,vo.getParentId()));
          //node.setSelectable(vo.isPermission());
          level2Nodes.add(node);
      }
      
      // Create level 3 nodes
      Iterator level3Iterator = level3.iterator();
      Collection<TreeNode> level3Nodes = new ArrayList<TreeNode>();
      while (level3Iterator.hasNext()) {
          PermissionVO vo = (PermissionVO) level3Iterator.next();
          TreeNode node = new DefaultTreeNode(vo.getPermissionId(),findParentNode(level2Nodes,vo.getParentId()));
          //node.setSelectable(vo.isPermission());
          if (!vo.isPermission()) {
              level3Nodes.add(node);
          }
      }
      
      // Create level 4 nodes
      Iterator level4Iterator = level4.iterator();
      Collection<TreeNode> level4Nodes = new ArrayList<TreeNode>();
      while (level4Iterator.hasNext()) {
          PermissionVO vo = (PermissionVO) level4Iterator.next();
          TreeNode node = new DefaultTreeNode(vo.getPermissionId(),findParentNode(level3Nodes, vo.getParentId()));
         // node.setSelectable(vo.isPermission());
          level4Nodes.add(node);
      }
      
      
  }
    private TreeNode findParentNode(Collection<TreeNode> upperLevelNodes, String parentId) {
       
        for (TreeNode node:upperLevelNodes) {
           if (node.getData().toString().equals(parentId)) {
               return node;
           }
        }
        return null;
    }
       
    private Collection<PermissionVO> findAllPermissions() {
       Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap(); 
       BizBoxServer server = (BizBoxServer) sessionMap.get(LoginConstants.SERVER_INSTANCE);
          // BizBoxServer server = new BizBoxServer("127.0.0.1", "8080", "TEST", "admin", "", "en");
           ServerActionUtil.setTargetServer(server); 
        if (server != null) {
            try {
                    Object [] param = new Object[3];
                    param[0] = false;
                    param[1] = 0;
                    param[2] = 1000;
                    Object result = ServerActionUtil.invoke(Configure.Module.SECURITY, "findAllPermission", param);
                    Collection<PermissionVO> permissionsList = (java.util.Collection<PermissionVO>)result;
                     /*   for (PermissionVO r:permissionsList){
                            if (!r.isPermission()) {
                                System.out.println(r.getPermissionId());
                                System.out.println(r.isPermission());
                                System.out.println(r.getParentId());
                                System.out.println();
                            }
                        }*/
                 return permissionsList;         
                } catch (ServerActionException ex) {
                    Logger.getLogger(AddUserBean.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
            }
        }
        return null; 
    }
}
