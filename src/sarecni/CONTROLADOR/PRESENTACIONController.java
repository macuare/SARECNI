/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarecni.CONTROLADOR;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import sarecni.MODELO.Ventanas_Auxiliares;

/**
 * FXML Controller class
 *
 * @author Andy Cusatti
 */
public class PRESENTACIONController implements Initializable {
   
    
    @FXML
    private ProgressBar Barra;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                try {System.out.println("ejecutando hilo");
                    Thread.sleep(5000);
                    Ventanas_Auxiliares va = new Ventanas_Auxiliares();
                    va.cerrar_ventana(true, Barra);
                    va.desplegar_permanente(va.cargar("/sarecni/VISTA/INICIO.fxml"));
                } catch (InterruptedException ex) {
                    Logger.getLogger(PRESENTACIONController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
      //  new Ventanas_Auxiliares().cerrar_ventana(true, Barra);
        
        /*
         Efectos_Especiales ee = new Efectos_Especiales();
        ee.presentacion(Fondo, 4000);
        ee.getSt().setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {                 
          
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                            Ventanas_Auxiliares va = new Ventanas_Auxiliares();                   
                            va.desplegar_permanente(va.cargar("/sistema_odontologico/Vista/AUTENTICACION.fxml"));                                  
                    }
                });
                
                new Ventanas_Auxiliares().cerrar_ventana(true, Fondo);
            }
        });   
        
        */
        
    }    
    
}
