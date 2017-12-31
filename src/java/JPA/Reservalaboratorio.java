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
@Table(name = "reservalaboratorio")
public class Reservalaboratorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idReservaLaboratorio")
    private Integer idReservaLaboratorio;
    @Basic(optional = false)
    @Column(name = "horainicio")
    private String horainicio;
    @Basic(optional = false)
    @Column(name = "horafin")
    private String horafin;
    @JoinColumn(name = "Laboratorio_idLaboratorio", referencedColumnName = "idLaboratorio")
    @ManyToOne(optional = false)
    private Laboratorio laboratorio;
    @JoinColumn(name = "alumno_idalumno", referencedColumnName = "idalumno")
    @ManyToOne(optional = false)
    private Alumno alumno;

    public Reservalaboratorio() {
    }

    public Reservalaboratorio(Integer idReservaLaboratorio) {
        this.idReservaLaboratorio = idReservaLaboratorio;
    }

    public Reservalaboratorio(Integer idReservaLaboratorio, String horainicio, String horafin) {
        this.idReservaLaboratorio = idReservaLaboratorio;
        this.horainicio = horainicio;
        this.horafin = horafin;
    }

    public Integer getIdReservaLaboratorio() {
        return idReservaLaboratorio;
    }

    public void setIdReservaLaboratorio(Integer idReservaLaboratorio) {
        this.idReservaLaboratorio = idReservaLaboratorio;
    }

    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public String getHorafin() {
        return horafin;
    }

    public void setHorafin(String horafin) {
        this.horafin = horafin;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
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
        hash += (idReservaLaboratorio != null ? idReservaLaboratorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservalaboratorio)) {
            return false;
        }
        Reservalaboratorio other = (Reservalaboratorio) object;
        if ((this.idReservaLaboratorio == null && other.idReservaLaboratorio != null) || (this.idReservaLaboratorio != null && !this.idReservaLaboratorio.equals(other.idReservaLaboratorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Reservalaboratorio[ idReservaLaboratorio=" + idReservaLaboratorio + " ]";
    }
    
}
