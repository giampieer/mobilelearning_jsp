/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBean;

import Factoria.DaoFactory;
import Interfaces.ActividadDao;
import JPA.Actividad;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author autonoma
 */
public class ManagerActividad {

    private int idactividad;
    private String actividad;
    private String estado;
    private List<Actividad> lista;
    private int id;
    private String mensaje;
    private ArrayList<SelectItem> listaItem;
    /**
     * Creates a new instance of ManagerActividad
     */
    public ManagerActividad() {
    }

    public int getIdactividad() {
        return idactividad;
    }

    public void setIdactividad(int idactividad) {
        this.idactividad = idactividad;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Actividad> getLista() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ActividadDao objActividadDao=objDaoFactory.getActividadDao();
        lista=objActividadDao.lista();
        return lista;
    }

    public void setLista(List<Actividad> lista) {
        this.lista = lista;
    }
    
    public void AgregarDatos(ActionEvent e){
        String i="";
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ActividadDao objActividadDao=objDaoFactory.getActividadDao();
        try {
            Actividad obj=new Actividad();
            obj.setIdActividad(getId());
            obj.setNombre(getActividad());
            obj.setEstado(getEstado());
            i=objActividadDao.AgregarActividad(obj);
            this.setMensaje(i);
            setActividad("");
            setEstado("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void CapturarCodigo(ActionEvent e){
        int idad;
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ActividadDao objActividadDao=objDaoFactory.getActividadDao();
        try {
            idad=Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());
            Actividad obj=new Actividad();
            obj.setIdActividad(idad);
            Actividad objact=objActividadDao.CapturarActividad(obj);
            setIdactividad(objact.getIdActividad());
            setActividad(objact.getNombre());
            setEstado(objact.getEstado());
        } catch (Exception ex) {
        }
    }
    public void ModificarActividad(ActionEvent e){
        String i="";
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ActividadDao objActividadDao=objDaoFactory.getActividadDao();
        try {
            Actividad obj=new Actividad();
            obj.setIdActividad(getIdactividad());
            obj.setNombre(getActividad());
            obj.setEstado(getEstado());
            i=objActividadDao.ModificarActividad(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }
    
    public void EliminarActividad(ActionEvent e){
        String i="";
        int idad;
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ActividadDao objActividadDao=objDaoFactory.getActividadDao();
        try {
            idad=Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());
            Actividad obj=new Actividad();
            obj.setIdActividad(idad);
            i=objActividadDao.EliminarActividad(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }
    
    public int getId() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ActividadDao objActividadDao=objDaoFactory.getActividadDao();
        id=objActividadDao.GenerarCodigo();
        if(id==0){
            id=1;
        }else{
            id=objActividadDao.GenerarCodigo()+1;
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
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ActividadDao objActividadDao=objDaoFactory.getActividadDao();
        try {
            for(Actividad obj:objActividadDao.lista()){
                listaItem.add(new SelectItem(obj.getIdActividad(),obj.getNombre()));
            }
        } catch (Exception e) {
        }
        return listaItem;
    }
    
    
}
