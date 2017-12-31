/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Factoria.DaoFactory;
import Interfaces.MatriculaDao;
import JPA.Administrador;
import JPA.Alumno;
import JPA.Matricula;
import JPA.Pagos;
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
public class MatriculaServlet extends HttpServlet {

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
        response.setHeader("Access-Control-Allow-Origin", "*");
        HttpSession respuesta = request.getSession();
        StringBuilder json = null;
        String opcad = request.getParameter("op");
        int op = Integer.parseInt(opcad);
        String cic, sec;
        int cod, cod_ad, cod_al, cod_pa;
        switch (op) {
            case 1: //LISTAR 
            {
                DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
                MatriculaDao objMatriculaDao = objDaoFactory.getMatriculaDao();
                PrintWriter out = response.getWriter();
                List<Matricula> lista = null;
                try {
                    lista = objMatriculaDao.listaMtri();
                    json = new StringBuilder();
                    json.append(lista.toString());
                    out.print(json.toString());

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case 2://GRABAR MATRICULA
            {
                DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
                MatriculaDao objMatriculaDao = objDaoFactory.getMatriculaDao();
                PrintWriter out = response.getWriter();
                cod = Integer.parseInt(request.getParameter("txtcod"));
                cic = request.getParameter("txtcic");
                sec = request.getParameter("txtsec");
                cod_ad = Integer.parseInt(request.getParameter("txtadm"));
                cod_al = Integer.parseInt(request.getParameter("txtalu"));
                cod_pa = Integer.parseInt(request.getParameter("txtpag"));

                try {
                    Administrador admin = new Administrador();
                    Alumno alum = new Alumno();
                    Pagos pagos = new Pagos();
                    Matricula obj = new Matricula();
                    obj.setIdmatricula(cod);
                    obj.setCiclo(cic);
                    obj.setSeccion(sec);
                    admin.setIdadministrador(cod_ad);
                    obj.setAdministrador(admin);
                    alum.setIdalumno(cod_al);
                    obj.setAlumno(alum);
                    pagos.setIdPagos(cod_pa);
                    obj.setPagos(pagos);
                    String i = objMatriculaDao.AgregarMatri(obj);
                    json = new StringBuilder();
                    json.append("[{\"estado\":\"" + i + "\"}]");
                    out.print(json.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case 3://MODIFICAR MATRICULA
            {
                DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
                MatriculaDao objMatriculaDao = objDaoFactory.getMatriculaDao();
                PrintWriter out = response.getWriter();
                cod = Integer.parseInt(request.getParameter("txtcod"));
                cic = request.getParameter("txtcic");
                sec = request.getParameter("txtsec");
                cod_ad = Integer.parseInt(request.getParameter("txtadm"));
                cod_al = Integer.parseInt(request.getParameter("txtalu"));
                cod_pa = Integer.parseInt(request.getParameter("txtpag"));

                try {
                    Administrador admin = new Administrador();
                    Alumno alum = new Alumno();
                    Pagos pagos = new Pagos();
                    Matricula obj = new Matricula();
                    obj.setIdmatricula(cod);
                    obj.setCiclo(cic);
                    obj.setSeccion(sec);
                    admin.setIdadministrador(cod_ad);
                    obj.setAdministrador(admin);
                    alum.setIdalumno(cod_al);
                    obj.setAlumno(alum);
                    pagos.setIdPagos(cod_pa);
                    obj.setPagos(pagos);
                    String i = objMatriculaDao.ModificarMatri(obj);
                    json = new StringBuilder();
                    json.append("[{\"estado\":\"" + i + "\"}]");
                    out.print(json.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case 4://Eliminar
            {
                DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
                MatriculaDao objMatriculaDao = objDaoFactory.getMatriculaDao();
                PrintWriter out = response.getWriter();
                int ide = Integer.parseInt(request.getParameter("cod"));
                try {
                    Matricula obj = new Matricula();
                    obj.setIdmatricula(ide);
                    String i = objMatriculaDao.EliminarMatri(obj);
                    json = new StringBuilder();
                    json.append("[{\"estado\":\"" + i + "\"}]");
                    out.print(json.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case 5://GENERAR CODIGO
            {
                DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
                MatriculaDao objMatriculaDao = objDaoFactory.getMatriculaDao();
                PrintWriter out = response.getWriter();
                int i = 0;
                try {
                if( i == 0){
                    i = 1;
                }    
                    i=objMatriculaDao.GenerarCodigo() + 1;
                    json = new StringBuilder();
                    json.append("[{\"estado\":\"" + i + "\"}]");
                    out.print(json.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case 6: //CAPTURAR DATOS
            {
                DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
                MatriculaDao objMatriculaDao = objDaoFactory.getMatriculaDao();
                PrintWriter out = response.getWriter();
                Matricula objeto = new Matricula();
                int ide = Integer.parseInt(request.getParameter("cod"));
                try {
                    objeto.setIdmatricula(ide);
                    Matricula obj = objMatriculaDao.CapturarMatri(objeto);
                    json = new StringBuilder();
                    json.append("[{\"Id\":\""+obj.getIdmatricula()+"\", \"Ciclo\":\""+obj.getCiclo()+"\", \"Seccion\":\""+obj.getSeccion()+"\", \"idAdministrador\":\""+obj.getAdministrador().getIdadministrador()+"\", \"idAlumno\":\""+obj.getAlumno().getIdalumno()+"\", \"idPagos\":\""+obj.getPagos().getIdPagos()+"\"}]\n");
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
