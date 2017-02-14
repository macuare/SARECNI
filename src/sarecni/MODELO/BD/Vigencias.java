/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sarecni.MODELO.BD;

/**
 *
 * Created by @author Andy Cusatti on 02-jun-2016
 */
public class Vigencias {
    private int idEstudiante, vigencia;
    private String turno;

    public Vigencias(int idEstudiante, int vigencia, String turno) {
        this.idEstudiante = idEstudiante;
        this.vigencia = vigencia;
        this.turno = turno;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getVigencia() {
        return vigencia;
    }

    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    
    
    

}
