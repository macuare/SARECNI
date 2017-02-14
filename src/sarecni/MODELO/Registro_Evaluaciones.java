/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarecni.MODELO;

import java.time.LocalDate;
import sarecni.MODELO.FORMATOS.FormatoEvaluacionesOfertadas;
import java.util.LinkedList;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;

/**
 *
 * @author ANDY
 */
public class Registro_Evaluaciones {
    
    private Archivos archivo;
    private Ventanas_Auxiliares va;
    private Registro_Parametros rp;
  
    /**Este registro almacena todas las evaluaciones que han sido ofertada.</br> id;PC;20%;CP-401;GERENCIA EDUCATIVA;27/09/2015*/ 
    private LinkedList<String> todas_evaluaciones; 
   
        
    public Registro_Evaluaciones() {
        archivo = new Archivos();      
        rp = new Registro_Parametros();
        rp.inicializando_registros();
        todas_evaluaciones = rp.todas_evaluaciones();
        va = new Ventanas_Auxiliares();
    }
    
    private void actualizar_evaluaciones(){        
        rp.inicializando_registros();      
        todas_evaluaciones = rp.todas_evaluaciones(); 
    }
    
    /**Este metodo filtra las evaluaciones de interes mediante la seleccion de la columna como discriminante.
     * </br> estructura: id;PC;20%;CP-401;GERENCIA EDUCATIVA;27/09/2015
     * 
     @param columna: Representa la columna por donde se quiere filtrar.
     @return Retorna un arreglo tipo cadena con los valores de interes sin repeticiones.*/
    private LinkedList<String> filtro(int columna){
        LinkedList<String> elementos = new LinkedList<>();
        todas_evaluaciones.stream()
                          .map(s -> s.split(";")[columna])
                          .distinct()
                          .forEach(elementos::add);
        return elementos;
    }
    
    private void ordenarEvaluacionesPorFecha(){
        LinkedList<String> elementos = new LinkedList<>();
        
        this.ordenarEvaluaciones(4);
        this.filtro(4).stream()
                      .forEach(item -> { // recorriendo cada item agrupado.
                         todas_evaluaciones.stream()
                                           .filter(s -> item.equalsIgnoreCase(s.split(";")[4])) // filtrando por item
                                           .map(registro -> registro) // mapeando los registros de forma temporal
                                           .sorted((s1,s2) ->  // comparando y ordenando por fecha
                                             LocalDate.of( // convirtiendo el registro como fecha
                                                          Integer.valueOf(s1.split(";")[5].split("/")[2]), //año
                                                          Integer.valueOf(s1.split(";")[5].split("/")[1]), //mes
                                                          Integer.valueOf(s1.split(";")[5].split("/")[0]) //dias
                                             )
                                             .compareTo(
                                             LocalDate.of(
                                                          Integer.valueOf(s2.split(";")[5].split("/")[2]), //año
                                                          Integer.valueOf(s2.split(";")[5].split("/")[1]), //mes
                                                          Integer.valueOf(s2.split(";")[5].split("/")[0]) //dias
                                             )
                                                        )
                          )
                          .forEach(elementos::add); // agregar todos los registros por cada item usado como discriminante
                      });
        
        todas_evaluaciones.clear(); // limpiando los registros
        todas_evaluaciones.addAll(elementos); // agregando los registros ordenados previamente
    
    }
    
    /**Este metodo permite ordenar y discriminar por columna de interes de una cadena de caracteres separados por ";". 
     @param columna: Se refiere a la posicion de la columna que desea discriminar
     */     
    private void ordenarEvaluaciones(int columna){
        LinkedList<String> elementos = new LinkedList<>();
      
        todas_evaluaciones.stream()
                          .sorted((s1,s2) -> s1.split(";")[columna].compareTo(s2.split(";")[columna])) // comparando y ordenando por la columna de interes
                          .forEach(elementos::add); 
        todas_evaluaciones.clear(); // limpiando los registros
        todas_evaluaciones.addAll(elementos); // agregando los registros ordenados previamente
      
    }
    
    public void evaluaciones_ofertadas(ObservableList<FormatoEvaluacionesOfertadas> informacion, TableView<FormatoEvaluacionesOfertadas> Evaluaciones_Ofertadas){
       //System.out.println("evaluaciones ofertadas "+todas_evaluaciones.size());
      if(!informacion.isEmpty()) informacion.clear();      
      //this.ordenarEvaluaciones(4); // ordenando las evaluaciones por materia
      this.ordenarEvaluacionesPorFecha();
      todas_evaluaciones.stream()
                        .forEach(s -> informacion.add(
                                new FormatoEvaluacionesOfertadas(
                                        Integer.valueOf(s.split(";")[0]), 
                                        s.split(";")[1], 
                                        s.split(";")[2], 
                                        s.split(";")[5], 
                                        s.split(";")[3], 
                                        s.split(";")[4]
                                )
                               ));
       
      Evaluaciones_Ofertadas.setItems(informacion);     
    }
    
    private LinkedList<String> adecuacion_secciones_materias(){
        LinkedList<String> sm = rp.secciones_materias(); // Estrategia evaluativas cargadas
        int i = 0;
        
        for(String aux : sm){
            sm.set(i, aux.replace(";", " - "));
            i++;
        }
        
        return sm;
    }
    
     private LinkedList<String> adecuacion_registros_estrategias(){        
        LinkedList<String> cre = new LinkedList<>();
      
        rp.cargando_registros_estrategias()  // cargando estrategias
          .stream()                
          .forEach(s -> cre.add(s.getDescripcion()));
        
        return cre;
    }
    
    /**Este metodo se encarga de estructurar la informacion de interes en los parametros necesarios siguiendo un patron.
     @param seccion_materia: Variable que contiene el nombre de la seccion y materia de interes simultaneamente
     @param estrategia: Este se refiere al nombre de la evaluacion de interes.
     @param ponderacion: Porcentaje de la evaluacion.
     @param fecha: Es la fecha en la que se realizara la evaluacion
     @return retorna una estructura de la siguiente manera. ejm: 5;20;1;GERENCIA EDUCATIVA;2015-10-24*/ 
    private String estructura_evaluacion(String seccion_materia, String estrategia, String ponderacion, String fecha){
        String estructura = null, id;
        String tipo = null, porciento = null, seccion = null, materia = null;
              
        //id;PC;20%;CP-401;GERENCIA EDUCATIVA;27/09/2015
        // 5;20;1;GERENCIA EDUCATIVA;2015-10-24
       
        id = rp.id_disponible(todas_evaluaciones);        
        tipo = String.valueOf(rp.cargando_registros_estrategias().stream()
                                                                 .filter(s -> s.getDescripcion().equalsIgnoreCase(estrategia))
                                                                 .findFirst()
                                                                 .get()
                                                                 .getId()
        );
        
        porciento = ponderacion.replace("%", "");
        seccion = String.valueOf(rp.datos_secciones().stream()
                                                     .filter(s -> s.getSeccion().equalsIgnoreCase(seccion_materia.split(" - ")[0]))
                                                     .findFirst()
                                                     .get()
                                                     .getId());
        
        materia = seccion_materia.split(" - ")[1];
        
        estructura = (id+";"+tipo+";"+porciento+";"+seccion+";"+materia+";"+fecha);
        
        return estructura;    
    }
    
    private void guardar_evaluacion(String seccion_materia, String estrategia, String ponderacion, String fecha ){
        LinkedList<String> estructura = new LinkedList<>();                
        estructura.add(this.estructura_evaluacion(seccion_materia, estrategia, ponderacion, fecha));       
        
        archivo.escribir_archivo(rp.direccion_actual()+"Evaluaciones.csv", estructura);    
    } 
     
    public void ofertar_evaluacion(){
        LinkedList<String> pon = new LinkedList<>(); pon.add("5%");pon.add("10%");pon.add("15%");pon.add("20%");pon.add("25%");pon.add("30%");
        
        
        
        
        Parent componente = null;
        componente = va.cargar("/sarecni/VISTA/Auxiliares/NUEVA_OFERTA.fxml");
                    va.modificar(componente, "ComboBox", "Seccion_Materia", this.adecuacion_secciones_materias());//modificando el contenido de un elemento de la vista
                    va.modificar(componente, "ComboBox", "Estrategia", this.adecuacion_registros_estrategias());//modificando el contenido de un elemento de la vista
                    va.modificar(componente, "ComboBox", "Ponderacion", pon);//modificando el contenido de un elemento de la vista
        
        va.desplegar(componente);                
        
        if(((DatePicker)va.modificacion_avanzada(componente, "Fecha")).getValue() != null){  //comprobando que no dejen la casilla de la fecha en blanco
        
            if(va.mensaje_confirmacion("CONFIRMACIÓN", "DESEA GUARDAR LA EVALUACIÓN OFERTADA")){
                String seccion_materia = va.recuperar(componente, "ComboBox", "Seccion_Materia"),
                       estrategia = va.recuperar(componente, "ComboBox", "Estrategia"),
                       ponderacion =  va.recuperar(componente, "ComboBox", "Ponderacion"),
                       fecha = va.recuperar(componente, "DatePicker", "Fecha");
               
                if(this.limiteEvaluaciones(seccion_materia, ponderacion)){
                  this.guardar_evaluacion(seccion_materia, estrategia, ponderacion, fecha);
                  this.actualizar_evaluaciones();                
                  va.mensaje_informacion("NOTIFICACIÓN", "LA OFERTA FUE ALMACENADO CON ÉXITO...!!!");
                }
               
            }else{
                va.mensaje_informacion("NOTIFICACIÓN", "PROCESO DE OFERTA CANCELADO.");
            }
            
        }else{
            va.mensaje_informacion("ADVERTENCIA", "Esta oferta no se puede guardar, debido a que no selecciono una fecha para la misma, por favor vuelva intentarlo.");
        }
    }
    
    /** Este metodo se encarga de modificar una linea de interes tomando en cuenta el id. Para ello se debe insertar una id
     * @param id_interes: es el id de la evaluacion al que se desea alterar
     * @param seccion_materia: es la seccion y materia bajo analisis
     * @param estrategia: es el tipo de evaluacion que se realizo
     * @param ponderacion: el porcentaje de la evaluacion
     * @param fecha: el dia en que se hara la evaluacion
     */
    private void modificar_registro_evaluacion(String id_interes, String seccion_materia, String estrategia, String ponderacion, String fecha ){
        LinkedList<String> estructura = new LinkedList<>();                
        String aux = this.estructura_evaluacion(seccion_materia, estrategia, ponderacion, fecha);
          
        //estructura = (id+";"+tipo+";"+porciento+";"+seccion+";"+materia+";"+fecha);
        estructura.add(id_interes+";"+
                       aux.split(";")[1]+";"+
                       aux.split(";")[2]+";"+
                       aux.split(";")[3]+";"+
                       aux.split(";")[4]+";"+
                       aux.split(";")[5]); 
        
        archivo.escribir_archivo(rp.direccion_actual()+"Evaluaciones.csv", estructura);    
    } 
    
    /**Este método modifica la evaluación seleccionada de la tabla.
     @param Evaluaciones_Ofertadas: Es la tabla de interes donde se muestra el contenido de las ofertas de las evaluaciones (TableView)      
     */
    public void modificar_evaluacion(TableView<FormatoEvaluacionesOfertadas> Evaluaciones_Ofertadas){
        if(Evaluaciones_Ofertadas.getSelectionModel().isEmpty()){ // si no hay seleccion de algun registro
            va.mensaje_informacion("NOTIFICACIÓN", "Disculpe, pero debe al menos seleccionar un registro...!!!");
        }else{ // si selececciono algun registro de la tabla
            
                LinkedList<String> pon = new LinkedList<>(); pon.add("5%");pon.add("10%");pon.add("15%");pon.add("20%");pon.add("25%");pon.add("30%");
                ObservableList<FormatoEvaluacionesOfertadas> datos = Evaluaciones_Ofertadas.getItems();
                int indice = Evaluaciones_Ofertadas.getSelectionModel().getSelectedIndex();

                Parent componente = null;
                componente = va.cargar("/sarecni/VISTA/Auxiliares/NUEVA_OFERTA.fxml");
                            
                             va.modificar(componente, "ComboBox", "Seccion_Materia", this.adecuacion_secciones_materias());//modificando el contenido de un elemento de la vista
                             ComboBox aux =  (ComboBox) va.modificacion_avanzada(componente, "Seccion_Materia"); // Seleccionando item
                                      aux.getSelectionModel().select(datos.get(indice).getSeccion()+" - "+datos.get(indice).getMateria());
                                      aux.setDisable(true);
                                      aux.setOpacity(0.8);
                             va.modificar(componente, "ComboBox", "Estrategia", this.adecuacion_registros_estrategias());//modificando el contenido de un elemento de la vista
                                      aux =  (ComboBox) va.modificacion_avanzada(componente, "Estrategia"); // Seleccionando item
                                      aux.getSelectionModel().select(datos.get(indice).getEstrategia());
                             va.modificar(componente, "ComboBox", "Ponderacion", pon);//modificando el contenido de un elemento de la vista
                                      aux =  (ComboBox) va.modificacion_avanzada(componente, "Ponderacion"); // Seleccionando item
                                      aux.getSelectionModel().select(datos.get(indice).getPonderacion());
                             va.modificar(componente, "DatePicker", "Fecha", datos.get(indice).getFecha());
                             Button boton = (Button)va.modificacion_avanzada(componente, "Agregar");
                                    boton.setText("MODIFICAR");

                va.desplegar(componente);                

                if(va.mensaje_confirmacion("CONFIRMACIÓN", "DESEA MODIFICAR LA EVALUACIÓN OFERTADA")){            
                    String seccion_materia = va.recuperar(componente, "ComboBox", "Seccion_Materia"),
                           estrategia = va.recuperar(componente, "ComboBox", "Estrategia"),
                           ponderacion =  va.recuperar(componente, "ComboBox", "Ponderacion"),
                           fecha = va.recuperar(componente, "DatePicker", "Fecha");

                    this.modificar_registro_evaluacion(String.valueOf(datos.get(indice).getId()),seccion_materia, estrategia, ponderacion, fecha);
                    this.actualizar_evaluaciones();

                    va.mensaje_informacion("NOTIFICACIÓN", "LA OFERTA FUE CAMBIADA CON ÉXITO...!!!");

                }else{
                    va.mensaje_informacion("NOTIFICACIÓN", "PROCESO DE MODIFICACIÓN CANCELADO.");
                }
                
        }
        
    }
    
    /**Este metodo se encarga de verificar si la evaluacion que fue ofertada tiene notas asociadas
     * @param id_evaluacion: Es el id de interes que se quiere analizar
     * @return booleano verdadero si existe vinculacion.*/
    private boolean comprobacion_vinculacion(String id_evaluacion){
        boolean existe = true;
        
        existe = rp.getNotas().stream()
                              .filter(nota -> String.valueOf(nota.getIdEvaluaciones()).equalsIgnoreCase(id_evaluacion)) // Si existe coincidencia con la id
                              .findFirst().isPresent();
       
        return existe;
    }
    
    /**Este metodo se encarga de eliminar todas las notas de los estudiantes que esten asociadas a la id de la evaluacion en cuestion 
     @param id_evaluacion: Representa la id que se desea buscar de toda la lista de notas.     
     */
    private void eliminacion_masiva_nota(String id_evaluacion){     
        LinkedList<String> contenido = new LinkedList<>();                       
      
        /*1;23;1;18
          2;23;4;17
          3;12;1;12*/ 
        rp.getNotas().stream()
                     .filter(nota -> String.valueOf(nota.getIdEvaluaciones()).equalsIgnoreCase(id_evaluacion)) // Si existe coincidencia con la id 
                     .forEach(nota -> contenido.add(
                                                     nota.getId()+"x;"+
                                                     nota.getIdEstudiantes()+";"+
                                                     nota.getIdEvaluaciones()+";"+
                                                     nota.getNota()+"\n"));
        if(!contenido.isEmpty()){
            contenido.set(contenido.size()-1, contenido.getLast().substring(0,contenido.getLast().length()-1)); // Es para solamente eliminar el ultimo salto de linea.
            archivo.escribir_archivo(rp.direccion_actual()+"Notas.csv", contenido);
        }
       
    }
    
    /**Este método se encarga de eliminar la evaluacion seleccionada comprobando que no existan notas asociadas a la evaluacion
     @param Evaluaciones_Ofertadas: Es la tabla de interes donde se muestra el contenido de las ofertas de las evaluaciones (TableView)      
     */
    public void eliminacion_evaluacion(TableView<FormatoEvaluacionesOfertadas> Evaluaciones_Ofertadas){
        boolean decision = false;
         
        if(Evaluaciones_Ofertadas.getSelectionModel().isEmpty()){ // si no hay seleccion de algun registro
            va.mensaje_informacion("NOTIFICACIÓN", "Disculpe, pero debe al menos seleccionar un registro...!!!");
        }else{ // si selececciono algun registro de la tabla
            TableViewSelectionModel tvsm = Evaluaciones_Ofertadas.getSelectionModel();
            ObservableList<FormatoEvaluacionesOfertadas> datos = Evaluaciones_Ofertadas.getItems();
            int indice = tvsm.getSelectedIndex();
            String id_interes = String.valueOf(datos.get(indice).getId());
            
                if(va.mensaje_confirmacion("CONFIRMACIÓN", "DESEA ELIMINAR LA EVALUACIÓN OFERTADA")){                       
                    
                        if(this.comprobacion_vinculacion(id_interes)){ // Revisando si existe alguna vinculacion con una evaluacion donde ya se coloco notas
                            
                            if(va.mensaje_confirmacion("ADVERTENCIA", "DISCULPE, PERO SE HA DETECTADO QUE LA EVALUACIÓN QUE DESEA ELIMINAR "
                                                      +"TIENE NOTAS ASOCIADAS. SI PROCEDE, ESTAS TAMBIÉN SERÁN BORRADAS. \n"
                                                      +"        DESEA CONTINUAR?"))
                              decision = true;
                            else decision = false;

                        }else decision = true;
                    
                }else{
                  decision = false;  
                }
                
                if(decision){            
                        this.modificar_registro_evaluacion(id_interes+"x",
                                                           datos.get(indice).getSeccion()+" - "+datos.get(indice).getMateria(),
                                                           datos.get(indice).getEstrategia(),
                                                           datos.get(indice).getPonderacion(),
                                                           datos.get(indice).getFecha());
                        this.eliminacion_masiva_nota(id_interes);                        
                        va.mensaje_informacion("NOTIFICACIÓN", "LA EVALUACIÓN FUE ELIMINADA CON ÉXITO...!!!");
                        this.actualizar_evaluaciones();
                }else{
                        va.mensaje_informacion("NOTIFICACIÓN", "PROCESO DE ELIMINACIÓN CANCELADA.");
                }    
        
        }
    }
    
private boolean limiteEvaluaciones(String seccion_materia, String porciento){
   LinkedList<String> registros = new LinkedList<>();
   int cantidadOfertadas = 0;
   int porcientoTotal = 0;
   boolean autorizar = false;
   
   todas_evaluaciones.stream()
                     .filter(s -> s.split(";")[3].equalsIgnoreCase(seccion_materia.split(" - ")[0]) && // comparando seccion
                                  s.split(";")[4].equalsIgnoreCase(seccion_materia.split(" - ")[1]) // Comparando materia
                             )
                     .forEach(registros::add); // Guardando los registros de interes
   
   porcientoTotal = registros.stream()
                             .mapToInt(s -> Integer.valueOf(s.split(";")[2].replace("%", ""))) // guardando temporalmente los porcentajes sin el simbolo porciento
                             .sum();
   
   cantidadOfertadas = registros.size();
   
   if(++cantidadOfertadas > 10 ){ 
       autorizar = false;
       va.mensaje_informacion("ADVERTENCIA", "Estimado Usuario, usted alcanzo la cantidad máxima de evaluaciones que se pueden ofertar (10).\nOPERACIÓN CANCELADA.");
   }else{   
        if((porcientoTotal + Integer.valueOf(porciento.replace("%", ""))) > 100 ){
            autorizar = false;
            va.mensaje_informacion("ADVERTENCIA", "Estimado Usuario, con esta evaluación supera el porcentaje máximo permitido de 100%.\nOPERACIÓN CANCELADA.");
        }else autorizar = true;
   }
   
   return autorizar;
}    
    
}// fin de la clase
