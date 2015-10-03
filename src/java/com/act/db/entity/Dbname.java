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
@Table(name = "DBNAME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dbname.findAll", query = "SELECT d FROM Dbname d"),
    @NamedQuery(name = "Dbname.findByDbnamevalue", query = "SELECT d FROM Dbname d WHERE d.dbnamevalue = :dbnamevalue")})
public class Dbname implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DBNAMEVALUE")
    private String dbnamevalue;

    public Dbname() {
    }

    public Dbname(String dbnamevalue) {
        this.dbnamevalue = dbnamevalue;
    }

    public String getDbnamevalue() {
        return dbnamevalue;
    }

    public void setDbnamevalue(String dbnamevalue) {
        this.dbnamevalue = dbnamevalue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dbnamevalue != null ? dbnamevalue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dbname)) {
            return false;
        }
        Dbname other = (Dbname) object;
        if ((this.dbnamevalue == null && other.dbnamevalue != null) || (this.dbnamevalue != null && !this.dbnamevalue.equals(other.dbnamevalue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.act.db.entity.Dbname[ dbnamevalue=" + dbnamevalue + " ]";
    }
    
}
