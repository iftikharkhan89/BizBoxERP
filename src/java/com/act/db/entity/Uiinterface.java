/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.db.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iftikhar
 */
@Entity
@Table(name = "UIINTERFACE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uiinterface.findAll", query = "SELECT u FROM Uiinterface u"),
    @NamedQuery(name = "Uiinterface.findByUiinterfaceId", query = "SELECT u FROM Uiinterface u WHERE u.uiinterfaceId = :uiinterfaceId"),
    @NamedQuery(name = "Uiinterface.findByUiinterfaceName", query = "SELECT u FROM Uiinterface u WHERE u.uiinterfaceName = :uiinterfaceName"),
    @NamedQuery(name = "Uiinterface.findByDescription", query = "SELECT u FROM Uiinterface u WHERE u.description = :description")})
public class Uiinterface implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UIINTERFACE_ID")
    private String uiinterfaceId;
    @Basic(optional = false)
    @Column(name = "UIINTERFACE_NAME")
    private String uiinterfaceName;
    @Column(name = "DESCRIPTION")
    private String description;

    public Uiinterface() {
    }

    public Uiinterface(String uiinterfaceId) {
        this.uiinterfaceId = uiinterfaceId;
    }

    public Uiinterface(String uiinterfaceId, String uiinterfaceName) {
        this.uiinterfaceId = uiinterfaceId;
        this.uiinterfaceName = uiinterfaceName;
    }

    public String getUiinterfaceId() {
        return uiinterfaceId;
    }

    public void setUiinterfaceId(String uiinterfaceId) {
        this.uiinterfaceId = uiinterfaceId;
    }

    public String getUiinterfaceName() {
        return uiinterfaceName;
    }

    public void setUiinterfaceName(String uiinterfaceName) {
        this.uiinterfaceName = uiinterfaceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uiinterfaceId != null ? uiinterfaceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uiinterface)) {
            return false;
        }
        Uiinterface other = (Uiinterface) object;
        if ((this.uiinterfaceId == null && other.uiinterfaceId != null) || (this.uiinterfaceId != null && !this.uiinterfaceId.equals(other.uiinterfaceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.act.db.entity.Uiinterface[ uiinterfaceId=" + uiinterfaceId + " ]";
    }
    
}
