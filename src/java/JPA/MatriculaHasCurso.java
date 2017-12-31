/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "matricula_has_curso")
public class MatriculaHasCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MatriculaHasCursoPK matriculaHasCursoPK;
    @JoinColumn(name = "curso_idcurso", referencedColumnName = "idcurso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "matricula_idmatricula", referencedColumnName = "idmatricula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Matricula matricula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matriculaHasCurso")
    private Collection<Notas> notasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matriculaHasCurso")
    private Collection<Asistencia> asistenciaCollection;

    public MatriculaHasCurso() {
    }

    public MatriculaHasCurso(MatriculaHasCursoPK matriculaHasCursoPK) {
        this.matriculaHasCursoPK = matriculaHasCursoPK;
    }

    public MatriculaHasCurso(int matriculaIdmatricula, int cursoIdcurso) {
        this.matriculaHasCursoPK = new MatriculaHasCursoPK(matriculaIdmatricula, cursoIdcurso);
    }

    public MatriculaHasCursoPK getMatriculaHasCursoPK() {
        return matriculaHasCursoPK;
    }

    public void setMatriculaHasCursoPK(MatriculaHasCursoPK matriculaHasCursoPK) {
        this.matriculaHasCursoPK = matriculaHasCursoPK;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Collection<Notas> getNotasCollection() {
        return notasCollection;
    }

    public void setNotasCollection(Collection<Notas> notasCollection) {
        this.notasCollection = notasCollection;
    }

    public Collection<Asistencia> getAsistenciaCollection() {
        return asistenciaCollection;
    }

    public void setAsistenciaCollection(Collection<Asistencia> asistenciaCollection) {
        this.asistenciaCollection = asistenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matriculaHasCursoPK != null ? matriculaHasCursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatriculaHasCurso)) {
            return false;
        }
        MatriculaHasCurso other = (MatriculaHasCurso) object;
        if ((this.matriculaHasCursoPK == null && other.matriculaHasCursoPK != null) || (this.matriculaHasCursoPK != null && !this.matriculaHasCursoPK.equals(other.matriculaHasCursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.MatriculaHasCurso[ matriculaHasCursoPK=" + matriculaHasCursoPK + " ]";
    }
    
}
