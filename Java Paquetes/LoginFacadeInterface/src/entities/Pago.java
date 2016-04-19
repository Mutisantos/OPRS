/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sala_a
 */
@Entity
@Table(name = "PAGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p"),
    @NamedQuery(name = "Pago.findByIdpago", query = "SELECT p FROM Pago p WHERE p.idpago = :idpago"),
    @NamedQuery(name = "Pago.findByEmail", query = "SELECT p FROM Pago p WHERE p.email = :email"),
    @NamedQuery(name = "Pago.findByNombrecliente", query = "SELECT p FROM Pago p WHERE p.nombrecliente = :nombrecliente"),
    @NamedQuery(name = "Pago.findByMesexpiracion", query = "SELECT p FROM Pago p WHERE p.mesexpiracion = :mesexpiracion"),
    @NamedQuery(name = "Pago.findByYearexpiracion", query = "SELECT p FROM Pago p WHERE p.yearexpiracion = :yearexpiracion"),
    @NamedQuery(name = "Pago.findByNumtarjeta", query = "SELECT p FROM Pago p WHERE p.numtarjeta = :numtarjeta"),
    @NamedQuery(name = "Pago.findByTipotarjeta", query = "SELECT p FROM Pago p WHERE p.tipotarjeta = :tipotarjeta")})
public class Pago implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDPAGO")
    private BigDecimal idpago;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "NOMBRECLIENTE")
    private String nombrecliente;
    @Column(name = "MESEXPIRACION")
    private BigInteger mesexpiracion;
    @Basic(optional = false)
    @Column(name = "YEAREXPIRACION")
    private String yearexpiracion;
    @Basic(optional = false)
    @Column(name = "NUMTARJETA")
    private BigInteger numtarjeta;
    @Basic(optional = false)
    @Column(name = "TIPOTARJETA")
    private String tipotarjeta;
    @JoinColumn(name = "IDALQUILER", referencedColumnName = "IDALQUILER")
    @ManyToOne
    private Solicitudalquiler idalquiler;
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCEDULA")
    @ManyToOne(optional = false)
    private Cliente idcliente;

    public Pago() {
    }

    public Pago(BigDecimal idpago) {
        this.idpago = idpago;
    }

    public Pago(BigDecimal idpago, String email, String nombrecliente, String yearexpiracion, BigInteger numtarjeta, String tipotarjeta) {
        this.idpago = idpago;
        this.email = email;
        this.nombrecliente = nombrecliente;
        this.yearexpiracion = yearexpiracion;
        this.numtarjeta = numtarjeta;
        this.tipotarjeta = tipotarjeta;
    }

    public BigDecimal getIdpago() {
        return idpago;
    }

    public void setIdpago(BigDecimal idpago) {
        this.idpago = idpago;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public BigInteger getMesexpiracion() {
        return mesexpiracion;
    }

    public void setMesexpiracion(BigInteger mesexpiracion) {
        this.mesexpiracion = mesexpiracion;
    }

    public String getYearexpiracion() {
        return yearexpiracion;
    }

    public void setYearexpiracion(String yearexpiracion) {
        this.yearexpiracion = yearexpiracion;
    }

    public BigInteger getNumtarjeta() {
        return numtarjeta;
    }

    public void setNumtarjeta(BigInteger numtarjeta) {
        this.numtarjeta = numtarjeta;
    }

    public String getTipotarjeta() {
        return tipotarjeta;
    }

    public void setTipotarjeta(String tipotarjeta) {
        this.tipotarjeta = tipotarjeta;
    }

    public Solicitudalquiler getIdalquiler() {
        return idalquiler;
    }

    public void setIdalquiler(Solicitudalquiler idalquiler) {
        this.idalquiler = idalquiler;
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
        hash += (idpago != null ? idpago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.idpago == null && other.idpago != null) || (this.idpago != null && !this.idpago.equals(other.idpago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pago[ idpago=" + idpago + " ]";
    }
    
}
