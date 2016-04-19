/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sala_a
 */
@Entity
@Table(name = "ESPERAPXC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Esperapxc.findAll", query = "SELECT e FROM Esperapxc e"),
    @NamedQuery(name = "Esperapxc.findByIdespera", query = "SELECT e FROM Esperapxc e WHERE e.idespera = :idespera")})
public class Esperapxc implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDESPERA")
    private BigDecimal idespera;
    @OneToMany(mappedBy = "idlespera")
    private List<Propiedad> propiedadList;
    @JoinColumn(name = "IDPROPIEDAD", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Propiedad idpropiedad;
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCEDULA")
    @ManyToOne(optional = false)
    private Cliente idcliente;

    public Esperapxc() {
    }

    public Esperapxc(BigDecimal idespera) {
        this.idespera = idespera;
    }

    public BigDecimal getIdespera() {
        return idespera;
    }

    public void setIdespera(BigDecimal idespera) {
        this.idespera = idespera;
    }

    @XmlTransient
    public List<Propiedad> getPropiedadList() {
        return propiedadList;
    }

    public void setPropiedadList(List<Propiedad> propiedadList) {
        this.propiedadList = propiedadList;
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
        hash += (idespera != null ? idespera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Esperapxc)) {
            return false;
        }
        Esperapxc other = (Esperapxc) object;
        if ((this.idespera == null && other.idespera != null) || (this.idespera != null && !this.idespera.equals(other.idespera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Esperapxc[ idespera=" + idespera + " ]";
    }
    
}
