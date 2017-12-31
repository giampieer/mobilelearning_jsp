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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author autonoma
 */
@Entity
@Table(name = "asistencia")
public class Asistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idasistencia")
    private Integer idasistencia;
    @Basic(optional = false)
    @Column(name = "asistencia")
    private String asistencia;
    @JoinColumns({
        @JoinColumn(name = "matricula_has_curso_matricula_idmatricula", referencedColumnName = "matricula_idmatricula")
        , @JoinColumn(name = "matricula_has_curso_curso_idcurso", referencedColumnName = "curso_idcurso")})
    @ManyToOne(optional = false)
    private MatriculaHasCurso matriculaHasCurso;

    public Asistencia() {
    }

    public Asistencia(Integer idasistencia) {
        this.idasistencia = idasistencia;
    }

    public Asistencia(Integer idasistencia, String asistencia) {
        this.idasistencia = idasistencia;
        this.asistencia = asistencia;
    }

    public Integer getIdasistencia() {
        return idasistencia;
    }

    public void setIdasistencia(Integer idasistencia) {
        this.idasistencia = idasistencia;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    public MatriculaHasCurso getMatriculaHasCurso() {
        return matriculaHasCurso;
    }

    public void setMatriculaHasCurso(MatriculaHasCurso matriculaHasCurso) {
        this.matriculaHasCurso = matriculaHasCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasistencia != null ? idasistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistencia)) {
            return false;
        }
        Asistencia other = (Asistencia) object;
        if ((this.idasistencia == null && other.idasistencia != null) || (this.idasistencia != null && !this.idasistencia.equals(other.idasistencia))) {
            return false;
        }
        return true;
    }

    @Override
     public String toString() {
        return "{\"idAsistencia\":\""+getIdasistencia()+"\",\"Asistencia\":\""+getAsistencia()+"\",\"idMatricula\":\""+getMatriculaHasCurso().getMatriculaHasCursoPK().getMatriculaIdmatricula()+"\",\"idCurso\":\""+getMatriculaHasCurso().getMatriculaHasCursoPK().getCursoIdcurso()+"\"}";
    }
    
}
