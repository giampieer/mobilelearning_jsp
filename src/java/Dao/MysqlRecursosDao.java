/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interfaces.RecursosDao;
import JPA.Recursos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Autonoma
 */
public class MysqlRecursosDao implements RecursosDao{

    EntityManagerFactory emf=Persistence.createEntityManagerFactory("campuscampus");
    EntityManager em=emf.createEntityManager();
    @Override
    public List<Recursos> lista() throws Exception {
        List lista=null;
        try {
            em.getTransaction().begin();
            Query sql=em.createQuery("select p from Recursos p");
            lista=sql.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return lista;
    }

    @Override
    public String GrabarRecurso(Recursos obj) throws Exception {
        String mensaje="";
        try {
            em.getTransaction().begin();
            em.persist(obj);
            mensaje="Registro Insertado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return mensaje;
    }

    @Override
    public String ModificarRecurso(Recursos obj) throws Exception {
        String mensaje="";
        try {
            em.getTransaction().begin();
            em.merge(obj);
            mensaje="Registro Modificado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return mensaje;
    }

    @Override
    public String EliminarRecurso(Recursos obj) throws Exception {
        String mensaje="";
        try {
            em.getTransaction().begin();
            Recursos objact=em.find(Recursos.class, obj.getIdrecursos());
            em.remove(objact);
            mensaje="Registro Eliminado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return mensaje;
    }

    @Override
    public Recursos CapturarRecurso(Recursos obj) throws Exception {
        Recursos datos=null;
        try {
            em.getTransaction().begin();
            datos=em.find(Recursos.class, obj.getIdrecursos());
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return datos;
    }

    @Override
    public int GenerarCodigo() throws Exception {
        int i=0;
        try {
            em.getTransaction().begin();
            i=(Integer)em.createQuery("select max(p.idrecursos) from Recursos p").getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return i;
    }
    
}
