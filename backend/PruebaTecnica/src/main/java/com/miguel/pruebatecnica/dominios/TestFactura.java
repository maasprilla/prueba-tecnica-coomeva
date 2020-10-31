/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguel.pruebatecnica.dominios;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "TEST_FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestFactura.findAll", query = "SELECT t FROM TestFactura t"),
    @NamedQuery(name = "TestFactura.findByIdFactura", query = "SELECT t FROM TestFactura t WHERE t.idFactura = :idFactura"),
    @NamedQuery(name = "TestFactura.findByFechaVenta", query = "SELECT t FROM TestFactura t WHERE t.fechaVenta = :fechaVenta"),
    @NamedQuery(name = "TestFactura.findByValorTotal", query = "SELECT t FROM TestFactura t WHERE t.valorTotal = :valorTotal")})
public class TestFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_factura")
    private Integer idFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_venta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_total")
    private int valorTotal;
    @JoinColumn(name = "IdCliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private TestCliente idCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFactura")
    private List<TestFacturaDetalle> testFacturaDetalleList;

    public TestFactura() {
    }

    public TestFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public TestFactura(Integer idFactura, Date fechaVenta, int valorTotal) {
        this.idFactura = idFactura;
        this.fechaVenta = fechaVenta;
        this.valorTotal = valorTotal;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public TestCliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(TestCliente idCliente) {
        this.idCliente = idCliente;
    }

    @XmlTransient
    public List<TestFacturaDetalle> getTestFacturaDetalleList() {
        return testFacturaDetalleList;
    }

    public void setTestFacturaDetalleList(List<TestFacturaDetalle> testFacturaDetalleList) {
        this.testFacturaDetalleList = testFacturaDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestFactura)) {
            return false;
        }
        TestFactura other = (TestFactura) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.miguel.pruebatecnica.TestFactura[ idFactura=" + idFactura + " ]";
    }
    
}
