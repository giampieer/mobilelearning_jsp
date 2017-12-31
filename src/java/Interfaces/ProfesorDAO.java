/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import JPA.Profesor;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public interface ProfesorDAO {
    public int loginprofesor(Profesor obj)throws Exception;
    public String grabarprofesor(Profesor obj)throws Exception;
    public String eliminarprofesor(Profesor obj)throws Exception;
    public String modificarprofesor(Profesor obj)throws Exception;
    public List<Profesor>listarprofesor()throws Exception;
    public Profesor cargarprofesor(Profesor obj)throws Exception;
    public int GenerarCodigo()throws Exception;
}
