package sample.Vistas;

import com.sun.javafx.geom.Rectangle;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Restaurante extends Stage {

    private Scene escena;
    private TabPane tabPane;
    private ScrollPane scrollPane;
    private VBox vBox[];
    private VBox vBoxPrincipal;
    private ImageView imageView;
    private Label lblName, lblPrice;
    private Button btnAdd, btnNext;

    // launch the application
    public Restaurante()
    {
        crearGUI();
        escena = new Scene(vBoxPrincipal, 300,300);
        setTitle("Select your mains");
        escena.getStylesheets().add(getClass().getResource("../Source/CSS/Restaurante.css").toExternalForm());
        setScene(escena);
        show();
    }

    private void crearGUI() { 
        iniciarComponentes();
        anadirComponentes();
    }

    private void iniciarComponentes() {
        vBoxPrincipal = new VBox();
        tabPane = new TabPane();
        tabPane.minHeight(300);
        tabPane.minWidth(300);
        Tab tab = new Tab();
        tab.setText("MEAT");
        tabPane.getTabs().add(tab);
        vBoxPrincipal.getChildren().add(tabPane);

    }

    private void anadirComponentes() {



    }
}
