/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBean;

import Factoria.DaoFactory;
import Interfaces.LibroDao;
import JPA.Libro;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author autonoma
 */
public class ManagerLibro {

    private int idlibro;
    private String nombre;
    private String autor;
    private int ejemplares;
    private String estado;
    private List<Libro> lista;
    private int id;
    private String mensaje;
    private ArrayList<SelectItem> listaItem;
    public ManagerLibro() {
    }

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Libro> getLista() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        LibroDao objLibroDao=objDaoFactory.getLibroDao();
        lista=objLibroDao.lista();
        return lista;
    }

    public void setLista(List<Libro> lista) {
        this.lista = lista;
    }

    public int getId() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        LibroDao objLibroDao=objDaoFactory.getLibroDao();
        id=objLibroDao.GenerarCodigo();
        if(id==0){
            id=1;
        }else{
            id=objLibroDao.GenerarCodigo()+1;
        }
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void AgregarDatos(ActionEvent e){
        String i="";
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        LibroDao objLibroDao=objDaoFactory.getLibroDao();
        try {
            Libro obj=new Libro();
            obj.setIdLibro(getId());
            obj.setNombre(getNombre());
            obj.setAutor(getAutor());
            obj.setEjemplares(getEjemplares());
            obj.setEstado(getEstado());
            i=objLibroDao.AgregarLibro(obj);
            this.setMensaje(i);
            setNombre("");
            setAutor("");
            setEjemplares(0);
            setEstado("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void CapturarCodigo(ActionEvent e){
        int idad;
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        LibroDao objLibroDao=objDaoFactory.getLibroDao();
        try {
            idad=Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());
            Libro obj=new Libro();
            obj.setIdLibro(idad);
            Libro objact=objLibroDao.CapturarLibro(obj);
            setIdlibro(objact.getIdLibro());
            setNombre(objact.getNombre());
            setAutor(objact.getAutor());
            setEjemplares(objact.getEjemplares());
            setEstado(objact.getEstado());
        } catch (Exception ex) {
        }
    }
    public void ModificarActividad(ActionEvent e){
        String i="";
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        LibroDao objLibroDao=objDaoFactory.getLibroDao();
        try {
            Libro obj=new Libro();
            obj.setIdLibro(getIdlibro());
            obj.setNombre(getNombre());
            obj.setAutor(getAutor());
            obj.setEjemplares(getEjemplares());
            obj.setEstado(getEstado());
            i=objLibroDao.ModificarLibro(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }
    
    public void EliminarActividad(ActionEvent e){
        String i="";
        int idad;
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        LibroDao objLibroDao=objDaoFactory.getLibroDao();
        try {
            idad=Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());
            Libro obj=new Libro();
            obj.setIdLibro(idad);
            i=objLibroDao.EliminarLibro(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public ArrayList<SelectItem> getListaItem() {
        listaItem=new ArrayList<SelectItem>();
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        LibroDao objLibroDao=objDaoFactory.getLibroDao();
        try {
            for(Libro obj:objLibroDao.lista()){
                listaItem.add(new SelectItem(obj.getIdLibro(),obj.getNombre()));
            }
        } catch (Exception e) {
        }
        return listaItem;
    }
}
