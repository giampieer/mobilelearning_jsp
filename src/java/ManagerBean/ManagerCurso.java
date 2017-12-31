/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBean;

import Bean.CursoBean;
import Factoria.DaoFactory;
import Interfaces.CursoDAO;
import JPA.Curso;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author TOSHIBA
 */
public class ManagerCurso {
    private int idcurso;
    private String nombre;
    private String mensaje;
    private List<Curso>lista;
    private ArrayList<SelectItem> listaitem;
    
    /**
     * Creates a new instance of ManagerCurso
     */
    public ManagerCurso() {
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Curso> getLista() throws Exception {
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        CursoDAO objcurso=objfaofactory.getCurso();
        lista=objcurso.listarcurso();
        return lista;
    }

    public void setLista(List<Curso> lista) {
        this.lista = lista;
    }
    
    public void CargarCurso(ActionEvent e){
          String  idcurso;
          DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
          CursoDAO objcurso=objfaofactory.getCurso();
        
         try {
            idcurso = e.getComponent().getAttributes().get("idcurso").toString();
            int idcurso1=Integer.parseInt(idcurso);
            Curso objbean1=new Curso();
            objbean1.setIdcurso(idcurso1);
            Curso objBean = objcurso.cargarcurso(objbean1);
            setIdcurso(objBean.getIdcurso());
            setNombre(objBean.getNombre());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void GrabarCurso(ActionEvent e2){
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        CursoDAO objcurso=objfaofactory.getCurso();
        String i="";
            try {
                Curso objbean=new Curso();
                objbean.setIdcurso(getId());
                objbean.setNombre(getNombre());
                i = objcurso.grabarcurso(objbean);  
                this.setMensaje(i);
                setNombre("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }    
    }
    public void ModificarCurso(ActionEvent e2){
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        CursoDAO objcurso=objfaofactory.getCurso();
        String i="";
            try {
                Curso objbean=new Curso();
                objbean.setIdcurso(getIdcurso());
                objbean.setNombre(getNombre());
                i = objcurso.modificarcurso(objbean);  
                this.setMensaje(i);
        } catch (Exception ex) {
            ex.printStackTrace();
        }     
    }
    public void EliminarCurso(ActionEvent e){
        String  idcurso;
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        CursoDAO objcurso=objfaofactory.getCurso();
        String id="";
         try {
            idcurso = e.getComponent().getAttributes().get("idcurso").toString();
            int idcurso1=Integer.parseInt(idcurso);
            Curso objbean1=new Curso();
            objbean1.setIdcurso(idcurso1);
            id = objcurso.eliminarcurso(objbean1);
            this.setMensaje(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private int id;

    public int getId() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        CursoDAO objCursoDAO=objDaoFactory.getCurso();
        id=objCursoDAO.GenerarCodigo();
        if(id==0){
            id=1;
        }else{
            id=objCursoDAO.GenerarCodigo()+1;
        }
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<SelectItem> getListaitem() {
        listaitem=new ArrayList<SelectItem>();
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        CursoDAO objCursoDAO=objDaoFactory.getCurso();
        try {
            for(Curso obj:objCursoDAO.listarcurso()){
                listaitem.add(new SelectItem(obj.getIdcurso(),obj.getNombre()));
            }
        } catch (Exception e) {
        }
        return listaitem;
    }

    public void setListaitem(ArrayList<SelectItem> listaitem) {
        this.listaitem = listaitem;
    }
    
}
