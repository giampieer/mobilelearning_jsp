/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Factoria.DaoFactory;
import Interfaces.LibroDao;
import JPA.Libro;
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
 * @author TOSHIBA
 */
public class LibroServlet extends HttpServlet {

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
        String nom,aut,est;
        int cod,eje;
        switch(op)
        {
        case 1: //LISTAR 
        {
            DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            LibroDao objLibroDao=objDaoFactory.getLibroDao();
            PrintWriter out=response.getWriter();
            List<Libro> lista= null;
            try {
                lista=objLibroDao.lista();
                json=new StringBuilder();
                json.append(lista.toString());    
                out.print(json.toString());
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        }
        case 2://GRABAR LIBRO
        {
            DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            LibroDao objLibroDao=objDaoFactory.getLibroDao();
            PrintWriter out=response.getWriter();
            cod = Integer.parseInt(request.getParameter("txtcod"));
            nom = request.getParameter("txtnom");
            aut = request.getParameter("txtaut");
            eje = Integer.parseInt(request.getParameter("txteje"));
            est = request.getParameter("txtest");
            
            try {
                Libro obj=new Libro();                
                obj.setIdLibro(cod);
                obj.setNombre(nom);
                obj.setAutor(aut);
                obj.setEjemplares(eje);
                obj.setEstado(est);                
                String i=objLibroDao.AgregarLibro(obj);
                json=new StringBuilder();
                json.append("[{\"estado\":\""+i+"\"}]");
                out.print(json.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }break;
        }
        case 3://MODIFICAR LIBRO
        {
            DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            LibroDao objLibroDao=objDaoFactory.getLibroDao();
            PrintWriter out=response.getWriter();
            cod = Integer.parseInt(request.getParameter("txtcod"));
            nom = request.getParameter("txtnom");
            aut = request.getParameter("txtaut");
            eje = Integer.parseInt(request.getParameter("txteje"));
            est = request.getParameter("txtest");
            
            try {
                Libro obj=new Libro();                
                obj.setIdLibro(cod);
                obj.setNombre(nom);
                obj.setAutor(aut);
                obj.setEjemplares(eje);
                obj.setEstado(est);                
                String i=objLibroDao.ModificarLibro(obj);
                json=new StringBuilder();
                json.append("[{\"estado\":\""+i+"\"}]");
                out.print(json.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }break;
        }
        case 4://Eliminar
        {
            DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            LibroDao objLibroDao=objDaoFactory.getLibroDao();
            PrintWriter out=response.getWriter();
            int ide=Integer.parseInt(request.getParameter("cod"));
            try {
                Libro obj=new Libro();
                obj.setIdLibro(ide);
                String i=objLibroDao.EliminarLibro(obj);
                json=new StringBuilder();
                json.append("[{\"estado\":\""+i+"\"}]");
                out.print(json.toString());
                } catch (Exception e) {
                    e.printStackTrace();
            }break;
        }
        case 5://GENERAR CODIGO
        { 
            DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            LibroDao objLibroDao=objDaoFactory.getLibroDao();
            PrintWriter out=response.getWriter();
            int i=0;
            try {
            if( i == 0){
                i = 1;
            }    
                i=objLibroDao.GenerarCodigo() + 1;
                json=new StringBuilder();
                json.append("[{\"estado\":\""+i+"\"}]");
                out.print(json.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        }
        case 6: //CAPTURAR DATOS
        {
            DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            LibroDao objLibroDao=objDaoFactory.getLibroDao();
            PrintWriter out=response.getWriter();
            Libro objeto=new Libro();
            int ide=Integer.parseInt(request.getParameter("cod"));
            try {
                objeto.setIdLibro(ide);
                Libro obj=objLibroDao.CapturarLibro(objeto);
                json=new StringBuilder();
                json.append("[{\"Id\":\""+obj.getIdLibro()+"\", \"Nombre\":\""+obj.getNombre()+"\", \"Autor\":\""+obj.getAutor()+"\", \"Ejemplares\":\""+obj.getEjemplares()+"\", \"Estado\":\""+obj.getEstado()+"\"}]\n");
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
