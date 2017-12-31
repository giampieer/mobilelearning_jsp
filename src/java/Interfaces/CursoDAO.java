/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Bean.CursoBean;
import JPA.Curso;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public interface CursoDAO {
    public String grabarcurso(Curso obj)throws Exception;
    public String eliminarcurso(Curso obj)throws Exception;
    public String modificarcurso(Curso obj)throws Exception;
    public List<Curso>listarcurso()throws Exception;
    public Curso cargarcurso(Curso obj)throws Exception;
    public int GenerarCodigo()throws Exception;
    
}
