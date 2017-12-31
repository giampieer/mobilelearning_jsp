/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBean;

import Factoria.DaoFactory;
import Interfaces.ReservaLibroDao;
import JPA.Alumno;
import JPA.Libro;
import JPA.Reservalibro;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author TOSHIBA
 */
public class ManagerReservaLibro {
    private int idReservaLibro;
    private String fechaentrega;
    private String fechadevolucion;
    private int idalumno;
    private int idLibro;
    private List<Reservalibro>lista;
    private int id;
    private String mensaje;
    private ArrayList<SelectItem> listaItem;
    
    /**
     * Creates a new instance of ManagerReservaLibro
     */
    public ManagerReservaLibro() {
    }

    public int getIdReservaLibro() {
        return idReservaLibro;
    }

    public void setIdReservaLibro(int idReservaLibro) {
        this.idReservaLibro = idReservaLibro;
    }

    public String getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(String fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public String getFechadevolucion() {
        return fechadevolucion;
    }

    public void setFechadevolucion(String fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public List<Reservalibro> getLista() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ReservaLibroDao objReservaLibroDao=objDaoFactory.getReservaLibroDao();
        lista= objReservaLibroDao.lista();
        return lista;
    }

    public void setLista(List<Reservalibro> lista) {
        this.lista = lista;
    }
    
    String i="";
    public void AgregarDatos(ActionEvent e){
        
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ReservaLibroDao objReservaLibroDao=objDaoFactory.getReservaLibroDao();
        try {
            Reservalibro obj=new Reservalibro();
            Alumno alm= new Alumno();
            Libro lib= new Libro();
            obj.setIdReservaLibro(getId());
            obj.setFechaentrega(getFechaentrega());
            obj.setFechadevolucion(getFechadevolucion());
            alm.setIdalumno(getIdalumno());
            obj.setAlumno(alm);
            lib.setIdLibro(getIdLibro());
            obj.setLibro(lib);
            i=objReservaLibroDao.AgregarReservaLibro(obj);
            this.setMensaje(i);
            setFechaentrega("");
            setFechadevolucion("");
            setIdalumno(0);
            setIdLibro(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void CapturarCodigo(ActionEvent e){
        int iduser;
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ReservaLibroDao objReservaLibroDao=objDaoFactory.getReservaLibroDao();
        try {
            iduser=Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());           
            Reservalibro objre=new Reservalibro();
            objre.setIdReservaLibro(iduser);
            Reservalibro objract=objReservaLibroDao.CapturarReservaLibro(objre);
            setIdReservaLibro(iduser);
            setFechaentrega(objract.getFechaentrega());
            setFechadevolucion(objract.getFechadevolucion());
            setIdalumno(objract.getAlumno().getIdalumno());
            setIdLibro(objract.getLibro().getIdLibro());
        } catch (Exception ex) {
        }
    }
    public void ModificarReservaLibro(ActionEvent e){
        String i="";
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ReservaLibroDao objReservaLibroDao=objDaoFactory.getReservaLibroDao();
        try {
            Reservalibro obj=new Reservalibro();
            Alumno alm= new Alumno();
            Libro lib= new Libro();
            obj.setIdReservaLibro(getIdReservaLibro());
            obj.setFechaentrega(getFechaentrega());
            obj.setFechadevolucion(getFechadevolucion());
            lib.setIdLibro(getIdLibro());
            obj.setLibro(lib);
            alm.setIdalumno(getIdalumno());
            obj.setAlumno(alm);
            i=objReservaLibroDao.ModificarReservaLibro(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }
    
    public void EliminarReservaLibro(ActionEvent e){
        String i="";
        int idad;
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ReservaLibroDao objReservaLibroDao=objDaoFactory.getReservaLibroDao();
        try {
            idad=Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());
            Reservalibro obj=new Reservalibro();
            obj.setIdReservaLibro(idad);
            i=objReservaLibroDao.EliminarReservaLibro(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }
    
    public int getId() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ReservaLibroDao objReservaLibroDao=objDaoFactory.getReservaLibroDao();
        id=objReservaLibroDao.GenerarCodigo();
        if(id==0){
            id=1;
        }else{
            id=objReservaLibroDao.GenerarCodigo();
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

    public ArrayList<SelectItem> getListaItem() {
        listaItem=new ArrayList<SelectItem>();
        DaoFactory objDAOFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ReservaLibroDao objReservaLibroDao=objDAOFactory.getReservaLibroDao();
        try {
            for(Reservalibro r:objReservaLibroDao.lista()){
                listaItem.add(new SelectItem(r.getIdReservaLibro(),r.getFechaentrega()));
            }
        } catch (Exception e) {
        }
        return listaItem;
    }

    public void setListaItem(ArrayList<SelectItem> listaItem) {
        this.listaItem = listaItem;
    }
    
}
