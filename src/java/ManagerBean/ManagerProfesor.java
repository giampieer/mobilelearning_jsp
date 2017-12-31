package ManagerBean;

import Bean.ProfesorBean;
import Dao.MysqlProfesorDao;
import Factoria.DaoFactory;
import Interfaces.ProfesorDAO;
import JPA.Profesor;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.swing.JOptionPane;


/**
 *
 * @author TOSHIBA
 */
public class ManagerProfesor {
    private int idprofesor;
    private String nombre;
    private String apellido;
    private int sexo;
    private int edad;
    private String correo;
    private String usuario;
    private String clave;
    private String mensaje;
    private List<Profesor>lista;
    private ArrayList<SelectItem> listaitem;
    /**
     * Creates a new instance of ManagerProfesor
     */
    
    public ManagerProfesor() {
    }

    public int getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(int idprofesor) {
        this.idprofesor = idprofesor;
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

    public List<Profesor> getLista() throws Exception {
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ProfesorDAO objprofesor=objfaofactory.getProfesor();
        lista=objprofesor.listarprofesor();
        return lista;
    }

    public void setLista(List<Profesor> lista) {
        this.lista = lista;
    }
    
    DaoFactory objfactoria;
    int i=1;
    int valor=0;
    String redireccion;
    
    public String loginprofesor(Profesor obj){
        return redireccion;
    }
    
    public void CargarProfesor(ActionEvent e){
          String  idprofesor;
          DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
          ProfesorDAO objprofesor=objfaofactory.getProfesor();
        
         try {
            idprofesor = e.getComponent().getAttributes().get("idprofesor").toString();
            int idprofesor1=Integer.parseInt(idprofesor);
            Profesor objbean1=new Profesor();
            objbean1.setIdprofesor(idprofesor1);
            Profesor objBean = objprofesor.cargarprofesor(objbean1);
            setIdprofesor(objBean.getIdprofesor());
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
    public void GrabarProfesor(ActionEvent e2){
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ProfesorDAO objprofesor=objfaofactory.getProfesor();
        String i="";
            try {
                Profesor objbean=new Profesor();
                objbean.setIdprofesor(getId());
                objbean.setNombre(getNombre());
                objbean.setApellido(getApellido());
                objbean.setSexo(getSexo());
                objbean.setEdad(getEdad());
                objbean.setCorreo(getCorreo());
                objbean.setUsuario(getUsuario());
                objbean.setClave(getClave());
                i = objprofesor.grabarprofesor(objbean);  
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
    
    public void ModificarProfesor(ActionEvent e2){
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ProfesorDAO objprofesor=objfaofactory.getProfesor();
        String i="";
            try {
                Profesor objbean=new Profesor();
                objbean.setIdprofesor(getIdprofesor());
                objbean.setNombre(getNombre());
                objbean.setApellido(getApellido());
                objbean.setSexo(getSexo());
                objbean.setEdad(getEdad());
                objbean.setCorreo(getCorreo());
                objbean.setUsuario(getUsuario());
                objbean.setClave(getClave());
                i = objprofesor.modificarprofesor(objbean);  
                this.setMensaje(i);
        } catch (Exception ex) {
            ex.printStackTrace();
        }     
    }
    
    public void EliminarProfesor(ActionEvent e){
        String  idprofesor;
        DaoFactory objfaofactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ProfesorDAO objprofesor=objfaofactory.getProfesor();
        
         try {
            idprofesor = e.getComponent().getAttributes().get("idprofesor").toString();
            int idprofesor1=Integer.parseInt(idprofesor);
            Profesor objbean1=new Profesor();
            objbean1.setIdprofesor(idprofesor1);
            String i = objprofesor.eliminarprofesor(objbean1);
            this.setMensaje(i);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private int id;

    public int getId() throws Exception {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ProfesorDAO objProfesorDAO=objDaoFactory.getProfesor();
        id=objProfesorDAO.GenerarCodigo();
        if(id==0){
            id=1;
        }else{
            id=objProfesorDAO.GenerarCodigo()+1;
        }
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<SelectItem> getListaitem() {
        listaitem=new ArrayList<SelectItem>();
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        ProfesorDAO objProfesorDAO=objDaoFactory.getProfesor();
        try {
            for(Profesor obj:objProfesorDAO.listarprofesor()){
                listaitem.add(new SelectItem(obj.getIdprofesor(),obj.getNombre()));
            }
        } catch (Exception e) {
        }
        return listaitem;
    }

    public void setListaitem(ArrayList<SelectItem> listaitem) {
        this.listaitem = listaitem;
    }
        
}
