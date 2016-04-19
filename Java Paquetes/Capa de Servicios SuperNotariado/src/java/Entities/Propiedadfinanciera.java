/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sala_bd
 */
@Entity
@Table(name = "PROPIEDADFINANCIERA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propiedadfinanciera.findAll", query = "SELECT p FROM Propiedadfinanciera p"),
    @NamedQuery(name = "Propiedadfinanciera.findByIdpropiedad", query = "SELECT p FROM Propiedadfinanciera p WHERE p.idpropiedad = :idpropiedad"),
    @NamedQuery(name = "Propiedadfinanciera.findByDireccion", query = "SELECT p FROM Propiedadfinanciera p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Propiedadfinanciera.findByLocalidad", query = "SELECT p FROM Propiedadfinanciera p WHERE p.localidad = :localidad"),
    @NamedQuery(name = "Propiedadfinanciera.findByNcuartos", query = "SELECT p FROM Propiedadfinanciera p WHERE p.ncuartos = :ncuartos")})
public class Propiedadfinanciera implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPROPIEDAD")
    private BigDecimal idpropiedad;
    @Size(max = 40)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 40)
    @Column(name = "LOCALIDAD")
    private String localidad;
    @Size(max = 40)
    @Column(name = "NCUARTOS")
    private String ncuartos;
    @Lob
    @Size(max = 0)
    @Column(name = "RENTA")
    private String renta;

    public Propiedadfinanciera() {
    }

    public Propiedadfinanciera(BigDecimal idpropiedad) {
        this.idpropiedad = idpropiedad;
    }

    public BigDecimal getIdpropiedad() {
        return idpropiedad;
    }

    public void setIdpropiedad(BigDecimal idpropiedad) {
        this.idpropiedad = idpropiedad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getNcuartos() {
        return ncuartos;
    }

    public void setNcuartos(String ncuartos) {
        this.ncuartos = ncuartos;
    }

    public String getRenta() {
        return renta;
    }

    public void setRenta(String renta) {
        this.renta = renta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpropiedad != null ? idpropiedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propiedadfinanciera)) {
            return false;
        }
        Propiedadfinanciera other = (Propiedadfinanciera) object;
        if ((this.idpropiedad == null && other.idpropiedad != null) || (this.idpropiedad != null && !this.idpropiedad.equals(other.idpropiedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Propiedadfinanciera[ idpropiedad=" + idpropiedad + " ]";
    }
    
}
