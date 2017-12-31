/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Factoria.DaoFactory;
import Interfaces.AsistenciaDAO;
import JPA.Asistencia;
import JPA.MatriculaHasCurso;
import JPA.MatriculaHasCursoPK;
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
public class AsistenciaServlet extends HttpServlet {

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
        String asi;
        int cod_mat,cod_cur;
        int cod;
        switch(op)
        {
        case 1: //LISTAR 
        {
            DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            AsistenciaDAO objAsistenciaDao=objDaoFactory.getAsistencia();
            PrintWriter out=response.getWriter();
            List<Asistencia> lista= null;
            try {
                lista=objAsistenciaDao.listarasistencia();
                json=new StringBuilder();
                json.append(lista.toString());
                out.print(json.toString());
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        }
        case 2://GRABAR ASISTENCIA
        {
            DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            AsistenciaDAO objAsistenciaDao=objDaoFactory.getAsistencia();
            PrintWriter out=response.getWriter();
            cod = Integer.parseInt(request.getParameter("txtcod"));
            asi = request.getParameter("txtasi");
            cod_mat = Integer.parseInt(request.getParameter("txtmat"));
            cod_cur = Integer.parseInt(request.getParameter("txtcur"));
                        
            try {
                Asistencia obj=new Asistencia();
                MatriculaHasCursoPK matricurpk=new MatriculaHasCursoPK();
                MatriculaHasCurso matricur=new MatriculaHasCurso();
                matricurpk.setMatriculaIdmatricula(cod_mat);
                matricurpk.setCursoIdcurso(cod_cur);
                matricur.setMatriculaHasCursoPK(matricurpk);
                obj.setIdasistencia(cod);
                obj.setAsistencia(asi);
                obj.setMatriculaHasCurso(matricur);
                String i=objAsistenciaDao.grabarasistencia(obj);
                json=new StringBuilder();
                json.append("[{\"estado\":\""+i+"\"}]");
                out.print(json.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }break;
        }
        case 3://MODIFICAR ASISTENCIA
        {
            DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            AsistenciaDAO objAsistenciaDao=objDaoFactory.getAsistencia();
            PrintWriter out=response.getWriter();
            cod = Integer.parseInt(request.getParameter("txtcod"));
            asi = request.getParameter("txtasi");
            cod_mat = Integer.parseInt(request.getParameter("txtmat"));
            cod_cur = Integer.parseInt(request.getParameter("txtcur"));
                        
            try {
                Asistencia obj=new Asistencia();
                MatriculaHasCursoPK matricurpk=new MatriculaHasCursoPK();
                MatriculaHasCurso matricur=new MatriculaHasCurso();
                matricurpk.setMatriculaIdmatricula(cod_mat);
                matricurpk.setCursoIdcurso(cod_cur);
                matricur.setMatriculaHasCursoPK(matricurpk);
                obj.setIdasistencia(cod);
                obj.setAsistencia(asi);
                obj.setMatriculaHasCurso(matricur);
                String i=objAsistenciaDao.modificarasistencia(obj);
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
            AsistenciaDAO objAsistenciaDao=objDaoFactory.getAsistencia();
            PrintWriter out=response.getWriter();
            int ide=Integer.parseInt(request.getParameter("cod"));
            try {
                Asistencia obj=new Asistencia();
                obj.setIdasistencia(ide);
                String i=objAsistenciaDao.eliminarasistencia(obj);
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
            AsistenciaDAO objAsistenciaDao=objDaoFactory.getAsistencia();
            PrintWriter out=response.getWriter();
            int i=0;
            try {
            if( i == 0){
                i = 1;
            }    
                i=objAsistenciaDao.GenerarCodigo() + 1;
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
            AsistenciaDAO objAsistenciaDao=objDaoFactory.getAsistencia();
            PrintWriter out=response.getWriter();
            Asistencia objeto=new Asistencia();
            int ide=Integer.parseInt(request.getParameter("cod"));
            try {
                objeto.setIdasistencia(ide);
                Asistencia obj=objAsistenciaDao.cargarasistencia(objeto);
                json=new StringBuilder();
                json.append("[{\"Id\":\""+obj.getIdasistencia()+"\", \"Asistencia\":\""+obj.getAsistencia()+"\", \"Cod_Matricula\":\""+obj.getMatriculaHasCurso().getMatriculaHasCursoPK().getMatriculaIdmatricula()+"\" , \"Cod_Curso\":\""+obj.getMatriculaHasCurso().getMatriculaHasCursoPK().getCursoIdcurso()+"\"}]\n");               
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
