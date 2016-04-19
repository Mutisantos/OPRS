/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdcedula", query = "SELECT c FROM Cliente c WHERE c.idcedula = :idcedula"),
    @NamedQuery(name = "Cliente.findByNuser", query = "SELECT c FROM Cliente c WHERE c.nuser = :nuser"),
    @NamedQuery(name = "Cliente.findByNpassword", query = "SELECT c FROM Cliente c WHERE c.npassword = :npassword"),
    @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cliente.findByApellido", query = "SELECT c FROM Cliente c WHERE c.apellido = :apellido"),
    @NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email"),
    @NamedQuery(name = "Cliente.findByEstado", query = "SELECT c FROM Cliente c WHERE c.estado = :estado")})
public class Cliente implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcliente")
    private List<Pago> pagoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcliente")
    private List<Visitaspxc> visitaspxcList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcliente")
    private List<Esperapxc> esperapxcList;
    @OneToMany(mappedBy = "idcliente")
    private List<Solicitudalquiler> solicitudalquilerList;
    @OneToMany(mappedBy = "idcliente")
    private List<Enlacedescarga> enlacedescargaList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDCEDULA")
    private String idcedula;
    @Basic(optional = false)
    @Column(name = "NUSER")
    private String nuser;
    @Basic(optional = false)
    @Column(name = "NPASSWORD")
    private String npassword;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;

    public Cliente() {
    }

    public Cliente(String idcedula) {
        this.idcedula = idcedula;
    }

    public Cliente(String idcedula, String nuser, String npassword, String email, String estado) {
        this.idcedula = idcedula;
        this.nuser = nuser;
        this.npassword = npassword;
        this.email = email;
        this.estado = estado;
    }

    public String getIdcedula() {
        return idcedula;
    }

    public void setIdcedula(String idcedula) {
        this.idcedula = idcedula;
    }

    public String getNuser() {
        return nuser;
    }

    public void setNuser(String nuser) {
        this.nuser = nuser;
    }

    public String getNpassword() {
        return npassword;
    }

    public void setNpassword(String npassword) {
        this.npassword = npassword;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcedula != null ? idcedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idcedula == null && other.idcedula != null) || (this.idcedula != null && !this.idcedula.equals(other.idcedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cliente[ idcedula=" + idcedula + " ]";
    }

    @XmlTransient
    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
    }

    @XmlTransient
    public List<Visitaspxc> getVisitaspxcList() {
        return visitaspxcList;
    }

    public void setVisitaspxcList(List<Visitaspxc> visitaspxcList) {
        this.visitaspxcList = visitaspxcList;
    }

    @XmlTransient
    public List<Esperapxc> getEsperapxcList() {
        return esperapxcList;
    }

    public void setEsperapxcList(List<Esperapxc> esperapxcList) {
        this.esperapxcList = esperapxcList;
    }

    @XmlTransient
    public List<Solicitudalquiler> getSolicitudalquilerList() {
        return solicitudalquilerList;
    }

    public void setSolicitudalquilerList(List<Solicitudalquiler> solicitudalquilerList) {
        this.solicitudalquilerList = solicitudalquilerList;
    }

    @XmlTransient
    public List<Enlacedescarga> getEnlacedescargaList() {
        return enlacedescargaList;
    }

    public void setEnlacedescargaList(List<Enlacedescarga> enlacedescargaList) {
        this.enlacedescargaList = enlacedescargaList;
    }
    
}
