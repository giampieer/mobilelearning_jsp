/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import JPA.Asistencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public interface AsistenciaDAO {
    public String grabarasistencia(Asistencia obj)throws Exception;
    public String eliminarasistencia(Asistencia obj)throws Exception;
    public String modificarasistencia(Asistencia obj)throws Exception;
    public List<Asistencia>listarasistencia()throws Exception;
    public Asistencia cargarasistencia(Asistencia obj)throws Exception;
    public int GenerarCodigo()throws Exception;
}
