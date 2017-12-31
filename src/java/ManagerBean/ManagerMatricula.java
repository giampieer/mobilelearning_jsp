/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBean;

import Bean.AlumnoBean;
import Bean.MatriiculaBean;
import Factoria.DaoFactory;
import Interfaces.MatriculaDao;
import JPA.Administrador;
import JPA.Alumno;
import JPA.Horario;
import JPA.Matricula;
import JPA.Pagos;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhonk
 */
public class ManagerMatricula {

    private int idmatricula;
    private String ciclo;
    private String seccion;
    private int idadministrador;
    private int idalumno;
    private int idpago;
    private String mensaje;
    private ArrayList<SelectItem> listaitem;
    private List<Matricula> lista;
    private int cod;

    public ManagerMatricula() {
    }

    public List<Matricula> getLista() throws Exception {
        DaoFactory objDaoFactoria = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        MatriculaDao objMatriculaDao = objDaoFactoria.getMatriculaDao();
        lista = objMatriculaDao.listaMtri();
        return lista;
    }

    public void setLista(List<Matricula> lista) {
        this.lista = lista;
    }

    public int getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(int idmatricula) {
        this.idmatricula = idmatricula;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public int getIdadministrador() {
        return idadministrador;
    }

    public void setIdadministrador(int idadministrador) {
        this.idadministrador = idadministrador;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public void Codigo(ActionEvent e) {
        int iduser;
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            Map params = facesContext.getExternalContext().getRequestParameterMap();
            iduser = new Integer((String) params.get("iduser"));
            this.setCod(iduser);
        } catch (Exception ex) {
        }
    }
    String i = "";

    public void AgregarMatricula(ActionEvent e) {
        int iduser;
        DaoFactory objDaoFactoria = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        MatriculaDao objMatriculaDao = objDaoFactoria.getMatriculaDao();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map params = facesContext.getExternalContext().getRequestParameterMap();
        try {
            iduser = new Integer((String) params.get("iduser"));
            Administrador admin = new Administrador();
            this.setCod(iduser);

            Alumno alum = new Alumno();
            Pagos pagos = new Pagos();
            Matricula obj = new Matricula();
            obj.setIdmatricula(getId());
            obj.setCiclo(getCiclo());
            obj.setSeccion(getSeccion());
            admin.setIdadministrador(getCod());
            obj.setAdministrador(admin);
            alum.setIdalumno(getIdalumno());
            obj.setAlumno(alum);
            pagos.setIdPagos(getIdpago());
            obj.setPagos(pagos);
            i = objMatriculaDao.AgregarMatri(obj);
            this.setMensaje(i);
            setCiclo("");
            setSeccion("");
            setIdalumno(0);
            setIdpago(0);

        } catch (Exception ex) {
        }
    }

    public void CapturarMatricula(ActionEvent e) {
        int idusers;
        int codadmin;
        DaoFactory objDaoFactoria = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        MatriculaDao objMatriculaDao = objDaoFactoria.getMatriculaDao();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map params = facesContext.getExternalContext().getRequestParameterMap();
        try {
            codadmin = new Integer((String) params.get("idadmin"));
            idusers = Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());
            Matricula matri = new Matricula();
            matri.setIdmatricula(idusers);
            Matricula obj = objMatriculaDao.CapturarMatri(matri);
            setIdmatricula(obj.getIdmatricula());
            setCiclo(obj.getCiclo());
            setSeccion(obj.getSeccion());
            setIdadministrador(codadmin);
            setIdalumno(obj.getAlumno().getIdalumno());
            setIdpago(obj.getPagos().getIdPagos());
        } catch (Exception ex) {
        }
    }

    public void ModificarMatricula(ActionEvent e) {
        int idadmin;
        DaoFactory objDaoFactoria = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        MatriculaDao objMatriculaDao = objDaoFactoria.getMatriculaDao();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map params = facesContext.getExternalContext().getRequestParameterMap();
        try {
            idadmin = new Integer((String) params.get("idadmin"));
            this.setCod(idadmin);

            Administrador admin = new Administrador();
            Alumno alum = new Alumno();
            Pagos pagos = new Pagos();
            Matricula obj = new Matricula();
            obj.setIdmatricula(getIdmatricula());
            obj.setCiclo(getCiclo());
            obj.setSeccion(getSeccion());
            admin.setIdadministrador(getIdadministrador());
            obj.setAdministrador(admin);
            alum.setIdalumno(getIdalumno());
            obj.setAlumno(alum);
            pagos.setIdPagos(getIdpago());
            obj.setPagos(pagos);
            i = objMatriculaDao.ModificarMatri(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }

    public void EliminarMatricula(ActionEvent e) {
        int idusers;
        int idadmin;
        DaoFactory objDaoFactoria = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        MatriculaDao objMatriculaDao = objDaoFactoria.getMatriculaDao();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map params = facesContext.getExternalContext().getRequestParameterMap();
        try {
            idadmin = new Integer((String) params.get("idadmin"));
            this.setCod(idadmin);

            idusers = Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());
            Matricula obj = new Matricula();
            obj.setIdmatricula(idusers);
            i = objMatriculaDao.EliminarMatri(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    private int id;

    public int getId() throws Exception {
        DaoFactory objDaoFactoria = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        MatriculaDao objMatriculaDao = objDaoFactoria.getMatriculaDao();
        id = objMatriculaDao.GenerarCodigo();
        if (id == 0) {
            id = 1;
        } else {
            id = objMatriculaDao.GenerarCodigo() + 1;
        }
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<SelectItem> getListaitem() {
        listaitem = new ArrayList<SelectItem>();
        DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        MatriculaDao objMatriculaDao = objDaoFactory.getMatriculaDao();
        try {
            for (Matricula obj : objMatriculaDao.listaMtri()) {
                listaitem.add(new SelectItem(obj.getIdmatricula(), obj.getAlumno().getApellido()));
            }
        } catch (Exception e) {
        }
        return listaitem;
    }

    public void setListaitem(ArrayList<SelectItem> listaitem) {
        this.listaitem = listaitem;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
