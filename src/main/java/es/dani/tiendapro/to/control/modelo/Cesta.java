/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dani.tiendapro.to.control.modelo;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dani1
 */
@Entity
@Table(name = "CESTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cesta.findAll", query = "SELECT c FROM Cesta c"),
    @NamedQuery(name = "Cesta.findByIdCesta", query = "SELECT c FROM Cesta c WHERE c.idCesta = :idCesta"),
    @NamedQuery(name = "Cesta.findByCantidad", query = "SELECT c FROM Cesta c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "Cesta.findByTotalPrecio", query = "SELECT c FROM Cesta c WHERE c.totalPrecio = :totalPrecio")})
public class Cesta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CESTA")
    private Integer idCesta;
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Column(name = "TOTAL_PRECIO")
    private double totalPrecio;
    @JoinColumn(name = "PRODUCTO_ID", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne
    private Producto idProducto;
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario;

    public Cesta() {
    }

    public Cesta(Integer idCesta) {
        this.idCesta = idCesta;
    }

    public Integer getIdCesta() {
        return idCesta;
    }

    public void setIdCesta(Integer idCesta) {
        this.idCesta = idCesta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotalPrecio() {
        return totalPrecio;
    }

    public void setTotalPrecio(double totalPrecio) {
        this.totalPrecio = totalPrecio;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCesta != null ? idCesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cesta)) {
            return false;
        }
        Cesta other = (Cesta) object;
        if ((this.idCesta == null && other.idCesta != null) || (this.idCesta != null && !this.idCesta.equals(other.idCesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.dani.tiendapro.modelo.Cesta[ idCesta=" + idCesta + " ]";
    }
    
}
