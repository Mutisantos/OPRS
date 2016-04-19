/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sala_a
 */
@Entity
@Table(name = "VISITASPXC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visitaspxc.findAll", query = "SELECT v FROM Visitaspxc v"),
    @NamedQuery(name = "Visitaspxc.findByIdpxc", query = "SELECT v FROM Visitaspxc v WHERE v.idpxc = :idpxc"),
    @NamedQuery(name = "Visitaspxc.findByFechavisita", query = "SELECT v FROM Visitaspxc v WHERE v.fechavisita = :fechavisita")})
public class Visitaspxc implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDPXC")
    private BigDecimal idpxc;
    @Column(name = "FECHAVISITA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechavisita;
    @JoinColumn(name = "IDPROPIEDAD", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Propiedad idpropiedad;
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCEDULA")
    @ManyToOne(optional = false)
    private Cliente idcliente;

    public Visitaspxc() {
    }

    public Visitaspxc(BigDecimal idpxc) {
        this.idpxc = idpxc;
    }

    public BigDecimal getIdpxc() {
        return idpxc;
    }

    public void setIdpxc(BigDecimal idpxc) {
        this.idpxc = idpxc;
    }

    public Date getFechavisita() {
        return fechavisita;
    }

    public void setFechavisita(Date fechavisita) {
        this.fechavisita = fechavisita;
    }

    public Propiedad getIdpropiedad() {
        return idpropiedad;
    }

    public void setIdpropiedad(Propiedad idpropiedad) {
        this.idpropiedad = idpropiedad;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpxc != null ? idpxc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitaspxc)) {
            return false;
        }
        Visitaspxc other = (Visitaspxc) object;
        if ((this.idpxc == null && other.idpxc != null) || (this.idpxc != null && !this.idpxc.equals(other.idpxc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Visitaspxc[ idpxc=" + idpxc + " ]";
    }
    
}
