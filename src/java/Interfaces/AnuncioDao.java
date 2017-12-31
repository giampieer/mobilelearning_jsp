/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import JPA.Anuncios;
import java.util.List;

/**
 *
 * @author Jhonk
 */
public interface AnuncioDao {
    public List<Anuncios> lista()throws Exception;
    public String GrabarAnuncio(Anuncios obj)throws Exception;
    public String ModificarAnuncio(Anuncios obj)throws Exception;
    public String EliminarAnuncio(Anuncios obj)throws Exception;
    public Anuncios CapturarAnuncio(Anuncios obj)throws Exception;
    public int GenerarCodigo()throws Exception;
}
