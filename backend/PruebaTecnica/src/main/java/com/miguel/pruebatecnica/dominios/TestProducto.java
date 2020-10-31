/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguel.pruebatecnica.dominios;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author user
 */
@Entity
@Table(name = "TEST_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestProducto.findAll", query = "SELECT t FROM TestProducto t"),
    @NamedQuery(name = "TestProducto.findByIdProducto", query = "SELECT t FROM TestProducto t WHERE t.idProducto = :idProducto"),
    @NamedQuery(name = "TestProducto.findByCodigo", query = "SELECT t FROM TestProducto t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "TestProducto.findByNombre", query = "SELECT t FROM TestProducto t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TestProducto.findByValorUnidad", query = "SELECT t FROM TestProducto t WHERE t.valorUnidad = :valorUnidad"),
    @NamedQuery(name = "TestProducto.findByStock", query = "SELECT t FROM TestProducto t WHERE t.stock = :stock")})
public class TestProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_unidad")
    private int valorUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<TestFacturaDetalle> testFacturaDetalleList;

    public TestProducto() {
    }

    public TestProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public TestProducto(Integer idProducto, String codigo, String nombre, int valorUnidad, int stock) {
        this.idProducto = idProducto;
        this.codigo = codigo;
        this.nombre = nombre;
        this.valorUnidad = valorUnidad;
        this.stock = stock;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValorUnidad() {
        return valorUnidad;
    }

    public void setValorUnidad(int valorUnidad) {
        this.valorUnidad = valorUnidad;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestProducto)) {
            return false;
        }
        TestProducto other = (TestProducto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre+" - $"+valorUnidad;
    }
    
}
