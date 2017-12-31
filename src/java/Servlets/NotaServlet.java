/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Factoria.DaoFactory;
import Interfaces.NotaDAO;
import JPA.Administrador;
import JPA.Curso;
import JPA.Matricula;
import JPA.MatriculaHasCurso;
import JPA.MatriculaHasCursoPK;
import JPA.Notas;
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
public class NotaServlet extends HttpServlet {

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
        String tip_no;
        double not;
        int cod, cod_ma, cod_cu;
        switch (op) {
            case 1: //LISTAR 
            {
                DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
                NotaDAO objNotaDao = objDaoFactory.getNota();
                PrintWriter out = response.getWriter();
                List<Notas> lista = null;
                try {
                    lista = objNotaDao.listarnota();
                    json = new StringBuilder();
                    json.append(lista.toString());
                    out.print(json.toString());

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case 2://GRABAR NOTA
            {
                DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
                NotaDAO objNotaDao = objDaoFactory.getNota();
                PrintWriter out = response.getWriter();
                cod = Integer.parseInt(request.getParameter("txtcod"));
                not = Double.parseDouble(request.getParameter("txtnot"));
                tip_no = request.getParameter("txttipno");
                cod_ma = Integer.parseInt(request.getParameter("txtmat"));
                cod_cu = Integer.parseInt(request.getParameter("txtcur"));

                try {
                    Notas obj = new Notas();
                    Notas objbean = new Notas();
                    MatriculaHasCurso matricur = new MatriculaHasCurso();
                    MatriculaHasCursoPK matricurPK = new MatriculaHasCursoPK();
                    obj.setIdnotas(cod);
                    obj.setNota(not);
                    obj.setTiponota(tip_no);
                    matricurPK.setMatriculaIdmatricula(cod_ma);
                    matricurPK.setCursoIdcurso(cod_cu);
                    matricur.setMatriculaHasCursoPK(matricurPK);
                    obj.setMatriculaHasCurso(matricur);

                    String i = objNotaDao.grabarnota(obj);
                    json = new StringBuilder();
                    json.append("[{\"estado\":\"" + i + "\"}]");
                    out.print(json.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case 3://MODIFICAR NOTA
            {
                DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
                NotaDAO objNotaDao = objDaoFactory.getNota();
                PrintWriter out = response.getWriter();
                cod = Integer.parseInt(request.getParameter("txtcod"));
                not = Double.parseDouble(request.getParameter("txtnot"));
                tip_no = request.getParameter("txttipno");
                cod_ma = Integer.parseInt(request.getParameter("txtmat"));
                cod_cu = Integer.parseInt(request.getParameter("txtcur"));

                try {
                    Notas obj = new Notas();
                    Notas objbean = new Notas();
                    MatriculaHasCurso matricur = new MatriculaHasCurso();
                    MatriculaHasCursoPK matricurPK = new MatriculaHasCursoPK();
                    obj.setIdnotas(cod);
                    obj.setNota(not);
                    obj.setTiponota(tip_no);
                    matricurPK.setMatriculaIdmatricula(cod_ma);
                    matricurPK.setCursoIdcurso(cod_cu);
                    matricur.setMatriculaHasCursoPK(matricurPK);
                    obj.setMatriculaHasCurso(matricur);

                    String i = objNotaDao.modificarnota(obj);
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
                NotaDAO objNotaDao = objDaoFactory.getNota();
                PrintWriter out = response.getWriter();
                int ide = Integer.parseInt(request.getParameter("cod"));
                try {
                    Notas obj = new Notas();
                    obj.setIdnotas(ide);
                    String i = objNotaDao.eliminarnota(obj);
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
                NotaDAO objNotaDao = objDaoFactory.getNota();
                PrintWriter out = response.getWriter();
                int i = 0;
                try {
                if( i == 0){
                    i = 1;
                }    
                    i=objNotaDao.GenerarCodigo() + 1;
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
                NotaDAO objNotaDao = objDaoFactory.getNota();
                PrintWriter out = response.getWriter();
                Notas objeto = new Notas();
                int ide = Integer.parseInt(request.getParameter("cod"));
                try {
                    objeto.setIdnotas(ide);
                    Notas obj = objNotaDao.cargarnota(objeto);
                    json = new StringBuilder();
                    json.append("[{\"Id\":\""+obj.getIdnotas()+"\", \"Nota\":\""+obj.getNota()+"\", \"Tip_Nota\":\""+obj.getTiponota()+"\", \"idMatricula\":\""+obj.getMatriculaHasCurso().getMatriculaHasCursoPK().getMatriculaIdmatricula()+"\", \"idCurso\":\""+obj.getMatriculaHasCurso().getMatriculaHasCursoPK().getCursoIdcurso()+"\"}]\n");
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
