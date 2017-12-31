/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interfaces.LaboratorioDao;
import JPA.Laboratorio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author autonoma
 */
public class MysqlLaboratorioDao implements LaboratorioDao{

    EntityManagerFactory emf=Persistence.createEntityManagerFactory("campuscampus");
    EntityManager em=emf.createEntityManager();
    @Override
    public List<Laboratorio> lista() throws Exception {
        List lista=null;
        try {
            em.getTransaction().begin();
            Query sql=em.createQuery("select l from Laboratorio l");
            lista=sql.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return lista;
    }

    @Override
    public String AgregarLaboratorio(Laboratorio obj) throws Exception {
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
    public String ModificarLaboratorio(Laboratorio obj) throws Exception {
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
    public String EliminarLaboratorio(Laboratorio obj) throws Exception {
        String mensaje="";
        try {
            em.getTransaction().begin();
            Laboratorio objact=em.find(Laboratorio.class, obj.getIdLaboratorio());
            em.remove(objact);
            mensaje="Registro Eliminado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return mensaje;
    }

    @Override
    public Laboratorio CapturarLaboratorio(Laboratorio obj) throws Exception {
        Laboratorio datos=null;
        try {
            em.getTransaction().begin();
            datos=em.find(Laboratorio.class, obj.getIdLaboratorio());
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
            i=(Integer)em.createQuery("select max(l.idLaboratorio) from Laboratorio l").getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return i;
    }
    
}
