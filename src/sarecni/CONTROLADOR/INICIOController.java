/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sarecni.CONTROLADOR;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sarecni.MODELO.FORMATOS.FormatoInasistencias;
import sarecni.MODELO.FORMATOS.FormatoNotas;
import sarecni.MODELO.Registro_Componentes;

/**
 * FXML Controller class
 *
 * @author ANDY
 */
public class INICIOController implements Initializable {
    private Registro_Componentes rc;
    
    @FXML
    private Menu Actas;
    @FXML
    private ObservableList<FormatoNotas> datos_notas;    
    @FXML
    private TableView<FormatoNotas> Acta_Notas;    
    @FXML
    private TableColumn<FormatoNotas, Integer> Nro;
    @FXML
    private TableColumn<FormatoNotas, String> Cedula;
    @FXML
    private TableColumn<FormatoNotas, String> Nombres;
    @FXML
    private TableColumn<FormatoNotas, String> Apellidos;   
    @FXML
    private TableColumn<FormatoNotas, String> Definitiva;   
    @FXML
    private TableColumn<FormatoNotas, String> Letras;   
    @FXML
    private TableColumn<FormatoNotas, String> Evaluacion1;
    @FXML
    private TableColumn<FormatoNotas, String> Evaluacion10;
    @FXML
    private TableColumn<FormatoNotas, String> Evaluacion2;
    @FXML
    private TableColumn<FormatoNotas, String> Evaluacion3;
    @FXML
    private TableColumn<FormatoNotas, String> Evaluacion4;
    @FXML
    private TableColumn<FormatoNotas, String> Evaluacion5;
    @FXML
    private TableColumn<FormatoNotas, String> Evaluacion6;
    @FXML
    private TableColumn<FormatoNotas, String> Evaluacion7;
    @FXML
    private TableColumn<FormatoNotas, String> Evaluacion8;
    @FXML
    private TableColumn<FormatoNotas, String> Evaluacion9;
    @FXML
    private TableColumn<FormatoNotas, String> Fecha1;
    @FXML
    private TableColumn<FormatoNotas, String> Fecha10;
    @FXML
    private TableColumn<FormatoNotas, String> Fecha2;
    @FXML
    private TableColumn<FormatoNotas, String> Fecha3;
    @FXML
    private TableColumn<FormatoNotas, String> Fecha4;
    @FXML
    private TableColumn<FormatoNotas, String> Fecha5;
    @FXML
    private TableColumn<FormatoNotas, String> Fecha6;
    @FXML
    private TableColumn<FormatoNotas, String> Fecha7;
    @FXML
    private TableColumn<FormatoNotas, String> Fecha8;
    @FXML
    private TableColumn<FormatoNotas, String> Fecha9;  
    @FXML
    private TableColumn<FormatoNotas, String> Porciento1;
    @FXML
    private TableColumn<FormatoNotas, String> Porciento10;
    @FXML
    private TableColumn<FormatoNotas, String> Porciento2;
    @FXML
    private TableColumn<FormatoNotas, String> Porciento3;
    @FXML
    private TableColumn<FormatoNotas, String> Porciento4;
    @FXML
    private TableColumn<FormatoNotas, String> Porciento5;
    @FXML
    private TableColumn<FormatoNotas, String> Porciento6;
    @FXML
    private TableColumn<FormatoNotas, String> Porciento7;
    @FXML
    private TableColumn<FormatoNotas, String> Porciento8;
    @FXML
    private TableColumn<FormatoNotas, String> Porciento9;
    
    @FXML
    private Label Periodo;
    @FXML
    private Label Uc;    
    @FXML
    private Label Carrera;
    @FXML
    private Label Seccion;
    @FXML
    private Label CI;
    @FXML
    private Label Materia;    
    @FXML
    private Label Profesor;    
    @FXML
    private ProgressIndicator Acumulado; 
    
    @FXML
    private ObservableList<FormatoInasistencias> datos_inasistencias;  
    @FXML
    private TableView<FormatoInasistencias> Acta_Inasistencias;
    @FXML
    private TableColumn<FormatoInasistencias, Integer> INro;
    @FXML
    private TableColumn<FormatoInasistencias, String> ICedula;
    @FXML
    private TableColumn<FormatoInasistencias, String> IApellidos;
    @FXML
    private TableColumn<FormatoInasistencias, String> INombres;
    @FXML
    private TableColumn<FormatoInasistencias, String> Semana_1;    
    @FXML
    private TableColumn<FormatoInasistencias, String> Teorica_1;
    @FXML
    private TableColumn<FormatoInasistencias, String> Practica_1;
    @FXML
    private TableColumn<FormatoInasistencias, String> Semana_2;
    @FXML
    private TableColumn<FormatoInasistencias, String> Teorica_2;
    @FXML
    private TableColumn<FormatoInasistencias, String> Practica_2;
    @FXML
    private TableColumn<FormatoInasistencias, String> Semana_3;
    @FXML
    private TableColumn<FormatoInasistencias, String> Teorica_3;
    @FXML
    private TableColumn<FormatoInasistencias, String> Practica_3;
    @FXML
    private TableColumn<FormatoInasistencias, String> Semana_4;
    @FXML
    private TableColumn<FormatoInasistencias, String> Teorica_4;
    @FXML
    private TableColumn<FormatoInasistencias, String> Practica_4;
    @FXML
    private TableColumn<FormatoInasistencias, String> Semana_5;
    @FXML
    private TableColumn<FormatoInasistencias, String> Teorica_5;
    @FXML
    private TableColumn<FormatoInasistencias, String> Practica_5;
    @FXML
    private TableColumn<FormatoInasistencias, String> Semana_6;
    @FXML
    private TableColumn<FormatoInasistencias, String> Teorica_6;
    @FXML
    private TableColumn<FormatoInasistencias, String> Practica_6;
    @FXML
    private TableColumn<FormatoInasistencias, String> Semana_7;
    @FXML
    private TableColumn<FormatoInasistencias, String> Teorica_7;
    @FXML
    private TableColumn<FormatoInasistencias, String> Practica_7;
    @FXML
    private TableColumn<FormatoInasistencias, String> Semana_8;
    @FXML
    private TableColumn<FormatoInasistencias, String> Teorica_8;
    @FXML
    private TableColumn<FormatoInasistencias, String> Practica_8;
    @FXML
    private TableColumn<FormatoInasistencias, String> Semana_9;
    @FXML
    private TableColumn<FormatoInasistencias, String> Teorica_9;
    @FXML
    private TableColumn<FormatoInasistencias, String> Practica_9;
    @FXML
    private TableColumn<FormatoInasistencias, String> Semana_10;
    @FXML
    private TableColumn<FormatoInasistencias, String> Teorica_10;
    @FXML
    private TableColumn<FormatoInasistencias, String> Practica_10;
    @FXML
    private TableColumn<FormatoInasistencias, String> Semana_11;
    @FXML
    private TableColumn<FormatoInasistencias, String> Teorica_11;
    @FXML
    private TableColumn<FormatoInasistencias, String> Practica_11;
    @FXML
    private TableColumn<FormatoInasistencias, String> Semana_12;
    @FXML
    private TableColumn<FormatoInasistencias, String> Teorica_12;
    @FXML
    private TableColumn<FormatoInasistencias, String> Practica_12;
    @FXML
    private TableColumn<FormatoInasistencias, String> Semana_13;
    @FXML
    private TableColumn<FormatoInasistencias, String> Teorica_13;
    @FXML
    private TableColumn<FormatoInasistencias, String> Practica_13;
    @FXML
    private TableColumn<FormatoInasistencias, String> Semana_14;
    @FXML
    private TableColumn<FormatoInasistencias, String> Teorica_14;
    @FXML
    private TableColumn<FormatoInasistencias, String> Practica_14;
    @FXML
    private TableColumn<FormatoInasistencias, String> Semana_15;
    @FXML
    private TableColumn<FormatoInasistencias, String> Teorica_15;
    @FXML
    private TableColumn<FormatoInasistencias, String> Practica_15;
    @FXML
    private TableColumn<FormatoInasistencias, String> Semana_16;
    @FXML
    private TableColumn<FormatoInasistencias, String> Teorica_16;
    @FXML
    private TableColumn<FormatoInasistencias, String> Practica_16;
    @FXML
    private TableColumn<FormatoInasistencias, String> Inasistencias;
    @FXML
    private TableColumn<FormatoInasistencias, Integer> IPorciento;
    @FXML
    private TableColumn<FormatoInasistencias, String> Condicion;

    
    @FXML
    void PROCESANDO_ACTAS(ActionEvent event) {  
        System.out.println("Procesando Actas");
        rc.cargando_estudiantes((MenuItem)event.getSource(), datos_notas, Acta_Notas, datos_inasistencias, Acta_Inasistencias);
        rc.cargando_parametros_acta((MenuItem)event.getSource(), Periodo, Uc, Carrera, Seccion, CI, Materia, Profesor);
        rc.cargando_evaluaciones_acta((MenuItem)event.getSource(), Acta_Notas, Acumulado);
        rc.cargando_notas_estudiantes((MenuItem)event.getSource(), datos_notas, Acta_Notas);
    }
       
     @FXML
    void CERRAR_APLICACION(ActionEvent event) {
        System.out.println("Saliendo de la aplicacion");
        Platform.exit();
    }

    @FXML
    void EVALUACIONES(ActionEvent event) {
        System.out.println("Ventana Evaluaciones");
        rc.ventana_evaluaciones();        
    }
    
    @FXML
    void REVISAR_NOTAS(ActionEvent event) {
        rc.ventana_notas();
    }
    
    @FXML
    void NOTAS_ESTUDIANTE_SELECCIONADO(ActionEvent event) {
        //System.out.println("estudiante seleccionado: "+Acta_Notas.getSelectionModel().getSelectedItem().getCedula());
        rc.ventana_notas(Acta_Notas.getSelectionModel().getSelectedItem().getCedula());
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //incializando controles
          //  System.out.println("ruta: "+url.getFile());
        
        //ACTAS DE NOTAS
        datos_notas = FXCollections.observableArrayList();
        
        Nro.setCellValueFactory(new PropertyValueFactory<>("nro"));
        Cedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        Nombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        Apellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        
        Fecha1.setCellValueFactory(new PropertyValueFactory<>("fecha_1"));
        Fecha2.setCellValueFactory(new PropertyValueFactory<>("fecha_2"));
        Fecha3.setCellValueFactory(new PropertyValueFactory<>("fecha_3"));
        Fecha4.setCellValueFactory(new PropertyValueFactory<>("fecha_4"));
        Fecha5.setCellValueFactory(new PropertyValueFactory<>("fecha_5"));
        Fecha6.setCellValueFactory(new PropertyValueFactory<>("fecha_6"));
        Fecha7.setCellValueFactory(new PropertyValueFactory<>("fecha_7"));
        Fecha8.setCellValueFactory(new PropertyValueFactory<>("fecha_8"));
        Fecha9.setCellValueFactory(new PropertyValueFactory<>("fecha_9"));
        Fecha1.setCellValueFactory(new PropertyValueFactory<>("fecha_10"));
        
        Evaluacion1.setCellValueFactory(new PropertyValueFactory<>("evaluacion_1"));
        Evaluacion2.setCellValueFactory(new PropertyValueFactory<>("evaluacion_2"));
        Evaluacion3.setCellValueFactory(new PropertyValueFactory<>("evaluacion_3"));
        Evaluacion4.setCellValueFactory(new PropertyValueFactory<>("evaluacion_4"));
        Evaluacion5.setCellValueFactory(new PropertyValueFactory<>("evaluacion_5"));
        Evaluacion6.setCellValueFactory(new PropertyValueFactory<>("evaluacion_6"));
        Evaluacion7.setCellValueFactory(new PropertyValueFactory<>("evaluacion_7"));
        Evaluacion8.setCellValueFactory(new PropertyValueFactory<>("evaluacion_8"));
        Evaluacion9.setCellValueFactory(new PropertyValueFactory<>("evaluacion_9"));
        Evaluacion10.setCellValueFactory(new PropertyValueFactory<>("evaluacion_10"));
        
        Porciento1.setCellValueFactory(new PropertyValueFactory<>("porciento_1"));
        Porciento2.setCellValueFactory(new PropertyValueFactory<>("porciento_2"));
        Porciento3.setCellValueFactory(new PropertyValueFactory<>("porciento_3"));
        Porciento4.setCellValueFactory(new PropertyValueFactory<>("porciento_4"));
        Porciento5.setCellValueFactory(new PropertyValueFactory<>("porciento_5"));
        Porciento6.setCellValueFactory(new PropertyValueFactory<>("porciento_6"));
        Porciento7.setCellValueFactory(new PropertyValueFactory<>("porciento_7"));
        Porciento8.setCellValueFactory(new PropertyValueFactory<>("porciento_8"));
        Porciento9.setCellValueFactory(new PropertyValueFactory<>("porciento_9"));
        Porciento10.setCellValueFactory(new PropertyValueFactory<>("porciento_10"));
        
        Definitiva.setCellValueFactory(new PropertyValueFactory<>("definitiva"));
        Letras.setCellValueFactory(new PropertyValueFactory<>("letras"));
        
        //ACTA DE INASISTENCIA
        datos_inasistencias = FXCollections.observableArrayList();
        
        INro.setCellValueFactory(new PropertyValueFactory<>("nro"));
        ICedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        INombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        IApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        
        
        Teorica_1.setCellValueFactory(new PropertyValueFactory<>("teorica_1"));
        Practica_1.setCellValueFactory(new PropertyValueFactory<>("practica_1"));                
        Teorica_2.setCellValueFactory(new PropertyValueFactory<>("teorica_2"));
        Practica_2.setCellValueFactory(new PropertyValueFactory<>("practica_2"));                
        Teorica_3.setCellValueFactory(new PropertyValueFactory<>("teorica_3"));
        Practica_3.setCellValueFactory(new PropertyValueFactory<>("practica_3"));        
        Teorica_4.setCellValueFactory(new PropertyValueFactory<>("teorica_4"));
        Practica_4.setCellValueFactory(new PropertyValueFactory<>("practica_4"));        
        Teorica_5.setCellValueFactory(new PropertyValueFactory<>("teorica_5"));
        Practica_5.setCellValueFactory(new PropertyValueFactory<>("practica_5"));        
        Teorica_6.setCellValueFactory(new PropertyValueFactory<>("teorica_6"));
        Practica_6.setCellValueFactory(new PropertyValueFactory<>("practica_6"));        
        Teorica_7.setCellValueFactory(new PropertyValueFactory<>("teorica_7"));
        Practica_7.setCellValueFactory(new PropertyValueFactory<>("practica_7"));       
        Teorica_8.setCellValueFactory(new PropertyValueFactory<>("teorica_8"));
        Practica_8.setCellValueFactory(new PropertyValueFactory<>("practica_8"));        
        
        Teorica_9.setCellValueFactory(new PropertyValueFactory<>("teorica_9"));
        Practica_9.setCellValueFactory(new PropertyValueFactory<>("practica_9"));        
        Teorica_10.setCellValueFactory(new PropertyValueFactory<>("teorica_10"));
        Practica_10.setCellValueFactory(new PropertyValueFactory<>("practica_10"));        
        Teorica_11.setCellValueFactory(new PropertyValueFactory<>("teorica_11"));
        Practica_11.setCellValueFactory(new PropertyValueFactory<>("practica_11"));        
        Teorica_12.setCellValueFactory(new PropertyValueFactory<>("teorica_12"));
        Practica_12.setCellValueFactory(new PropertyValueFactory<>("practica_12"));        
        Teorica_13.setCellValueFactory(new PropertyValueFactory<>("teorica_13"));
        Practica_13.setCellValueFactory(new PropertyValueFactory<>("practica_13"));        
        Teorica_14.setCellValueFactory(new PropertyValueFactory<>("teorica_14"));
        Practica_14.setCellValueFactory(new PropertyValueFactory<>("practica_14"));        
        Teorica_15.setCellValueFactory(new PropertyValueFactory<>("teorica_15"));
        Practica_15.setCellValueFactory(new PropertyValueFactory<>("practica_15"));        
        Teorica_16.setCellValueFactory(new PropertyValueFactory<>("teorica_16"));
        Practica_16.setCellValueFactory(new PropertyValueFactory<>("practica_16"));
        
        IPorciento.setCellValueFactory(new PropertyValueFactory<>("iporciento"));
        Condicion.setCellValueFactory(new PropertyValueFactory<>("condicion"));
        
        //inicializando registros
        rc = new Registro_Componentes();
        rc.menu_actas(Actas);
        
        
    }    
    
}

