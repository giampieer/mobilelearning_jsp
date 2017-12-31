/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author autonoma
 */
@Entity
@Table(name = "reservalibro")
public class Reservalibro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idReservaLibro")
    private Integer idReservaLibro;
    @Basic(optional = false)
    @Column(name = "fechaentrega")
    private String fechaentrega;
    @Basic(optional = false)
    @Column(name = "fechadevolucion")
    private String fechadevolucion;
    @JoinColumn(name = "Libro_idLibro", referencedColumnName = "idLibro")
    @ManyToOne(optional = false)
    private Libro libro;
    @JoinColumn(name = "alumno_idalumno", referencedColumnName = "idalumno")
    @ManyToOne(optional = false)
    private Alumno alumno;

    public Reservalibro() {
    }

    public Reservalibro(Integer idReservaLibro) {
        this.idReservaLibro = idReservaLibro;
    }

    public Reservalibro(Integer idReservaLibro, String fechaentrega, String fechadevolucion) {
        this.idReservaLibro = idReservaLibro;
        this.fechaentrega = fechaentrega;
        this.fechadevolucion = fechadevolucion;
    }

    public Integer getIdReservaLibro() {
        return idReservaLibro;
    }

    public void setIdReservaLibro(Integer idReservaLibro) {
        this.idReservaLibro = idReservaLibro;
    }

    public String getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(String fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public String getFechadevolucion() {
        return fechadevolucion;
    }

    public void setFechadevolucion(String fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservaLibro != null ? idReservaLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservalibro)) {
            return false;
        }
        Reservalibro other = (Reservalibro) object;
        if ((this.idReservaLibro == null && other.idReservaLibro != null) || (this.idReservaLibro != null && !this.idReservaLibro.equals(other.idReservaLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Reservalibro[ idReservaLibro=" + idReservaLibro + " ]";
    }
    
}
