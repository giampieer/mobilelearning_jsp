/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBean;

import Factoria.DaoFactory;
import Interfaces.AnuncioDao;
import JPA.Anuncios;
import JPA.Horario;
import java.util.List;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Jhonk
 */
public class ManagerAnuncio {

    private int idanuncio;
    private String nombre;
    private int idhorario;
    private List<Anuncios>lista;
    private String mensaje;
    private int id;
    public ManagerAnuncio() {
    }

    public int getIdanuncio() {
        return idanuncio;
    }

    public void setIdanuncio(int idanuncio) {
        this.idanuncio = idanuncio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(int idhorario) {
        this.idhorario = idhorario;
    }

    public List<Anuncios> getLista() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AnuncioDao objAnuncioDao=objDaoFactory.getAnuncioDao();
        lista=objAnuncioDao.lista();
        return lista;
    }

    public void setLista(List<Anuncios> lista) {
        this.lista = lista;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getId() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AnuncioDao objAnuncioDao=objDaoFactory.getAnuncioDao();
        id=objAnuncioDao.GenerarCodigo();
        if(id==0){
            id=1;
        }else{
            id=objAnuncioDao.GenerarCodigo()+1;
        }
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void AgregarDatos(ActionEvent e){
        String i="";
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AnuncioDao objAnuncioDao=objDaoFactory.getAnuncioDao();
        try {
            Anuncios obj=new Anuncios();
            Horario hor=new Horario();
            obj.setIdanuncios(getId());
            obj.setNombre(getNombre());
            hor.setIdhorario(getIdhorario());
            obj.setHorario(hor);
            i=objAnuncioDao.GrabarAnuncio(obj);
            this.setMensaje(i);
            setNombre("");
            setIdhorario(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void CapturarDatos(ActionEvent e){
        int idad;
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AnuncioDao objAnuncioDao=objDaoFactory.getAnuncioDao();
        try {
            idad=Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());
            Anuncios obj=new Anuncios();
            obj.setIdanuncios(idad);
            Anuncios objact=objAnuncioDao.CapturarAnuncio(obj);
            setIdanuncio(objact.getIdanuncios());
            setNombre(objact.getNombre());
            setIdhorario(objact.getHorario().getIdhorario());
        } catch (Exception ex) {
        }
    }
    public void ModificarActividad(ActionEvent e){
        String i="";
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AnuncioDao objAnuncioDao=objDaoFactory.getAnuncioDao();
        try {
            Anuncios obj=new Anuncios();
            obj.setIdanuncios(getIdanuncio());
            obj.setNombre(getNombre());
            Horario hor=new Horario();
            hor.setIdhorario(getIdhorario());
            obj.setHorario(hor);
            i=objAnuncioDao.ModificarAnuncio(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }
    
    public void EliminarActividad(ActionEvent e){
        String i="";
        int idad;
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AnuncioDao objAnuncioDao=objDaoFactory.getAnuncioDao();
        try {
            idad=Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());
            Anuncios obj=new Anuncios();
            obj.setIdanuncios(idad);
            i=objAnuncioDao.EliminarAnuncio(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }
    
}
