/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sarecni.MODELO;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Parent;
import javafx.util.Duration;

/**
 *
 * @author AN
 */
public class Efectos_Especiales {
    private FadeTransition ft;
    private SequentialTransition st;
    
    public Efectos_Especiales() {
    }

    public FadeTransition getFt() {
        return ft;
    }

    public void setFt(FadeTransition ft) {
        this.ft = ft;
    }

    public SequentialTransition getSt() {
        return st;
    }

    public void setSt(SequentialTransition st) {
        this.st = st;
    }
    
    
    /**Los parametro son Parent que es el contiene el panel o toda la interfaz grafica y el tiempo expresado en milisegundos */
    public void desvanecencia(Parent root, double tiempo){        
                ft = new FadeTransition(Duration.millis(tiempo), root);
                ft.setFromValue(0.0f);
                ft.setToValue(1.0f);
                ft.play();
                /*
                ft.setOnFinished(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                      System.out.println("Termino la animacion");
                    }
                });*/
                
    }
    
    public void desvanecencia_salida(Parent root, double tiempo){        
                ft = new FadeTransition(Duration.millis(tiempo), root);
                ft.setFromValue(1.0f);
                ft.setToValue(0.0f);
                ft.play(); 
                
    }
    
    public void presentacion(Parent root, double tiempo){
    
        
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(tiempo), root);
                fadeTransition.setFromValue(0.0f);
                fadeTransition.setToValue(1.0f);
             //   fadeTransition.setCycleCount(Timeline.INDEFINITE);
                fadeTransition.setAutoReverse(true);
         //       fadeTransition.play(); 
        FadeTransition fadeTransition1 = new FadeTransition(Duration.millis(tiempo), root);
                fadeTransition1.setFromValue(1.0f);
                fadeTransition1.setToValue(0.0f);
              //  fadeTransition1.setCycleCount(Timeline.INDEFINITE);
                fadeTransition1.setAutoReverse(true);
           //     fadeTransition1.play();  
    
         st = new SequentialTransition();
         st.getChildren().addAll(fadeTransition, fadeTransition1);
         st.play();
         
         
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}//fin de la clase
