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
public class Materias {
    //1;8;EDC36393;GERENCIA EDUCATIVA;0;0;0;3;0;0;0;0;0;2010;LIC. EDUCACION INTEGRAL;DIURNO
    //id, semestre, codigo, asignatura, horas_teoricas, horas_practicas, horas_laboratorio, credito, vigencia, carrera, turno            
    private int id, semestre;
    private String codigo, asignatura;
    private int horas_teoricas, horas_practicas, horas_laboratorio, credito, vigencia;
    private String carrera, turno;

    public Materias(int id, int semestre, String codigo, String asignatura, int horas_teoricas, int horas_practicas, int horas_laboratorio, int credito, int vigencia, String carrera, String turno) {
        this.id = id;
        this.semestre = semestre;
        this.codigo = codigo;
        this.asignatura = asignatura;
        this.horas_teoricas = horas_teoricas;
        this.horas_practicas = horas_practicas;
        this.horas_laboratorio = horas_laboratorio;
        this.credito = credito;
        this.vigencia = vigencia;
        this.carrera = carrera;
        this.turno = turno;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public int getHoras_practicas() {
        return horas_practicas;
    }

    public void setHoras_practicas(int horas_practicas) {
        this.horas_practicas = horas_practicas;
    }

    public int getHoras_teoricas() {
        return horas_teoricas;
    }

    public void setHoras_teoricas(int horas_teoricas) {
        this.horas_teoricas = horas_teoricas;
    }

    public int getHoras_laboratorio() {
        return horas_laboratorio;
    }

    public void setHoras_laboratorio(int horas_laboratorio) {
        this.horas_laboratorio = horas_laboratorio;
    }

    public int getVigencia() {
        return vigencia;
    }

    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    

}
