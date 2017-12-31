/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Bean.AlumnoBean;
import JPA.Alumno;
import JPA.Profesor;
import ManagerBean.ManagerProfesor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public interface AlumnoDAO {
    public int loginalumno(Alumno obj)throws Exception;
    public String grabaralumno(Alumno obj)throws Exception;
    public String eliminaralumno(Alumno obj)throws Exception;
    public String modificaralumno(Alumno obj)throws Exception;
    public List<Alumno>listaralumno()throws Exception;
    public Alumno cargaralumno(Alumno obj)throws Exception;
    public int GenerarCodigo()throws Exception;
    
}
