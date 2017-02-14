/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sarecni.MODELO.FORMATOS;

/**
 *
 * Created by @author Andy Cusatti on 31-may-2016
 */
public class FormatoInasistencias {
   private int nro;
   private String cedula, nombres, apellidos;    
   private String teorica_1,teorica_2,teorica_3,teorica_4,teorica_5,teorica_6,teorica_7,teorica_8,
                  teorica_9,teorica_10,teorica_11,teorica_12,teorica_13,teorica_14,teorica_15,teorica_16; 
   private String practica_1,practica_2,practica_3,practica_4,practica_5,practica_6,practica_7,practica_8,
                  practica_9,practica_10,practica_11,practica_12,practica_13,practica_14,practica_15,practica_16; 
   private int iporciento;
   private String condicion;

    public FormatoInasistencias(int nro, String cedula, String nombres, String apellidos, String teorica_1, String teorica_2, String teorica_3, String teorica_4, String teorica_5, String teorica_6, String teorica_7, String teorica_8, String teorica_9, String teorica_10, String teorica_11, String teorica_12, String teorica_13, String teorica_14, String teorica_15, String teorica_16, String practica_1, String practica_2, String practica_3, String practica_4, String practica_5, String practica_6, String practica_7, String practica_8, String practica_9, String practica_10, String practica_11, String practica_12, String practica_13, String practica_14, String practica_15, String practica_16, int iporciento, String condicion) {
        this.nro = nro;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;        
        this.teorica_1 = teorica_1;
        this.teorica_2 = teorica_2;
        this.teorica_3 = teorica_3;
        this.teorica_4 = teorica_4;
        this.teorica_5 = teorica_5;
        this.teorica_6 = teorica_6;
        this.teorica_7 = teorica_7;
        this.teorica_8 = teorica_8;
        this.teorica_9 = teorica_9;
        this.teorica_10 = teorica_10;
        this.teorica_11 = teorica_11;
        this.teorica_12 = teorica_12;
        this.teorica_13 = teorica_13;
        this.teorica_14 = teorica_14;
        this.teorica_15 = teorica_15;
        this.teorica_16 = teorica_16;
        this.practica_1 = practica_1;
        this.practica_2 = practica_2;
        this.practica_3 = practica_3;
        this.practica_4 = practica_4;
        this.practica_5 = practica_5;
        this.practica_6 = practica_6;
        this.practica_7 = practica_7;
        this.practica_8 = practica_8;
        this.practica_9 = practica_9;
        this.practica_10 = practica_10;
        this.practica_11 = practica_11;
        this.practica_12 = practica_12;
        this.practica_13 = practica_13;
        this.practica_14 = practica_14;
        this.practica_15 = practica_15;
        this.practica_16 = practica_16;
        this.iporciento = iporciento;
        this.condicion = condicion;
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

    public String getTeorica_1() {
        return teorica_1;
    }

    public void setTeorica_1(String teorica_1) {
        this.teorica_1 = teorica_1;
    }

    public String getTeorica_2() {
        return teorica_2;
    }

    public void setTeorica_2(String teorica_2) {
        this.teorica_2 = teorica_2;
    }

    public String getTeorica_3() {
        return teorica_3;
    }

    public void setTeorica_3(String teorica_3) {
        this.teorica_3 = teorica_3;
    }

    public String getTeorica_4() {
        return teorica_4;
    }

    public void setTeorica_4(String teorica_4) {
        this.teorica_4 = teorica_4;
    }

    public String getTeorica_5() {
        return teorica_5;
    }

    public void setTeorica_5(String teorica_5) {
        this.teorica_5 = teorica_5;
    }

    public String getTeorica_6() {
        return teorica_6;
    }

    public void setTeorica_6(String teorica_6) {
        this.teorica_6 = teorica_6;
    }

    public String getTeorica_7() {
        return teorica_7;
    }

    public void setTeorica_7(String teorica_7) {
        this.teorica_7 = teorica_7;
    }

    public String getTeorica_8() {
        return teorica_8;
    }

    public void setTeorica_8(String teorica_8) {
        this.teorica_8 = teorica_8;
    }

    public String getTeorica_9() {
        return teorica_9;
    }

    public void setTeorica_9(String teorica_9) {
        this.teorica_9 = teorica_9;
    }

    public String getTeorica_10() {
        return teorica_10;
    }

    public void setTeorica_10(String teorica_10) {
        this.teorica_10 = teorica_10;
    }

    public String getTeorica_11() {
        return teorica_11;
    }

    public void setTeorica_11(String teorica_11) {
        this.teorica_11 = teorica_11;
    }

    public String getTeorica_12() {
        return teorica_12;
    }

    public void setTeorica_12(String teorica_12) {
        this.teorica_12 = teorica_12;
    }

    public String getTeorica_13() {
        return teorica_13;
    }

    public void setTeorica_13(String teorica_13) {
        this.teorica_13 = teorica_13;
    }

    public String getTeorica_14() {
        return teorica_14;
    }

    public void setTeorica_14(String teorica_14) {
        this.teorica_14 = teorica_14;
    }

    public String getTeorica_15() {
        return teorica_15;
    }

    public void setTeorica_15(String teorica_15) {
        this.teorica_15 = teorica_15;
    }

    public String getTeorica_16() {
        return teorica_16;
    }

    public void setTeorica_16(String teorica_16) {
        this.teorica_16 = teorica_16;
    }

    public String getPractica_1() {
        return practica_1;
    }

    public void setPractica_1(String practica_1) {
        this.practica_1 = practica_1;
    }

    public String getPractica_2() {
        return practica_2;
    }

    public void setPractica_2(String practica_2) {
        this.practica_2 = practica_2;
    }

    public String getPractica_3() {
        return practica_3;
    }

    public void setPractica_3(String practica_3) {
        this.practica_3 = practica_3;
    }

    public String getPractica_4() {
        return practica_4;
    }

    public void setPractica_4(String practica_4) {
        this.practica_4 = practica_4;
    }

    public String getPractica_5() {
        return practica_5;
    }

    public void setPractica_5(String practica_5) {
        this.practica_5 = practica_5;
    }

    public String getPractica_6() {
        return practica_6;
    }

    public void setPractica_6(String practica_6) {
        this.practica_6 = practica_6;
    }

    public String getPractica_7() {
        return practica_7;
    }

    public void setPractica_7(String practica_7) {
        this.practica_7 = practica_7;
    }

    public String getPractica_8() {
        return practica_8;
    }

    public void setPractica_8(String practica_8) {
        this.practica_8 = practica_8;
    }

    public String getPractica_9() {
        return practica_9;
    }

    public void setPractica_9(String practica_9) {
        this.practica_9 = practica_9;
    }

    public String getPractica_10() {
        return practica_10;
    }

    public void setPractica_10(String practica_10) {
        this.practica_10 = practica_10;
    }

    public String getPractica_11() {
        return practica_11;
    }

    public void setPractica_11(String practica_11) {
        this.practica_11 = practica_11;
    }

    public String getPractica_12() {
        return practica_12;
    }

    public void setPractica_12(String practica_12) {
        this.practica_12 = practica_12;
    }

    public String getPractica_13() {
        return practica_13;
    }

    public void setPractica_13(String practica_13) {
        this.practica_13 = practica_13;
    }

    public String getPractica_14() {
        return practica_14;
    }

    public void setPractica_14(String practica_14) {
        this.practica_14 = practica_14;
    }

    public String getPractica_15() {
        return practica_15;
    }

    public void setPractica_15(String practica_15) {
        this.practica_15 = practica_15;
    }

    public String getPractica_16() {
        return practica_16;
    }

    public void setPractica_16(String practica_16) {
        this.practica_16 = practica_16;
    }

    public int getIporciento() {
        return iporciento;
    }

    public void setIporciento(int iporciento) {
        this.iporciento = iporciento;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }
    
    
    

}
