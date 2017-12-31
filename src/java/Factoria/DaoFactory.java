/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factoria;

import Bean.ProfesorBean;
import Interfaces.ActividadDao;
import Interfaces.AdministradorDao;
import Interfaces.AlumnoDAO;
import Interfaces.AnuncioDao;
import Interfaces.AsistenciaDAO;
import Interfaces.CursoDAO;
import Interfaces.HorarioDao;
import Interfaces.LaboratorioDao;
import Interfaces.LibroDao;
import Interfaces.MatriculaDao;
import Interfaces.NotaDAO;
import Interfaces.PagoDao;
import Interfaces.ProfesorDAO;
import Interfaces.RecursosDao;
import Interfaces.ReservaActividadDao;
import Interfaces.ReservaLaboratorioDao;
import Interfaces.ReservaLibroDao;

/**
 *
 * @author Home
 */
public abstract  class DaoFactory {
    public static final int MYSQL=1;
    public abstract  ProfesorDAO getProfesor();
    public abstract  AlumnoDAO getAlumno();
    public abstract  CursoDAO getCurso();
    public abstract  NotaDAO getNota();
    public abstract  AsistenciaDAO getAsistencia();
    public abstract AdministradorDao getAdministradorDao();
    public abstract MatriculaDao getMatriculaDao();
    public abstract HorarioDao getHorarioDao();
    public abstract ActividadDao getActividadDao();
    public abstract LaboratorioDao getLaboratorioDao();
    public abstract LibroDao getLibroDao();
    public abstract PagoDao getPagos();
    public abstract RecursosDao getRecursosDao();
    public abstract AnuncioDao getAnuncioDao();
    public abstract ReservaActividadDao getReservaActividadDao();
    public abstract ReservaLaboratorioDao getReservaLaboratorioDao();
    public abstract ReservaLibroDao getReservaLibroDao();
    public static DaoFactory getDaoFactory(int op){
      switch(op){
          case 1 :
          return new MysqlDaoFactory();
          default: return null;
          
      }
    }
}
