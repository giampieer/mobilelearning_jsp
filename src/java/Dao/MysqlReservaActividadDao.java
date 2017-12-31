/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interfaces.ReservaActividadDao;
import JPA.Reservaactividad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author TOSHIBA
 */
public class MysqlReservaActividadDao implements ReservaActividadDao{
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("campuscampus");
    EntityManager em=emf.createEntityManager();

    @Override
    public List<Reservaactividad> lista() throws Exception {
        List lista=null;
        try {
            em.getTransaction().begin();
            Query sql=em.createQuery("select ra from Reservaactividad ra");
            lista=sql.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return lista;
    }

    @Override
    public String AgregarReservaActividad(Reservaactividad obj) throws Exception {
        String mensaje="";
        try {
            em.getTransaction().begin();
            em.persist(obj);
            mensaje="Registro insertado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return mensaje;
    }

    @Override
    public String ModificarReservaActividad(Reservaactividad obj) throws Exception {
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
    public String EliminarReservaActividad(Reservaactividad obj) throws Exception {
        String mensaje="";
        try {
            em.getTransaction().begin();
            Reservaactividad objact=em.find(Reservaactividad.class, obj.getIdReservaActividad());
            em.remove(objact);
            mensaje="Registro eliminado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return mensaje;
    }

    @Override
    public Reservaactividad CapturarReservaActividad(Reservaactividad obj) throws Exception {
        Reservaactividad datos=null;
        try {
            em.getTransaction().begin();
            datos=em.find(Reservaactividad.class, obj.getIdReservaActividad());
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
            i=(Integer)em.createQuery("select max(ra.idReservaActividad)+1 from Reservaactividad ra").getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return i;
    }
    
}
