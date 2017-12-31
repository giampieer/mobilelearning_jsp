/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import JPA.Actividad;
import java.util.List;

/**
 *
 * @author autonoma
 */
public interface ActividadDao {
    public List<Actividad> lista()throws Exception;
    public String AgregarActividad(Actividad obj)throws Exception;
    public String ModificarActividad(Actividad obj)throws Exception;
    public String EliminarActividad(Actividad obj)throws Exception;
    public Actividad CapturarActividad(Actividad obj)throws Exception;
    public int GenerarCodigo()throws Exception;
}
