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
public class FormatoNotas {
    
   private int nro;
   private String cedula, nombres, apellidos;  
   private String fecha_1,fecha_2,fecha_3,fecha_4,fecha_5,fecha_6,fecha_7,fecha_8,fecha_9,fecha_10; 
   private String evaluacion_1,evaluacion_2,evaluacion_3,evaluacion_4,evaluacion_5,evaluacion_6,evaluacion_7,evaluacion_8,evaluacion_9,evaluacion_10; 
   private String porciento_1,porciento_2,porciento_3,porciento_4,porciento_5,porciento_6,porciento_7,porciento_8,porciento_9,porciento_10; 
   private String definitiva, letras;

    public FormatoNotas(int nro, String cedula, String nombres, String apellidos, String fecha_1, String evaluacion_1, String porciento_1, String fecha_2, String evaluacion_2, String porciento_2,String fecha_3, String evaluacion_3, String porciento_3, String fecha_4, String evaluacion_4, String porciento_4, String fecha_5, String evaluacion_5, String porciento_5, String fecha_6, String evaluacion_6, String porciento_6, String fecha_7, String evaluacion_7, String porciento_7, String fecha_8, String evaluacion_8, String porciento_8, String fecha_9, String evaluacion_9, String porciento_9, String fecha_10, String evaluacion_10, String porciento_10, String definitiva, String letras) {
        this.nro = nro;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha_1 = fecha_1;
        this.fecha_2 = fecha_2;
        this.fecha_3 = fecha_3;
        this.fecha_4 = fecha_4;
        this.fecha_5 = fecha_5;
        this.fecha_6 = fecha_6;
        this.fecha_7 = fecha_7;
        this.fecha_8 = fecha_8;
        this.fecha_9 = fecha_9;
        this.fecha_10 = fecha_10;
        this.evaluacion_1 = evaluacion_1;
        this.evaluacion_2 = evaluacion_2;
        this.evaluacion_3 = evaluacion_3;
        this.evaluacion_4 = evaluacion_4;
        this.evaluacion_5 = evaluacion_5;
        this.evaluacion_6 = evaluacion_6;
        this.evaluacion_7 = evaluacion_7;
        this.evaluacion_8 = evaluacion_8;
        this.evaluacion_9 = evaluacion_9;
        this.evaluacion_10 = evaluacion_10;
        this.porciento_1 = porciento_1;
        this.porciento_2 = porciento_2;
        this.porciento_3 = porciento_3;
        this.porciento_4 = porciento_4;
        this.porciento_5 = porciento_5;
        this.porciento_6 = porciento_6;
        this.porciento_7 = porciento_7;
        this.porciento_8 = porciento_8;
        this.porciento_9 = porciento_9;
        this.porciento_10 = porciento_10;
        this.definitiva = definitiva;
        this.letras = letras;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFecha_1() {
        return fecha_1;
    }

    public void setFecha_1(String fecha_1) {
        this.fecha_1 = fecha_1;
    }

    public String getFecha_2() {
        return fecha_2;
    }

    public void setFecha_2(String fecha_2) {
        this.fecha_2 = fecha_2;
    }

    public String getFecha_3() {
        return fecha_3;
    }

    public void setFecha_3(String fecha_3) {
        this.fecha_3 = fecha_3;
    }

    public String getFecha_4() {
        return fecha_4;
    }

    public void setFecha_4(String fecha_4) {
        this.fecha_4 = fecha_4;
    }

    public String getFecha_5() {
        return fecha_5;
    }

    public void setFecha_5(String fecha_5) {
        this.fecha_5 = fecha_5;
    }

    public String getFecha_6() {
        return fecha_6;
    }

    public void setFecha_6(String fecha_6) {
        this.fecha_6 = fecha_6;
    }

    public String getFecha_7() {
        return fecha_7;
    }

    public void setFecha_7(String fecha_7) {
        this.fecha_7 = fecha_7;
    }

    public String getFecha_8() {
        return fecha_8;
    }

    public void setFecha_8(String fecha_8) {
        this.fecha_8 = fecha_8;
    }

    public String getFecha_9() {
        return fecha_9;
    }

    public void setFecha_9(String fecha_9) {
        this.fecha_9 = fecha_9;
    }

    public String getFecha_10() {
        return fecha_10;
    }

    public void setFecha_10(String fecha_10) {
        this.fecha_10 = fecha_10;
    }

    public String getEvaluacion_1() {
        return evaluacion_1;
    }

    public void setEvaluacion_1(String evaluacion_1) {
        this.evaluacion_1 = evaluacion_1;
    }

    public String getEvaluacion_2() {
        return evaluacion_2;
    }

    public void setEvaluacion_2(String evaluacion_2) {
        this.evaluacion_2 = evaluacion_2;
    }

    public String getEvaluacion_3() {
        return evaluacion_3;
    }

    public void setEvaluacion_3(String evaluacion_3) {
        this.evaluacion_3 = evaluacion_3;
    }

    public String getEvaluacion_4() {
        return evaluacion_4;
    }

    public void setEvaluacion_4(String evaluacion_4) {
        this.evaluacion_4 = evaluacion_4;
    }

    public String getEvaluacion_5() {
        return evaluacion_5;
    }

    public void setEvaluacion_5(String evaluacion_5) {
        this.evaluacion_5 = evaluacion_5;
    }

    public String getEvaluacion_6() {
        return evaluacion_6;
    }

    public void setEvaluacion_6(String evaluacion_6) {
        this.evaluacion_6 = evaluacion_6;
    }

    public String getEvaluacion_7() {
        return evaluacion_7;
    }

    public void setEvaluacion_7(String evaluacion_7) {
        this.evaluacion_7 = evaluacion_7;
    }

    public String getEvaluacion_8() {
        return evaluacion_8;
    }

    public void setEvaluacion_8(String evaluacion_8) {
        this.evaluacion_8 = evaluacion_8;
    }

    public String getEvaluacion_9() {
        return evaluacion_9;
    }

    public void setEvaluacion_9(String evaluacion_9) {
        this.evaluacion_9 = evaluacion_9;
    }

    public String getEvaluacion_10() {
        return evaluacion_10;
    }

    public void setEvaluacion_10(String evaluacion_10) {
        this.evaluacion_10 = evaluacion_10;
    }

    public String getPorciento_1() {
        return porciento_1;
    }

    public void setPorciento_1(String porciento_1) {
        this.porciento_1 = porciento_1;
    }

    public String getPorciento_2() {
        return porciento_2;
    }

    public void setPorciento_2(String porciento_2) {
        this.porciento_2 = porciento_2;
    }

    public String getPorciento_3() {
        return porciento_3;
    }

    public void setPorciento_3(String porciento_3) {
        this.porciento_3 = porciento_3;
    }

    public String getPorciento_4() {
        return porciento_4;
    }

    public void setPorciento_4(String porciento_4) {
        this.porciento_4 = porciento_4;
    }

    public String getPorciento_5() {
        return porciento_5;
    }

    public void setPorciento_5(String porciento_5) {
        this.porciento_5 = porciento_5;
    }

    public String getPorciento_6() {
        return porciento_6;
    }

    public void setPorciento_6(String porciento_6) {
        this.porciento_6 = porciento_6;
    }

    public String getPorciento_7() {
        return porciento_7;
    }

    public void setPorciento_7(String porciento_7) {
        this.porciento_7 = porciento_7;
    }

    public String getPorciento_8() {
        return porciento_8;
    }

    public void setPorciento_8(String porciento_8) {
        this.porciento_8 = porciento_8;
    }

    public String getPorciento_9() {
        return porciento_9;
    }

    public void setPorciento_9(String porciento_9) {
        this.porciento_9 = porciento_9;
    }

    public String getPorciento_10() {
        return porciento_10;
    }

    public void setPorciento_10(String porciento_10) {
        this.porciento_10 = porciento_10;
    }

    public String getDefinitiva() {
        return definitiva;
    }

    public void setDefinitiva(String definitiva) {
        this.definitiva = definitiva;
    }

    public String getLetras() {
        return letras;
    }

    public void setLetras(String letras) {
        this.letras = letras;
    }
   
   
   
    
}//fin de la clase
