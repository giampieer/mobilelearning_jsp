/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBean;

import Factoria.DaoFactory;
import Interfaces.ReservaLaboratorioDao;
import JPA.Alumno;
import JPA.Laboratorio;
import JPA.Reservalaboratorio;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author TOSHIBA
 */
public class ManagerReservaLaboratorio {
    private int idReservaLaboratorio;
    private String horainicio;
    private String horafin;
    private int idalumno;
    private int idLaboratorio;
    private List<Reservalaboratorio>lista;
    private int id;
    private String mensaje;
    private ArrayList<SelectItem> listaItem;
    /**
     * Creates a new instance of ManagerReservaLaboratorio
     */
    public ManagerReservaLaboratorio() {
    }

    public int getIdReservaLaboratorio() {
        return idReservaLaboratorio;
    }

    public void setIdReservaLaboratorio(int idReservaLaboratorio) {
        this.idReservaLaboratorio = idReservaLaboratorio;
    }

    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public String getHorafin() {
        return horafin;
    }

    public void setHorafin(String horafin) {
        this.horafin = horafin;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public List<Reservalaboratorio> getLista() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ReservaLaboratorioDao objReservaLaboratorioDao=objDaoFactory.getReservaLaboratorioDao();
        lista= objReservaLaboratorioDao.lista();
        return lista;
    }

    public void setLista(List<Reservalaboratorio> lista) {
        this.lista = lista;
    }
    
    String i="";
    public void AgregarDatos(ActionEvent e){
        
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ReservaLaboratorioDao objReservaLaboratorioDao=objDaoFactory.getReservaLaboratorioDao();
        try {
            Reservalaboratorio obj=new Reservalaboratorio();
            Alumno alm= new Alumno();
            Laboratorio lab= new Laboratorio();
            obj.setIdReservaLaboratorio(getId());
            obj.setHorainicio(getHorainicio());
            obj.setHorafin(getHorafin());
            alm.setIdalumno(getIdalumno());
            obj.setAlumno(alm);
            lab.setIdLaboratorio(getIdLaboratorio());
            obj.setLaboratorio(lab);
            i=objReservaLaboratorioDao.AgregarReservaLaboratorio(obj);
            this.setMensaje(i);
            setHorainicio("");
            setHorafin("");
            setIdalumno(0);
            setIdLaboratorio(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void CapturarCodigo(ActionEvent e){
        int iduser;
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ReservaLaboratorioDao objReservaLaboratorioDao=objDaoFactory.getReservaLaboratorioDao();
        try {
            iduser=Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());           
            Reservalaboratorio objre=new Reservalaboratorio();
            objre.setIdReservaLaboratorio(iduser);
            Reservalaboratorio objract=objReservaLaboratorioDao.CapturarReservaLaboratorio(objre);
            setIdReservaLaboratorio(iduser);
            setHorainicio(objract.getHorainicio());
            setHorafin(objract.getHorafin());
            setIdalumno(objract.getAlumno().getIdalumno());
            setIdLaboratorio(objract.getLaboratorio().getIdLaboratorio());
        } catch (Exception ex) {
        }
    }
    public void ModificarReservaLaboratorio(ActionEvent e){
        String i="";
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ReservaLaboratorioDao objReservaLaboratorioDao=objDaoFactory.getReservaLaboratorioDao();
        try {
            Reservalaboratorio obj=new Reservalaboratorio();
            Alumno alm= new Alumno();
            Laboratorio lab= new Laboratorio();
            obj.setIdReservaLaboratorio(getIdReservaLaboratorio());
            obj.setHorainicio(getHorainicio());
            obj.setHorafin(getHorafin());
            lab.setIdLaboratorio(getIdLaboratorio());
            obj.setLaboratorio(lab);
            alm.setIdalumno(getIdalumno());
            obj.setAlumno(alm);
            i=objReservaLaboratorioDao.ModificarReservaLaboratorio(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }
    
    public void EliminarReservaLaboratorio(ActionEvent e){
        String i="";
        int idad;
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ReservaLaboratorioDao objReservaLaboratorioDao=objDaoFactory.getReservaLaboratorioDao();
        try {
            idad=Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());
            Reservalaboratorio obj=new Reservalaboratorio();
            obj.setIdReservaLaboratorio(idad);
            i=objReservaLaboratorioDao.EliminarReservaLaboratorio(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }
    public int getId() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ReservaLaboratorioDao objReservaLaboratorioDao=objDaoFactory.getReservaLaboratorioDao();
        id=objReservaLaboratorioDao.GenerarCodigo();
        if(id==0){
            id=1;
        }else{
            id=objReservaLaboratorioDao.GenerarCodigo();
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
        ReservaLaboratorioDao objReservaLaboratorioDao=objDAOFactory.getReservaLaboratorioDao();
        try {
            for(Reservalaboratorio r:objReservaLaboratorioDao.lista()){
                listaItem.add(new SelectItem(r.getIdReservaLaboratorio(),r.getHorainicio()));
            }
        } catch (Exception e) {
        }
        return listaItem;
    }

    public void setListaItem(ArrayList<SelectItem> listaItem) {
        this.listaItem = listaItem;
    }
    
}

