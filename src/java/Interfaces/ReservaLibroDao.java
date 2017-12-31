/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import JPA.Reservalibro;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public interface ReservaLibroDao {
    public List<Reservalibro> lista()throws Exception;
    public String AgregarReservaLibro(Reservalibro obj)throws Exception;
    public String ModificarReservaLibro(Reservalibro obj)throws Exception;
    public String EliminarReservaLibro(Reservalibro obj)throws Exception;
    public Reservalibro CapturarReservaLibro(Reservalibro obj)throws Exception;
    public int GenerarCodigo()throws Exception;
    
}
