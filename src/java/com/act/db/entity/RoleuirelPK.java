/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.db.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author iftikhar
 */
@Embeddable
public class RoleuirelPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ROLE_ID")
    private String roleId;
    @Basic(optional = false)
    @Column(name = "UIINTERFACE_ID")
    private String uiinterfaceId;

    public RoleuirelPK() {
    }

    public RoleuirelPK(String roleId, String uiinterfaceId) {
        this.roleId = roleId;
        this.uiinterfaceId = uiinterfaceId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUiinterfaceId() {
        return uiinterfaceId;
    }

    public void setUiinterfaceId(String uiinterfaceId) {
        this.uiinterfaceId = uiinterfaceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        hash += (uiinterfaceId != null ? uiinterfaceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleuirelPK)) {
            return false;
        }
        RoleuirelPK other = (RoleuirelPK) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        if ((this.uiinterfaceId == null && other.uiinterfaceId != null) || (this.uiinterfaceId != null && !this.uiinterfaceId.equals(other.uiinterfaceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.act.db.entity.RoleuirelPK[ roleId=" + roleId + ", uiinterfaceId=" + uiinterfaceId + " ]";
    }
    
}
