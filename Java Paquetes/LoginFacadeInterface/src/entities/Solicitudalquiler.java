/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sala_a
 */
@Entity
@Table(name = "SOLICITUDALQUILER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitudalquiler.findAll", query = "SELECT s FROM Solicitudalquiler s"),
    @NamedQuery(name = "Solicitudalquiler.findByIdalquiler", query = "SELECT s FROM Solicitudalquiler s WHERE s.idalquiler = :idalquiler"),
    @NamedQuery(name = "Solicitudalquiler.findByEstado", query = "SELECT s FROM Solicitudalquiler s WHERE s.estado = :estado"),
    @NamedQuery(name = "Solicitudalquiler.findByFecha", query = "SELECT s FROM Solicitudalquiler s WHERE s.fecha = :fecha")})
public class Solicitudalquiler implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDALQUILER")
    private BigDecimal idalquiler;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(mappedBy = "idalquiler")
    private List<Pago> pagoList;
    @JoinColumn(name = "IDPROPIEDAD", referencedColumnName = "ID")
    @ManyToOne
    private Propiedad idpropiedad;
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCEDULA")
    @ManyToOne
    private Cliente idcliente;

    public Solicitudalquiler() {
    }

    public Solicitudalquiler(BigDecimal idalquiler) {
        this.idalquiler = idalquiler;
    }

    public Solicitudalquiler(BigDecimal idalquiler, String estado) {
        this.idalquiler = idalquiler;
        this.estado = estado;
    }

    public BigDecimal getIdalquiler() {
        return idalquiler;
    }

    public void setIdalquiler(BigDecimal idalquiler) {
        this.idalquiler = idalquiler;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
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
        hash += (idalquiler != null ? idalquiler.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitudalquiler)) {
            return false;
        }
        Solicitudalquiler other = (Solicitudalquiler) object;
        if ((this.idalquiler == null && other.idalquiler != null) || (this.idalquiler != null && !this.idalquiler.equals(other.idalquiler))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Solicitudalquiler[ idalquiler=" + idalquiler + " ]";
    }
    
}
