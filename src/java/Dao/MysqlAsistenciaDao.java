/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.AsistenciaBean;
import Factoria.DaoFactory;
import Interfaces.AsistenciaDAO;
import JPA.Asistencia;
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
 * @author TOSHIBA
 */
public class MysqlAsistenciaDao implements AsistenciaDAO{

    EntityManagerFactory emf=Persistence.createEntityManagerFactory("campuscampus");
    EntityManager em=emf.createEntityManager();
    @Override
    public String grabarasistencia(Asistencia obj) throws Exception{
        String estado="";
        try {
            em.getTransaction().begin();
            em.persist(obj);
            estado="Registro Insertado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return estado;
    }

    @Override
    public String eliminarasistencia(Asistencia obj) throws Exception{
        String estado="";
        try {
            em.getTransaction().begin();
            Asistencia obja=em.find(Asistencia.class, obj.getIdasistencia());
            em.remove(obja);
            estado="Registro Eliminado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return estado;
    }

    @Override
    public String modificarasistencia(Asistencia obj) throws Exception{
        String estado="";
        try {
            em.getTransaction().begin();
            em.merge(obj);
            estado="Registro Modificado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return estado;
    }

    @Override
    public List<Asistencia> listarasistencia() throws Exception{
        List lista=null;
        try {
            em.getTransaction().begin();
            Query sql=em.createQuery("select a from Asistencia a");
            lista=sql.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return lista;
    }

    @Override
    public Asistencia cargarasistencia(Asistencia obj) throws Exception{
        Asistencia obja=null;
        try {
            em.getTransaction().begin();
            obja=em.find(Asistencia.class, obj.getIdasistencia());
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return obja;
    }

    @Override
    public int GenerarCodigo() throws Exception {
        int i=0;
        try {
            em.getTransaction().begin();
            i=(Integer)em.createQuery("select max(a.idasistencia) from Asistencia a").getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return i;
    }
    
}
