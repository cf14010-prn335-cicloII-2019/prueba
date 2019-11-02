/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.parcial.entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CF14010
 */
@Entity
@Table(name = "menu_consumible", catalog = "cine", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuConsumible.findAll", query = "SELECT m FROM MenuConsumible m"),
    @NamedQuery(name = "MenuConsumible.findByIdConsumible", query = "SELECT m FROM MenuConsumible m WHERE m.idConsumible = :idConsumible"),
    @NamedQuery(name = "MenuConsumible.findByNombre", query = "SELECT m FROM MenuConsumible m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "MenuConsumible.findByPrecio", query = "SELECT m FROM MenuConsumible m WHERE m.precio = :precio")})
public class MenuConsumible implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_consumible")
    private Integer idConsumible;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuConsumible")
    private List<OrdenConsumible> ordenConsumibleList;

    public MenuConsumible() {
    }

    public MenuConsumible(Integer idConsumible) {
        this.idConsumible = idConsumible;
    }

    public MenuConsumible(Integer idConsumible, String nombre, double precio) {
        this.idConsumible = idConsumible;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getIdConsumible() {
        return idConsumible;
    }

    public void setIdConsumible(Integer idConsumible) {
        this.idConsumible = idConsumible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @XmlTransient
    public List<OrdenConsumible> getOrdenConsumibleList() {
        return ordenConsumibleList;
    }

    public void setOrdenConsumibleList(List<OrdenConsumible> ordenConsumibleList) {
        this.ordenConsumibleList = ordenConsumibleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsumible != null ? idConsumible.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuConsumible)) {
            return false;
        }
        MenuConsumible other = (MenuConsumible) object;
        if ((this.idConsumible == null && other.idConsumible != null) || (this.idConsumible != null && !this.idConsumible.equals(other.idConsumible))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.ingenieria.prn335.parcial.entity.MenuConsumible[ idConsumible=" + idConsumible + " ]";
    }
    
}
