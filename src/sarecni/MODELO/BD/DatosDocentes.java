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
public class DatosDocentes {
    private String cedula, profesor;

    public DatosDocentes(String cedula, String profesor) {
        this.cedula = cedula;
        this.profesor = profesor;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    

}
