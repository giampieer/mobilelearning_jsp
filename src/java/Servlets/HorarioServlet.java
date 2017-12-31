/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Factoria.DaoFactory;
import Interfaces.HorarioDao;
import JPA.Curso;
import JPA.Horario;
import JPA.Profesor;
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
public class HorarioServlet extends HttpServlet {

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
        String fec_i,fec_f,hor_i,hor_f;
        int cod,cod_p,cod_c;
        switch(op)
        {
        case 1: //LISTAR 
        {
            DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            HorarioDao objHorarioDao=objDaoFactory.getHorarioDao();
            PrintWriter out=response.getWriter();
            List<Horario> lista= null;
            try {
                lista=objHorarioDao.lista();
                json=new StringBuilder();
                json.append(lista.toString());
                out.print(json.toString());
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        }
        case 2://GRABAR HORARIO
        {
            DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            HorarioDao objHorarioDao=objDaoFactory.getHorarioDao();
            PrintWriter out=response.getWriter();
            cod = Integer.parseInt(request.getParameter("txtcod"));
            fec_i = request.getParameter("txtfec_i");
            fec_f = request.getParameter("txtfec_f");
            hor_i = request.getParameter("txthor_i");
            hor_f = request.getParameter("txthor_f");
            cod_p = Integer.parseInt(request.getParameter("txtcod_p"));
            cod_c = Integer.parseInt(request.getParameter("txtcod_c"));
            
            try {
                Horario obj=new Horario();
                Profesor pro=new Profesor();
                pro.setIdprofesor(cod_p);
                Curso cur=new Curso();
                cur.setIdcurso(cod_c);
                obj.setIdhorario(cod);
                obj.setFechainicio(fec_i);
                obj.setFechafin(fec_f);
                obj.setHorainicio(hor_i);
                obj.setHorafin(hor_f);
                obj.setProfesor(pro);
                obj.setCurso(cur);
                String i=objHorarioDao.AgregarHorario(obj);
                json=new StringBuilder();
                json.append("[{\"estado\":\""+i+"\"}]");
                out.print(json.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }break;
        }
        case 3://MODIFICAR HORARIO
        {
            DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
            HorarioDao objHorarioDao=objDaoFactory.getHorarioDao();
            PrintWriter out=response.getWriter();
            cod = Integer.parseInt(request.getParameter("txtcod"));
            fec_i = request.getParameter("txtfec_i");
            fec_f = request.getParameter("txtfec_f");
            hor_i = request.getParameter("txthor_i");
            hor_f = request.getParameter("txthor_f");
            cod_p = Integer.parseInt(request.getParameter("txtcod_p"));
            cod_c = Integer.parseInt(request.getParameter("txtcod_c"));
            
            try {
                Horario obj=new Horario();
                Profesor pro=new Profesor();
                pro.setIdprofesor(cod_p);
                Curso cur=new Curso();
                cur.setIdcurso(cod_c);
                obj.setIdhorario(cod);
                obj.setFechainicio(fec_i);
                obj.setFechafin(fec_f);
                obj.setHorainicio(hor_i);
                obj.setHorafin(hor_f);
                obj.setProfesor(pro);
                obj.setCurso(cur);
                String i=objHorarioDao.ModificarHorario(obj);
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
            HorarioDao objHorarioDao=objDaoFactory.getHorarioDao();
            PrintWriter out=response.getWriter();
            int ide=Integer.parseInt(request.getParameter("cod"));
            try {
                Horario obj=new Horario();
                obj.setIdhorario(ide);
                String i=objHorarioDao.EliminarHorario(obj);
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
            HorarioDao objHorarioDao=objDaoFactory.getHorarioDao();
            PrintWriter out=response.getWriter();
            int i=0;
            try {
            if( i == 0){
                i = 1;
            }    
                i=objHorarioDao.generarcodigo() + 1;
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
            HorarioDao objHorarioDao=objDaoFactory.getHorarioDao();
            PrintWriter out=response.getWriter();
            Horario objeto=new Horario();
            int ide=Integer.parseInt(request.getParameter("cod"));
            try {
                objeto.setIdhorario(ide);
                Horario obj=objHorarioDao.CapturarHorario(objeto);
                json=new StringBuilder();
                json.append("[{\"Id\":\""+obj.getIdhorario()+"\", \"Fecha_I\":\""+obj.getFechainicio()+"\", \"Fecha_F\":\""+obj.getFechafin()+"\", \"Hora_I\":\""+obj.getHorainicio()+"\", \"Hora_F\":\""+obj.getHorafin()+"\", \"Cod_p\":\""+obj.getProfesor().getIdprofesor()+"\", \"Cod_c\":\""+obj.getCurso().getIdcurso()+"\"}]\n");
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
