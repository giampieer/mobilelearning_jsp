/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author autonoma
 */
@Embeddable
public class MatriculaHasCursoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "matricula_idmatricula")
    private int matriculaIdmatricula;
    @Basic(optional = false)
    @Column(name = "curso_idcurso")
    private int cursoIdcurso;

    public MatriculaHasCursoPK() {
    }

    public MatriculaHasCursoPK(int matriculaIdmatricula, int cursoIdcurso) {
        this.matriculaIdmatricula = matriculaIdmatricula;
        this.cursoIdcurso = cursoIdcurso;
    }

    public int getMatriculaIdmatricula() {
        return matriculaIdmatricula;
    }

    public void setMatriculaIdmatricula(int matriculaIdmatricula) {
        this.matriculaIdmatricula = matriculaIdmatricula;
    }

    public int getCursoIdcurso() {
        return cursoIdcurso;
    }

    public void setCursoIdcurso(int cursoIdcurso) {
        this.cursoIdcurso = cursoIdcurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) matriculaIdmatricula;
        hash += (int) cursoIdcurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatriculaHasCursoPK)) {
            return false;
        }
        MatriculaHasCursoPK other = (MatriculaHasCursoPK) object;
        if (this.matriculaIdmatricula != other.matriculaIdmatricula) {
            return false;
        }
        if (this.cursoIdcurso != other.cursoIdcurso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.MatriculaHasCursoPK[ matriculaIdmatricula=" + matriculaIdmatricula + ", cursoIdcurso=" + cursoIdcurso + " ]";
    }
    
}
