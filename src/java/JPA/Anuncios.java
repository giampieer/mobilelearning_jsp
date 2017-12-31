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
@Table(name = "anuncios")
public class Anuncios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idanuncios")
    private Integer idanuncios;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "horario_idhorario", referencedColumnName = "idhorario")
    @ManyToOne(optional = false)
    private Horario horario;

    public Anuncios() {
    }

    public Anuncios(Integer idanuncios) {
        this.idanuncios = idanuncios;
    }

    public Anuncios(Integer idanuncios, String nombre) {
        this.idanuncios = idanuncios;
        this.nombre = nombre;
    }

    public Integer getIdanuncios() {
        return idanuncios;
    }

    public void setIdanuncios(Integer idanuncios) {
        this.idanuncios = idanuncios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idanuncios != null ? idanuncios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anuncios)) {
            return false;
        }
        Anuncios other = (Anuncios) object;
        if ((this.idanuncios == null && other.idanuncios != null) || (this.idanuncios != null && !this.idanuncios.equals(other.idanuncios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{\"idAnuncio\":\""+getIdanuncios()+"\",\"Nombre\":\""+getNombre()+"\",\"idHorario\":\""+getHorario().getFechainicio()+"\"}";
    }
    
}
