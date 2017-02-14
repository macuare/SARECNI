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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import sarecni.MODELO.Registro_Notas;
import sarecni.MODELO.Ventanas_Auxiliares;

/**
 * FXML Controller class
 *
 * @author andy
 */
public class NUEVA_NOTAController implements Initializable {
    private Ventanas_Auxiliares va;
    private Registro_Notas rn;

    @FXML
    private ComboBox<String> Evaluaciones;

    @FXML
    private TextField Nota_Evaluacion;

    @FXML
    private Button Guardar;

    @FXML
    void GUARDAR_NOTA(ActionEvent event) {
        if(Nota_Evaluacion.getText() == null) Nota_Evaluacion.setText("0");
        va.cerrar_ventana(true, Guardar);
    }

    @FXML
    void TIPEANDO(KeyEvent event) {
        System.out.println("tipeando");
       
        Nota_Evaluacion.setText(rn.limite_notas(Nota_Evaluacion.getText()));
        Nota_Evaluacion.end();
        
                
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        va = new Ventanas_Auxiliares();
        rn = new Registro_Notas();
                
    }    
    
}
