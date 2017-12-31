/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interfaces.ReservaLaboratorioDao;
import JPA.Reservalaboratorio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author TOSHIBA
 */
public class MysqlReservaLaboratorioDao implements ReservaLaboratorioDao{
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("campuscampus");
    EntityManager em=emf.createEntityManager();

    @Override
    public List<Reservalaboratorio> lista() throws Exception {
        List lista=null;
        try {
            em.getTransaction().begin();
            Query sql=em.createQuery("select la from Reservalaboratorio la");
            lista=sql.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
       return lista;
    }

    @Override
    public String AgregarReservaLaboratorio(Reservalaboratorio obj) throws Exception {
        String mensaje="";
        try {
            em.getTransaction().begin();
            em.persist(obj);
            mensaje="Registro insertado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return mensaje;
    }

    @Override
    public String ModificarReservaLaboratorio(Reservalaboratorio obj) throws Exception {
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
    public String EliminarReservaLaboratorio(Reservalaboratorio obj) throws Exception {
        String mensaje="";
        try {
            em.getTransaction().begin();
            Reservalaboratorio hora=em.find(Reservalaboratorio.class, obj.getIdReservaLaboratorio());
            em.remove(hora);
            mensaje="Registro Eliminado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return mensaje;
    }

    @Override
    public Reservalaboratorio CapturarReservaLaboratorio(Reservalaboratorio obj) throws Exception {
        Reservalaboratorio datos=null;
        try {
            em.getTransaction().begin();
            datos=em.find(Reservalaboratorio.class, obj.getIdReservaLaboratorio());
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return  datos;
    }

    @Override
    public int GenerarCodigo() throws Exception {
        int i=0;
        try {
            em.getTransaction().begin();
            i=(Integer)em.createQuery("select max(la.idReservaLaboratorio)+1 from Reservalaboratorio la").getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return i;
    }
    
}
