/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sarecni.MODELO;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author AN
 */
public class Despliegue {

    public Despliegue() {
    }
    
    /** Metodo para lanzar algo.
     * 
     * @param String direccion
     * @return void
     * @throws IOException
     * @see IOException
     */
    public void lanzar(String direccion){
        try {
            Stage ventana = new Stage(StageStyle.TRANSPARENT);
            
            
            FXMLLoader fxml = new FXMLLoader();
            Parent root = fxml.load(getClass().getResource(direccion));
            
            Scene scene = new Scene(root);
            scene.setFill(null);
            
            ventana.initModality(Modality.APPLICATION_MODAL);
            ventana.setScene(scene);
            
            new Efectos_Especiales().desvanecencia(root, 1000);
            
            ventana.showAndWait();
           
            
        } catch (IOException ex) {
            Logger.getLogger(Despliegue.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}//fin de la clase
