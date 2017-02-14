/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarecni.CONTROLADOR.Auxiliares;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import sarecni.MODELO.Ventanas_Auxiliares;

/**
 * FXML Controller class
 *
 * @author ANDY
 */
public class NUEVA_OFERTAController implements Initializable {
    private Ventanas_Auxiliares va;
    @FXML
    private Button Agregar;

    @FXML
    private ComboBox<String> Ponderacion;

    @FXML
    private DatePicker Fecha;

    @FXML
    private ComboBox<String> Seccion_Materia;

    @FXML
    private ComboBox<String> Estrategia;

    
    @FXML
    void AGREGAR_OFERTA(ActionEvent event) {
        va.cerrar_ventana(true, Agregar);

    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        va = new Ventanas_Auxiliares();
        
        
    }    
    
}
