/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.db.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iftikhar
 */
@Entity
@Table(name = "ROLEUIREL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roleuirel.findAll", query = "SELECT r FROM Roleuirel r"),
    @NamedQuery(name = "Roleuirel.findByRoleId", query = "SELECT r FROM Roleuirel r WHERE r.roleuirelPK.roleId = :roleId"),
    @NamedQuery(name = "Roleuirel.findByUiinterfaceId", query = "SELECT r FROM Roleuirel r WHERE r.roleuirelPK.uiinterfaceId = :uiinterfaceId")})
public class Roleuirel implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RoleuirelPK roleuirelPK;

    public Roleuirel() {
    }

    public Roleuirel(RoleuirelPK roleuirelPK) {
        this.roleuirelPK = roleuirelPK;
    }

    public Roleuirel(String roleId, String uiinterfaceId) {
        this.roleuirelPK = new RoleuirelPK(roleId, uiinterfaceId);
    }

    public RoleuirelPK getRoleuirelPK() {
        return roleuirelPK;
    }

    public void setRoleuirelPK(RoleuirelPK roleuirelPK) {
        this.roleuirelPK = roleuirelPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleuirelPK != null ? roleuirelPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roleuirel)) {
            return false;
        }
        Roleuirel other = (Roleuirel) object;
        if ((this.roleuirelPK == null && other.roleuirelPK != null) || (this.roleuirelPK != null && !this.roleuirelPK.equals(other.roleuirelPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.act.db.entity.Roleuirel[ roleuirelPK=" + roleuirelPK + " ]";
    }
    
}
