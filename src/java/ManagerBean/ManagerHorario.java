/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBean;

import Bean.AlumnoBean;
import Bean.HorarioBean;
import Factoria.DaoFactory;
import Interfaces.HorarioDao;
import JPA.Curso;
import JPA.Horario;
import JPA.Profesor;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

/**
 *
 * @author Jhonk
 */
public class ManagerHorario {

    private int idhorario;
    private String fechainicio;
    private String fechafin;
    private String horainicio;
    private String horafin;
    private int idprofesor;
    private int idcurso;
    private List<Horario>lista;
    private String mensaje;
    private ArrayList<SelectItem> listaItem;
    public ManagerHorario() {
    }

    public int getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(int idhorario) {
        this.idhorario = idhorario;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
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

    public int getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(int idprofesor) {
        this.idprofesor = idprofesor;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public List<Horario> getLista() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        HorarioDao objHorarioDao=objDaoFactory.getHorarioDao();
        lista= objHorarioDao.lista();
        return lista;
    }

    public void setLista(List<Horario> lista) {
        this.lista = lista;
    }
    
    String i="";
    public void AgregarHorario(ActionEvent e){
        try {
            DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            HorarioDao objHorarioDao=objDaoFactory.getHorarioDao();
            Horario obj=new Horario();
            Profesor pro=new Profesor();
            Curso cur=new Curso();
            obj.setIdhorario(getId());
            obj.setFechainicio(getFechainicio());
            obj.setFechafin(getFechafin());
            obj.setHorainicio(getHorainicio());
            obj.setHorafin(getHorafin());
            pro.setIdprofesor(getIdprofesor());
            obj.setProfesor(pro);
            cur.setIdcurso(getIdcurso());
            obj.setCurso(cur);
            i=objHorarioDao.AgregarHorario(obj);
            this.setMensaje(i);
            setFechainicio("");
            setFechafin("");
            setHorainicio("");
            setHorafin("");
            setIdprofesor(0);
            setIdcurso(0);
            
        } catch (Exception ex) {
        }
    }
    public void CarturarDatos(ActionEvent e){
        int iduser;
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        HorarioDao objHorarioDao=objDaoFactory.getHorarioDao();
        try {
            iduser=Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());
            Horario objho=new Horario();
            objho.setIdhorario(iduser);
            Horario obj=objHorarioDao.CapturarHorario(objho);
            setIdhorario(iduser);
            setFechainicio(obj.getFechainicio());
            setFechafin(obj.getFechafin());
            setHorainicio(obj.getHorainicio());
            setHorafin(obj.getHorafin());
            setIdprofesor(obj.getProfesor().getIdprofesor());
            setIdcurso(obj.getCurso().getIdcurso());
            
        } catch (Exception ex) {
        }
    }
    public void ModificarHorario(ActionEvent e){
        try {
            DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            HorarioDao objHorarioDao=objDaoFactory.getHorarioDao();
            Profesor pro= new Profesor();
            Curso cur=new Curso();
            Horario obj=new Horario();
            obj.setIdhorario(getIdhorario());
            obj.setFechainicio(getFechainicio());
            obj.setFechafin(getFechafin());
            obj.setHorainicio(getHorainicio());
            obj.setHorafin(getHorafin());
            pro.setIdprofesor(getIdprofesor());
            obj.setProfesor(pro);
            cur.setIdcurso(getIdcurso());
            obj.setCurso(cur);
            i=objHorarioDao.ModificarHorario(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }
    public void EliminarHorario(ActionEvent e){
        int iduser=0;
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        HorarioDao objHorarioDao=objDaoFactory.getHorarioDao();
        try {
            iduser=Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());
            Horario obj=new Horario();
            obj.setIdhorario(iduser);
            i=objHorarioDao.EliminarHorario(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }

    private int id;
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getId() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        HorarioDao objHorarioDao=objDaoFactory.getHorarioDao();
        id=objHorarioDao.generarcodigo();
        if(id==0){
            id=1;
        }else{
            id=objHorarioDao.generarcodigo()+1;
        }
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<SelectItem> getListaItem() {
        listaItem=new ArrayList<SelectItem>();
        DaoFactory objDAOFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        HorarioDao objHorarioDao=objDAOFactory.getHorarioDao();
        try {
            for(Horario d:objHorarioDao.lista()){
                listaItem.add(new SelectItem(d.getIdhorario(),d.getFechainicio()));
            }
        } catch (Exception e) {
        }
        return listaItem;
    }

    public void setListaItem(ArrayList<SelectItem> listaItem) {
        this.listaItem = listaItem;
    }
}
