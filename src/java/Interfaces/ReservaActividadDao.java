/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import JPA.Reservaactividad;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public interface ReservaActividadDao {
    public List<Reservaactividad> lista()throws Exception;
    public String AgregarReservaActividad(Reservaactividad obj)throws Exception;
    public String ModificarReservaActividad(Reservaactividad obj)throws Exception;
    public String EliminarReservaActividad(Reservaactividad obj)throws Exception;
    public Reservaactividad CapturarReservaActividad(Reservaactividad obj)throws Exception;
    public int GenerarCodigo()throws Exception;
    
}
