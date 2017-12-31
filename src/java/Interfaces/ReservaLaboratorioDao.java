/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import JPA.Reservalaboratorio;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public interface ReservaLaboratorioDao {
    public List<Reservalaboratorio> lista()throws Exception;
    public String AgregarReservaLaboratorio(Reservalaboratorio obj)throws Exception;
    public String ModificarReservaLaboratorio(Reservalaboratorio obj)throws Exception;
    public String EliminarReservaLaboratorio(Reservalaboratorio obj)throws Exception;
    public Reservalaboratorio CapturarReservaLaboratorio(Reservalaboratorio obj)throws Exception;
    public int GenerarCodigo()throws Exception;
    
}
