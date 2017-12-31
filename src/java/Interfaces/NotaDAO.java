/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Bean.NotaBean;
import JPA.Notas;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public interface NotaDAO {
    public String grabarnota(Notas obj)throws Exception;
    public String eliminarnota(Notas obj)throws Exception;
    public String modificarnota(Notas obj)throws Exception;
    public List<Notas>listarnota()throws Exception;
    public Notas cargarnota(Notas obj)throws Exception;
    public int GenerarCodigo()throws Exception;
}
