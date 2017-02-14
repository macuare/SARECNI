/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarecni.MODELO.FORMATOS;

/**
 *
 * @author ANDY
 */
public class FormatoEvaluacionesOfertadas {
    
    private int id;
    private String estrategia, ponderacion, fecha, seccion, materia;

    public FormatoEvaluacionesOfertadas(int id, String estrategia, String ponderacion, String fecha, String seccion, String materia) {
        this.id = id;
        this.estrategia = estrategia;
        this.ponderacion = ponderacion;
        this.fecha = fecha;
        this.seccion = seccion;
        this.materia = materia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }

    public String getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(String ponderacion) {
        this.ponderacion = ponderacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
