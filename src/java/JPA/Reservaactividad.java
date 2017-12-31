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
@Table(name = "reservaactividad")
public class Reservaactividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idReservaActividad")
    private Integer idReservaActividad;
    @Basic(optional = false)
    @Column(name = "dia")
    private String dia;
    @Basic(optional = false)
    @Column(name = "hora")
    private String hora;
    @JoinColumn(name = "Actividad_idActividad", referencedColumnName = "idActividad")
    @ManyToOne(optional = false)
    private Actividad actividad;
    @JoinColumn(name = "alumno_idalumno", referencedColumnName = "idalumno")
    @ManyToOne(optional = false)
    private Alumno alumno;

    public Reservaactividad() {
    }

    public Reservaactividad(Integer idReservaActividad) {
        this.idReservaActividad = idReservaActividad;
    }

    public Reservaactividad(Integer idReservaActividad, String dia, String hora) {
        this.idReservaActividad = idReservaActividad;
        this.dia = dia;
        this.hora = hora;
    }

    public Integer getIdReservaActividad() {
        return idReservaActividad;
    }

    public void setIdReservaActividad(Integer idReservaActividad) {
        this.idReservaActividad = idReservaActividad;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
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
        hash += (idReservaActividad != null ? idReservaActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservaactividad)) {
            return false;
        }
        Reservaactividad other = (Reservaactividad) object;
        if ((this.idReservaActividad == null && other.idReservaActividad != null) || (this.idReservaActividad != null && !this.idReservaActividad.equals(other.idReservaActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Reservaactividad[ idReservaActividad=" + idReservaActividad + " ]";
    }
    
}
