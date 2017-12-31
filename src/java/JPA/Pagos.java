/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author autonoma
 */
@Entity
@Table(name = "pagos")
public class Pagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPagos")
    private Integer idPagos;
    @Basic(optional = false)
    @Column(name = "nombrepago")
    private String nombrepago;
    @Basic(optional = false)
    @Column(name = "monto")
    private double monto;
    @Basic(optional = false)
    @Column(name = "tipomoneda")
    private String tipomoneda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pagos")
    private Collection<Matricula> matriculaCollection;

    public Pagos() {
    }

    public Pagos(Integer idPagos) {
        this.idPagos = idPagos;
    }

    public Pagos(Integer idPagos, String nombrepago, double monto, String tipomoneda) {
        this.idPagos = idPagos;
        this.nombrepago = nombrepago;
        this.monto = monto;
        this.tipomoneda = tipomoneda;
    }

    public Integer getIdPagos() {
        return idPagos;
    }

    public void setIdPagos(Integer idPagos) {
        this.idPagos = idPagos;
    }

    public String getNombrepago() {
        return nombrepago;
    }

    public void setNombrepago(String nombrepago) {
        this.nombrepago = nombrepago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipomoneda() {
        return tipomoneda;
    }

    public void setTipomoneda(String tipomoneda) {
        this.tipomoneda = tipomoneda;
    }

    public Collection<Matricula> getMatriculaCollection() {
        return matriculaCollection;
    }

    public void setMatriculaCollection(Collection<Matricula> matriculaCollection) {
        this.matriculaCollection = matriculaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagos != null ? idPagos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        if ((this.idPagos == null && other.idPagos != null) || (this.idPagos != null && !this.idPagos.equals(other.idPagos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{\"idPago\":\"" + getIdPagos() + "\",\"Nombre\":\"" + getNombrepago() + "\",\"Monto\":\"" + getMonto() + "\",\"TipoMoneda\":\"" + getTipomoneda() + "\"}";
    }
    
}
