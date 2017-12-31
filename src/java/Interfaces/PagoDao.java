/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import JPA.Pagos;
import java.util.List;

/**
 *
 * @author Autonoma
 */
public interface PagoDao {
    public List<Pagos> lista()throws Exception;
    public String GrabarPago(Pagos obj)throws Exception;
    public String ModificarPago(Pagos obj)throws Exception;
    public String EliminarPago(Pagos obj)throws Exception;
    public Pagos CapturarPago(Pagos obj)throws Exception;
    public int GenerarCodigo()throws Exception;
}
