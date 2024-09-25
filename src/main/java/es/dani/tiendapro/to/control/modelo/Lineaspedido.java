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
@Table(name = "LINEASPEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineaspedido.findAll", query = "SELECT l FROM Lineaspedido l"),
    @NamedQuery(name = "Lineaspedido.findByIdLineas", query = "SELECT l FROM Lineaspedido l WHERE l.idLineas = :idLineas"),
    @NamedQuery(name = "Lineaspedido.findByCantidad", query = "SELECT l FROM Lineaspedido l WHERE l.cantidad = :cantidad"),
    @NamedQuery(name = "Lineaspedido.findByTotalPrecio", query = "SELECT l FROM Lineaspedido l WHERE l.totalPrecio = :totalPrecio")})
public class Lineaspedido implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LINEAS")
    private Integer idLineas;
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Column(name = "TOTAL_PRECIO")
    private double totalPrecio;
    @JoinColumn(name = "PEDIDO_ID", referencedColumnName = "ID_PEDIDO")
    @ManyToOne
    private Pedido idPedido;
    @JoinColumn(name = "PRODUCTO_ID", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne
    private Producto idProducto;

    public Lineaspedido() {
    }

    public Lineaspedido(Integer idLineas) {
        this.idLineas = idLineas;
    }

    public Integer getIdLineas() {
        return idLineas;
    }

    public void setIdLineas(Integer idLineas) {
        this.idLineas = idLineas;
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

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLineas != null ? idLineas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineaspedido)) {
            return false;
        }
        Lineaspedido other = (Lineaspedido) object;
        if ((this.idLineas == null && other.idLineas != null) || (this.idLineas != null && !this.idLineas.equals(other.idLineas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.dani.tiendapro.modelo.Lineaspedido[ idLineas=" + idLineas + " ]";
    }
    
}
