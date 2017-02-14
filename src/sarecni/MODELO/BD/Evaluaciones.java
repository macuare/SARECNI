/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sarecni.MODELO.BD;

/**
 *
 * Created by @author Andy Cusatti on 03-jun-2016
 */
public class Evaluaciones {
    private String id;
    private int idEstrategias, porcentaje, idSecciones;
    private String materia, fecha;

    public Evaluaciones(String id, int idEstrategias, int porcentaje, int idSecciones, String materia, String fecha) {
        this.id = id;
        this.idEstrategias = idEstrategias;
        this.porcentaje = porcentaje;
        this.idSecciones = idSecciones;
        this.materia = materia;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdEstrategias() {
        return idEstrategias;
    }

    public void setIdEstrategias(int idEstrategias) {
        this.idEstrategias = idEstrategias;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getIdSecciones() {
        return idSecciones;
    }

    public void setIdSecciones(int idSecciones) {
        this.idSecciones = idSecciones;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
    
}
