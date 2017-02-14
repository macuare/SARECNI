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
public class DatosAcademicos {
    private int id, idEstudiante, idMateria, idSeccion;

    public DatosAcademicos(int id, int idEstudiante, int idMateria, int idSeccion) {
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.idMateria = idMateria;
        this.idSeccion = idSeccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }
    
    
    
    

}
