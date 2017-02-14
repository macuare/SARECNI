/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarecni.CONTROLADOR;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sarecni.MODELO.FORMATOS.FormatoEvaluacionesOfertadas;
import sarecni.MODELO.Registro_Evaluaciones;
import sarecni.MODELO.Ventanas_Auxiliares;

/**
 * FXML Controller class
 *
 * @author ANDY
 */
public class OFERTASController implements Initializable {
   private Registro_Evaluaciones re;
  

    @FXML
    private ObservableList<FormatoEvaluacionesOfertadas> informacion;
            
    @FXML
    private TableView<FormatoEvaluacionesOfertadas> Evaluaciones_Ofertadas;

    @FXML
    private TableColumn<FormatoEvaluacionesOfertadas, String> Ponderacion;

    @FXML
    private TableColumn<FormatoEvaluacionesOfertadas, String> Fecha;

    @FXML
    private TableColumn<FormatoEvaluacionesOfertadas, String> Seccion;

    @FXML
    private TableColumn<FormatoEvaluacionesOfertadas, String> Estrategia;

    @FXML
    private TableColumn<FormatoEvaluacionesOfertadas, Integer> Id;

    @FXML
    private TableColumn<FormatoEvaluacionesOfertadas, String> Materia;
    
    @FXML
    void NUEVA_OFERTA(ActionEvent event) {
        re.ofertar_evaluacion();
        re.evaluaciones_ofertadas(informacion, Evaluaciones_Ofertadas);
    }

    @FXML
    void MODIFICAR_OFERTA(ActionEvent event) {
        re.modificar_evaluacion(Evaluaciones_Ofertadas);
        re.evaluaciones_ofertadas(informacion, Evaluaciones_Ofertadas);

    }

    @FXML
    void ELIMINAR_OFERTA(ActionEvent event) {
        re.eliminacion_evaluacion(Evaluaciones_Ofertadas);
        re.evaluaciones_ofertadas(informacion, Evaluaciones_Ofertadas);
    }
    
    @FXML
    void CERRAR_VENTANA(ActionEvent event) {
        new Ventanas_Auxiliares().cerrar_ventana(true, Evaluaciones_Ofertadas);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        re = new Registro_Evaluaciones();
        
        informacion = FXCollections.observableArrayList();
        Id.setCellValueFactory(new PropertyValueFactory<FormatoEvaluacionesOfertadas, Integer>("id"));
        Estrategia.setCellValueFactory(new PropertyValueFactory<FormatoEvaluacionesOfertadas, String>("estrategia"));
        Ponderacion.setCellValueFactory(new PropertyValueFactory<FormatoEvaluacionesOfertadas, String>("ponderacion"));
        Fecha.setCellValueFactory(new PropertyValueFactory<FormatoEvaluacionesOfertadas, String>("fecha"));
        Seccion.setCellValueFactory(new PropertyValueFactory<FormatoEvaluacionesOfertadas, String>("seccion"));
        Materia.setCellValueFactory(new PropertyValueFactory<FormatoEvaluacionesOfertadas, String>("materia"));
        
        re.evaluaciones_ofertadas(informacion, Evaluaciones_Ofertadas);
        
        
    }    
    
}
