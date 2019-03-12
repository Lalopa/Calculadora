package sample.Vistas;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Events.EventosTeclado;

public class Taquimecanografo extends Stage
{
    private Scene scene;
    private VBox vbox;
    private Button btnPrueba1, btnPrueba2;
    private ToolBar toolBMenu;
    private TextArea txtATexto,txtAEscritura;

    public Taquimecanografo(){
        crearGUI();
        scene = new Scene(vbox);
        setTitle("TAQUIMECANOGRAFO");
        scene.getStylesheets().add(getClass().getResource("../Source/CSS/estiloTaqui.css").toExternalForm());
        setScene(scene);
        show();
    }

    private void crearGUI() {
        iniciarComponentes();
        anadirComponentes();
    }
    private void iniciarComponentes(){
        vbox = new VBox();
        toolBMenu = new ToolBar();
        txtATexto = new TextArea();
        txtATexto.setEditable(false);
        txtAEscritura = new TextArea();
        btnPrueba1 = new Button("Prueba 1");
        btnPrueba1.setId("btnTaquiPrueba1");
        btnPrueba2 = new Button("Prueba 2");
        btnPrueba2.setId("btnTaquiPrueba2");
        //txtAEscritura.addEventHandler(KeyEvent.KEY_TYPED,new EventosTeclado());
        txtAEscritura.setOnKeyPressed(new EventosTeclado());
    }
    private void anadirComponentes(){
        vbox.getChildren().addAll(toolBMenu,txtATexto,txtAEscritura, btnPrueba1, btnPrueba2);
    }
}