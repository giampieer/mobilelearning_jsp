/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.AdministradorBean;
import Dao.MysqlAdministradorDao;
import Factoria.DaoFactory;
import Interfaces.AdministradorDao;
import JPA.Administrador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author TOSHIBA
 */
public class AdministradorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        HttpSession respuesta=request.getSession();
        response.setContentType("application/json");
        StringBuilder json=null;
        String opcad=request.getParameter("op");
        int op=Integer.parseInt(opcad);
        String nom,ape,sex,eda,cor,id,pass,codi;
        int cod;
        String pagina = "";
        MysqlAdministradorDao objAdministradorDAO = null;
        AdministradorBean  objAdministradorBean = null;
        switch(op)
        {
        //Login json
        case 1:{
            DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            AdministradorDao objAdministradorDao = objDaoFactory.getAdministradorDao();
            PrintWriter out=response.getWriter();
            Administrador objAdministrador = null;
            Administrador dato=null;
            try {
                String usu=request.getParameter("usuario");
                String clave=request.getParameter("clave");
                objAdministrador=new Administrador();
                objAdministrador.setUsuario(usu);
                objAdministrador.setClave(clave);
                int i=objAdministradorDao.LoginAdmin(objAdministrador);
                dato=objAdministradorDao.DatosAdmin(objAdministrador);
                json=new StringBuilder();
                json.append("[{\"estado\":\""+i+"\",\"cod\":\""+dato.getIdadministrador()+"\", \"Nombre\":\""+dato.getNombre()+"\"}]");
                //json.append("[{\"cod\":\""+dato.getIdadministrador()+"\", \"Nombre\":\""+dato.getNombre()+"\"}]");
                out.print(json.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
           }
        case 2:{
            DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            AdministradorDao objAdministradorDao=objDaoFactory.getAdministradorDao();
            PrintWriter out=response.getWriter();
            List<Administrador> lista= null;
            try {
                lista=objAdministradorDao.lista();
                json=new StringBuilder();
                json.append(lista.toString());
                out.print(json.toString());
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
      
        }
        case 3://GRABAR ADMINISTRADOR
        {
            DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            AdministradorDao objAdministradorDao = objDaoFactory.getAdministradorDao();
            PrintWriter out=response.getWriter();
            cod = Integer.parseInt(request.getParameter("txtcod"));
            nom = request.getParameter("txtnom");
            ape = request.getParameter("txtape");
            sex = request.getParameter("txtsex");
            eda = request.getParameter("txteda");
            cor = request.getParameter("txtcor");
            id=request.getParameter("txtid");
            pass=request.getParameter("txtpass");
            
            try {
                Administrador obj=new Administrador();
                obj.setIdadministrador(cod);
                obj.setNombre(nom);
                obj.setApellido(ape);
                obj.setSexo(Integer.parseInt(sex));
                obj.setEdad(Integer.parseInt(eda));
                obj.setCorreo(cor);
                obj.setUsuario(id);
                obj.setClave(pass);
                String i=objAdministradorDao.AgregarAdmin(obj);
                json=new StringBuilder();
                json.append("[{\"estado\":\""+i+"\"}]");
                out.print(json.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }break;
        }
        case 4://MODIFICAR ADMINISTRADOR
        {
            DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            AdministradorDao objAdministradorDao = objDaoFactory.getAdministradorDao();
            PrintWriter out=response.getWriter();
            cod = Integer.parseInt(request.getParameter("txtcod"));
            nom = request.getParameter("txtnom");
            ape = request.getParameter("txtape");
            sex = request.getParameter("txtsex");
            eda = request.getParameter("txteda");
            cor = request.getParameter("txtcor");
            id=request.getParameter("txtid");
            pass=request.getParameter("txtpass");
            
            try {
                Administrador obj=new Administrador();
                obj.setIdadministrador(cod);
                obj.setNombre(nom);
                obj.setApellido(ape);
                obj.setSexo(Integer.parseInt(sex));
                obj.setEdad(Integer.parseInt(eda));
                obj.setCorreo(cor);
                obj.setUsuario(id);
                obj.setClave(pass);
                String i=objAdministradorDao.ModificarAdmin(obj);
                json=new StringBuilder();
                json.append("[{\"estado\":\""+i+"\"}]");
                out.print(json.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }break;
        }
        case 5://Eliminar
        {
            DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            AdministradorDao objAdministradorDao = objDaoFactory.getAdministradorDao();
            PrintWriter out=response.getWriter();
            int ide=Integer.parseInt(request.getParameter("cod"));
            try {
                Administrador obj=new Administrador();
                obj.setIdadministrador(ide);
                String i=objAdministradorDao.EliminarAdmin(obj);
                json=new StringBuilder();
                json.append("[{\"estado\":\""+i+"\"}]");
                out.print(json.toString());
                } catch (Exception e) {
                    e.printStackTrace();
            }break;
        }
        case 6:{
            DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            AdministradorDao objAdministradorDao=objDaoFactory.getAdministradorDao();
            PrintWriter out=response.getWriter();
            int i=0;
            try {
            if( i == 0){
                i = 1;
            }    
                i=objAdministradorDao.generarcodigo() + 1;
                json=new StringBuilder();
                json.append("[{\"estado\":\""+i+"\"}]");
                out.print(json.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        }
        case 7:{
            DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            AdministradorDao objAdministradorDao=objDaoFactory.getAdministradorDao();
            PrintWriter out=response.getWriter();
            Administrador objeto=new Administrador();
            int ide=Integer.parseInt(request.getParameter("cod"));
            try {
                objeto.setIdadministrador(ide);
                Administrador obj=objAdministradorDao.CapturarDatos(objeto);
                json=new StringBuilder();
                json.append("[{\"Id\":\""+obj.getIdadministrador()+"\", \"Nombre\":\""+obj.getNombre()+"\", \"Apellido\":\""+obj.getApellido()+"\", \"Sexo\":\""+obj.getSexo()+"\", \"Edad\":\""+obj.getEdad()+"\", \"Correo\":\""+obj.getCorreo()+"\", \"Usuario\":\""+obj.getUsuario()+"\", \"Clave\":\""+obj.getClave()+"\"}]\n");
                out.print(json.toString());
            } catch (Exception e) {
            }
            break;
        }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
