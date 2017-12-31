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
@Table(name = "matricula")
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idmatricula")
    private Integer idmatricula;
    @Basic(optional = false)
    @Column(name = "ciclo")
    private String ciclo;
    @Basic(optional = false)
    @Column(name = "seccion")
    private String seccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matricula")
    private Collection<MatriculaHasCurso> matriculaHasCursoCollection;
    @JoinColumn(name = "Pagos_idPagos", referencedColumnName = "idPagos")
    @ManyToOne(optional = false)
    private Pagos pagos;
    @JoinColumn(name = "administrador_idadministrador", referencedColumnName = "idadministrador")
    @ManyToOne(optional = false)
    private Administrador administrador;
    @JoinColumn(name = "alumno_idalumno", referencedColumnName = "idalumno")
    @ManyToOne(optional = false)
    private Alumno alumno;

    public Matricula() {
    }

    public Matricula(Integer idmatricula) {
        this.idmatricula = idmatricula;
    }

    public Matricula(Integer idmatricula, String ciclo, String seccion) {
        this.idmatricula = idmatricula;
        this.ciclo = ciclo;
        this.seccion = seccion;
    }

    public Integer getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(Integer idmatricula) {
        this.idmatricula = idmatricula;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public Collection<MatriculaHasCurso> getMatriculaHasCursoCollection() {
        return matriculaHasCursoCollection;
    }

    public void setMatriculaHasCursoCollection(Collection<MatriculaHasCurso> matriculaHasCursoCollection) {
        this.matriculaHasCursoCollection = matriculaHasCursoCollection;
    }

    public Pagos getPagos() {
        return pagos;
    }

    public void setPagos(Pagos pagos) {
        this.pagos = pagos;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
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
        hash += (idmatricula != null ? idmatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.idmatricula == null && other.idmatricula != null) || (this.idmatricula != null && !this.idmatricula.equals(other.idmatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{\"idMatricula\":\"" +getIdmatricula() + "\",\"Ciclo\":\"" +getCiclo() + "\",\"Seccion\":\"" +getSeccion() + "\",\"idAdministrador\":\"" + getAdministrador().getIdadministrador() + "\",\"idAlumno\":\"" + getAlumno().getNombre() + "\",\"idPagos\":\"" +getPagos().getNombrepago() + "\"}";
    }

    public void getIdmatricula(int idusers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
