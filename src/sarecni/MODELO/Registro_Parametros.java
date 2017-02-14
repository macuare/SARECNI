/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sarecni.MODELO;

import java.util.HashMap;
import java.util.LinkedList;
import sarecni.MODELO.BD.DatosAcademicos;
import sarecni.MODELO.BD.DatosDocentes;
import sarecni.MODELO.BD.DatosPersonales;
import sarecni.MODELO.BD.Estrategias;
import sarecni.MODELO.BD.Estudiantes;
import sarecni.MODELO.BD.Evaluaciones;
import sarecni.MODELO.BD.Materias;
import sarecni.MODELO.BD.Notas;
import sarecni.MODELO.BD.Secciones;
import sarecni.MODELO.BD.Vigencias;

/**
 *
 * @author ANDY
 */
public class Registro_Parametros {
    private final Archivos archivo;
    
    private LinkedList<Estudiantes> estudiantes;
    private LinkedList<DatosPersonales> personales;
    private LinkedList<Vigencias> vigencias;
    private LinkedList<DatosAcademicos> academico;
    private LinkedList<DatosDocentes> docente;
    private LinkedList<Materias> materias;
    private LinkedList<Secciones> secciones;
    private LinkedList<Estrategias> estrategias;
    private LinkedList<String> miscelaneos;
    private LinkedList<Evaluaciones> evaluaciones;
    private LinkedList<Notas> notas;
    private LinkedList<String> semanas;
    private String direccion = null;
      
    
    public Registro_Parametros() {
        archivo = new Archivos();
       
    }
    
    private void cargar_direccion(){    
    
        direccion = "/home/andy/ESCRITORIO VIRTUAL/DOCUMENTOS/UNIVERSIDAD/SARECNI/RECURSOS/123456789 - PROFESOR, UNIVERSITARIO/";
       
    }
   
    public String direccion_actual(){
        return direccion;
    }
    
    private void cargando_datos_docente(){  
        docente = new LinkedList<>();        
        archivo.leyendo_archivo(direccion+"Datos_Docente.csv")
               .stream()
               .forEach(s -> docente.add(
                       new DatosDocentes(s.split(";")[0],s.split(";")[1])
               ));      
    }
    
    private void cargando_datos_cedulas(){   
        estudiantes = new LinkedList<>();
        archivo.leyendo_archivo(direccion+"Estudiantes.csv")
               .stream()
               .forEach(s -> estudiantes.add(
                       new Estudiantes(Integer.valueOf(s.split(";")[0]), s.split(";")[1]))
               );
    }
    
    private void cargando_datos_personales(){      
        personales = new LinkedList<>();
        archivo.leyendo_archivo(direccion+"Datos_Personales.csv")
               .stream()
               .forEach(s -> personales.add(
                       new DatosPersonales(Integer.valueOf(s.split(";")[0]), s.split(";")[1], s.split(";")[2]))
               );
    }
    
    private void cargando_datos_vigencias(){      
        vigencias = new LinkedList<>();
        archivo.leyendo_archivo(direccion+"Vigencias_Estudiantes.csv")
               .stream()
               .forEach(s -> vigencias.add(
                       new Vigencias(Integer.valueOf(s.split(";")[0]), Integer.valueOf(s.split(";")[1]), s.split(";")[2])
               ));
    }
    
    private void cargando_datos_academicos(){     
        academico = new LinkedList<>();
        archivo.leyendo_archivo(direccion+"Datos_Academicos.csv")
               .stream()
               .forEach(s -> academico.add(
                       new DatosAcademicos(Integer.valueOf(s.split(";")[0]), Integer.valueOf(s.split(";")[1]), Integer.valueOf(s.split(";")[2]), Integer.valueOf(s.split(";")[3]))
               ));
    }
    
    private void cargando_datos_materias(){
       // materias = archivo.leyendo_archivo(direccion+"Materias.csv");
       // archivo.ver_registros(materias);

        //1;8;EDC36393;GERENCIA EDUCATIVA;0;0;0;3;0;0;0;0;0;2010;LIC. EDUCACION INTEGRAL;DIURNO
    //id, semestre, codigo, asignatura, horas_teoricas, horas_practicas, horas_laboratorio, credito, vigencia, carrera, turno 
        materias = new LinkedList<>();
        archivo.leyendo_archivo(direccion+"Materias.csv")
               .stream()
               .forEach(s -> materias.add(                      
                       new Materias(
                               Integer.valueOf(s.split(";")[0]), // id
                               Integer.valueOf(s.split(";")[1]), // semestre
                               s.split(";")[2], // codigo
                               s.split(";")[3], // asignatura
                               Integer.valueOf(s.split(";")[4]), // horas_teoricas 
                               Integer.valueOf(s.split(";")[5]), // horas_practicas
                               Integer.valueOf(s.split(";")[6]), // horas_laboratorio
                               Integer.valueOf(s.split(";")[7]), // credito
                               Integer.valueOf(s.split(";")[13]), // vigencia
                               s.split(";")[14], // carrera
                               s.split(";")[15]) // turno
               ));
    }
    
    private void cargando_datos_secciones(){
        //secciones = archivo.leyendo_archivo(direccion+"Secciones.csv");        
        secciones = new LinkedList<>();
        archivo.leyendo_archivo(direccion+"Secciones.csv")
               .stream()
               .forEach(s -> secciones.add(
                       new Secciones(Integer.valueOf(s.split(";")[0]), s.split(";")[1])
               ));
        
    }
    
    public LinkedList<Secciones> datos_secciones(){
        return secciones;
    }
    
    private void cargando_datos_estrategias(){
        estrategias = new LinkedList<>();
        archivo.leyendo_archivo(direccion+"Estrategias.csv")
               .stream()
               .forEach(s -> estrategias.add(
                       new Estrategias(Integer.valueOf(s.split(";")[0]), s.split(";")[1], s.split(";")[2])
               ));
       // estrategias = archivo.leyendo_archivo(direccion+"Estrategias.csv");
        //archivo.ver_registros(estrategias);
    }
    
    public LinkedList<Estrategias> cargando_registros_estrategias(){
        this.cargando_datos_estrategias();
        return estrategias;
    }
    
    private void cargando_datos_miscelaneos(){
        miscelaneos = archivo.leyendo_archivo(direccion+"Miscelaneos.csv");
        //archivo.ver_registros(miscelaneos);
    }
   
    private void cargando_datos_semanas(){
        semanas = archivo.leyendo_archivo(direccion+"Semanas.csv");
    }
    
    public LinkedList<String> cargando_registros_semanas(){
        this.cargando_datos_semanas();
        return semanas;
    }
    
    /**Este metodo determina si el caracter en cuestion es realmente un entero
     * @param valor: Es el valor en caracter de interes numerico entero
     * @return regresa si es numerico
     */ 
    public boolean es_numerico(String valor){
      //  System.out.println("valor: "+valor);
        boolean respuesta = false;
        char[] caracteres = valor.toCharArray();
        
        
            for(char dato : caracteres){
                
                String aux = String.valueOf(dato);
                //System.out.println("caracteres: "+valor+" longitud: "+caracteres.length+" - conversion: "+aux+" "+aux.codePointAt(0));
                
                if(aux.codePointAt(0) >= 48 && aux.codePointAt(0) <= 57) {
                    respuesta = true;
                   
                }else {
                    respuesta = false;
                    break;
                }
            }
            
       // System.out.println("respuesta : "+valor+" - "+respuesta);
        
        return respuesta;
    }
    
    
    /**Este metodo se encarga de ignorar todos aquellos valores con "x" en la id y ademas de retirar el registro con la misma id
     @param informacion: Contiene todos los registros que se desean revisar
     @return HashMap<Integer, String> Representa todos los valores de interes sin los registros con id"x" y aquellos asociados a la misma id 
     */
    private HashMap<Integer, String> filtro_idxyz(LinkedList<String> informacion){
        HashMap<Integer, String> revisados = new HashMap<>();
        
        for(String dato : informacion){
           String aux[] = dato.split(";");
          // System.out.println("original: "+dato);
           
           if(this.es_numerico(aux[0])){ // solo se guarda los valores con id numerico
               if(revisados.isEmpty()){ // si temporal esta vacio entonces agrega el primer valor
                 revisados.put(Integer.valueOf(aux[0]), dato );
               }else{ // en caso contrario
                   if(revisados.containsKey(aux[0])){ // Se verifica si el id ya existe y si es asi se reemplaza el contenido por el nuevo valor
                       revisados.replace(Integer.getInteger(aux[0]), dato); // se remplaza el contenido en la direccion de interes
                   }else{ // en caso de que no existe se agrega
                       revisados.put(Integer.valueOf(aux[0]), dato );
                   }
               }
           }else{ 
              // System.out.println("encontrado idx:"+aux[0].substring(0, aux[0].length()-1));
               if(aux[0].contains("x")) revisados.remove(Integer.valueOf(aux[0].substring(0, aux[0].length()-1))); // Se elimina el registro asociado con el "id" del id"x"
           }
       }
        
        return revisados;    
    }
    
    
    private void filtro_evaluaciones(){
     HashMap<Integer, Evaluaciones> temporal = new HashMap<>();     
     evaluaciones.stream()                
                 .forEach(evaluacion -> {                     
                    if(evaluacion.getId().contains("x")) temporal.remove(Integer.valueOf(evaluacion.getId().replace("x", "")));
                    else temporal.put(Integer.valueOf(evaluacion.getId()), evaluacion);
                 });
     evaluaciones.clear();
     evaluaciones.addAll(temporal.values());
       
    }
    
    
    private void cargando_datos_evaluaciones(){
        //evaluaciones = archivo.leyendo_archivo(direccion+"Evaluaciones.csv");
        //this.filtro_evaluaciones();
        //archivo.ver_registros(miscelaneos);
        
        evaluaciones = new LinkedList<>();
        archivo.leyendo_archivo(direccion+"Evaluaciones.csv")
               .stream()
               .forEach(s -> evaluaciones.add(
                       new Evaluaciones(
                               s.split(";")[0], 
                               Integer.valueOf(s.split(";")[1]),
                               Integer.valueOf(s.split(";")[2]), 
                               Integer.valueOf(s.split(";")[3]), 
                               s.split(";")[4], 
                               s.split(";")[5])                     
               ));
        this.filtro_evaluaciones();
    }

    public LinkedList<Notas> getNotas() {
        return notas;
    }
    
    private void filtro_notas(){
     HashMap<Integer, Notas> temporal = new HashMap<>();
     notas.stream()                
          .forEach(nota -> {                     
                    if(nota.getId().contains("x")) temporal.remove(Integer.valueOf(nota.getId().replace("x", "")));
                    else temporal.put(Integer.valueOf(nota.getId()), nota);
                 });
     notas.clear();
     notas.addAll(temporal.values());
       
    }
    
     private void cargando_notas(){        
        notas = new LinkedList<>();
        archivo.leyendo_archivo(direccion+"Notas.csv")
               .stream()
               .forEach(s -> notas.add(
                       new Notas(
                               s.split(";")[0],
                               Integer.valueOf(s.split(";")[1]),
                               Integer.valueOf(s.split(";")[2]),
                               Integer.valueOf(s.split(";")[3]))
               ));
        this.filtro_notas();
    }
    
    
    
    
    public void inicializando_registros(){
        this.cargar_direccion();
        this.cargando_datos_docente();
        this.cargando_datos_cedulas();
        this.cargando_datos_academicos();
        this.cargando_datos_estrategias();
        this.cargando_datos_materias();
        this.cargando_datos_personales();
        this.cargando_datos_secciones();
        this.cargando_datos_vigencias();
        this.cargando_datos_miscelaneos();
        this.cargando_datos_evaluaciones();
        this.cargando_notas();
        this.cargando_datos_semanas();
    }
    
    
    
    
    public Materias informacion_materia(String id){
        return materias.stream()
                       .filter(materia -> String.valueOf(materia.getId()).equalsIgnoreCase(id)) //si los identificadores son iguales
                       .findFirst()
                       .get(); //se toma todos los parametros que contiene ese identificador. datos de la materia        
    } 
    
    public LinkedList<String> secciones_materias(){
        LinkedList<String> aux = new LinkedList<>();
        
        secciones.stream().forEach(seccion -> {
            academico.stream().forEach(aca -> {
                if(seccion.getId() == aca.getIdSeccion()){//si son las mismas secciones, se verifica si no estan repetidas
                    archivo.filtro(
                            aux, 
                            seccion.getSeccion()+";"+this.informacion_materia(String.valueOf(aca.getIdMateria())).getAsignatura(),
                            1); //se almacena el nombre de la seccion y el nombre de la materia               
                }
            });
           
        });
        
        return aux;
    }
   
    private LinkedList<String> estudiantes_seccion_materias(String seccion, String materia){
        LinkedList<String> combinaciones = new LinkedList<>();
        LinkedList<String> aux = new LinkedList<>();       
        int idSeccion;
       
        idSeccion = secciones.stream()
                             .filter(s -> s.getSeccion().equalsIgnoreCase(seccion))
                             .findFirst().get().getId();
        
        materias.stream()
                .filter(m -> m.getAsignatura().equalsIgnoreCase(materia)) //buscando por nombre de materia.
                .forEach(m -> combinaciones.add(m.getId()+";"+idSeccion)); //combinacion materias con la misma seccion
           
        //una vez tenida las combinaciones de interes. se procede a buscar las id de los estudiantes coincidentes con las combinaciones
       
        combinaciones.stream().forEach(c -> {            
            academico.stream()
                     .filter(aca -> String.valueOf(aca.getIdMateria()).equalsIgnoreCase(c.split(";")[0]) 
                                 && String.valueOf(aca.getIdSeccion()).equalsIgnoreCase(c.split(";")[1])) // comparando materias y seccion
                     .forEachOrdered(aca -> aux.add(String.valueOf(aca.getIdEstudiante()))); //guardando la id_cedula
        });
     
        return aux;
    }
    
    /**Metodo que se encarga de buscar a traves de la id la cedula del estudiante asociada
     * @param id: id del estudiante;
     * @return Devuelve un texto con la cedula*/
    private String cedula_estudiante(String id){        
        String ced = null;
        
        for(Estudiantes estudiante : estudiantes){
            if(String.valueOf(estudiante.getIdEstudiante()).equalsIgnoreCase(id)){
                ced = estudiante.getCedula();
                break;
            }
        }
        
      return ced;
    }
    
    
    private LinkedList<String> reordemiento_por_apellido(LinkedList<String> estudiantado){
          int indice = 0;
          LinkedList<String> aux = new LinkedList<>(); 
          LinkedList<String> orden = new LinkedList<>(); 
          for(String dato : estudiantado) aux.add(dato.split(";")[4]+";"+dato.split(";")[3]); // almacenando solo los apellidos 
          aux.stream()
                .sorted()                  
                .forEach(orden::add);
                //.forEach(s -> System.out.println(""+s));
          aux.clear();
          aux.addAll(orden);
          orden.clear();
        //aux.add(id+";"+(i+1)+";"+cedula+";"+nombres+";"+apellidos);//agregando nro, cedula, nombres, apellidos
          
              for(String s : aux){
                  String x[] = s.split(";"); 
                  indice++;
                  
                  for(String est : estudiantado){                      
                     String elementos[] = est.split(";"); 
                  
                     if(x[0].equalsIgnoreCase(elementos[4]) && x[1].equalsIgnoreCase(elementos[3])){ // Comparando Apellidos y Nombres de ambas listas para guardarlo en el orden
                         
                          orden.add(elementos[0]+";"+ // id en base de datos
                                    indice+";"+ // indice en la lista a mostrar
                                    elementos[2]+";"+ // cedula
                                    elementos[3]+";"+ // Nombres
                                    elementos[4] // Apellidos
                          );
                          break;        
                      }
                     
                  }
                  
              }
          
         //  orden.stream().forEach(s -> System.out.println(""+s));
          return orden;
    }
    
    /**
     * @param seccion
     * @param materia
     * @return Devuelve un arreglo de texto lineal con la estructura "id_estudiante, posicion, cedula, nombres, apellidos"*/
    public LinkedList<String> informacion_estudiantes(String seccion, String materia){
        LinkedList<String> aux = new LinkedList<>();
        LinkedList<String> ids = this.estudiantes_seccion_materias(seccion, materia);
        String cedula = null, nombres = null, apellidos = null;
        
        for(int i=0; i<ids.size(); i++){//recorriendo id de interes
            String id = ids.get(i);
            
           cedula = this.cedula_estudiante(id);           
           
           DatosPersonales dp = personales.stream()
                                          .filter(s -> String.valueOf(s.getIdEstudiante()).equalsIgnoreCase(id))
                                          .findFirst()
                                          .get();
           nombres = dp.getNombres();
           apellidos = dp.getApellidos();
           
           aux.add(id+";"+(i+1)+";"+cedula+";"+nombres+";"+apellidos);//agregando nro, cedula, nombres, apellidos
           
           
        }//fin recorrido id de interes
        
        aux = this.reordemiento_por_apellido(aux);
        
        return aux;
    }
    
    private Materias datos_materia(String nombre){        
        return materias.stream()
                       .filter(materia -> materia.getAsignatura().equalsIgnoreCase(nombre)) //si los nombres de la asignatura son iguales
                       .findFirst()
                       .get();
           
    }
    
    private String[] datos_miscelaneos(String id){
        String [] parametros = null;
        
         for(int i=0; i<miscelaneos.size(); i++){                        
            if(miscelaneos.get(i).split(";")[0].equalsIgnoreCase(id)){//si los nombres de la asignatura son iguales
                parametros = miscelaneos.get(i).split(";");//se toma todos los parametros que contiene la materia
                break;
            }
        }
      return parametros;
    }
    
    public String[] informacion_acta(String materia_elegida, String seccion_elegida ){
        String acta_materia = materia_elegida,
               acta_carrera = null, 
               acta_uc = null,
               acta_seccion = seccion_elegida,
               acta_periodo = null, 
               acta_profesor = null,
               acta_cedula = null;
        String [] aux = null;
        
        Materias materia = datos_materia(materia_elegida);
        acta_carrera = materia.getCarrera();
        acta_uc = String.valueOf(materia.getCredito());
        
        aux = this.datos_miscelaneos("1"); // obteniendo el periodo academico
        acta_periodo = aux[1];
        
        acta_cedula = docente.getFirst().getCedula();
        acta_profesor = docente.getFirst().getProfesor();
        
        return new String[]{acta_materia, acta_carrera, acta_uc, acta_seccion, acta_periodo, acta_profesor, acta_cedula};
    }
    
    
    private String obtener_seccion(String id){        
        return secciones.stream()
                        .filter(seccion -> String.valueOf(seccion.getId()).equalsIgnoreCase(id))
                        .findFirst().get().getSeccion();
        
    }
    
    private Estrategias obtener_estrategia(String id){        
        String aux[] = new String[]{};
        Estrategias est = new Estrategias(1000000, "x", "ERROR. Estrategia no reconocida");
        
        for(Estrategias estrategia : estrategias){
            if(String.valueOf(estrategia.getId()).equalsIgnoreCase(id)){                
                est = estrategia;
                break;
            }
        }
        
        return est;
    }
    
    
    /** Este metodo recoge la evaluaciones ofertadas para la materia y seccion de interes seleccionada.
     @param materia_elegida: representa la materia seleccionada
     @param seccion_elegida: representa la seccion seleccionada 
     @return Devuelve por cada texto los siguientes parametros. "id;fecha;estrategia;porcentaje"
     */
    public LinkedList<String> informacion_evaluaciones(String materia_elegida, String seccion_elegida){
        //id;PC;20%;CP-401;GERENCIA EDUCATIVA;27/09/2015
        // 1;1 ;20 ;  1   ;GERENCIA EDUCATIVA;27/09/2015
        LinkedList<String> elementos = new LinkedList<>();
        evaluaciones.stream()
                    .filter(evaluacion -> materia_elegida.equalsIgnoreCase(evaluacion.getMateria()) && 
                                 seccion_elegida.equalsIgnoreCase(this.obtener_seccion(String.valueOf(evaluacion.getIdSecciones())))) // si es la misma materia y seccion de interes
                    .forEach(evaluacion -> elementos.add(
                                                         evaluacion.getId()+";"+
                                                         evaluacion.getFecha()+";"+
                                                         this.obtener_estrategia(String.valueOf(evaluacion.getIdEstrategias())).getTipo()+";"+
                                                         evaluacion.getPorcentaje()));
     
        return elementos;
    }
   
    
    /**Este metodo carga todas las evaluaciones que han sido ofertadas por el usuario de todas las secciones
     @return Devuelvue una lista LinkedList con la siguiente estrutura ejm.<br>
        id;PC;20%;CP-401;GERENCIA EDUCATIVA;27/09/2015
     */ 
    public LinkedList<String> todas_evaluaciones(){
        //id;PC;20%;CP-401;GERENCIA EDUCATIVA;27/09/2015
        // 1;1 ;20 ;  1   ;GERENCIA EDUCATIVA;27/09/2015
        
        LinkedList<String> elementos = new LinkedList<>();
        
        evaluaciones.stream()
                    .forEach(aux -> elementos.add(// agregando las evaluaciones de interes
                                                    aux.getId()+";"
                                                    +this.obtener_estrategia(String.valueOf(aux.getIdEstrategias())).getDescripcion()+";" // se sobre escribe el id_seccion al nombre real
                                                    +aux.getPorcentaje()+"%;"
                                                    +this.obtener_seccion(String.valueOf(aux.getIdSecciones()))+";" // obteniendo los valores a partir del id_estrategias
                                                    +aux.getMateria()+";"
                                                    +aux.getFecha()));
       // elementos.stream().forEach(s->System.out.println("evaluaciones mejorada: "+s));
        return elementos;    
    }
    
    
    /**Metodo que se encarga de buscar a la id de la cedula de interes
     * @param id: id del estudiante;
     * @return Devuelve un texto con la cedula*/
    public String id_cedula(String cedula){        
        String id = null;
        
        for(Estudiantes estudiante : estudiantes){
            if(estudiante.getCedula().equalsIgnoreCase(cedula)){
                id = String.valueOf(estudiante.getIdEstudiante());
                break;
            }
        }
        
        return id;
    }
    
    /** Este metodo extrae todas las notas vinculadas a la id_ced de interes
     * @param id_ced: id de la cedula
     * @return Registros con las notas el id_ced con la estructura "id;id_est;id_eva;nota"
     */
    private LinkedList<Notas> notas_estudiante(String id_ced){        
        LinkedList<Notas> datos = new LinkedList<>();
       // String[] elemento = new String[]{};
       
        // id;id_est;id_eva;nota
        //  1;  25  ;  1   ; 18                
        notas.stream().filter(nota -> String.valueOf(nota.getIdEstudiantes()).equalsIgnoreCase(id_ced))
                      .forEach(datos::add);
        
     return datos;
    }
    
    /**
     */
    private String buscar_evaluacion(LinkedList<String> eva, String id){      
        String[] elementos = null;
        
        for(String aux : eva){ // Recorriendo las evaluaciones ofertadas
             elementos = aux.split(";");
            
            if(elementos[0].equalsIgnoreCase(id)){ // Si los id coinciden                
                break; // Se sale del ciclo y se conserva el valor recuperado
            }
        }
        
        return elementos[1]+";"+elementos[2]+";"+elementos[3];
    }
    
    /**Este metodo se encarga de adecuar los registros de las notas de cada estudiante sustituyendo los id por el valor real
     * @param lote: grupo de notas del estudiante
     * @param cedula: ci real del estudiante
     * @return Devuelve el lote de materias acondicionadas.  */ 
    private LinkedList<String> adecuacion_notas(LinkedList<Notas> lote, LinkedList<String> eva, String cedula){
        LinkedList<String> datos = new LinkedList<>();
        lote.stream()
            .forEach(s -> datos.add( // Sustituyendo el registro por la nueva configuracion
                                    s.getId()+";"+
                                    cedula+";"+ // // Sustituyendo el id_ced por la cedula
                                    this.buscar_evaluacion(eva, String.valueOf(s.getIdEvaluaciones()))+";"+ 
                                    s.getNota())); // Sustituyendo el id_eva por la evaluacion ofertada sin el id
        
        return datos;
    }
    
    /**Este metodo proporciona todas las notas de los estudiantes de la seccion y materia de interes
     * @param materia_elegida: Materia de Interes
     * @param seccion_elegida: Seccion de Interes
     * @param cedulas: Estudiantes pertenecientes a la materia y seccion de interes 
       @return Devuelve un registro con la siguiente estructura por texto "id;cedula;fecha;estrategia;porciento;nota" */
    public LinkedList<String> notas_acta(String materia_elegida, String seccion_elegida, LinkedList<String> cedulas){
        String id_ced = null;        
        
        LinkedList<String> eva = this.informacion_evaluaciones(materia_elegida, seccion_elegida);
        LinkedList<String> registros = new LinkedList<>();
        
        for(String ced : cedulas){ // Recorriendo todos los estudiantes de la seccion materia de interes
            //System.out.println("alumno: "+ced);
            id_ced = this.id_cedula(ced); // hallando el id de la cedula de interes
            //System.out.println("id_ced "+id_ced);
            LinkedList<Notas> notas_estudiante = this.notas_estudiante(id_ced); // Extrayendo todas las notas asociada a la id de la cedula
            //System.out.println("notas capacidad: "+notas_estudiante.size());
            registros.addAll(this.adecuacion_notas(notas_estudiante, eva, ced)); // Agregando registros
            //System.out.println("registros capacidad: "+registros.size());
           
        } // Fin recorrido
        
        
        return registros;
    }
    
    
    public String definitivas_letras(int definitiva){
        String palabra = null;
            switch(definitiva){
                case 0:
                    palabra = "CERO";
                break;    
                case 1:
                    palabra = "CERO UNO";
                break;
                case 2:
                    palabra = "CERO DOS";
                break;
                case 3:
                    palabra = "CERO TRES";
                break;    
                case 4:
                    palabra = "CERO CUATRO";
                break;    
                case 5:
                    palabra = "CERO CINCO";
                break;        
                case 6:
                    palabra = "CERO SEIS";
                break;    
                case 7:
                    palabra = "CERO SIETE";
                break;        
                case 8:
                    palabra = "CERO OCHO";
                break;        
                case 9:
                    palabra = "CERO NUEVE";
                break;        
                case 10:
                    palabra = "DIEZ";
                break;        
                case 11:
                    palabra = "ONCE";
                break;        
                case 12:
                    palabra = "DOCE";
                break;
                case 13:
                    palabra = "TRECE";
                break;
                case 14:
                    palabra = "CATORCE";
                break;    
                case 15:
                    palabra = "QUINCE";
                break;    
                case 16:
                    palabra = "DIECISEIS";
                break;     
                case 17:
                    palabra = "DIECISIETE";
                break;
                case 18:
                    palabra = "DIECIOCHO";
                break;
                case 19:
                    palabra = "DIECINUEVE";
                break;    
                case 20:
                    palabra = "VEINTE";
                break;
                default: 
                    palabra = "NO EXISTE";
                break;    
                    
            }
            
        return palabra;
    }
    
     /**Este metodo determina un id que no se repita y sea secuencial dentro de la lista de items.
      @param registros: Representa los elementos que se desean revisar para determinar una id unica. Analiza la id de cada registro 
      @return id disponible
     */
    public String id_disponible(LinkedList<String> registros){
        String id = "0"; //Estableciendo que el primer valor es cero para que el conteo sea la unidad en caso de que no existan registros
        
            for(String dato : registros){
                String aux = dato.split(";")[0];                
                    if(this.es_numerico(aux)) id = aux; // se almacena el id                   
            }
        
            id = String.valueOf(Integer.valueOf(id) + 1); // sumando uno a partir del ultimo id
            
      return id;
    }
    
    
}//fin de la clase
