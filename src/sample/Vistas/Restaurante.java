package sample.Vistas;

import com.sun.javafx.geom.Rectangle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.modelos.cartasRestaurante;
import sample.modelos.mainsRes;

import static javafx.application.Application.launch;

public class Restaurante extends Stage {

    private Scene escena;
    private TabPane tabPane;
    private Tab[] tab;
    private HBox hBox;
    private ScrollPane scrollPane;
    private VBox[] vBox;
    private VBox vBoxPrincipal;
    mainsRes[] menu;
    private ImageView imageView;
    private Label lblName, lblPrice;
    private Button btnAdd, btnNext;

    // launch the application
    public Restaurante(mainsRes[] menu)
    {
        this.menu=menu;
        crearGUI();
        escena = new Scene(vBoxPrincipal, 1000,700);
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
        vBoxPrincipal.setId("vBoxPrincipal");
        System.out.println(mainsRes.getCantidad());
        tabPane = new TabPane();
        tabPane.minHeight(500);
        tabPane.minWidth(500);
        tab = new Tab[mainsRes.getCantidad()];
        btnNext = new Button("Next");
        btnAdd = new Button("Select yours mains");


    }

    private void anadirComponentes() {
        System.out.println(menu[0].getNombre());
        cartasRestaurante obj1= new cartasRestaurante("Holaa",500,100,"../Source/imagenes/hola.png");
        cartasRestaurante obj2= new cartasRestaurante("Holaa",500,100,"../Source/imagenes/hola.png");
        cartasRestaurante obj3= new cartasRestaurante("Holaa",500,100,"../Source/imagenes/hola.png");
        for (int i=0;i<mainsRes.getCantidad();i++){
            tab[i] = new Tab(menu[i].getNombre());
            tab[i].setClosable(false);
            tab[i].setContent(obj3.principal);
        }
        hBox = new HBox();
        hBox.setSpacing(20);
        hBox.setPrefSize(400,400);
        hBox.setId("hboxCartas");
        hBox.setPadding(new Insets(30,10,30,50));
        hBox.getChildren().addAll(obj1.principal,obj2.principal);
        tab[0].setContent(hBox);
        tabPane.getTabs().addAll(tab);
        tabPane.setPadding(new Insets(0,0,0,0));
        btnNext.setId("btnNext");
        btnNext.setPadding(new Insets(8,60,8,60));
        btnAdd.setId("btnAdd");
        btnAdd.setPadding(new Insets(10,442,10,442));
        vBoxPrincipal.getChildren().addAll(btnAdd,tabPane, btnNext);
        VBox.setMargin(btnNext, new Insets(10,10,10,10));
        vBoxPrincipal.setAlignment(Pos.TOP_CENTER);

    }
}
