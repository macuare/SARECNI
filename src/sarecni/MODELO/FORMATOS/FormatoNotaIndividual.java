/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarecni.MODELO.FORMATOS;

import java.text.DecimalFormat;
import javafx.scene.Parent;
import sarecni.MODELO.Ventanas_Auxiliares;

/**
 *
 * @author andy
 */
public class FormatoNotaIndividual {
    private Ventanas_Auxiliares va;
    private Parent panel;
    private int identificador, posicion, nota;
    private String estrategia, porciento, fecha;

    public FormatoNotaIndividual(int identificador, int nota, int posicion, String estrategia, String porciento, String fecha) {
       
        this.identificador = identificador;
        this.nota = nota;
        this.posicion = posicion;
        this.estrategia = estrategia;
        this.porciento = porciento;
        this.fecha = fecha;
        va = new Ventanas_Auxiliares();
        this.estructura();
    }

    
    public Parent getPanel() {
        return panel;
    }

    public void setPanel(Parent panel) {
        this.panel = panel;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }

    public String getPorciento() {
        return porciento;
    }

    public void setPorciento(String porciento) {
        this.porciento = porciento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    
    

    private void estructura(){
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat df2 = new DecimalFormat("00");
        
        panel = null;
        panel = va.cargar("/sarecni/VISTA/Auxiliares/Etiquetas/Etiqueta_Notas.fxml");
        panel.setId(String.valueOf(this.getIdentificador())); // se guarda el id de la nota
       
       // System.out.println("estructura: "+this.getFecha()+"-"+this.getPosicion()+"-"+this.getEstrategia()+"-"+this.getPorciento()+"-"+df2.format(this.getNota())+"-"+df.format(this.getNota() * Double.valueOf( this.getPorciento().substring(0, this.getPorciento().length()-1) )/100.0));
       // System.out.println("El panel existe: "+(panel != null));
        
                     va.modificar(panel, "Label", "Fecha", this.getFecha());
                     va.modificar(panel, "Label", "Posicion", this.getPosicion());
                     va.modificar(panel, "Label", "Estrategia", this.getEstrategia());
                     va.modificar(panel, "Label", "Porciento", this.getPorciento());
                     va.modificar(panel, "Label", "Nota", df2.format(this.getNota()));
                     va.modificar(panel, "Label", "Calculo", df.format(this.getNota() * Double.valueOf( this.getPorciento().substring(0, this.getPorciento().length()-1) )/100.0)); 
   
    }
    
}
