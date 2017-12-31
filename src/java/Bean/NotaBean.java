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
public class NotaBean {
    private int idnota;
    private double nota;
    private String tipnota;
    private int matricula_idmatricula;
    private int curso_idcurso;

    public int getIdnota() {
        return idnota;
    }

    public void setIdnota(int idnota) {
        this.idnota = idnota;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getTipnota() {
        return tipnota;
    }

    public void setTipnota(String tipnota) {
        this.tipnota = tipnota;
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
