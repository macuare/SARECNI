/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarecni.MODELO;


import sarecni.MODELO.FORMATOS.FormatoNotaIndividual;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sarecni.MODELO.BD.Notas;

/**
 *
 * @author andy
 */
public class Registro_Notas {
    private  Registro_Parametros rp;
    private  Archivos archivo;
    private  Calendario cal;
    private  Ventanas_Auxiliares va;
    private  TableView<FormatoNotaIndividual> tabla;
    private  Label posiciones, estudiante, acumulado, evaluado, estado, restante;
    private  ComboBox<String> asignaturas;
    
    /**Este registro almacena la nota de todos los estudiantes. </br> id;id_estudiante;id_evaluacion;nota*/
    private LinkedList<Notas> notas_estudiantes;
    /**Devuelve un arreglo de texto lineal con la estructura "id_estudiante, posicion, cedula, nombres, apellidos*/
    private LinkedList<String> listado;
    private Double total_acumulado = 00.00, total_restante = 00.00;
    private int total_porciento = 0;

    public Registro_Notas() {
        rp = new Registro_Parametros();
        va = new Ventanas_Auxiliares();
    }
    
    public Registro_Notas(ComboBox<String> asignaturas, TableView<FormatoNotaIndividual> tabla, Label posiciones, Label estudiante, Label acumulado, Label evaluado, Label estado, Label restante) {
        this.tabla = tabla;
        this.posiciones = posiciones;
        this.estudiante = estudiante;
        this.acumulado = acumulado;
        this.evaluado = evaluado;
        this.estado = estado;
        this.restante = restante;
        this.asignaturas = asignaturas;
        
        archivo = new Archivos();
        cal = new Calendario();
        rp = new Registro_Parametros();
        rp.inicializando_registros();
        notas_estudiantes = rp.getNotas();
        listado = new LinkedList<>();
        va = new Ventanas_Auxiliares();
    }

    
    private void actualizar_notas(){        
        rp.inicializando_registros();      
        notas_estudiantes = rp.getNotas();
    }
    
    private ObservableList<String> secciones_materias_actuales(){
        LinkedList<String> sm = rp.secciones_materias();       
        asignaturas.getItems().clear();
        ObservableList<String> registros = FXCollections.observableArrayList();
        
        for(String dato : sm){
            registros.add(dato.replace(";", " @ "));
        }
        
        return registros;
    }
    
    public void secciones_materias_disponibles(){        
        asignaturas.setItems(this.secciones_materias_actuales());
        asignaturas.getSelectionModel().selectFirst();    
    }
    
    public void listado_estudiantes(){       
        String aux[] = asignaturas.getSelectionModel().getSelectedItem().split(" @ ");
       
        listado = rp.informacion_estudiantes(aux[0], aux[1]);
    }
    
    
    
    
    /**Este metodo se encarga de tomar solo los registros asociado al id del estudiante
     * @param id_estudiante: es el identificador unico perteneciente al estudiante
     * @return Regresa el arreglo con las notas solo del estudiante id;id_estudiante;id_evaluaciones;notas;
     */
    private LinkedList<Notas> separar_notas_estudiante(String id_estudiante){
        this.actualizar_notas();
        LinkedList<Notas> informacion = new LinkedList<>();

        notas_estudiantes.stream()
                         .filter(nota -> String.valueOf(nota.getIdEstudiantes()).equalsIgnoreCase(id_estudiante))
                         .forEach(informacion::add);
       
        return informacion;
    }
    
  
    /**Este metodo se encarga de eliminar la nota con el id de interes agregando una "x"
     * @param id_interes: es el id de la nota al que se desea alterar         
     */
    private void eliminacion_registro_notas(String id_nota){ 
        //System.out.println("buscando idNota: "+id_nota);
        
        Notas nota = notas_estudiantes.stream()
                                      .filter(n -> n.getId().equalsIgnoreCase(id_nota))
                                      .findFirst()
                                      .get(); // Recuperando la coleccion de la nota asociada al id buscado
        
        nota.setId(id_nota+"x"); // Colocando "x" al id para indicar que ese registro esta siendo eliminado
      
        this.guardar_nota(nota);        
    }
    
    public void eliminar_nota_estudiante(){
        if(!tabla.getSelectionModel().isEmpty()){
          if(va.mensaje_confirmacion("CONFIRMACIÓN", "DESEA ELIMINAR LA NOTA SELECCIONADA ?")){  
            int id_nota = tabla.getSelectionModel().getSelectedItem().getIdentificador(); // id_nota directo de la tabla        
            this.eliminacion_registro_notas(String.valueOf(id_nota));        
            this.tabla_notas_estudiante(rp.id_cedula(estudiante.getText().split(" - ")[0])); // Actualiza la tabla con el nuevo cambio  
            this.protocolo();
            va.mensaje_informacion("ADVERTENCIA", "LA NOTA SELECCIONADA FUE ELIMINADA EXITOSAMENTE...!!!");
          }else{
            va.mensaje_informacion("ADVERTENCIA", "PROCESO DE ELIMINACIÓN CANCELADA.");
          }
        }else{
          va.mensaje_informacion("ADVERTENCIA", "Estimado usuario, debe al menos seleccionar una nota del listado.");
        }
    }
    
    
    /**Este metodo entrega la informacion de la estrategia de interes segun la id buscada 
     @param evaluaciones_ofertadas: lista de todas las evaluaciones ofertadas con id traducidos
     @param id_buscada: id de la evaluacion que se quiere.
     @return String[] Regresa un arreglo con la informacion traducida de la evaluacion de interes. 
     * </br>id;PC;20%;CP-401;GERENCIA EDUCATIVA;27/09/2015*/
    private String[] informacion_evaluacion(LinkedList<String> evaluaciones_ofertadas, String id_buscada){
     //id;PC;20%;CP-401;GERENCIA EDUCATIVA;27/09/2015 
        String aux[] = null;
       // System.out.println("buscando informacion evaluacion:"+evaluaciones_ofertadas.size()+" id:"+id_buscada);
        
        for(String dato : evaluaciones_ofertadas){
            aux = dato.split(";");            
           // System.out.println("    buscando: "+id_buscada+"  analizando> "+aux[0]+" - coincide:"+aux[0].equalsIgnoreCase(id_buscada));
            if(aux[0].equalsIgnoreCase(id_buscada)) // Si coincide la id de la evaluacion con el de la nota, se retorna                
                break;
            else aux = null; // Es para limpiar la variable y evitar que cuando no exista ninguna coincidencia quede almacenado el ultimo valor del recorrido
        }
       
        return aux;
    }
    
    
    /**Este metodo separa adecua la nota del estudiante segun parametros de interes para ser mostrada en una tabla
     * @param notas: Representa el registro de las notas del estudiante de interes
     * @return ObservableLists el cual contiene los elementos ordenado de las notas del estudiante
     */
    private ObservableList<FormatoNotaIndividual> acondicionar_notas_estudiante(LinkedList<Notas> notas){
        ObservableList<FormatoNotaIndividual> registros = FXCollections.observableArrayList();
        LinkedList<String> te = this.analisis_evaluaciones_estudiante(true);
        total_acumulado = 0.0;
        total_porciento = 0;
        total_restante = 0.0;
       
        // 1;23;1;18        
       final AtomicInteger indice = new AtomicInteger(1);
        notas.stream()
             .forEach(nota -> {                 
                 String ie[] = this.informacion_evaluacion(te, String.valueOf(nota.getIdEvaluaciones()));                
                 if(ie != null){
                     total_acumulado += (Integer.valueOf(ie[2].substring(0, ie[2].length()-1)) * nota.getNota())/100.0;
                     total_porciento += Integer.valueOf(ie[2].substring(0, ie[2].length()-1));
                     total_restante = 10.0 - total_acumulado;
                     
                     // System.out.println("notas: "+nota.getId()+"-"+nota.getNota()+"-"+ie[1]+"-"+ie[2]+"-"+cal.estructura_fecha(ie[5]));
                     
                     registros.add(new FormatoNotaIndividual(Integer.valueOf(nota.getId()), // id de la nota 
                                                            nota.getNota(), 
                                                            indice.getAndIncrement(),    
                                                            ie[1], 
                                                            ie[2], 
                                                            cal.estructura_fecha(ie[5]))
                                                         );

                 }
             });
        
        
      return registros;           
    }
    
    /**Este metodo muesta las notas del estudiante de interes
     @param id_estudiante: identificador unico del estudiante
     */
    public void tabla_notas_estudiante(String id_estudiante){
       this.actualizar_notas(); // se cargan las notas de todos        
       LinkedList<Notas> notas_separadas = this.separar_notas_estudiante(id_estudiante); // se toman solo las notas del estudiante de interes
        
       tabla.getItems().clear();
       tabla.setItems(this.acondicionar_notas_estudiante(notas_separadas));        
    }
    
    public void resumen(){
        DecimalFormat df = new DecimalFormat("0.00");
        double total_restante = 00.00;
        
        acumulado.setText(df.format(total_acumulado));
        evaluado.setText(String.valueOf(total_porciento)+"%");
        restante.setText(df.format(10.0-total_acumulado));
        
        if(total_acumulado < 10.0) {
            estado.setText("REPROBADO");
        }else{ 
            estado.setText("APROBADO");
            restante.setText("0.00");
        }
        
    }
    
    /**Este metodo se encarga de actualizar y colocar en el orden correspondiente los valores de interes de cada estudiante */ 
    private void protocolo(){             
        
        int indice = Integer.valueOf(posiciones.getText().split("/")[0]) - 1;
        
        String datos[] = listado.get(indice).split(";");
        estudiante.setText(datos[2]+" - "+datos[4].trim()+", "+datos[3].trim());        
        //System.out.println("informacion: "+listado);
        this.tabla_notas_estudiante(datos[0]);
        this.resumen();
    }
    
    /**Este metodo actualiza ciertos valores de interes para el correcto funcionamiento del sistema. asignaturas y listado*/
    private void actualizar_parametros(){
        
        String aux[] = asignaturas.getSelectionModel().getSelectedItem().split(" @ ");        
        listado = rp.informacion_estudiantes(aux[0], aux[1]); // extrayendo el listado de estudiante de acuerdo a la seccionmateria
        
    }
    
    public void avanzar_retroceder_lista(String tipo){
        this.actualizar_parametros();
        int nro = Integer.valueOf(posiciones.getText().split("/")[0]);
        DecimalFormat df = new DecimalFormat("00");
        
        if(tipo.equalsIgnoreCase("AVANZAR")) nro++; else nro--;
        
        // Si alcanza el maximo de estudiante en el recorrido, se de iniciar la lista
        if(nro > listado.size()) nro = 1; 
        if(nro <= 0) nro = listado.size();
        
        //System.out.println("nro: "+nro);
        posiciones.setText(df.format(nro)+"/"+listado.size());
        this.protocolo();
    }
    
    private void inicializacion(){
        this.secciones_materias_disponibles(); 
        this.listado_estudiantes();
        posiciones.setText("01/"+listado.size());
        this.protocolo();
        
        //System.out.println("detalle: "+listado.getFirst());
    }
    
    /**Metodo para realizar la busqueda de los elementos del estudiante.
     @param cedula: Corresponde a la cedula de cada estudiante.*/
    private void buscador(String cedula){
     String informacion = null;   
     boolean coincidencia = false;
     int i = 0;
     AtomicInteger indice = new AtomicInteger();
     DecimalFormat df = new DecimalFormat("00");
        //System.out.println("asignaturas: "+asignaturas.getItems().size());
     
        //asignaturas.getItems().stream().forEach(s -> System.out.println("asignatuas: "+s));
     
        for(String elemento : asignaturas.getItems()){ // Recorriendo los listados de estudiante discrimado por materias asignadas al docente
         String aux[] = elemento.split(" @ ");
         indice.set(0); // Inicializando valor por cada item de la asignatura
         
         //System.out.println("cedula: "+cedula+" - "+elemento);
         if(!listado.isEmpty())listado.clear();
         
         listado = rp.informacion_estudiantes(aux[0], aux[1]); // extrayendo el listado de estudiante de acuerdo a la seccionmateria
         
         coincidencia = listado.stream()
                               .anyMatch(s -> {
                                               indice.getAndIncrement(); //System.out.println("buscador: "+cedula+" - "+s.split(";")[2]);
                                               return s.split(";")[2].equalsIgnoreCase(cedula);  
                                              }
                               );
        
        if(coincidencia) {
         //System.out.println("selector: "+i);
         informacion = listado.get(indice.get());
         asignaturas.getSelectionModel().select(i);
        }
        
//         System.out.println("informacion:-> "+informacion);
//         System.out.println(" indice:-> "+indice);
//         System.out.println("  posiciones:"+(posiciones == null) );
        if(informacion != null){
             posiciones.setText(df.format(indice)+"/"+listado.size()); // Depende de donde este el estudiante       
             break;
        } 
         
         i++;
     } // fin ciclo for
     
    }
    
    /**Este metodo permite cargar los datos del estudiante seleccionado.
     @param cedula: recurso necesario para identificar el estudiante. En caso de que sea nulo el valor este tomara por defecto al primero de la lista
    */
    public void inicializacion_avanzada(String cedula){ 
//        System.out.println("valores: "+cedula);
      if(cedula == null || cedula.isEmpty() || cedula.length() <= 5){ // si el valor es nulo o vacio o de longitud pequeña, se tomara el registro del primer estudiante.
          this.inicializacion(); 
      }else{
          this.buscador(cedula);
          this.protocolo();
      } 
        
    }
    
    public void refrezcar(){        
        this.listado_estudiantes();
        posiciones.setText("01/"+listado.size());
        this.protocolo();
        //System.out.println("detalle: "+listado.getFirst());
    }
    
    public void vista_rapida(){
      LinkedList<String> filtro = new LinkedList<>();
      DecimalFormat df = new DecimalFormat("00");
      this.actualizar_parametros();
      
      Parent componente =  va.cargar("/sarecni/VISTA/Auxiliares/Etiquetas/Vista_Rapida.fxml");
      listado.stream()
             .forEach(l ->{
                            String posicion = l.split(";")[1],
                                   cedula = l.split(";")[2],
                                   nombres = l.split(";")[3],
                                   apellidos = l.split(";")[4]; 
                                   filtro.add(df.format(Integer.valueOf(posicion))+")>"+cedula+" "+apellidos+", "+nombres);
                         });
     
      va.modificar(componente, "ListView", "Listado", filtro);      
      
      final ListView<String> vista = (ListView<String>) va.modificacion_avanzada(componente, "Listado");
      vista.setOnMouseClicked(new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent event) {
              va.cerrar_ventana(true, vista);
          }
      });
      
      va.desplegar(componente); 
      String texto = va.recuperar(componente, "ListView", "Listado");
      posiciones.setText(texto.substring(0, 2)+"/"+listado.size());
      this.protocolo();
      
    }
    
    /**Este metodo separa de todas las evaluaciones aquellas de interes
     @param seccion: Es la seccion que se desea comparar
     @param materia: Es la materia de interes
     @param evaluaciones: Se refiere a todas las evaluaciones efectuadas por el docente de las materias que imparte
     @return Retorna un arreglo discriminado por los parametros de los registros iniciales
     */ 
    private LinkedList<String> filtro_evaluaciones(String seccion, String materia, LinkedList<String> evaluaciones){
        LinkedList<String> filtrado = new LinkedList<>();
        
        evaluaciones.stream()
                    .filter(aux -> (aux.split(";")[3].equalsIgnoreCase(seccion) && aux.split(";")[4].equalsIgnoreCase(materia)) )
                    .forEach(filtrado::add);
                
        return filtrado;
    }
    
    /**Este metodo se encarga de obtener las evaluaciones que le faltan al estudiante o las que ya realizo
     @param realizadas: Si es verdadero se busca las evaluaciones del estudiante realizadas. Si es falso entonces se busca las evaluaciones faltantes
     @return Retorna un registro con las evaluaciones hechas o faltantes del estudiante en relacion a las evaluaciones ofertadas*/ 
    private LinkedList<String> analisis_evaluaciones_estudiante(boolean realizadas){
        LinkedList<String> te = rp.todas_evaluaciones(); // Son todas las evaluaciones ofertadas por el docente
        String secmat[] = asignaturas.getSelectionModel().getSelectedItem().split(" @ "); // La seccion materia del estudiante
        LinkedList<String> filtradas = this.filtro_evaluaciones(secmat[0],secmat[1] , te); // Solo Evaluaciones ofertadas para la seccion materia de interes        
        String id_est = rp.id_cedula(estudiante.getText().split(" - ")[0]);
        
        LinkedList<Notas> notas_separadas = this.separar_notas_estudiante(id_est);
        LinkedList<String> registros = new LinkedList<>(); // Registros con los valores deseados
       
    
        filtradas.stream()
                 .filter((String aux) -> notas_separadas.stream() 
                                                        .anyMatch(ns -> String.valueOf(ns.getIdEvaluaciones())
                                                                              .equalsIgnoreCase(aux.split(";")[0])) // Comparando los id de las evaluaciones y notas del estudiante
                                         == realizadas // Se discrimina si se quiere las notas de las evaluaciones que tiene o las que le falta 
                        )
                 .forEach(registros::add);
     
        return  registros;
    }
    
    
    /**Este metodo almacena la nota ya con su estructura
     @param estructura: Representa la cadena escrita en como es almacenada la nota
     *</br> ejm: 11;1;15;"17"
     */
    private void guardar_nota(Notas estrutura){
        LinkedList<String> informacion = new LinkedList<>();
        informacion.add(estrutura.getId()+";"+
                        estrutura.getIdEstudiantes()+";"+
                        estrutura.getIdEvaluaciones()+";"+
                        estrutura.getNota());
                
        archivo.escribir_archivo(rp.direccion_actual()+"Notas.csv",informacion);  
        
    }
    
    private void modificacion_visual(LinkedList<String> evaluacion, Notas nota){
        String nota_nueva = null,
               nota_vieja = null,
               nueva_estructura = null;
        boolean decision = false;
        DecimalFormat df = new DecimalFormat("00");
        
        evaluacion.set(0, evaluacion.getFirst().replaceAll(";", " - "));
        //evaluacion.stream().forEach(System.out::println);
        
        Parent ventana = va.cargar("/sarecni/VISTA/Auxiliares/NUEVA_NOTA.fxml");                                
                va.modificar(ventana, "ComboBox", "Evaluaciones",evaluacion); 
                TextField texto = (TextField) va.modificacion_avanzada(ventana, "Nota_Evaluacion");
                texto.setText(null);
                texto.setPromptText(String.valueOf(tabla.getSelectionModel().getSelectedItem().getNota()));
                
                va.desplegar(ventana);
                nota_nueva = df.format(Double.valueOf(va.recuperar(ventana, "TextField", "Nota_Evaluacion")));
                nota_vieja = String.valueOf(nota.getNota());//estructura_nota.split(";")[3];
               
               if(nota_vieja.equalsIgnoreCase(nota_nueva)){
                    decision = false;
               }else{
                    if(va.mensaje_confirmacion("CONFIRMACIÓN", "Realmente desea modificar esta nota? \n\tDe:-> "+nota_vieja+" a "+nota_nueva)){
                       decision = true;
                       
                       nota.setNota(Integer.valueOf(nota_nueva)); // actualizando la nota del registro                   
                       this.guardar_nota(nota);
                       
                    }else{
                       decision = false;
                    }
                }
                
                if(decision)va.mensaje_informacion("NOTIFICACIÓN", "LA NOTA SE MODIFICÓ CON ÉXITO...!!!");
                else va.mensaje_informacion("NOTIFICACIÓN", "LA NOTA NO SE MODIFICÓ...!!!");
                
                
    }
    
    /**Este metodo se encarga de tomar las modificaciones de la nota del estudiante y guardarla 
     @param opcion: Si es verdadero se modifica la nota de interes y solo se mostrara la nota seleccionada, 
     sino se desplegaran las evaluaciones que le faltan al estudiante para asentar la nota.
     */
    public void modificar_nota_estudiante(boolean opcion){
        
        if(opcion){ // si es true se modifica las nota seleccionada existente
            if(!tabla.getSelectionModel().isEmpty()){
                int id_nota = tabla.getSelectionModel().getSelectedItem().getIdentificador(); // id_nota directo de la tabla
                LinkedList<String> evaluacion = new LinkedList<>(); // Lugar donde se almacenara la informacion de interes
                //System.out.println("id_nota:"+id_nota);
                Notas nota = notas_estudiantes.stream()
                                               .filter(ne -> ne.getId().equalsIgnoreCase(String.valueOf(id_nota)))
                                               .findFirst()
                                               .get();
                
                //System.out.println("nota:"+nota);
                this.analisis_evaluaciones_estudiante(opcion).stream()
                                                             .filter(s -> s.split(";")[0].equalsIgnoreCase(String.valueOf(nota.getIdEvaluaciones())))
                                                             .forEach(evaluacion::add);
                this.modificacion_visual(evaluacion, nota);
                this.tabla_notas_estudiante(rp.id_cedula(estudiante.getText().split(" - ")[0])); // Actualiza la tabla con el nuevo cambio
                this.protocolo();
            }else{
                va.mensaje_informacion("ADVERTENCIA", "Estimado usuario, debe al menos seleccionar una nota del listado.");
            }
            
        }
    
    }
    

private void agregar_nota_visual(LinkedList<String> evaluaciones, Notas nota){
        String nota_nueva = null;
        int id_evaluacion = 0;
        boolean decision = false;
        DecimalFormat df = new DecimalFormat("00");
        
        Parent ventana = va.cargar("/sarecni/VISTA/Auxiliares/NUEVA_NOTA.fxml");                                
                va.modificar(ventana, "ComboBox", "Evaluaciones",evaluaciones); 
                TextField texto = (TextField) va.modificacion_avanzada(ventana, "Nota_Evaluacion");
                texto.setText(null);
                texto.setPromptText(String.valueOf("0"));                
                va.desplegar(ventana);
                
                nota_nueva = df.format(Double.valueOf(va.recuperar(ventana, "TextField", "Nota_Evaluacion")));
                id_evaluacion = Integer.valueOf(va.recuperar(ventana, "ComboBox", "Evaluaciones").split(" - ")[0]);
               
                
                    if(va.mensaje_confirmacion("CONFIRMACIÓN", "Realmente desea agregar esta nota? \n\tNOTA: "+nota_nueva)){
                       decision = true;
                      
                      nota.setIdEvaluaciones(id_evaluacion); 
                      nota.setNota(Integer.valueOf(nota_nueva)); // actualizando la nota del registro                                         
                      this.guardar_nota(nota);
                       
                    }else{
                       decision = false;
                    }
                
                
                if(decision)va.mensaje_informacion("NOTIFICACIÓN", "LA NOTA SE AGREGÓ CON ÉXITO...!!!");
                else va.mensaje_informacion("NOTIFICACIÓN", "LA NOTA NO SE GUARDÓ...!!!");
                
                this.tabla_notas_estudiante(rp.id_cedula(estudiante.getText().split(" - ")[0])); // Actualiza la tabla con el nuevo cambio
      
    }

    
/**Este metodo es utilizado para agregar una nota nueva del estudiante en las evaluaciones postuladas por el docente donde aun
 no tenga nota.*/    
public void agregar_nota_estudiante(){
    LinkedList<String> registros = new LinkedList<>();
    String id_nueva = null;
    int indice = 0;
    
    //Fase 0: obteniendo solo un identificador para asi poder agregar la nueva nota
    this.actualizar_parametros();
    
    notas_estudiantes.stream()
                     .forEach(ns -> registros.add(ns.getId()+";"));
    id_nueva = rp.id_disponible(registros);
    
    //Fase 1: Obteniendo solo las evaluaciones que del estudiante aun no tiene notas.
    registros.clear();
    this.analisis_evaluaciones_estudiante(false).stream()                                                 
                                                .forEach(s -> registros.add(s.replaceAll(";", " - ")));
    
    //Fase 2: Obteniendo informacion del estudiante
    indice = Integer.valueOf(posiciones.getText().split("/")[0]) - 1;
    String idAlumno = listado.get(indice).split(";")[0]; // recuperando el id del estudiante
    
    //Fase 2: Formalidad visual. se levanta un entorno visual y ademas se envia la id de la nota junto a la del estudiante. los otros datos se obtiene de las operaciones posteriores
    this.agregar_nota_visual(registros, new Notas(id_nueva, Integer.valueOf(idAlumno), 0, 0));
    
    this.protocolo();
    
}
    
public String limite_notas(String nota){
        String salida = null;
      
        System.out.println("nota: "+nota);
        
        if(!nota.isEmpty() && rp.es_numerico(nota) && nota.length() <= 2){ // que la nota no sea vacia, que sea numerico y que su longitud sean dos cifras o menos
            int valor = Integer.valueOf(nota);

            if(valor >= 0 && valor <= 20){
                salida = nota;
            }else{
                va.mensaje_informacion("ADVERTENCIA", "RECUERDE QUE LA NOTA DEBE SER DESDE CERO(0) HASTA (20) PUNTOS");
            }
            
        }else{
            va.mensaje_informacion("ADVERTENCIA", "RECUERDE QUE DEBE SER UN NUMERO ENTRE 0 y 20");
            
        }
        
        return (salida);
        
    }
    


    
}// Fin de la clase
