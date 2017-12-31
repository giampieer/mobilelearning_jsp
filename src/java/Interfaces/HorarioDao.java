/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Bean.HorarioBean;
import JPA.Horario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhonk
 */
public interface HorarioDao {
    public List<Horario>lista()throws Exception;
    public String AgregarHorario(Horario obj)throws Exception;
    public Horario CapturarHorario(Horario obj)throws Exception;
    public String ModificarHorario(Horario obj)throws Exception;
    public String EliminarHorario(Horario obj)throws Exception;
    public int generarcodigo()throws Exception;
}
