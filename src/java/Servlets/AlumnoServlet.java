/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.AlumnoBean;
import Dao.MysqlAlumnoDao;
import Factoria.DaoFactory;
import Interfaces.AlumnoDAO;
import JPA.Alumno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Autonoma
 */
public class AlumnoServlet extends HttpServlet {

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
        StringBuilder json=null;
        String opcad=request.getParameter("op");
        int op=Integer.parseInt(opcad);
        String nom,ape,sex,eda,cor,id,pass,codi;
        int cod;
        switch(op)
        {
        case 1:{
            try {
                
            } catch (Exception e) {
            }break;
        }
        case 2: //LISTAR 
        {
            DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            AlumnoDAO objAlumnoDao=objDaoFactory.getAlumno();
            PrintWriter out=response.getWriter();
            List<Alumno> lista= null;
            try {
                lista=objAlumnoDao.listaralumno();
                json=new StringBuilder();
                json.append(lista.toString());
                out.print(json.toString());
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;       
        }
        case 3://GRABAR ALUMNO
        {
            DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            AlumnoDAO objAlumnoDao = objDaoFactory.getAlumno();
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
                Alumno obj=new Alumno();
                obj.setIdalumno(cod);
                obj.setNombre(nom);
                obj.setApellido(ape);
                obj.setSexo(Integer.parseInt(sex));
                obj.setEdad(Integer.parseInt(eda));
                obj.setCorreo(cor);
                obj.setUsuario(id);
                obj.setClave(pass);
                String i=objAlumnoDao.grabaralumno(obj);
                json=new StringBuilder();
                json.append("[{\"estado\":\""+i+"\"}]");
                out.print(json.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }break;
        }
        case 4://MODIFICAR ALUMNO
        {
            DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            AlumnoDAO objAlumnoDao = objDaoFactory.getAlumno();
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
                Alumno obj=new Alumno();
                obj.setIdalumno(cod);
                obj.setNombre(nom);
                obj.setApellido(ape);
                obj.setSexo(Integer.parseInt(sex));
                obj.setEdad(Integer.parseInt(eda));
                obj.setCorreo(cor);
                obj.setUsuario(id);
                obj.setClave(pass);
                String i=objAlumnoDao.modificaralumno(obj);
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
            AlumnoDAO objAlumnoDao = objDaoFactory.getAlumno();
            PrintWriter out=response.getWriter();
            int ide=Integer.parseInt(request.getParameter("cod"));
            try {
                Alumno obj=new Alumno();
                obj.setIdalumno(ide);
                String i=objAlumnoDao.eliminaralumno(obj);
                json=new StringBuilder();
                json.append("[{\"estado\":\""+i+"\"}]");
                out.print(json.toString());
                } catch (Exception e) {
                    e.printStackTrace();
            }break;
        }
        case 6://GENERAR CODIGO
        { 
            DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            AlumnoDAO objAlumnoDao=objDaoFactory.getAlumno();
            PrintWriter out=response.getWriter();
            int i=0;
            try {
            if( i == 0){
                i = 1;
            }    
                i=objAlumnoDao.GenerarCodigo() + 1;
                json=new StringBuilder();
                json.append("[{\"estado\":\""+i+"\"}]");
                out.print(json.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        }
        case 7: //CAPTURAR DATOS
        {
            DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            AlumnoDAO objAlumnoDao=objDaoFactory.getAlumno();
            PrintWriter out=response.getWriter();
            Alumno objeto=new Alumno();
            int ide=Integer.parseInt(request.getParameter("cod"));
            try {
                objeto.setIdalumno(ide);
                Alumno obj=objAlumnoDao.cargaralumno(objeto);
                json=new StringBuilder();
                json.append("[{\"Id\":\""+obj.getIdalumno()+"\", \"Nombre\":\""+obj.getNombre()+"\", \"Apellido\":\""+obj.getApellido()+"\" , \"Sexo\":\""+obj.getSexo()+"\" , \"Edad\":\""+obj.getEdad()+"\" , \"Correo\":\""+obj.getCorreo()+"\" , \"Usuario\":\""+obj.getUsuario()+"\", \"Clave\":\""+obj.getClave()+"\"}]\n");
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
