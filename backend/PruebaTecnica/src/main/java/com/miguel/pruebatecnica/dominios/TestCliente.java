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
@Table(name = "TEST_CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestCliente.findAll", query = "SELECT t FROM TestCliente t"),
    @NamedQuery(name = "TestCliente.findByIdCliente", query = "SELECT t FROM TestCliente t WHERE t.idCliente = :idCliente"),
    @NamedQuery(name = "TestCliente.findByIdentifiacion", query = "SELECT t FROM TestCliente t WHERE t.identifiacion = :identifiacion"),
    @NamedQuery(name = "TestCliente.findByNombres", query = "SELECT t FROM TestCliente t WHERE t.nombres = :nombres"),
    @NamedQuery(name = "TestCliente.findByApellidos", query = "SELECT t FROM TestCliente t WHERE t.apellidos = :apellidos"),
    @NamedQuery(name = "TestCliente.findByDireccion", query = "SELECT t FROM TestCliente t WHERE t.direccion = :direccion"),
    @NamedQuery(name = "TestCliente.findByTelefono", query = "SELECT t FROM TestCliente t WHERE t.telefono = :telefono"),
    @NamedQuery(name = "TestCliente.findByEmail", query = "SELECT t FROM TestCliente t WHERE t.email = :email")})
public class TestCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Long idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "identifiacion")
    private int identifiacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 50)
    @Column(name = "telefono")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private List<TestFactura> testFacturaList;

    public TestCliente() {
    }

    public TestCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public TestCliente(Long idCliente, int identifiacion, String nombres, String apellidos, String direccion) {
        this.idCliente = idCliente;
        this.identifiacion = identifiacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdentifiacion() {
        return identifiacion;
    }

    public void setIdentifiacion(int identifiacion) {
        this.identifiacion = identifiacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<TestFactura> getTestFacturaList() {
        return testFacturaList;
    }

    public void setTestFacturaList(List<TestFactura> testFacturaList) {
        this.testFacturaList = testFacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestCliente)) {
            return false;
        }
        TestCliente other = (TestCliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.miguel.pruebatecnica.TestCliente[ idCliente=" + idCliente + " ]";
    }
    
}
