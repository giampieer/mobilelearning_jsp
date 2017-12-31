/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBean;

import Bean.AsistenciaBean;
import Factoria.DaoFactory;
import Interfaces.AsistenciaDAO;
import JPA.Asistencia;
import JPA.Curso;
import JPA.Matricula;
import JPA.MatriculaHasCurso;
import JPA.MatriculaHasCursoPK;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;

/**
 *
 * @author TOSHIBA
 */
public class ManagerAsistencia {
    private int idasistencia;
    private String asistencia;
    private int matricula_idmatricula;
    private int curso_idcurso;
    private String mensaje;
    private List<Asistencia>lista;
    
    /**
     * Creates a new instance of ManagerAsistencia
     */
    public ManagerAsistencia() {
    }

    public int getIdasistencia() {
        return idasistencia;
    }

    public void setIdasistencia(int idasistencia) {
        this.idasistencia = idasistencia;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    public int getMatricula_idmatricula() {
        return matricula_idmatricula;
    }

    public void setMatricula_idmatricula(int matricula_idmatricula) {
        this.matricula_idmatricula = matricula_idmatricula;
    }

    public int getCurso_idcurso() {
        return curso_idcurso;
    }

    public void setCurso_idcurso(int curso_idcurso) {
        this.curso_idcurso = curso_idcurso;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Asistencia> getLista() throws Exception {
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AsistenciaDAO objasistencia=objfaofactory.getAsistencia();
        lista=objasistencia.listarasistencia();
        return lista;
    }

    public void setLista(List<Asistencia> lista) {
        this.lista = lista;
    }
    
    public void CargarAsistencia(ActionEvent e){
          String  idasistencia;
          DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
          AsistenciaDAO objasistencia=objfaofactory.getAsistencia();
        
         try {
            idasistencia = e.getComponent().getAttributes().get("idasistencia").toString();
            int idasistencia1=Integer.parseInt(idasistencia);
            Asistencia objbean1=new Asistencia();
            objbean1.setIdasistencia(idasistencia1);
            Asistencia objBean = objasistencia.cargarasistencia(objbean1);
            setIdasistencia(objBean.getIdasistencia());
            setAsistencia(objBean.getAsistencia());
            setMatricula_idmatricula(objBean.getMatriculaHasCurso().getMatriculaHasCursoPK().getMatriculaIdmatricula());
            setCurso_idcurso(objBean.getMatriculaHasCurso().getMatriculaHasCursoPK().getCursoIdcurso());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void GrabarAsistencia(ActionEvent e2){
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AsistenciaDAO objasistencia=objfaofactory.getAsistencia();
        String i="";
            try {
                Asistencia objbean=new Asistencia();
                MatriculaHasCurso matricur=new MatriculaHasCurso();
                MatriculaHasCursoPK matricurPK=new MatriculaHasCursoPK();
                objbean.setIdasistencia(getId());
                objbean.setAsistencia(getAsistencia());
                matricurPK.setMatriculaIdmatricula(getMatricula_idmatricula());
                matricurPK.setCursoIdcurso(getCurso_idcurso());
                matricur.setMatriculaHasCursoPK(matricurPK);
                objbean.setMatriculaHasCurso(matricur);
                i = objasistencia.grabarasistencia(objbean);
                this.setMensaje(i);
                setAsistencia("");
                setCurso_idcurso(0);
                setMatricula_idmatricula(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }    
    }
    public void ModificarAsistencia(ActionEvent e2){
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AsistenciaDAO objasistencia=objfaofactory.getAsistencia();
        String i="";
            try {
                Asistencia objbean=new Asistencia();
                MatriculaHasCurso matricur=new MatriculaHasCurso();
                MatriculaHasCursoPK matricurFK=new MatriculaHasCursoPK();
                objbean.setIdasistencia(getIdasistencia());
                objbean.setAsistencia(getAsistencia());
                matricurFK.setMatriculaIdmatricula(getMatricula_idmatricula());
                matricurFK.setCursoIdcurso(getCurso_idcurso());
                matricur.setMatriculaHasCursoPK(matricurFK);
                objbean.setMatriculaHasCurso(matricur);
                i = objasistencia.modificarasistencia(objbean);
                this.setMensaje(i);
        } catch (Exception ex) {
            ex.printStackTrace();
        }     
    }
    public void EliminarAsistencia(ActionEvent e){
        String  idasistencia;
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AsistenciaDAO objasistencia=objfaofactory.getAsistencia();
        
         try {
            idasistencia = e.getComponent().getAttributes().get("idasistencia").toString();
            int idasistencia1=Integer.parseInt(idasistencia);
            Asistencia objbean1=new Asistencia();
            objbean1.setIdasistencia(idasistencia1);
            String i = objasistencia.eliminarasistencia(objbean1);  
            this.setMensaje(i);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private int id;

    public int getId() throws Exception {
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AsistenciaDAO objasistencia=objfaofactory.getAsistencia();
        id=objasistencia.GenerarCodigo();
        if(id==0){
            id=1;
        }else{
            id=objasistencia.GenerarCodigo()+1;
        }
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
