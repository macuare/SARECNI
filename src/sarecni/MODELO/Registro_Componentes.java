/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sarecni.MODELO;

import sarecni.MODELO.FORMATOS.FormatoNotas;
import java.text.DecimalFormat;
import java.util.LinkedList;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import sarecni.MODELO.FORMATOS.FormatoInasistencias;

/**
 *
 * @author ANDY
 */
public class Registro_Componentes {
   private Archivos archivo; 
   private Registro_Parametros rp;
   private Ventanas_Auxiliares va;
   public static String temporal = null;

    public Registro_Componentes() {
        System.out.println("inicializando registos");
       //this.ic = ic;
       
       rp = new Registro_Parametros();
       archivo = new Archivos();       
       rp.inicializando_registros();
       va = new Ventanas_Auxiliares();
       
    }
   
   
    public void menu_actas(Menu m){
       LinkedList<String> aux = rp.secciones_materias();
       Menu seccion = null;
       MenuItem materia = null;
       boolean coincidencia = false;
       
      
       
       m.getItems().clear();
       
       
       for(int i=0; i<aux.size(); i++){//recorriendo secciones_materias
           
           if(m.getItems().isEmpty()){//si no hay secciones agregadas aun.
               seccion = new Menu(aux.get(i).split(";")[0]);//agregando la seccion
               materia = new MenuItem(aux.get(i).split(";")[1]);//agregando la materia
               //materia.addEventHandler(ActionEvent.ACTION, m.getOnAction());//agregando el manejador del evento
               materia.setOnAction(m.getOnAction());
               
               seccion.getItems().add(materia);//colocando la materia dentro de la seccion
               m.getItems().add(seccion);//agregando la seccion dentro del menu principal               
           }else{//si ya existen secciones agregadas, se verifica el registro
               for(int x=0; x<m.getItems().size(); x++){//recorriendo el menu principal
                //  System.out.println("nombre seccion: "+m.getItems().get(x).getText());
                   seccion = (Menu) m.getItems().get(x);
                   if(aux.get(i).split(";")[0].equalsIgnoreCase(seccion.getText())){//si coinciden los nombres de secciones
                       materia = new MenuItem(aux.get(i).split(";")[1]);//se agrega la nueva materia a la seccion que ya existe
                       //materia.addEventHandler(ActionEvent.ACTION, m.getOnAction());//agregando el manejador del evento
                       materia.setOnAction(m.getOnAction());
                       seccion.getItems().add(materia);
                       coincidencia = true;
                       break; //se rompe la busqueda
                   }else{
                       coincidencia = false;
                   }
               }//fin recorrido menu principal
           
               if(coincidencia == false){//si despues del recorrido no se hallo la seccion, entonces se agrega
                   seccion = new Menu(aux.get(i).split(";")[0]);//agregando la seccion
                   materia = new MenuItem(aux.get(i).split(";")[1]);//agregando la materia
                   //materia.addEventHandler(ActionEvent.ACTION, m.getOnAction());//agregando el manejador del evento
                   materia.setOnAction(m.getOnAction());
                   seccion.getItems().add(materia);//colocando la materia dentro de la seccion
                   m.getItems().add(seccion);//agregando la seccion dentro del menu principal               
               }
           }
           
       }//fin recorrido secciones_materias
       
    }
    
    
    public void cargando_estudiantes(MenuItem materia, ObservableList<FormatoNotas> datos_notas, TableView<FormatoNotas> Acta_Notas, 
                                     ObservableList<FormatoInasistencias> datos_inasistencias, TableView<FormatoInasistencias> Acta_Inasistencias){
        
        LinkedList<String> aux = rp.informacion_estudiantes(materia.getParentMenu().getText(), materia.getText());         
        
        datos_notas.clear();
        datos_inasistencias.clear();
        
        aux.stream().forEachOrdered(dato -> {
            String elemento[] = dato.split(";");
            datos_notas.add(new FormatoNotas(Integer.valueOf(elemento[1]),
                                              elemento[2],
                                              elemento[3], 
                                              elemento[4], 
                                              null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));                  
           
             datos_inasistencias.add(new FormatoInasistencias(Integer.valueOf(elemento[1]),
                                              elemento[2],
                                              elemento[3], 
                                              elemento[4],                                               
                                              "20", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
                                              "30", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
                                              100, "REPROBADO"));                        
        });
        
        Acta_Notas.setItems(datos_notas);
        Acta_Inasistencias.setItems(datos_inasistencias);
    }
    
    
    public void cargando_parametros_acta(MenuItem mi, Label Periodo, Label Uc, Label Carrera, Label Seccion, Label CI, Label Materia, Label Profesor){
        String aux[] = rp.informacion_acta(mi.getText(),mi.getParentMenu().getText()); 
        
        Materia.setText(aux[0]);
        Carrera.setText(aux[1]);
        Uc.setText(aux[2]);
        Seccion.setText(aux[3]);
        Periodo.setText(aux[4]);
        Profesor.setText(aux[5]);  
        CI.setText(aux[6]);
    }
    
    public void cargando_evaluaciones_acta(MenuItem mi, TableView<FormatoNotas> Acta_Notas, ProgressIndicator Acumulado){
       int indice = 0;
       double porcentajes = 0.0;
       LinkedList<String> ie = rp.informacion_evaluaciones(mi.getText(), mi.getParentMenu().getText());
    
       
        //System.out.println("columnas: "+Acta_Notas.getColumns().size());
        for(TableColumn<FormatoNotas, ?> columna : Acta_Notas.getColumns()){ // Recorriendo las columnas. el signo de interrogacion es porque hay columnas tipo entero y string como contenedores de otras columnas
           // System.out.println("revisando cada columna: "+columna.getText()+" - "+columna.getColumns().size());
            if(columna.getColumns().size() >= 2 ){ // Si identifica si es una columna que contiene 2 columnas internamente
                if(indice < ie.size()){ // Se verifica no superar la cantidad de evaluaciones ofertadas
                    String valores[] = ie.get(indice).split(";");
                    columna.setVisible(true); // Haciendo visibles las columnas a utilizar
                    columna.setText(valores[1]); // Fecha de la evaluacion
                    columna.getColumns().get(0).setText(valores[2]); // Tipo de evaluacion
                    columna.getColumns().get(1).setText(valores[3]+"%"); // Porcentaje
                    porcentajes = porcentajes + (Double.valueOf(valores[3])/100.0);
                    indice++; // Incrementando el contador                
                    
                }else{ // Reescribiendo las columnas con un valor por defecto cuando ya no hay evaluaciones
                    if(!columna.getText().equalsIgnoreCase("RESUMEN")){ // Se reescriben las columnas de 2 distinta a la llamada RESUMEN
                        columna.setText("---"); // Fecha de la evaluacion
                        columna.getColumns().get(0).setText("---"); // Tipo de evaluacion
                        columna.getColumns().get(1).setText("---"); // Porcentaje
                        columna.setVisible(false); // Haciendo invisible las columnas que no estan siendo utilizadas
                    }
                }
            }
        }
        
        Acumulado.setProgress(porcentajes);
        if(porcentajes >= 1.0){
            Text doneText = (Text) Acumulado.lookup(".text.percentage");
            doneText.setText("Completado");
            Acumulado.applyCss();
        }
        
    }
    
    private void notas_filas(FormatoNotas fn, int opcion, String evaluacion, String porciento){
        
        switch(opcion){
            case 1:
                fn.setEvaluacion_1(evaluacion); fn.setPorciento_1(porciento);
            break;
            case 2:
                fn.setEvaluacion_2(evaluacion); fn.setPorciento_2(porciento);
            break;
            case 3:
                fn.setEvaluacion_3(evaluacion); fn.setPorciento_3(porciento);
            break;    
            case 4:
                fn.setEvaluacion_4(evaluacion); fn.setPorciento_4(porciento);
            break;    
            case 5:
                fn.setEvaluacion_5(evaluacion); fn.setPorciento_5(porciento);
            break;
            case 6:
                fn.setEvaluacion_6(evaluacion); fn.setPorciento_6(porciento);
            break;    
            case 7:
                fn.setEvaluacion_7(evaluacion); fn.setPorciento_7(porciento);
            break;
            case 8:
                fn.setEvaluacion_8(evaluacion); fn.setPorciento_8(porciento);
            break;
            case 9:
                fn.setEvaluacion_9(evaluacion); fn.setPorciento_9(porciento);
            break;    
            case 10:
                fn.setEvaluacion_10(evaluacion); fn.setPorciento_10(porciento);
            break;
            case 11:          
                fn.setDefinitiva(evaluacion); fn.setLetras(porciento);
            break;    
            default: 
                System.out.println("OPCION NO RECONOCIDA");
            break;    
        
        }
    
    }
    
    public void cargando_notas_estudiantes(MenuItem mi, ObservableList<FormatoNotas> datos_notas, TableView<FormatoNotas> Acta_Notas){
        LinkedList<String> cedulas_actas = new LinkedList<>();
        LinkedList<String> notas_ordenadas = new LinkedList<>();
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat df2 = new DecimalFormat("00");
        double acumulado = 0.0;
        String cedula_actual = ""; // Se almacena la cedula de control para poder diferenciar cuando se ha pasado por una cedula distinta. discriminador
        
       // System.out.println("Cant. Estudiantes: "+datos_notas.size());      
        
       for(FormatoNotas dn : datos_notas){ // Copiando las cedulas de la tabla de actas de notas
           cedulas_actas.add(dn.getCedula());
       }
      
       notas_ordenadas = rp.notas_acta(mi.getText(), mi.getParentMenu().getText(),cedulas_actas); // Extrayendo las notas acomodadas de los estudiantes de la lista
       
       // System.out.println("ordenadas: "+notas_ordenadas.size());
       //AGREGANDO LAS NOTAS POR CADA ESTUDIANTE
       for(String aux : notas_ordenadas){ // Recorriendo las notas ordenadas
          String[] dato = aux.split(";"); // "id;cedula;fecha;estrategia;porciento;nota"
          // System.out.println("contenido: "+aux);
          for(FormatoNotas fn : datos_notas){ // Recorriendo las cedulas del acta de notas
            //  System.out.println("comparando: "+fn.getCedula()+" <-> "+dato[1]);
               
              if(fn.getCedula().equalsIgnoreCase(dato[1])){ // Si las cedulas coinciden
                  if(!cedula_actual.equalsIgnoreCase(dato[1])){acumulado = 0; cedula_actual = dato[1]; } // En caso de que sea una cedula distinta a la analizada anteriormente entonces se resetea el acumulador y se almacena la nueva cedula bajo analisis
                      
                  for(TableColumn<FormatoNotas,?> columna : Acta_Notas.getColumns()){ // Recorriendo las columnas del acta de notas           
                        if(columna.getColumns().size() >= 2 && columna.isVisible()){ // Si identifica si es una columna que contiene 2 columnas internamente y esta disponible visible
                            String fecha = columna.getText(); // Reteniendo el nombre de interes de cada columna para comparacion
                            String tipo_eva = columna.getColumns().get(0).getText();
                            String porciento = columna.getColumns().get(1).getText().substring(0, (columna.getColumns().get(1).getText().length()-1) );
                            String id_col = columna.getId(); // ejm: Fecha1
                          //  System.out.println("analisis: "+fecha+" - "+tipo_eva+" - "+porciento);
                          //  System.out.println("--------: "+dato[2]+" - "+dato[3]+" - "+dato[4]); 
                               
                               if(fecha.equalsIgnoreCase(dato[2]) && tipo_eva.equalsIgnoreCase(dato[3]) && porciento.equalsIgnoreCase(dato[4])){ // Si es la columna de interes de la fila en cuestion
                                   
                                   double calculo = (double)(Integer.valueOf(dato[4])/100.0)*Integer.valueOf(dato[5]);
                                   acumulado = acumulado + calculo;
                                 //  System.out.println(dato[1]+" nota: "+dato[4]+" x "+dato[5]+" = "+calculo);
                                   //System.out.println(" -> acumulado: "+acumulado);
                                   
                                   this.notas_filas( // Agregando nota en la columna de interes
                                                    fn, 
                                                    Integer.valueOf(id_col.substring(5)), 
                                                    dato[5],
                                                    df.format(calculo)
                                   ); 
                                   
                                   this.notas_filas(// Agregando el acumulado en el campo de interes
                                                    fn, 
                                                    11,
                                                    String.valueOf(Math.round(acumulado)),//df2.format(Math.round(acumulado)),
                                                    rp.definitivas_letras(Integer.valueOf(df2.format(acumulado)))
                                   );
                                   
                                   break; // Se sale del ciclo de busqueda de la columna. ya se encontro
                                   
                               }
                               
                         }
                    }
                  
                 break; // salgo del ciclo y avanzo a la siguiente nota
              }
          } // Fin recorrido cedulas actas notas
          
       }// Fin recorrido notas ordenadas
       
    }
    
/**Metodo que permite desplegar de forma modal la ventana para el tratamiento de las evaluaciones por materia */   
public void ventana_evaluaciones(){
    Parent componente = null;
    
    componente = va.cargar("/sarecni/VISTA/OFERTAS.fxml");
    va.desplegar(componente);  
}    

public void ventana_notas(){
    Parent componente = null;
    
    componente = va.cargar("/sarecni/VISTA/NOTAS.fxml");
    va.desplegar(componente);  
}    

public void ventana_notas(String cedula){ System.out.println("cargando notas: "+cedula);   
    Registro_Notas rn;
    
    System.out.println("verificando temporal: "+temporal);
    Parent componente = null;
    componente = va.cargar("/sarecni/VISTA/NOTAS.fxml");       
    rn = new Registro_Notas((ComboBox) va.modificacion_avanzada(componente, "Seccion_Materia"), 
                            (TableView) va.modificacion_avanzada(componente, "Tabla_Notas"), 
                            (Label) va.modificacion_avanzada(componente, "Posicion"),  
                            (Label) va.modificacion_avanzada(componente, "Estudiante"), 
                            (Label) va.modificacion_avanzada(componente, "Acumulado"), 
                            (Label) va.modificacion_avanzada(componente, "Evaluado"), 
                            (Label) va.modificacion_avanzada(componente, "Estado"), 
                            (Label) va.modificacion_avanzada(componente, "Restante"));    
    
    va.modificar(componente, "Label", "Estudiante", cedula);    
    rn.inicializacion_avanzada(cedula);
    va.desplegar(componente);
}

    
    
}//fin de la clase
