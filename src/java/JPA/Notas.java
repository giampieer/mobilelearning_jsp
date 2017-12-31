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
@Table(name = "notas")
public class Notas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idnotas")
    private Integer idnotas;
    @Basic(optional = false)
    @Column(name = "nota")
    private double nota;
    @Basic(optional = false)
    @Column(name = "tiponota")
    private String tiponota;
    @JoinColumns({
        @JoinColumn(name = "matricula_has_curso_matricula_idmatricula", referencedColumnName = "matricula_idmatricula")
        , @JoinColumn(name = "matricula_has_curso_curso_idcurso", referencedColumnName = "curso_idcurso")})
    @ManyToOne(optional = false)
    private MatriculaHasCurso matriculaHasCurso;

    public Notas() {
    }

    public Notas(Integer idnotas) {
        this.idnotas = idnotas;
    }

    public Notas(Integer idnotas, double nota, String tiponota) {
        this.idnotas = idnotas;
        this.nota = nota;
        this.tiponota = tiponota;
    }

    public Integer getIdnotas() {
        return idnotas;
    }

    public void setIdnotas(Integer idnotas) {
        this.idnotas = idnotas;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getTiponota() {
        return tiponota;
    }

    public void setTiponota(String tiponota) {
        this.tiponota = tiponota;
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
        hash += (idnotas != null ? idnotas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notas)) {
            return false;
        }
        Notas other = (Notas) object;
        if ((this.idnotas == null && other.idnotas != null) || (this.idnotas != null && !this.idnotas.equals(other.idnotas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{\"idNota\":\"" + getIdnotas() + "\",\"Nota\":\"" + getNota() + "\",\"TipoNota\":\"" + getTiponota() + "\",\"idMatricula\":\"" + getMatriculaHasCurso().getMatriculaHasCursoPK().getMatriculaIdmatricula() + "\",\"idCurso\":\"" + getMatriculaHasCurso().getMatriculaHasCursoPK().getCursoIdcurso() + "\"}";
    }
    
}
