/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBean;

import Factoria.DaoFactory;
import Interfaces.RecursosDao;
import JPA.Horario;
import JPA.Recursos;
import java.util.List;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Autonoma
 */
public class ManagerRecursos {

    private int idrecurso;
    private String nombre;
    private String contenido;
    private int idhorario;
    private List<Recursos> lista;
    private int id;
    private String mensaje;
    public ManagerRecursos() {
    }

    public int getIdrecurso() {
        return idrecurso;
    }

    public void setIdrecurso(int idrecurso) {
        this.idrecurso = idrecurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(int idhorario) {
        this.idhorario = idhorario;
    }

    public List<Recursos> getLista() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        RecursosDao objRecursosDao=objDaoFactory.getRecursosDao();
        lista=objRecursosDao.lista();
        return lista;
    }

    public void setLista(List<Recursos> lista) {
        this.lista = lista;
    }

    public int getId() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        RecursosDao objRecursosDao=objDaoFactory.getRecursosDao();
        id=objRecursosDao.GenerarCodigo();
        if(id==0){
            id=1;
        }else{
            id=objRecursosDao.GenerarCodigo()+1;
        }
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public void AgregarDatos(ActionEvent e){
        String i="";
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        RecursosDao objPagoDao=objDaoFactory.getRecursosDao();
        try {
            Recursos obj=new Recursos();
            Horario hor=new Horario();
            obj.setIdrecursos(getId());
            obj.setNombre(getNombre());
            obj.setContenido(getContenido());
            hor.setIdhorario(getIdhorario());
            obj.setHorario(hor);
            i=objPagoDao.GrabarRecurso(obj);
            this.setMensaje(i);
            setNombre("");
            setContenido("");
            setIdhorario(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void CapturarDatos(ActionEvent e){
        int idad;
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        RecursosDao objPagoDao=objDaoFactory.getRecursosDao();
        try {
            idad=Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());
            Recursos obj=new Recursos();
            obj.setIdrecursos(idad);
            Recursos objact=objPagoDao.CapturarRecurso(obj);
            setIdrecurso(objact.getIdrecursos());
            setNombre(objact.getNombre());
            setContenido(objact.getContenido());
            setIdhorario(objact.getHorario().getIdhorario());
        } catch (Exception ex) {
        }
    }
    public void ModificarActividad(ActionEvent e){
        String i="";
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        RecursosDao objPagoDao=objDaoFactory.getRecursosDao();
        try {
            Recursos obj=new Recursos();
            obj.setIdrecursos(getIdrecurso());
            obj.setNombre(getNombre());
            obj.setContenido(getContenido());
            Horario hor=new Horario();
            hor.setIdhorario(getIdhorario());
            obj.setHorario(hor);
            i=objPagoDao.ModificarRecurso(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }
    
    public void EliminarActividad(ActionEvent e){
        String i="";
        int idad;
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        RecursosDao objPagoDao=objDaoFactory.getRecursosDao();
        try {
            idad=Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());
            Recursos obj=new Recursos();
            obj.setIdrecursos(idad);
            i=objPagoDao.EliminarRecurso(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }
}
