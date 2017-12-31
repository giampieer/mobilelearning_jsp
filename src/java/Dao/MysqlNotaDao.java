/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.NotaBean;
import Interfaces.NotaDAO;
import JPA.Notas;
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
public class MysqlNotaDao implements NotaDAO{

    EntityManagerFactory emf=Persistence.createEntityManagerFactory("campuscampus");
    EntityManager em=emf.createEntityManager();
    
    @Override
    public String grabarnota(Notas obj) throws Exception {
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
    public String eliminarnota(Notas obj) throws Exception {
        String estado="";
        try {
            em.getTransaction().begin();
            Notas obja=em.find(Notas.class, obj.getIdnotas());
            em.remove(obja);
            estado="Registro Eliminado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return estado;
    }

    @Override
    public String modificarnota(Notas obj) throws Exception {
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
    public List<Notas> listarnota() throws Exception {
        List lista=null;
        try {
            em.getTransaction().begin();
            Query sql=em.createQuery("select n from Notas n");
            lista=sql.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return lista;
    }

    @Override
    public Notas cargarnota(Notas obj) throws Exception {
        Notas obja=null;
        try {
            em.getTransaction().begin();
            obja=em.find(Notas.class, obj.getIdnotas());
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
            i=(Integer)em.createQuery("select max(n.idnotas) from Notas n").getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return i;
    }
    
}
