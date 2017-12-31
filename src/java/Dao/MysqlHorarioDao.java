/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.AdministradorBean;
import Bean.CursoBean;
import Bean.HorarioBean;
import Interfaces.HorarioDao;
import JPA.Horario;
import UTIL.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Jhonk
 */
public class MysqlHorarioDao implements HorarioDao{

    EntityManagerFactory emf=Persistence.createEntityManagerFactory("campuscampus");
    EntityManager em=emf.createEntityManager();
    @Override
    public List<Horario> lista() throws Exception {
        List lista=null;
        try {
            em.getTransaction().begin();
            Query sql=em.createQuery("select h from Horario h");
            lista=sql.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
       return lista;
    }

    @Override
    public String AgregarHorario(Horario obj) throws Exception {
        String mensaje="";
        try {
            em.getTransaction().begin();
            em.persist(obj);
            mensaje="Registro Insertado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return mensaje;
    }

    @Override
    public Horario CapturarHorario(Horario obj) throws Exception {
        Horario datos=null;
        try {
            em.getTransaction().begin();
            datos=em.find(Horario.class, obj.getIdhorario());
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return  datos;
    }

    @Override
    public String ModificarHorario(Horario obj) throws Exception {
        String mensaje="";
        try {
            em.getTransaction().begin();
            em.merge(obj);
            mensaje="Registro Modificado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return mensaje;
    }

    @Override
    public String EliminarHorario(Horario obj) throws Exception {
        String mensaje="";
        try {
            em.getTransaction().begin();
            Horario hora=em.find(Horario.class, obj.getIdhorario());
            em.remove(hora);
            mensaje="Registro Eliminado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return mensaje;
    }

    @Override
    public int generarcodigo() throws Exception {
        int i=0;
        try {
            em.getTransaction().begin();
            i=(Integer)em.createQuery("select max(h.idhorario) from Horario h").getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return i;
    }

}
