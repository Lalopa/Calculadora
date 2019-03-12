package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.modelos.peliculaDAO;

import java.util.stream.Stream;

public class ListaPeliculas extends Stage {

    private Scene escena ;
    private VBox vBox;
    private TableView <peliculaDAO> tbvPelicula;
    private Button btnAgregar;

    public ListaPeliculas(){
        CrearUI();

        setTitle("CRUD Peliculas");
        setScene(escena);
        show();
    }

    private void CrearUI() {
        vBox = new VBox();
        tbvPelicula = new TableView<>();
        CrearTabla();
        btnAgregar = new Button("Agregar");
        vBox.getChildren().addAll(tbvPelicula,btnAgregar);
        escena = new Scene(vBox, 200, 200);
    }

    private void CrearTabla(){
        TableColumn <peliculaDAO, Integer> tbcIdPelicula = new TableColumn<>("ID");
        tbcIdPelicula.setCellValueFactory(new PropertyValueFactory<>("idPelicula"));

        TableColumn <peliculaDAO, String> tbcNombPelicula = new TableColumn<>("Nombre");
        tbcNombPelicula.setCellValueFactory(new PropertyValueFactory<>("nomPelicula"));

        TableColumn <peliculaDAO, Integer> tbcDuracion = new TableColumn<>("Duracion");
        tbcDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));

        TableColumn <peliculaDAO, String> tbcDescripcion = new TableColumn<>("Descripcion");
        tbcDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));

        TableColumn <peliculaDAO, String> tbcClase = new TableColumn<>("Clase");
        tbcClase.setCellValueFactory(new PropertyValueFactory<>("clase"));

        TableColumn <peliculaDAO, Integer> tbcCategoria = new TableColumn<>("Categoria");
        tbcCategoria.setCellValueFactory(new PropertyValueFactory<>("idCategoria"));

        tbvPelicula.getColumns().addAll(tbcIdPelicula,tbcNombPelicula,tbcDuracion,tbcDescripcion,tbcClase,tbcCategoria);
        tbvPelicula.setItems(new peliculaDAO().SELECT());
    }


}
