/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factoria;

import Bean.ProfesorBean;
import Dao.MysqlActividadDao;
import Dao.MysqlAdministradorDao;
import Dao.MysqlAlumnoDao;
import Dao.MysqlAnuncioDao;
import Dao.MysqlAsistenciaDao;
import Dao.MysqlCursoDao;
import Dao.MysqlHorarioDao;
import Dao.MysqlLaboratorioDao;
import Dao.MysqlLibroDao;
import Dao.MysqlMatriculaDao;
import Dao.MysqlNotaDao;
import Dao.MysqlPagoDao;
import Dao.MysqlProfesorDao;
import Dao.MysqlRecursosDao;
import Dao.MysqlReservaActividadDao;
import Dao.MysqlReservaLaboratorioDao;
import Dao.MysqlReservaLibroDao;
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
public class MysqlDaoFactory extends DaoFactory{

    @Override
    public ProfesorDAO getProfesor() {
    return new MysqlProfesorDao();
    }

    @Override
    public AlumnoDAO getAlumno() {
    return new MysqlAlumnoDao();
    }

    @Override
    public CursoDAO getCurso() {
    return new MysqlCursoDao();
    }

    @Override
    public NotaDAO getNota() {
    return new MysqlNotaDao();
    }

    @Override
    public AsistenciaDAO getAsistencia() {
    return new MysqlAsistenciaDao();
    }

    @Override
    public AdministradorDao getAdministradorDao() {
        return new MysqlAdministradorDao();
    }

    @Override
    public MatriculaDao getMatriculaDao() {
        return new MysqlMatriculaDao();
    }

    @Override
    public HorarioDao getHorarioDao() {
        return new MysqlHorarioDao();
    }

    @Override
    public ActividadDao getActividadDao() {
        return new MysqlActividadDao();
    }

    @Override
    public LaboratorioDao getLaboratorioDao() {
        return new MysqlLaboratorioDao();
    }

    @Override
    public LibroDao getLibroDao() {
        return new MysqlLibroDao();
    }

    @Override
    public PagoDao getPagos() {
        return new MysqlPagoDao();
    }

    @Override
    public RecursosDao getRecursosDao() {
        return new MysqlRecursosDao();
    }

    @Override
    public AnuncioDao getAnuncioDao() {
        return new MysqlAnuncioDao();
    }

    @Override
    public ReservaActividadDao getReservaActividadDao() {
        return new MysqlReservaActividadDao();
    }

    @Override
    public ReservaLaboratorioDao getReservaLaboratorioDao() {
        return new MysqlReservaLaboratorioDao();
    }

    @Override
    public ReservaLibroDao getReservaLibroDao() {
        return new MysqlReservaLibroDao();
    }
    
    
    
}
