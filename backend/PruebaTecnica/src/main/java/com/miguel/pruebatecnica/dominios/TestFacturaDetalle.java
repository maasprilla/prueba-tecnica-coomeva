/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguel.pruebatecnica.dominios;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author user
 */
@Entity
@Table(name = "TEST_FACTURA_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestFacturaDetalle.findAll", query = "SELECT t FROM TestFacturaDetalle t"),
    @NamedQuery(name = "TestFacturaDetalle.findByIdFacturaDetalle", query = "SELECT t FROM TestFacturaDetalle t WHERE t.idFacturaDetalle = :idFacturaDetalle"),
    @NamedQuery(name = "TestFacturaDetalle.findByCantidad", query = "SELECT t FROM TestFacturaDetalle t WHERE t.cantidad = :cantidad"),
    @NamedQuery(name = "TestFacturaDetalle.findByValorUnidad", query = "SELECT t FROM TestFacturaDetalle t WHERE t.valorUnidad = :valorUnidad"),
    @NamedQuery(name = "TestFacturaDetalle.findByValorTotal", query = "SELECT t FROM TestFacturaDetalle t WHERE t.valorTotal = :valorTotal")})
public class TestFacturaDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_factura_detalle")
    private Integer idFacturaDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_unidad")
    private int valorUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_total")
    private int valorTotal;
    @JoinColumn(name = "IdFactura", referencedColumnName = "id_factura")
    @ManyToOne(optional = false)
    private TestFactura idFactura;
    @JoinColumn(name = "IdProducto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private TestProducto idProducto;

    public TestFacturaDetalle() {
    }

    public TestFacturaDetalle(Integer idFacturaDetalle) {
        this.idFacturaDetalle = idFacturaDetalle;
    }

    public TestFacturaDetalle(Integer idFacturaDetalle, int cantidad, int valorUnidad, int valorTotal) {
        this.idFacturaDetalle = idFacturaDetalle;
        this.cantidad = cantidad;
        this.valorUnidad = valorUnidad;
        this.valorTotal = valorTotal;
    }

    public Integer getIdFacturaDetalle() {
        return idFacturaDetalle;
    }

    public void setIdFacturaDetalle(Integer idFacturaDetalle) {
        this.idFacturaDetalle = idFacturaDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValorUnidad() {
        return valorUnidad;
    }

    public void setValorUnidad(int valorUnidad) {
        this.valorUnidad = valorUnidad;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public TestFactura getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(TestFactura idFactura) {
        this.idFactura = idFactura;
    }

    public TestProducto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(TestProducto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacturaDetalle != null ? idFacturaDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestFacturaDetalle)) {
            return false;
        }
        TestFacturaDetalle other = (TestFacturaDetalle) object;
        if ((this.idFacturaDetalle == null && other.idFacturaDetalle != null) || (this.idFacturaDetalle != null && !this.idFacturaDetalle.equals(other.idFacturaDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.miguel.pruebatecnica.TestFacturaDetalle[ idFacturaDetalle=" + idFacturaDetalle + " ]";
    }
    
}
