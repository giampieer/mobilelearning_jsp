/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBean;

import Factoria.DaoFactory;
import Interfaces.AdministradorDao;
import Interfaces.AlumnoDAO;
import Interfaces.ProfesorDAO;
import javax.annotation.PostConstruct;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author Jhonk
 */
public class ManagerGraficos {
private BarChartModel animatedModel2;
 
    @PostConstruct
    public void init() {
        createAnimatedModels();
    }
 
    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }
 
    private void createAnimatedModels() {
         
        animatedModel2 = initBarModel();
        animatedModel2.setTitle("Cantidad de Usuarios");
        animatedModel2.setAnimate(true);
        animatedModel2.setLegendPosition("ne");
        Axis yAxis = animatedModel2.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
    }
     
    private BarChartModel initBarModel() {
        DaoFactory objDaoFactory=DaoFactory.getDaoFactory(DaoFactory.MYSQL);
        AdministradorDao objAdministradorDao=objDaoFactory.getAdministradorDao();
        AlumnoDAO objAlumnoDAO=objDaoFactory.getAlumno();
        ProfesorDAO objProfesorDAO=objDaoFactory.getProfesor();
        BarChartModel model = new BarChartModel();
        try {
            ChartSeries boys = new ChartSeries();
            boys.setLabel("Administradores");
            boys.set("2017", objAdministradorDao.generarcodigo());

            ChartSeries girls = new ChartSeries();
            girls.setLabel("Profesores");
            girls.set("2017", objProfesorDAO.GenerarCodigo());

            ChartSeries Alumno = new ChartSeries();
            Alumno.setLabel("Alumnos");
            Alumno.set("2017", objAlumnoDAO.GenerarCodigo());

            model.addSeries(boys);
            model.addSeries(girls);
            model.addSeries(Alumno);
         
        } catch (Exception e) {
        }
        
        return model;
    }
    
}
