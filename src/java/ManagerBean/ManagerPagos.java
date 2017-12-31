/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBean;

import Factoria.DaoFactory;
import Interfaces.PagoDao;
import JPA.Libro;
import JPA.Pagos;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author Autonoma
 */
public class ManagerPagos {

    private int idpago;
    private String nombre;
    private double monto;
    private String tipomoneda;
    private List<Pagos> lista;
    private int id;
    private String mensaje;
    private ArrayList<SelectItem> listaitem;
    public ManagerPagos() {
    }

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipomoneda() {
        return tipomoneda;
    }

    public void setTipomoneda(String tipomoneda) {
        this.tipomoneda = tipomoneda;
    }

    public List<Pagos> getLista() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        PagoDao objPagoDao=objDaoFactory.getPagos();
        lista=objPagoDao.lista();
        return lista;
    }

    public void setLista(List<Pagos> lista) {
        this.lista = lista;
    }

    public int getId() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        PagoDao obPagoDao=objDaoFactory.getPagos();
        id=obPagoDao.GenerarCodigo();
        if(id==0){
            id=1;
        }else{
            id=obPagoDao.GenerarCodigo()+1;
        }
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public void AgregarDatos(ActionEvent e){
        String i="";
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        PagoDao objPagoDao=objDaoFactory.getPagos();
        try {
            Pagos obj=new Pagos();
            obj.setIdPagos(getId());
            obj.setNombrepago(getNombre());
            obj.setMonto(getMonto());
            obj.setTipomoneda(getTipomoneda());
            i=objPagoDao.GrabarPago(obj);
            this.setMensaje(i);
            setNombre("");
            setMonto(0);
            setTipomoneda("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void CapturarCodigo(ActionEvent e){
        int idad;
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        PagoDao objPagoDao=objDaoFactory.getPagos();
        try {
            idad=Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());
            Pagos obj=new Pagos();
            obj.setIdPagos(idad);
            Pagos objact=objPagoDao.CapturarPago(obj);
            setIdpago(objact.getIdPagos());
            setNombre(objact.getNombrepago());
            setMonto(objact.getMonto());
            setTipomoneda(objact.getTipomoneda());
        } catch (Exception ex) {
        }
    }
    public void ModificarActividad(ActionEvent e){
        String i="";
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        PagoDao objPagoDao=objDaoFactory.getPagos();
        try {
            Pagos obj=new Pagos();
            obj.setIdPagos(getIdpago());
            obj.setNombrepago(getNombre());
            obj.setMonto(getMonto());
            obj.setTipomoneda(getTipomoneda());
            i=objPagoDao.ModificarPago(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }
    
    public void EliminarActividad(ActionEvent e){
        String i="";
        int idad;
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        PagoDao objPagoDao=objDaoFactory.getPagos();
        try {
            idad=Integer.parseInt(e.getComponent().getAttributes().get("iduser").toString());
            Pagos obj=new Pagos();
            obj.setIdPagos(idad);
            i=objPagoDao.EliminarPago(obj);
            this.setMensaje(i);
        } catch (Exception ex) {
        }
    }

    public ArrayList<SelectItem> getListaitem() {
        listaitem=new ArrayList<SelectItem>();
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        PagoDao objPagoDao=objDaoFactory.getPagos();
        try {
            for(Pagos obj:objPagoDao.lista()){
                listaitem.add(new SelectItem(obj.getIdPagos(),obj.getNombrepago()));
            }
        } catch (Exception e) {
        }
        return listaitem;
    }

    public void setListaitem(ArrayList<SelectItem> listaitem) {
        this.listaitem = listaitem;
    }
    
}
