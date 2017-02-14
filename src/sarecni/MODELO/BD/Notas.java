/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sarecni.MODELO.BD;

/**
 *
 * Created by @author Andy Cusatti on 06-jun-2016
 */
public class Notas {
   private String id; 
   private int idEstudiantes, idEvaluaciones, nota;

    public Notas(String id, int idEstudiantes, int idEvaluaciones, int nota) {
        this.id = id;
        this.idEstudiantes = idEstudiantes;
        this.idEvaluaciones = idEvaluaciones;
        this.nota = nota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdEstudiantes() {
        return idEstudiantes;
    }

    public void setIdEstudiantes(int idEstudiantes) {
        this.idEstudiantes = idEstudiantes;
    }

    public int getIdEvaluaciones() {
        return idEvaluaciones;
    }

    public void setIdEvaluaciones(int idEvaluaciones) {
        this.idEvaluaciones = idEvaluaciones;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

}
