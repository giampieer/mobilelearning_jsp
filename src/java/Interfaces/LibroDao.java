/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import JPA.Libro;
import java.util.List;

/**
 *
 * @author autonoma
 */
public interface LibroDao{
    public List<Libro> lista()throws Exception;
    public String AgregarLibro(Libro obj)throws Exception;
    public String ModificarLibro(Libro obj)throws Exception;
    public String EliminarLibro(Libro obj)throws Exception;
    public Libro CapturarLibro(Libro obj)throws Exception;
    public int GenerarCodigo()throws Exception;
}
