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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AN
 */
public class INFORMACIONController implements Initializable{

    @FXML
    private Button Aceptar;
    @FXML
    private TextArea Comentarios;
    @FXML
    private ImageView Imagen;
    @FXML
    private Label Titulo;

   @FXML
    private AnchorPane Contenedor;

    
   @FXML   
    private double ox, oy;
    double rx, ry;
    
    @FXML
    void ACEPTANDO(ActionEvent event) {
        Stage st = (Stage) Aceptar.getScene().getWindow();
        st.close();
    }
    
     @FXML
    void ARRASTRADO(MouseEvent event) {
        double x = event.getSceneX() ,y = event.getSceneY();
        double deltaX, deltaY;
        deltaX = x - rx;
        deltaY = y - ry;
        Contenedor.setLayoutX(ox + deltaX);
        Contenedor.setLayoutY(oy + deltaY);
    }

    @FXML
    void PRESIONADO(MouseEvent event) {
         ox = Contenedor.getLayoutX(); oy = Contenedor.getLayoutY();//origen del panel
        rx =  event.getSceneX();  ry = event.getSceneY();
    }

    
    
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //TODO
    }
    
}
