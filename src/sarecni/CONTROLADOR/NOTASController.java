/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarecni.CONTROLADOR;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sarecni.MODELO.FORMATOS.FormatoNotaIndividual;
import sarecni.MODELO.Registro_Notas;
import sarecni.MODELO.Ventanas_Auxiliares;

/**
 * FXML Controller class
 *
 * @author andy
 */
public class NOTASController implements Initializable {
    private Registro_Notas rn;
    
    
    @FXML
    private Label Posicion;

    @FXML
    private TableView<FormatoNotaIndividual> Tabla_Notas;
    
    @FXML
    private TableColumn<FormatoNotaIndividual, Parent> Notas_Estudiante;

    @FXML
    private ComboBox<String> Seccion_Materia;

    @FXML
    private Label Estudiante;

    @FXML
    private Label Acumulado;

    @FXML
    private Label Evaluado;

    @FXML
    private Label Estado;

    @FXML
    private Label Restante;
    
     @FXML
    private Button Izquierda;

    @FXML
    private Button Derecha;

    @FXML
    void ANTERIOR(ActionEvent event) {        
        rn.avanzar_retroceder_lista("RETROCEDER");
    }

    @FXML
    void POSTERIOR(ActionEvent event) {        
        rn.avanzar_retroceder_lista("AVANZAR");
    }
    
     @FXML
    void SELECCION(ActionEvent event) {
        rn.refrezcar();
    }
    
    @FXML
    void VENTANA_EMERGENTE(MouseEvent event) {
        rn.vista_rapida();
    }
    
    @FXML
    void ELIMINAR_NOTA(ActionEvent event) {
        rn.eliminar_nota_estudiante();
    }

    @FXML
    void MODIFICAR_NOTA(ActionEvent event) {
         rn.modificar_nota_estudiante(true);
    }

    @FXML
    void AGREGAR_NOTA(ActionEvent event) {       
        rn.agregar_nota_estudiante();
    }
    
     @FXML
    void CERRAR_VENTANA(ActionEvent event) {
         System.out.println("cerrando venatana notas");
         new Ventanas_Auxiliares().cerrar_ventana(true, Estado);
    }    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Notas_Estudiante.setCellValueFactory(new PropertyValueFactory<>("panel"));        
        rn = new Registro_Notas(Seccion_Materia, Tabla_Notas, Posicion, Estudiante, Acumulado, Evaluado, Estado, Restante);    
        
        //System.out.println("---cargando vista: "+Estudiante.getText()+" estatica: "+Registro_Componentes.temporal);
        rn.inicializacion_avanzada(null);
       
        
    }    
    
}
