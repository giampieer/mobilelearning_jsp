/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.AdministradorBean;
import Factoria.DaoFactory;
import Interfaces.AdministradorDao;
import Interfaces.AlumnoDAO;
import JPA.Administrador;
import JPA.Alumno;
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
public class MysqlAlumnoDao implements AlumnoDAO{
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("campuscampus");
    EntityManager em=emf.createEntityManager();
    @Override
    public int loginalumno(Alumno obj)throws Exception{
        int i=0;
        try {
            em.getTransaction().begin();
            Query sql=em.createQuery("select a FROM Alumno a where a.usuario=?1 and a.clave=?2");
            sql.setParameter(1, obj.getUsuario());
            sql.setParameter(2, obj.getClave());
            List<Alumno> lista=sql.getResultList();
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
    public String grabaralumno(Alumno obj) throws Exception{
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
    public String eliminaralumno(Alumno obj) throws Exception{
        String mensaje="";
        try {
            em.getTransaction().begin();
            Alumno alum=em.find(Alumno.class, obj.getIdalumno());
            em.remove(alum);
            mensaje="Registro Eliminado";
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return mensaje;
    }

    @Override
    public String modificaralumno(Alumno obj)throws Exception{
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
    public List<Alumno> listaralumno() throws Exception{
        List lista=null;
        try {
            em.getTransaction().begin();
            Query sql=em.createQuery("select al from Alumno al");
            lista=sql.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
       return lista;
    }

    @Override
    public Alumno cargaralumno(Alumno obj)throws Exception {
        Alumno datos=null;
        try {
            em.getTransaction().begin();
            datos=em.find(Alumno.class, obj.getIdalumno());
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
            i=(Integer)em.createQuery("select max(a.idalumno) from Alumno a").getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return i;
    }
    
}