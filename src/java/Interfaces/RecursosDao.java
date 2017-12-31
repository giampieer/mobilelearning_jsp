/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import JPA.Recursos;
import java.util.List;

/**
 *
 * @author Autonoma
 */
public interface RecursosDao {
    public List<Recursos> lista()throws Exception;
    public String GrabarRecurso(Recursos obj)throws Exception;
    public String ModificarRecurso(Recursos obj)throws Exception;
    public String EliminarRecurso(Recursos obj)throws Exception;
    public Recursos CapturarRecurso(Recursos obj)throws Exception;
    public int GenerarCodigo()throws Exception;
}
