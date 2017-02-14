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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sarecni.MODELO.Ventanas_Auxiliares;


/**
 * FXML Controller class
 *
 * @author AN
 */
public class CONFIRMACIONController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Ventanas_Auxiliares va;
     @FXML
    private Button Aceptar;

    @FXML
    private Button Cancelar;

    @FXML
    private TextArea Comentarios;

    @FXML
    private ImageView Imagen;

    @FXML
    private Label Titulo;

   @FXML
    private AnchorPane Panel_Ancla;
    

    @FXML
    void ACEPTADO(ActionEvent event) {
        va.cerrar_ventana(true, Aceptar);        
    }

    @FXML
    void CANCELADO(ActionEvent event) {
        Cancelar.setDisable(true);
        Panel_Ancla.setId("false");//se pasa el elemento como id del contenedor
        va.cerrar_ventana(true, Cancelar);
        
    }

    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Panel_Ancla.setId("true");//se pasa el elemento como id del contenedor principal
        va = new Ventanas_Auxiliares();
    }    
    
}
