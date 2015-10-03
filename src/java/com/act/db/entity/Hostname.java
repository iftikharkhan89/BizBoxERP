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
@Table(name = "HOSTNAME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hostname.findAll", query = "SELECT h FROM Hostname h"),
    @NamedQuery(name = "Hostname.findByHostnamevalue", query = "SELECT h FROM Hostname h WHERE h.hostnamevalue = :hostnamevalue")})
public class Hostname implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "HOSTNAMEVALUE")
    private String hostnamevalue;

    public Hostname() {
    }

    public Hostname(String hostnamevalue) {
        this.hostnamevalue = hostnamevalue;
    }

    public String getHostnamevalue() {
        return hostnamevalue;
    }

    public void setHostnamevalue(String hostnamevalue) {
        this.hostnamevalue = hostnamevalue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hostnamevalue != null ? hostnamevalue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hostname)) {
            return false;
        }
        Hostname other = (Hostname) object;
        if ((this.hostnamevalue == null && other.hostnamevalue != null) || (this.hostnamevalue != null && !this.hostnamevalue.equals(other.hostnamevalue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.act.db.entity.Hostname[ hostnamevalue=" + hostnamevalue + " ]";
    }
    
}
