/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author TOSHIBA
 */
public class AsistenciaBean {
    private int idasistencia;
    private String asistencia;
    private int matricula_idmatricula;
    private int curso_idcurso;

    public int getIdasistencia() {
        return idasistencia;
    }

    public void setIdasistencia(int idasistencia) {
        this.idasistencia = idasistencia;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    public int getMatricula_idmatricula() {
        return matricula_idmatricula;
    }

    public void setMatricula_idmatricula(int matricula_idmatricula) {
        this.matricula_idmatricula = matricula_idmatricula;
    }

    public int getCurso_idcurso() {
        return curso_idcurso;
    }

    public void setCurso_idcurso(int curso_idcurso) {
        this.curso_idcurso = curso_idcurso;
    }
   
}
