/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sarecni.MODELO;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author AN
 */
public class Ventanas_Auxiliares {
    private double ox, oy;
    private double rx, ry;
    private FXMLLoader fxml;
    
  
    public Ventanas_Auxiliares() {
        ox = 0.0; oy = 0.0;
        rx = 0.0; ry = 0.0;
    }

    public FXMLLoader getFxml() {
        return fxml;
    }
    
    
     public void cerrar_ventana(boolean cerrar, Button boton){
        if(cerrar){
            Stage st = (Stage) boton.getScene().getWindow();
            st.close();
        }else{}
    }
     
    public void cerrar_ventana(boolean cerrar, Node nodo){
        if(cerrar){
            Stage st = (Stage) nodo.getScene().getWindow();
            st.close();
        }else{}
    }
   
    private Node busqueda_recursiva(Parent raiz, String elemento){
        Node nodo = null;
        boolean encontrado = false;
            
            //System.out.println("Buscando: "+elemento);
          //  System.out.println(" raiz: "+raiz.getId()+" contenido: "+raiz.getChildrenUnmodifiable().size());
        // System.out.println("Existe: "+raiz.lookup("#"+raiz.getId()).getId());
        
            if(elemento.equalsIgnoreCase(("#"+raiz.getId()))){ //Elemento encontrado
                    encontrado = true;
                    nodo = raiz;
            }else{ // Se busca dentro del contenedor de cada parent
                for(int i=0; i<raiz.getChildrenUnmodifiable().size(); i++){ // Recorriendo cada elemento
                    nodo = raiz.getChildrenUnmodifiable().get(i); // Almacenando el nodo                    
                       // System.out.println((i+1)+"  revisando: "+nodo.getId()); 
                       
                     if(("#"+nodo.getId()).equalsIgnoreCase(elemento)){ // Si son iguales, encontro el elemento de interes      
                        // System.out.println("   encontrado: "+elemento);
                         encontrado = true;
                         break;
                     }else{                        
                         encontrado = false;
                         if(nodo instanceof AnchorPane && !encontrado){/*System.out.println("    RECURSIVIDAD: ")*/;nodo = this.busqueda_recursiva((Parent) nodo, elemento); if(nodo == null)encontrado = false; else encontrado = true;}
                         if(nodo instanceof Pane && !encontrado){/* System.out.println("    RECURSIVIDAD: ");*/nodo = this.busqueda_recursiva((Parent)((Pane) nodo), elemento); if(nodo == null)encontrado = false; else encontrado = true;}
                         if(nodo instanceof ScrollPane && !encontrado){ /*System.out.println("    RECURSIVIDAD: scrollpane");*/ nodo = this.busqueda_recursiva((Parent)((ScrollPane)nodo).getContent(), elemento); if(nodo == null)encontrado = false; else encontrado = true;}
                         if(nodo instanceof TabPane && !encontrado){/*System.out.println("    RECURSIVIDAD: ");System.out.println("revisando tabpane"); */
                             TabPane pesta = ((TabPane)nodo);
                             for(int t=0; t<pesta.getTabs().size(); t++){//System.out.println("      pestña "+(t+1)); 
                                pesta.getSelectionModel().select(t);
                                nodo = this.busqueda_recursiva((Parent) pesta.getSelectionModel().getSelectedItem().getContent(), elemento);           
                               // nodo = this.busqueda_recursiva((Parent) pesta.getTabs().get(i).getContent(), elemento); 
                                if(nodo == null){encontrado = false;} else {encontrado = true; break;}
                             }
                         }
                     }
                     
                    if(!encontrado){ 
                        nodo = null; // Despues de todas las revisiones
                       // System.out.println("NODO NO ENCONTRADO...!!!");
                    }else{break;}
                } // Fin recorrido raiz
            }
            
            
            
            
      //  System.out.println("--> NODO RETORNADO: "+nodo );    
        return nodo;
    }
    
      public String recuperar(Parent root, String tipo, String id){
          String recuperado = null;
        id = "#"+id;//agregando el simbolo especial de los identificadores
       // System.out.println("identificador: "+id+" roots:"+root.getChildrenUnmodifiable().get(0));
        String opcion = tipo;
        switch(opcion){
            case "button":
             //Button b = (Button) root.lookup(id);
               Button b = (Button) this.busqueda_recursiva(root, id); 
                    recuperado = b.getText();
            break;
            case "TextArea":                
             TextArea ta = (TextArea) this.busqueda_recursiva(root, id);             
                    recuperado = ta.getText();
            break;   
            case "Label":
             Label texto = (Label) this.busqueda_recursiva(root, id);
                  recuperado = texto.getText();
            break; 
            case "TextField":
             TextField tf =  (TextField) this.busqueda_recursiva(root, id);
                  recuperado = tf.getText();
            break;
            case "ComboBox":
             ComboBox cb =  (ComboBox) this.busqueda_recursiva(root, id);
                  recuperado = cb.getSelectionModel().getSelectedItem().toString();
            break;
            case "ListView":
             ListView lv =  (ListView) this.busqueda_recursiva(root, id);
                  recuperado = lv.getSelectionModel().getSelectedItem().toString();
            break;    
            case "CheckBox":
             CheckBox cbx =  (CheckBox) this.busqueda_recursiva(root, id);
                  recuperado = String.valueOf(cbx.isSelected());
            break;
            case "DatePicker":
             DatePicker dp =  (DatePicker) this.busqueda_recursiva(root, id);
                  recuperado = (dp.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            break;    
            default:
                System.out.println("No se identifico el tipo de elemento");
               
            break;
            
        };
        
        return recuperado;
    }
     
      /** Este metodo es para modificar el contenido del FXML.
       * <br>root es el contenedor principal
       * <br>tipo es el objeto que se va a modificar ejm. Button<br>id es el identificador del objeto<br>informacion es el contenido a agregar
       */
    public Parent modificar(Parent root, String tipo, String id, Object informacion){
     
        id = "#"+id;//agregando el simbolo especial de los identificadores
       // System.out.println("identificador: "+id+" roots:"+root.getChildrenUnmodifiable().get(0));
       // System.out.println("SOLICITANDO:_ "+id);
        String opcion = tipo;
       // System.out.println("modificar: "+id+" - "+tipo);
        switch(opcion){
            case "button":
             Button b = (Button) this.busqueda_recursiva(root, id);
                    b.setText(informacion.toString());
            break;
            case "TextArea":              
             TextArea ta = (TextArea) this.busqueda_recursiva(root, id);             
                    ta.setText(informacion.toString());
            break;   
            case "Label":
             Label texto = (Label) this.busqueda_recursiva(root, id);
                  texto.setText(informacion.toString());
            break; 
            case "TextField":
             TextField tf = (TextField) this.busqueda_recursiva(root, id);
                  tf.setText(informacion.toString());
            break; 
            case "AnchorPane":
             AnchorPane ap = (AnchorPane) this.busqueda_recursiva(root, id);
                  ap.setId(informacion.toString());
            break; 
            case "CheckBox":                
             //CheckBox cbx =  (CheckBox) root.lookup(id);
                CheckBox cbx =  (CheckBox) this.busqueda_recursiva(root, id);
                  cbx.setSelected(Boolean.valueOf(informacion.toString()));           
            break;
            case "ImageView":       
             ImageView iv =  (ImageView) this.busqueda_recursiva(root, id);
                iv.setImage(new Image(new File(informacion.toString()).toURI().toString()));            
            break;
            case "DatePicker":
             DatePicker dp =  (DatePicker) this.busqueda_recursiva(root, id);
                        dp.setValue(LocalDate.parse(informacion.toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        //().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            break;
            default:
                System.out.println("No se identifico el tipo de elemento1: "+id);
                root =  null;
            break;
            
        };
        return root;
    }
    
     public Parent modificar(Parent root, String tipo, String id, LinkedList<String> informacion) {
           id = "#"+id;//agregando el simbolo especial de los identificadores
       // System.out.println("identificador: "+id+" roots:"+root.getChildrenUnmodifiable().get(0));
        String opcion = tipo;
        switch(opcion){           
            case "ComboBox":
             ComboBox cb =  (ComboBox) this.busqueda_recursiva(root, id);//root.lookup(id);              
                cb.getItems().clear();
                cb.getItems().addAll(informacion);
                cb.getSelectionModel().select(0);
            break; 
            case "ListView":
             ListView lv =  (ListView) this.busqueda_recursiva(root, id);//root.lookup(id);              
                lv.getItems().clear();
                lv.getItems().addAll(informacion);
                //lv.getSelectionModel().select(0);
            break;     
            default:
                System.out.println("No se identifico el tipo de elemento2: "+id);
                root =  null;
            break;
            
        };
        return root;
        
    }
     
    public Parent cargar(String direccion){
        //FXMLLoader fxml = new FXMLLoader();
        fxml = new FXMLLoader();
        Parent root = null; 
        try {
            root = fxml.load(getClass().getResource(direccion));
        } catch (IOException ex) {
            Logger.getLogger(Ventanas_Auxiliares.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return root;
    }
    
    private void movimientos_ventana(Scene sc, Stage st){
           final Scene escena = sc;   
           final Stage stg = st;
           
            escena.setOnMouseDragged(new EventHandler<MouseEvent>() {//arrastrando. A partir de la referencia se realiza los desplazamientos
                @Override
                public void handle(MouseEvent t) {
                    //System.out.println("arrastrando ventana");
                   double x = t.getScreenX(), y = t.getScreenY();                   
                    double deltaX, deltaY;
                    deltaX = x - rx;
                    deltaY = y - ry;                  
                    stg.setX(ox + deltaX);
                    stg.setY(oy + deltaY);
                }
            });
            escena.setOnMousePressed(new EventHandler<MouseEvent>() {//presionando boton del raton. Estableciendo referencia de la ventana
                @Override
                public void handle(MouseEvent t) {
                 //  System.out.println("presionando ventana");
                    ox = escena.getWindow().getX(); oy = escena.getWindow().getY();//origen del panel
                    rx = t.getScreenX();  ry = t.getScreenY();//origen del raton                     
                }
            });
    
    }
    
    public void desplegar(Parent root){
     
      //  this.movimientos(root);
            
            final Stage ventana = new Stage(StageStyle.TRANSPARENT);
            
            Scene scene = new Scene(root);
            scene.setFill(null);
          
            ventana.initModality(Modality.APPLICATION_MODAL);
            ventana.setScene(scene);
            this.movimientos_ventana(scene, ventana);
            
            new Efectos_Especiales().desvanecencia(root, 1000);
            
            ventana.showAndWait();
        
    }
    
    /**Este metodo permite desplegar una ventana independiente */
    public void desplegar_permanente(Parent root){
        final Stage ventana = new Stage(StageStyle.TRANSPARENT);
            
            Scene scene = new Scene(root);
            scene.setFill(null);
           
            ventana.initModality(Modality.APPLICATION_MODAL);
            ventana.setScene(scene);
            this.movimientos_ventana(scene, ventana);
            
            new Efectos_Especiales().desvanecencia(root, 1000);
            
            ventana.show();    
    }
    
    public void mensaje_informacion(String titulo, String comentario){
        Parent componente = null;
        componente = this.cargar("/sarecni/VISTA/Auxiliares/INFORMACION.fxml");
        componente = this.modificar(componente, "TextArea", "Comentarios", comentario);//modificando el contenido de un elemento de la vista
        componente = this.modificar(componente, "Label", "Titulo", titulo);//modificando el contenido de un elemento de la vista        
        this.desplegar(componente);                
    }
    
    /**Metodo de confirmacion de operacion
     * @return  Boolean*/
    public boolean mensaje_confirmacion(String titulo, String comentario){
        boolean respuesta = false;
        
        Parent componente = null;
        componente = this.cargar("/sarecni/VISTA/Auxiliares/CONFIRMACION.fxml");
        componente = this.modificar(componente, "TextArea", "Comentarios", comentario);//modificando el contenido de un elemento de la vista
        componente = this.modificar(componente, "Label", "Titulo", titulo);//modificando el contenido de un elemento de la vista
        this.desplegar(componente);                
        respuesta = Boolean.valueOf(componente.getId());//se convierte el string almacenado en el id del anchorpane en un booleano como respuesta de la desicion tomada
        
//        System.out.println("componennte comfirmacion: "+componente.getId());
        
        return respuesta;
    }
    

    public String abrir_ruta_archivo(String titulo_ventana){
        String ruta = null;
        File archivo = null;       
        
        FileChooser fc = new FileChooser(); 
        fc.setTitle(titulo_ventana);
        
        archivo = fc.showOpenDialog(new Stage());
        
        if(archivo != null){
            if(archivo.isFile()){
               ruta = archivo.getPath();
            }else{
               this.mensaje_informacion("NOTIFICACIÓN", "DISCULPE, PERO DEBE SELECCIONAR UN ARCHIVO...!!!");
               ruta = this.abrir_ruta_archivo(titulo_ventana);
            }
        }else{
            this.mensaje_informacion("NOTIFICACIÓN", "BUSQUEDA CANCELADA...!!!");
        }
        
        return ruta;
    }
   
    public void agregar_comentario(Node nodo, String comentario){
         Tooltip tt = new Tooltip();
                     tt.setWrapText(true);
                     tt.setPrefSize(300, 300);
                     tt.setMaxSize(300, 300);
                     tt.setTextAlignment(TextAlignment.JUSTIFY);
                     tt.setText(comentario);
                     tt.install(nodo,tt);//este es un metodo estatico.
    }
    
    public Node modificacion_avanzada(Parent raiz, String id_nodo){       
        id_nodo = "#"+id_nodo;                
        Node nodo = this.busqueda_recursiva(raiz, id_nodo);           
      return nodo;
    }
    
    
    
}