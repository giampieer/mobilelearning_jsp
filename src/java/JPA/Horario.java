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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author autonoma
 */
@Entity
@Table(name = "horario")
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idhorario")
    private Integer idhorario;
    @Basic(optional = false)
    @Column(name = "fechainicio")
    private String fechainicio;
    @Basic(optional = false)
    @Column(name = "fechafin")
    private String fechafin;
    @Basic(optional = false)
    @Column(name = "horainicio")
    private String horainicio;
    @Basic(optional = false)
    @Column(name = "horafin")
    private String horafin;
    @JoinColumn(name = "curso_idcurso", referencedColumnName = "idcurso")
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "profesor_idprofesor", referencedColumnName = "idprofesor")
    @ManyToOne(optional = false)
    private Profesor profesor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horario")
    private Collection<Anuncios> anunciosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horario")
    private Collection<Recursos> recursosCollection;

    public Horario() {
    }

    public Horario(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public Horario(Integer idhorario, String fechainicio, String fechafin, String horainicio, String horafin) {
        this.idhorario = idhorario;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.horainicio = horainicio;
        this.horafin = horafin;
    }

    public Integer getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Collection<Anuncios> getAnunciosCollection() {
        return anunciosCollection;
    }

    public void setAnunciosCollection(Collection<Anuncios> anunciosCollection) {
        this.anunciosCollection = anunciosCollection;
    }

    public Collection<Recursos> getRecursosCollection() {
        return recursosCollection;
    }

    public void setRecursosCollection(Collection<Recursos> recursosCollection) {
        this.recursosCollection = recursosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhorario != null ? idhorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.idhorario == null && other.idhorario != null) || (this.idhorario != null && !this.idhorario.equals(other.idhorario))) {
            return false;
        }
        return true;
    }

    @Override
      public String toString() {
        return "{\"idHorario\":\""+getIdhorario()+"\",\"Fecha_I\":\""+getFechainicio()+"\",\"Fecha_F\":\""+getFechafin()+"\",\"Hora_I\":\""+getHorainicio()+"\",\"Hora_F\":\""+getHorafin()+"\",\"idProfesor\":\""+getProfesor().getIdprofesor()+"\",\"idCurso\":\""+getCurso().getIdcurso()+"\"}";
    }
    
}
