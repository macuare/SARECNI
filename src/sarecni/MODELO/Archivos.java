/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sarecni.MODELO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author ANDY
 */
public class Archivos {

    public Archivos() {
    }
    
   
    public LinkedList<String> leyendo_archivo(String ruta){
         LinkedList<String> elementos = new LinkedList<>();
         
        try (Stream<String> flujo = Files.lines(Paths.get(ruta))){
               
            flujo.forEach(elementos::add);
          //  elementos.stream().forEach(System.out::println);
                    
        } catch (IOException e) {
            System.out.println("Error leyendo archivo. "+ruta);
            e.printStackTrace();
	}
        
        return elementos;
    }
    
     public LinkedList<String> leyendo_archivox(String ruta){
        FileReader lector = null;
        LinkedList<String> elementos = null;
        File archivo = new File(ruta);
        
        if(archivo.exists() && archivo.isFile()){
                try {

                    lector = new FileReader(archivo);
                    BufferedReader memoria = new BufferedReader(lector);
                    elementos = new LinkedList<>();

                    while(true){//leyendo linea a linea
                       String texto = memoria.readLine();
                       if(texto == null || texto.isEmpty()){ 
                           break;
                       }else{
                           elementos.add(texto);
                       }
                    }

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Registro_Parametros.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Registro_Parametros.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        lector.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Registro_Parametros.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        }else{
            System.out.println("EL elemento señalado en la ruta, no existe: "+ruta);
        }
    return elementos;
    }
    
    
    public void ver_registros(LinkedList<String> registros){
       
      if(registros != null){  
           System.out.println("Capacidad: "+registros.size());
       for(int i=0; i<registros.size(); i++){
           System.out.println(" "+i+" | "+registros.get(i));
       }
      }
    
    
    }
    
    
    
     /**Metodo que permite agrupar por un registro en especifico. se especifica la longitud minima para ser considerado por el filtro */
    public void filtro(LinkedList<String> aux, String registro, int longitud){
        boolean coincidencia = false;
        if(registro.length()>longitud && registro != null){//evitando registros vacios
            if(aux.isEmpty()){
                aux.add(registro); //agregando primer registro
            }else{
                for(int i=0; i<aux.size(); i++){
                    if(registro.equalsIgnoreCase(aux.get(i))){
                        coincidencia = true;//existe. se sale del ciclo
                        break;
                    }else{
                        coincidencia = false;
                    }
                }
                
                if(coincidencia == false) aux.add(registro);//despues de revisar todo el registro no encontro nada, entonces se agrega el elemento
            }    
            
        }
    }
    
     public void filtro_con_indice(LinkedList<String> aux, String registro, int longitud){ 
         boolean coincidencia = false;
         
         if(registro.length() > longitud && registro != null){
             
            if(aux.isEmpty()){             
                aux.add("1;"+registro);//seccion 

            }else{
                for(int s=0; s<aux.size(); s++){//recirriendo los auxiliares
                    if(aux.get(s).split(";")[1].equalsIgnoreCase(registro)){
                        coincidencia = true;
                        break;
                    }else{
                        coincidencia = false;
                    }
                }//fin recorrido auxiliares

                     if(coincidencia == false){
                      aux.add(String.valueOf(aux.size()+1)+";"+registro);   
                     } 
            }
            
         }
    }
     /**Este metodo fue modificado para ser usado con el pensum */ 
    public void filtro_con_indice_2(LinkedList<String> aux, String registro, int longitud){ 
         boolean coincidencia = false;
         
         if(registro.length() > longitud && registro != null){
             
            if(aux.isEmpty()){             
                aux.add("1;"+registro);//seccion 

            }else{
                for(int s=0; s<aux.size(); s++){//recirriendo los auxiliares
                    if(aux.get(s).equalsIgnoreCase((s+1)+";"+registro)){
                        
                        coincidencia = true;
                        break;
                    }else{
                        coincidencia = false;
                    }
                }//fin recorrido auxiliares

                     if(coincidencia == false){
                      aux.add(String.valueOf(aux.size()+1)+";"+registro);   
                     } 
            }
            
         }
    }
    
    
    public void escribir_archivo(String direccion, LinkedList<String> datos){
        FileWriter escritor = null;
        PrintWriter lapiz = null;
        System.out.println(direccion);

    if(direccion != null && datos != null){
        try {
            File archivo = new File(direccion);
            escritor = new FileWriter(archivo,true);
            lapiz = new PrintWriter(escritor);
            
            if(archivo.exists()){//solo si el archivo existe
                for(int i=0; i<datos.size(); i++){//recorriendo los datos almacenados
                    
                    lapiz.print("\n"+datos.get(i));//escribiendo linea a linea                                         
                }// fin recorrido datos almacenados
            }else{
                System.out.println("El archivo no existe");
            }
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                escritor.close();
            } catch (IOException ex) {
                Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    
    }
    }
    
    
}//fin de la clase
