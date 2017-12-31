/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBean;

import Factoria.DaoFactory;
import Interfaces.AdministradorDao;
import Interfaces.AlumnoDAO;
import Interfaces.ProfesorDAO;
import JPA.Administrador;
import JPA.Alumno;
import JPA.Profesor;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhonk
 */
public class ManagerLoginUsuario {

    private int tipousuario;
    private String usuario;
    private String clave;
    private String mensaje;
    private int cod;

    public ManagerLoginUsuario() {
    }

    String redireccion;

    public String LoginAcceso(ManagerLoginUsuario objbean) {
        try {
            DaoFactory objDaoFactoria = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            AdministradorDao objDao = objDaoFactoria.getAdministradorDao();
            AlumnoDAO objAlumnoDAO = objDaoFactoria.getAlumno();
            ProfesorDAO objProfesorDAO = objDaoFactoria.getProfesor();
            Administrador ad = new Administrador();
            Alumno al = new Alumno();
            Profesor pro = new Profesor();
            int i = 0;
            if (tipousuario == 1) {
                ad.setUsuario(usuario);
                ad.setClave(clave);
                i = objDao.LoginAdmin(ad);
                if (i == 1) {
                    Administrador dat=objDao.DatosAdmin(ad);
                    redireccion = "PRINCIPALADMINISTRADOR";
                    setMensaje("Bienvenido Administrador");
                    int id=dat.getIdadministrador();
                    this.setCod(id);
                } else {
                    redireccion = "LOGIN";
                    setMensaje("Datos Incorrectos,PRUEBE OTRA VEZ");
                }
            } else if (tipousuario == 2) {
                pro.setUsuario(usuario);
                pro.setClave(clave);
                i = objProfesorDAO.loginprofesor(pro);
                if (i == 1) {
                    redireccion = "PRINCIPALPROFESOR";
                    setMensaje("Bienvenido Profesor");
                } else {
                    redireccion = "LOGIN";
                    setMensaje("Datos Incorrectos,PRUEBE OTRA VEZ");
                }
            } else if (tipousuario == 3) {
                al.setUsuario(usuario);
                al.setClave(clave);
                i = objAlumnoDAO.loginalumno(al);
                if (i == 1) {
                    redireccion = "PRINCIPALALUMNO";
                    setMensaje("Bienvenido Alumno");
                } else {
                    redireccion = "LOGIN";
                    setMensaje("Datos Incorrectos,PRUEBE OTRA VEZ");
                }
            }
        } catch (Exception ex) {
        }
        return redireccion;
    }

    public int getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(int tipousuario) {
        this.tipousuario = tipousuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

}
