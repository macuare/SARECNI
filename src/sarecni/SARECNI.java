/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sarecni;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ANDY
 * SISTEMA AUTOMATIZADO DE REGISTRO, EVALUACION, CONTROL DE NOTAS E INASISTENCIAS
 */
public class SARECNI extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.TRANSPARENT);
        Parent root = FXMLLoader.load(getClass().getResource("/sarecni/VISTA/PRESENTACION.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/sarecni/VISTA/INICIO.fxml"));
      // Parent root = FXMLLoader.load(getClass().getResource("/sarecni/VISTA/OFERTAS.fxml"));
     //  Parent root = FXMLLoader.load(getClass().getResource("/sarecni/VISTA/NOTAS.fxml"));
        stage.setFullScreen(true); // Pantalla completa
        
        Scene scene = new Scene(root);
        
        scene.setFill(null);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
