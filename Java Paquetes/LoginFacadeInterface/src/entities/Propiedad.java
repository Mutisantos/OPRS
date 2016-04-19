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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "PROPIEDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propiedad.findAll", query = "SELECT p FROM Propiedad p"),
    @NamedQuery(name = "Propiedad.findById", query = "SELECT p FROM Propiedad p WHERE p.id = :id"),
    @NamedQuery(name = "Propiedad.findByNombre", query = "SELECT p FROM Propiedad p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Propiedad.findByDireccion", query = "SELECT p FROM Propiedad p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Propiedad.findByPrecio", query = "SELECT p FROM Propiedad p WHERE p.precio = :precio"),
    @NamedQuery(name = "Propiedad.findByCiudad", query = "SELECT p FROM Propiedad p WHERE p.ciudad = :ciudad")})
public class Propiedad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Lob
    @Column(name = "IMAGEN")
    private Serializable imagen;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "PRECIO")
    private String precio;
    @Basic(optional = false)
    @Column(name = "CIUDAD")
    private String ciudad;
    @JoinColumn(name = "IDLESPERA", referencedColumnName = "IDESPERA")
    @ManyToOne
    private Esperapxc idlespera;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpropiedad")
    private List<Visitaspxc> visitaspxcList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpropiedad")
    private List<Esperapxc> esperapxcList;
    @OneToMany(mappedBy = "idpropiedad")
    private List<Solicitudalquiler> solicitudalquilerList;
    @OneToMany(mappedBy = "idpropiedad")
    private List<Enlacedescarga> enlacedescargaList;

    public Propiedad() {
    }

    public Propiedad(BigDecimal id) {
        this.id = id;
    }

    public Propiedad(BigDecimal id, String nombre, String direccion, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Serializable getImagen() {
        return imagen;
    }

    public void setImagen(Serializable imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Esperapxc getIdlespera() {
        return idlespera;
    }

    public void setIdlespera(Esperapxc idlespera) {
        this.idlespera = idlespera;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propiedad)) {
            return false;
        }
        Propiedad other = (Propiedad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Propiedad[ id=" + id + " ]";
    }
    
}
