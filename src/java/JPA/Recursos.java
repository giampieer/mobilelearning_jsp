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
@Table(name = "recursos")
public class Recursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idrecursos")
    private Integer idrecursos;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "contenido")
    private String contenido;
    @JoinColumn(name = "horario_idhorario", referencedColumnName = "idhorario")
    @ManyToOne(optional = false)
    private Horario horario;

    public Recursos() {
    }

    public Recursos(Integer idrecursos) {
        this.idrecursos = idrecursos;
    }

    public Recursos(Integer idrecursos, String nombre, String contenido) {
        this.idrecursos = idrecursos;
        this.nombre = nombre;
        this.contenido = contenido;
    }

    public Integer getIdrecursos() {
        return idrecursos;
    }

    public void setIdrecursos(Integer idrecursos) {
        this.idrecursos = idrecursos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrecursos != null ? idrecursos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recursos)) {
            return false;
        }
        Recursos other = (Recursos) object;
        if ((this.idrecursos == null && other.idrecursos != null) || (this.idrecursos != null && !this.idrecursos.equals(other.idrecursos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{\"idRecurso\":\"" + getIdrecursos() + "\",\"Nombre\":\"" + getNombre() + "\",\"Contenido\":\"" + getContenido() + "\",\"idHorario\":\"" + getHorario().getFechainicio()+ "\"}";
    }
    
}
