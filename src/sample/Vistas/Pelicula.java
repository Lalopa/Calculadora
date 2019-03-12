package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class Pelicula {

    private Scene escena;
    private VBox vBox;
    private Label lblTitulo;
    private TextField txtNombPeli, txtDuraPeli, txtSinopsisPeli, txtClasePeli, txtCatPeli;

    public Pelicula(){
        CrearUI();
    }

    private void CrearUI() {

        vBox = new VBox();
        lblTitulo = new Label("Pelicula");
        txtNombPeli = new TextField();
        txtNombPeli.setPromptText("Nombre");
        txtDuraPeli = new TextField();
        txtDuraPeli.setPromptText("Duracion");
        txtSinopsisPeli = new TextField();
        txtSinopsisPeli.setPromptText("Sinopsis");
        txtClasePeli = new TextField();
        txtClasePeli.setPromptText("Clase");
        txtCatPeli = new TextField();
        txtCatPeli.setPromptText("Categoria");
        vBox.getChildren().addAll(lblTitulo, txtNombPeli,txtDuraPeli,txtSinopsisPeli,txtClasePeli,txtCatPeli);
        escena = new Scene(vBox,250,300);
    }

}
