/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.AdministradorBean;
import Factoria.DaoFactory;
import Interfaces.AdministradorDao;
import Interfaces.ProfesorDAO;
import JPA.Administrador;
import JPA.Profesor;
import ManagerBean.ManagerAdministrador;
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
public class MysqlProfesorDao implements ProfesorDAO{
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("campuscampus");
    EntityManager em=emf.createEntityManager();
    @Override
    public int loginprofesor(Profesor obj)throws Exception{
        int i=0;
        try {
            em.getTransaction().begin();
            Query sql=em.createQuery("select a FROM Profesor a where a.usuario=?1 and a.clave=?2");
            sql.setParameter(1, obj.getUsuario());
            sql.setParameter(2, obj.getClave());
            List<Profesor> lista=sql.getResultList();
            if(lista.size()>0){
                i=1;
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return i;
    }
    
@Override
    public String grabarprofesor(Profesor obj) throws Exception {
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
    public String eliminarprofesor(Profesor obj) throws Exception {
        String mensaje="";
        try {
            em.getTransaction().begin();
            Profesor profe=em.find(Profesor.class, obj.getIdprofesor());
            em.remove(profe);
            mensaje="Registro Eliminado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return mensaje;
    }

    @Override
    public String modificarprofesor(Profesor obj) throws Exception {
        String mensaje="";
        try {
            em.getTransaction().begin();
            em.merge(obj);
            mensaje="Registro Modificado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().commit();
        }
        return mensaje;
    }

    @Override
    public List<Profesor> listarprofesor() throws Exception {
        List<Profesor> lista=null;
        try {
            em.getTransaction().begin();
            Query sql=em.createQuery("select p from Profesor p");
            lista=sql.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Profesor cargarprofesor(Profesor obj) throws Exception {
        Profesor objeto=null;
        try {
            em.getTransaction().begin();
            objeto=em.find(Profesor.class, obj.getIdprofesor());
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return objeto;
    }

    @Override
    public int GenerarCodigo() throws Exception {
        int i=0;
        try {
            em.getTransaction().begin();
            i=(Integer)em.createQuery("select max(p.idprofesor) from Profesor p").getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return i;
    }
    
}