/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBean;

import Factoria.DaoFactory;
import Interfaces.LaboratorioDao;
import JPA.Laboratorio;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author autonoma
 */
public class ManagerLaboratorio {

    private int idlaboratorio;
    private String nombre;
    private String estado;
    private String mensaje;
    private int id;
    private List<Laboratorio> lista;
    private ArrayList<SelectItem> listaItem;
    public ManagerLaboratorio() {
    }

    public int getIdlaboratorio() {
        return idlaboratorio;
    }

    public void setIdlaboratorio(int idlaboratorio) {
        this.idlaboratorio = idlaboratorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getId() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        LaboratorioDao objLaboratorioDao=objDaoFactory.getLaboratorioDao();
        id=objLaboratorioDao.GenerarCodigo();
        if(id==0){
            id=1;
        }else{
            id=objLaboratorioDao.GenerarCodigo()+1;
        }
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Laboratorio> getLista() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        LaboratorioDao objLaboratorioDao=objDaoFactory.getLaboratorioDao();
        lista=objLaboratorioDao.lista();
        return lista;
    }

    public void setLista(List<Laboratorio> lista) {
        this.lista = lista;
    }
    
    public void AgregarDatos(ActionEvent e){
        String i="";
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        LaboratorioDao objLaboratorioDao=objDaoFactory.getLaboratorioDao();
        try {
            Laboratorio obj=new Laboratorio();
            obj.setIdLaboratorio(getId());
            obj.setNombre(getNombre());
            obj.setEstado(getEstado());
            i=objLaboratorioDao.AgregarLaboratorio(obj);
            this.setMensaje(i);
            setNombre("");
            setEstado("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void CapturarCodigo(ActionEvent e){
        int idad;
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        LaboratorioDao objLaboratorioDao=objDaoFactory.getLaboratorioDao();
        try {
            idad=Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());
            Laboratorio obj=new Laboratorio();
            obj.setIdLaboratorio(idad);
            Laboratorio objact=objLaboratorioDao.CapturarLaboratorio(obj);
            setIdlaboratorio(objact.getIdLaboratorio());
            setNombre(objact.getNombre());
            setEstado(objact.getEstado());
        } catch (Exception ex) {
        }
    }
    public void ModificarActividad(ActionEvent e){
        String i="";
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        LaboratorioDao objLaboratorioDao=objDaoFactory.getLaboratorioDao();
        try {
            Laboratorio obj=new Laboratorio();
            obj.setIdLaboratorio(getIdlaboratorio());
            obj.setNombre(getNombre());
            obj.setEstado(getEstado());
            i=objLaboratorioDao.ModificarLaboratorio(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }
    
    public void EliminarActividad(ActionEvent e){
        String i="";
        int idad;
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        LaboratorioDao objLaboratorioDao=objDaoFactory.getLaboratorioDao();
        try {
            idad=Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());
            Laboratorio obj=new Laboratorio();
            obj.setIdLaboratorio(idad);
            i=objLaboratorioDao.EliminarLaboratorio(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }
    public ArrayList<SelectItem> getListaItem() {
        listaItem=new ArrayList<SelectItem>();
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        LaboratorioDao objLaboratorioDao=objDaoFactory.getLaboratorioDao();
        try {
            for(Laboratorio obj:objLaboratorioDao.lista()){
                listaItem.add(new SelectItem(obj.getIdLaboratorio(),obj.getNombre()));
            }
        } catch (Exception e) {
        }
        return listaItem;
    }
}
