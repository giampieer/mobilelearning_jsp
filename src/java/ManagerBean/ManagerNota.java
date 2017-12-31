/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBean;

import Bean.NotaBean;
import Factoria.DaoFactory;
import Interfaces.NotaDAO;
import JPA.MatriculaHasCurso;
import JPA.MatriculaHasCursoPK;
import JPA.Notas;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;

/**
 *
 * @author TOSHIBA
 */
public class ManagerNota {
    private int idnota;
    private double nota;
    private String tipnota;
    private int matricula_idmatricula;
    private int curso_idcurso;
    private String mensaje;
    private List<Notas>lista;
    
    /**
     * Creates a new instance of ManagerNota
     */
    public ManagerNota() {
    }

    public int getIdnota() {
        return idnota;
    }

    public void setIdnota(int idnota) {
        this.idnota = idnota;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getTipnota() {
        return tipnota;
    }

    public void setTipnota(String tipnota) {
        this.tipnota = tipnota;
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

    public List<Notas> getLista() throws Exception {
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        NotaDAO objnota=objfaofactory.getNota();
        lista=objnota.listarnota();
        return lista;
    }

    public void setLista(List<Notas> lista) {
        this.lista = lista;
    }
    
    public void CargarNota(ActionEvent e){
          int  idnotal;
          DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
          NotaDAO objnota=objfaofactory.getNota();
        
         try {
            idnotal = Integer.parseInt(e.getComponent().getAttributes().get("idnotas").toString());
            Notas objbeanl=new Notas();
            objbeanl.setIdnotas(idnotal);
            Notas objBean = objnota.cargarnota(objbeanl);
            setIdnota(objBean.getIdnotas());
            setNota(objBean.getNota());
            setTipnota(objBean.getTiponota());
            setMatricula_idmatricula(objBean.getMatriculaHasCurso().getMatriculaHasCursoPK().getMatriculaIdmatricula());
            setCurso_idcurso(objBean.getMatriculaHasCurso().getMatriculaHasCursoPK().getCursoIdcurso());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void GrabarNota(ActionEvent e2){
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        NotaDAO objnota=objfaofactory.getNota();
        String i="";
            try {
                Notas objbean=new Notas();
                MatriculaHasCurso matricur=new MatriculaHasCurso();
                MatriculaHasCursoPK matricurPK=new MatriculaHasCursoPK();
                objbean.setIdnotas(getId());
                objbean.setNota(getNota());
                objbean.setTiponota(getTipnota());
                matricurPK.setMatriculaIdmatricula(getMatricula_idmatricula());
                matricurPK.setCursoIdcurso(getCurso_idcurso());
                matricur.setMatriculaHasCursoPK(matricurPK);
                objbean.setMatriculaHasCurso(matricur);
                i = objnota.grabarnota(objbean);
                this.setMensaje(i);
                setNota(0);
                setTipnota("");
                setMatricula_idmatricula(0);
                setCurso_idcurso(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }    
    }
    public void ModificarNota(ActionEvent e2){
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        NotaDAO objnota=objfaofactory.getNota();
        String i="";
            try {
                Notas objbean=new Notas();
                MatriculaHasCurso matricur=new MatriculaHasCurso();
                MatriculaHasCursoPK matricurPK=new MatriculaHasCursoPK();
                objbean.setIdnotas(getIdnota());
                objbean.setNota(getNota());
                objbean.setTiponota(getTipnota());
                matricurPK.setMatriculaIdmatricula(getMatricula_idmatricula());
                matricurPK.setCursoIdcurso(getCurso_idcurso());
                matricur.setMatriculaHasCursoPK(matricurPK);
                objbean.setMatriculaHasCurso(matricur);
                i = objnota.modificarnota(objbean);
                this.setMensaje(i);
        } catch (Exception ex) {
            ex.printStackTrace();
        }     
    }
    public void EliminarNota(ActionEvent e){
        String  idnota;
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        NotaDAO objnota=objfaofactory.getNota();
        
         try {
            idnota =e.getComponent().getAttributes().get("idnotas").toString();
            int idnotass=Integer.parseInt(idnota);
            Notas objbean1=new Notas();
            objbean1.setIdnotas(idnotass);
            String i = objnota.eliminarnota(objbean1);
            this.setMensaje(i);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private int id;

    public int getId() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        NotaDAO objNotaDAO=objDaoFactory.getNota();
        id=objNotaDAO.GenerarCodigo();
        if(id==0){
            id=1;
        }else{
            id=objNotaDAO.GenerarCodigo()+1;
        }
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
