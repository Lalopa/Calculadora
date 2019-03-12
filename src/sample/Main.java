package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.Vistas.Calculadora;
import sample.Vistas.ListaPeliculas;
import sample.Vistas.Restaurante;
import sample.Vistas.Taquimecanografo;
import sample.modelos.Conexion;


public class Main extends Application implements EventHandler
{

    private Scene scene;
    //private Button btnSalir;
    private MenuBar menuBar;
    private Menu menuCompetencia1,menuCompetencia2,menuSalir;
    private MenuItem menuItmCalculadora,menuItmTaquimecanografo,menuItmSalir, menuItmRestaurante, menuItmListaPelicula;
    private BorderPane pane;

    @Override
    public void start(Stage primaryStage) throws Exception{
        pane = new BorderPane();
        scene = new Scene(pane);
        createMenu();
        //Calculadora calculadora = new Calculadora();
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Prácticas Topicos Avanzados de Programación");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.addEventHandler(WindowEvent.WINDOW_SHOWN,this);
        primaryStage.show();
    }

    private void createMenu(){
        iniciarComponents();
        anadirComponentes();
        scene.getStylesheets().add(getClass().getResource("Source/CSS/bootstrap3.css").toExternalForm());
    }

    private void iniciarComponents(){
        menuBar = new MenuBar();
        menuCompetencia1 = new Menu("Competencia 1");
        menuCompetencia1.setId("menu1");
        menuCompetencia2 = new Menu("Competencia 2");
        menuCompetencia2.setId("menu2");
        menuSalir = new Menu("Salir");
        menuSalir.setId("menuSalir");
        menuItmCalculadora = new MenuItem("Calculadora");
        menuItmTaquimecanografo = new MenuItem("Taquimecanografo");
        menuItmRestaurante = new MenuItem("Restaurante");
        menuItmListaPelicula = new MenuItem("Lista Peliculas");
        menuItmSalir = new MenuItem("Bye");
        menuItmSalir.setAccelerator(KeyCombination.keyCombination("Ctrl+x"));
        menuItmSalir.setOnAction(evento->EventoItem(0));
        menuItmRestaurante.setOnAction(evento->EventoItem(3));
        menuItmTaquimecanografo.setOnAction(evento->EventoItem(2));
        menuItmCalculadora.setOnAction(evento->EventoItem(1));
        menuItmListaPelicula.setOnAction(evento->EventoItem(4));

    }

    private void anadirComponentes(){
        menuCompetencia1.getItems().addAll(menuItmCalculadora,menuItmTaquimecanografo, menuItmRestaurante, menuItmListaPelicula);
        menuSalir.getItems().add(menuItmSalir);
        menuBar.getMenus().addAll(menuCompetencia1,menuCompetencia2,menuSalir);
        pane.setTop(menuBar);
    }

    private void EventoItem(int opcion) {
        switch (opcion){
            case 1:
                new Calculadora();
                break;
            case 2:
                new Taquimecanografo();
                break;
            case 3:
                new Restaurante();
                break;
            case 4:
                new ListaPeliculas();
            case 0:
                System.exit(0);
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(Event event) {
        Conexion.getConexion();
        if(Conexion.con != null){
            System.out.println("Conexion Exitosa!!");
        }
        else
            System.out.println("No exitoso");
    }
}