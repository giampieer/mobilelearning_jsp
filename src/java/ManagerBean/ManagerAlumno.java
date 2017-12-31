/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBean;

import Bean.AlumnoBean;
import Factoria.DaoFactory;
import Interfaces.AlumnoDAO;
import JPA.Alumno;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author TOSHIBA
 */
public class ManagerAlumno {
    private int idalumno;
    private String nombre;
    private String apellido;
    private int sexo;
    private int edad;
    private String correo;
    private String usuario;
    private String clave;
    private String mensaje;
    private List<Alumno>lista;
    private ArrayList<SelectItem> listaItem;
    
    /**
     * Creates a new instance of ManagerAlumno
     */
    public ManagerAlumno() {
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Alumno> getLista() throws Exception {
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AlumnoDAO objalumno=objfaofactory.getAlumno();
        lista=objalumno.listaralumno();
        return lista;
    }

    public void setLista(List<Alumno> lista) {
        this.lista = lista;
    }
    
    public void CargarAlumno(ActionEvent e){
          String  idalumno;
          DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
          AlumnoDAO objalumno=objfaofactory.getAlumno();
        
         try {
            idalumno = e.getComponent().getAttributes().get("idalumno").toString();
            int idalumno1=Integer.parseInt(idalumno);
            Alumno objbean1=new Alumno();
            objbean1.setIdalumno(idalumno1);
            Alumno objBean = objalumno.cargaralumno(objbean1);
            setIdalumno(objBean.getIdalumno());
            setNombre(objBean.getNombre());
            setApellido(objBean.getApellido());
            setSexo(objBean.getSexo());
            setEdad(objBean.getEdad());
            setCorreo(objBean.getCorreo());
            setUsuario(objBean.getUsuario());
            setClave(objBean.getClave());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void GrabarAlumno(ActionEvent e2){
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AlumnoDAO objalumno=objfaofactory.getAlumno();
            try {
                Alumno objbean=new Alumno();
                objbean.setIdalumno(getId());
                objbean.setNombre(getNombre());
                objbean.setApellido(getApellido());
                objbean.setSexo(getSexo());
                objbean.setEdad(getEdad());
                objbean.setCorreo(getCorreo());
                objbean.setUsuario(getUsuario());
                objbean.setClave(getClave());
                String i = objalumno.grabaralumno(objbean);  
                this.setMensaje(i);
                setNombre("");
                setApellido("");
                setSexo(0);
                setEdad(0);
                setCorreo("");
                setUsuario("");
                setClave("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }    
    }
    public void ModificarAlumno(ActionEvent e2){
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AlumnoDAO objalumno=objfaofactory.getAlumno();
        String i="";
            try {
                Alumno objbean=new Alumno();
                objbean.setIdalumno(getIdalumno());
                objbean.setNombre(getNombre());
                objbean.setApellido(getApellido());
                objbean.setSexo(getSexo());
                objbean.setEdad(getEdad());
                objbean.setCorreo(getCorreo());
                objbean.setUsuario(getUsuario());
                objbean.setClave(getClave());
                i = objalumno.modificaralumno(objbean);  
                this.setMensaje(i);
        } catch (Exception ex) {
            ex.printStackTrace();
        }     
    }
    
    public void EliminarAlumno(ActionEvent e){
        String  idalumno;
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AlumnoDAO objalumno=objfaofactory.getAlumno();
        
         try {
            idalumno = e.getComponent().getAttributes().get("idalumno").toString();
            int idalumno1=Integer.parseInt(idalumno);
            Alumno objbean1=new Alumno();
            objbean1.setIdalumno(idalumno1);
            String i = objalumno.eliminaralumno(objbean1);
            this.setMensaje(i);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private int id;

    public int getId() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AlumnoDAO objAlumnoDAO=objDaoFactory.getAlumno();
        id=objAlumnoDAO.GenerarCodigo();
        if(id==0){
            id=1;
        }else{
            id=objAlumnoDAO.GenerarCodigo()+1;
        }
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<SelectItem> getListaItem() {
        listaItem=new ArrayList<SelectItem>();
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AlumnoDAO objAlumnoDAO=objDaoFactory.getAlumno();
        try {
            for(Alumno obj:objAlumnoDAO.listaralumno()){
                listaItem.add(new SelectItem(obj.getIdalumno(),obj.getNombre()));
            }
        } catch (Exception e) {
        }
        return listaItem;
    }

    public void setListaItem(ArrayList<SelectItem> listaItem) {
        this.listaItem = listaItem;
    }
}
