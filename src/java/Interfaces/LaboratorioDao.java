/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import JPA.Laboratorio;
import java.util.List;

/**
 *
 * @author autonoma
 */
public interface LaboratorioDao {
    public List<Laboratorio> lista()throws Exception;
    public String AgregarLaboratorio(Laboratorio obj)throws Exception;
    public String ModificarLaboratorio(Laboratorio obj)throws Exception;
    public String EliminarLaboratorio(Laboratorio obj)throws Exception;
    public Laboratorio CapturarLaboratorio(Laboratorio obj)throws Exception;
    public int GenerarCodigo()throws Exception;
}
