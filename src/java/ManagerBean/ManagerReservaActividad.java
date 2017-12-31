/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBean;

import Factoria.DaoFactory;
import Interfaces.ReservaActividadDao;
import JPA.Actividad;
import JPA.Alumno;
import JPA.Reservaactividad;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author TOSHIBA
 */
@ManagedBean
@RequestScoped
public class ManagerReservaActividad {
    
    private int idreservaactividad;
    private String dia;
    private String hora;
    private int idalumno;
    private int idactividad;
    private List<Reservaactividad> lista;
    private int id;
    private String mensaje;
    private ArrayList<SelectItem> listaItem;
    
    /**
     * Creates a new instance of ManagerReservaActividad
     */
    public ManagerReservaActividad() {
    }

    public int getIdreservaactividad() {
        return idreservaactividad;
    }

    public void setIdreservaactividad(int idreservaactividad) {
        this.idreservaactividad = idreservaactividad;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public int getIdactividad() {
        return idactividad;
    }

    public void setIdactividad(int idactividad) {
        this.idactividad = idactividad;
    }

    public List<Reservaactividad> getLista() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ReservaActividadDao objReservaActividadDao=objDaoFactory.getReservaActividadDao();
        lista= objReservaActividadDao.lista();
        return lista;
    }

    public void setLista(List<Reservaactividad> lista) {
        this.lista = lista;
    }
    String i="";
    public void AgregarDatos(ActionEvent e){
        
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ReservaActividadDao objReservaActividadDao=objDaoFactory.getReservaActividadDao();
        try {
            Reservaactividad obj=new Reservaactividad();
            Alumno alm= new Alumno();
            Actividad act= new Actividad();
            obj.setIdReservaActividad(getId());
            obj.setDia(getDia());
            obj.setHora(getHora());
            alm.setIdalumno(getIdalumno());
            obj.setAlumno(alm);
            act.setIdActividad(getIdactividad());
            obj.setActividad(act);
            i=objReservaActividadDao.AgregarReservaActividad(obj);
            this.setMensaje(i);
            setDia("");
            setHora("");
            setIdalumno(0);
            setIdactividad(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void CapturarCodigo(ActionEvent e){
        int iduser;
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ReservaActividadDao objReservaActividadDao=objDaoFactory.getReservaActividadDao();
        try {
            iduser=Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());           
            Reservaactividad objre=new Reservaactividad();
            objre.setIdReservaActividad(iduser);
            Reservaactividad objract=objReservaActividadDao.CapturarReservaActividad(objre);
            setIdreservaactividad(iduser);
            setDia(objract.getDia());
            setHora(objract.getHora());
            setIdalumno(objract.getAlumno().getIdalumno());
            setIdactividad(objract.getActividad().getIdActividad());
        } catch (Exception ex) {
        }
    }
    public void ModificarReservaActividad(ActionEvent e){
        String i="";
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ReservaActividadDao objReservaActividadDao=objDaoFactory.getReservaActividadDao();
        try {
            Reservaactividad obj=new Reservaactividad();
            Alumno alm= new Alumno();
            Actividad act= new Actividad();
            obj.setIdReservaActividad(getIdreservaactividad());
            obj.setDia(getDia());
            obj.setHora(getHora());
            act.setIdActividad(getIdactividad());
            obj.setActividad(act);
            alm.setIdalumno(getIdalumno());
            obj.setAlumno(alm);
            i=objReservaActividadDao.ModificarReservaActividad(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }
    
    public void EliminarReservaActividad(ActionEvent e){
        String i="";
        int idad;
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ReservaActividadDao objReservaActividadDao=objDaoFactory.getReservaActividadDao();
        try {
            idad=Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());
            Reservaactividad obj=new Reservaactividad();
            obj.setIdReservaActividad(idad);
            i=objReservaActividadDao.EliminarReservaActividad(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }
    
    public int getId() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ReservaActividadDao objReservaActividadDao=objDaoFactory.getReservaActividadDao();
        id=objReservaActividadDao.GenerarCodigo();
        if(id==0){
            id=1;
        }else{
            id=objReservaActividadDao.GenerarCodigo();
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
        ReservaActividadDao objReservaActividadDao=objDAOFactory.getReservaActividadDao();
        try {
            for(Reservaactividad r:objReservaActividadDao.lista()){
                listaItem.add(new SelectItem(r.getIdReservaActividad(),r.getDia()));
            }
        } catch (Exception e) {
        }
        return listaItem;
    }

    public void setListaItem(ArrayList<SelectItem> listaItem) {
        this.listaItem = listaItem;
    }
    
}
