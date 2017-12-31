/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Factoria.DaoFactory;
import Interfaces.ProfesorDAO;
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
 * @author Autonoma
 */
public class ProfesorServlet extends HttpServlet {

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
        String nom, ape, sex, eda, cor, id, pass, codi;
        int cod;
        switch (op) {
            case 1: {
                try {

                } catch (Exception e) {
                }
                break;
            }
            case 2: //LISTAR 
            {
                DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
                ProfesorDAO objProfesorDao = objDaoFactory.getProfesor();
                PrintWriter out = response.getWriter();
                List<Profesor> lista = null;
                try {
                    lista = objProfesorDao.listarprofesor();
                    json = new StringBuilder();
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
                ProfesorDAO objProfesorDao = objDaoFactory.getProfesor();
                PrintWriter out = response.getWriter();
                cod = Integer.parseInt(request.getParameter("txtcod"));
                nom = request.getParameter("txtnom");
                ape = request.getParameter("txtape");
                sex = request.getParameter("txtsex");
                eda = request.getParameter("txteda");
                cor = request.getParameter("txtcor");
                id = request.getParameter("txtid");
                pass = request.getParameter("txtpass");

                try {
                    Profesor obj = new Profesor();
                    obj.setIdprofesor(cod);
                    obj.setNombre(nom);
                    obj.setApellido(ape);
                    obj.setSexo(Integer.parseInt(sex));
                    obj.setEdad(Integer.parseInt(eda));
                    obj.setCorreo(cor);
                    obj.setUsuario(id);
                    obj.setClave(pass);
                    String i = objProfesorDao.grabarprofesor(obj);
                    json = new StringBuilder();
                    json.append("[{\"estado\":\"" + i + "\"}]");
                    out.print(json.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case 4://MODIFICAR ALUMNO
            {
                DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
                ProfesorDAO objProfesorDao = objDaoFactory.getProfesor();
                PrintWriter out = response.getWriter();
                cod = Integer.parseInt(request.getParameter("txtcod"));
                nom = request.getParameter("txtnom");
                ape = request.getParameter("txtape");
                sex = request.getParameter("txtsex");
                eda = request.getParameter("txteda");
                cor = request.getParameter("txtcor");
                id = request.getParameter("txtid");
                pass = request.getParameter("txtpass");

                try {
                    Profesor obj = new Profesor();
                    obj.setIdprofesor(cod);
                    obj.setNombre(nom);
                    obj.setApellido(ape);
                    obj.setSexo(Integer.parseInt(sex));
                    obj.setEdad(Integer.parseInt(eda));
                    obj.setCorreo(cor);
                    obj.setUsuario(id);
                    obj.setClave(pass);
                    String i = objProfesorDao.modificarprofesor(obj);
                    json = new StringBuilder();
                    json.append("[{\"estado\":\"" + i + "\"}]");
                    out.print(json.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case 5://Eliminar
            {
                DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
                ProfesorDAO objProfesorDao = objDaoFactory.getProfesor();
                PrintWriter out = response.getWriter();
                int ide = Integer.parseInt(request.getParameter("cod"));
                try {
                    Profesor obj = new Profesor();
                    obj.setIdprofesor(ide);
                    String i = objProfesorDao.eliminarprofesor(obj);
                    json = new StringBuilder();
                    json.append("[{\"estado\":\"" + i + "\"}]");
                    out.print(json.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case 6://GENERAR CODIGO
            {
                DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
                ProfesorDAO objProfesorDao = objDaoFactory.getProfesor();
                PrintWriter out = response.getWriter();
                int i = 0;
                try {
                if( i == 0){
                    i = 1;
                }    
                    i=objProfesorDao.GenerarCodigo() + 1;
                    json = new StringBuilder();
                    json.append("[{\"estado\":\"" + i + "\"}]");
                    out.print(json.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case 7: //CAPTURAR DATOS
            {
                DaoFactory objDaoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
                ProfesorDAO objProfesorDao = objDaoFactory.getProfesor();
                PrintWriter out = response.getWriter();
                Profesor objeto = new Profesor();
                int ide = Integer.parseInt(request.getParameter("cod"));
                try {
                    objeto.setIdprofesor(ide);
                    Profesor obj = objProfesorDao.cargarprofesor(objeto);
                    json = new StringBuilder();
                    json.append("[{\"Id\":\""+obj.getIdprofesor()+"\", \"Nombre\":\""+obj.getNombre()+"\", \"Apellido\":\""+obj.getApellido()+"\" , \"Sexo\":\""+obj.getSexo()+"\" , \"Edad\":\""+obj.getEdad()+"\" , \"Correo\":\""+obj.getCorreo()+"\" , \"Usuario\":\""+obj.getUsuario()+"\", \"Clave\":\""+obj.getClave()+"\"}]\n");
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
