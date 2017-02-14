/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarecni.MODELO;

import java.text.DecimalFormat;
import java.util.Calendar;

/**
 *
 * @author andy
 */
public class Calendario {

    public Calendario() {
    }
    
    private String dia_semana(int dia_numero){
        String dia = null;
            switch(dia_numero){
                case Calendar.SUNDAY: dia = "Domingo"; break;
                case Calendar.MONDAY: dia = "Lunes"; break;
                case Calendar.TUESDAY: dia = "Martes"; break;    
                case Calendar.WEDNESDAY: dia = "Miercoles"; break;    
                case Calendar.THURSDAY: dia = "Jueves"; break;
                case Calendar.FRIDAY: dia = "Viernes"; break;
                case Calendar.SATURDAY: dia = "Sabado"; break;    
                default: break;
            }
    
        return dia;
    }
    
    private String mes_del_año(int mes_numero){
        String mes = null;
            switch(mes_numero){
                case 0: mes = "Enero"; break;    
                case 1: mes = "Febrero"; break;
                case 2: mes = "Marzo"; break;
                case 3: mes = "Abril"; break;
                case 4: mes = "Mayo";  break;
                case 5: mes = "Junio"; break;    
                case 6: mes = "Julio"; break;        
                case 7: mes = "Agosto"; break;    
                case 8: mes = "Septiembre"; break;        
                case 9: mes = "Octubre"; break;        
                case 10: mes = "Noviembre"; break;        
                case 11: mes = "Diciembre"; break;        
                default: break;
            }
        return mes;
    }
    
    public String estructura_fecha(String fecha){
        String texto = null;
        DecimalFormat df = new DecimalFormat("00");
        // 27/09/2015
        String aux[] = fecha.split("/");
        Calendar calendario = Calendar.getInstance();
        calendario.set(Integer.valueOf(aux[2]), Integer.valueOf(aux[1])-1, Integer.valueOf(aux[0]));
        
       // System.out.println("FECHA: "+fecha+" - "+Calendar.DAY_OF_MONTH+"/"+Calendar.MONTH+"/"+Calendar.YEAR+" ||| "+aux[2]+aux[1]+aux[0]);
       
        texto = this.dia_semana(calendario.get(Calendar.DAY_OF_WEEK))+", "+
                df.format(calendario.get(Calendar.DAY_OF_MONTH))+" de "+
                this.mes_del_año(calendario.get(Calendar.MONTH))+" de "+
                calendario.get(Calendar.YEAR);
        
        return texto;
    }
    
    
    
    
}
