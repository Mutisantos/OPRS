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
@Table(name = "ENLACEDESCARGA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enlacedescarga.findAll", query = "SELECT e FROM Enlacedescarga e"),
    @NamedQuery(name = "Enlacedescarga.findByIdenlace", query = "SELECT e FROM Enlacedescarga e WHERE e.idenlace = :idenlace"),
    @NamedQuery(name = "Enlacedescarga.findByEnlace", query = "SELECT e FROM Enlacedescarga e WHERE e.enlace = :enlace"),
    @NamedQuery(name = "Enlacedescarga.findByFechacreacion", query = "SELECT e FROM Enlacedescarga e WHERE e.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Enlacedescarga.findByEstado", query = "SELECT e FROM Enlacedescarga e WHERE e.estado = :estado")})
public class Enlacedescarga implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDENLACE")
    private BigDecimal idenlace;
    @Basic(optional = false)
    @Column(name = "ENLACE")
    private String enlace;
    @Basic(optional = false)
    @Column(name = "FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "IDPROPIEDAD", referencedColumnName = "ID")
    @ManyToOne
    private Propiedad idpropiedad;
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCEDULA")
    @ManyToOne
    private Cliente idcliente;

    public Enlacedescarga() {
    }

    public Enlacedescarga(BigDecimal idenlace) {
        this.idenlace = idenlace;
    }

    public Enlacedescarga(BigDecimal idenlace, String enlace, Date fechacreacion, String estado) {
        this.idenlace = idenlace;
        this.enlace = enlace;
        this.fechacreacion = fechacreacion;
        this.estado = estado;
    }

    public BigDecimal getIdenlace() {
        return idenlace;
    }

    public void setIdenlace(BigDecimal idenlace) {
        this.idenlace = idenlace;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        hash += (idenlace != null ? idenlace.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enlacedescarga)) {
            return false;
        }
        Enlacedescarga other = (Enlacedescarga) object;
        if ((this.idenlace == null && other.idenlace != null) || (this.idenlace != null && !this.idenlace.equals(other.idenlace))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Enlacedescarga[ idenlace=" + idenlace + " ]";
    }
    
}
