/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Bean.MatriiculaBean;
import JPA.Matricula;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhonk
 */
public interface MatriculaDao {
    public List<Matricula> listaMtri()throws Exception;
    public String AgregarMatri(Matricula obj)throws Exception;
    public Matricula CapturarMatri(Matricula obj)throws Exception;
    public String ModificarMatri(Matricula obj)throws Exception;
    public String EliminarMatri(Matricula obj)throws Exception;
    public int GenerarCodigo()throws Exception;

}
