    package sample.Vistas;

    import javafx.event.Event;
    import javafx.event.EventHandler;
    import javafx.geometry.Insets;
    import javafx.scene.Scene;
    import javafx.scene.control.Alert;
    import javafx.scene.input.MouseEvent;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;
    import javafx.scene.control.TextField;
    import javafx.scene.control.Button;
    import javafx.stage.WindowEvent;
    import sample.Events.EventosCalculadora;


    public class Calculadora extends Stage implements EventHandler {



        TextField txtOperacion;
        private Scene scene;
        private VBox vBox;
        HBox [] arHBox;
        Button [] arBtns;
        private String [] valores = {"7","8","9","+","4","5","6","-","1","2","3","*",".","0","=","/"};

        public Calculadora(){

            CrearGUI();

            //Creando la ventana y mandando la parte principal en este caso Vbox
            scene = new Scene(vBox,200,200);
            setScene(scene);
            setTitle("Calculadorcita");
            show();
            addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST,this);
            scene.getStylesheets().add(getClass().getResource("../Source/CSS/calculadora.css").toExternalForm());

        }

        private void CrearGUI() {
            vBox = new VBox();

            //Crear instancia hacia la clase
            //EventosCalculadora objEvC = new EventosCalculadora();
            txtOperacion = new TextField();
            txtOperacion.setEditable(false);
            // Añadiendo al vBox el textfield
            vBox.getChildren().add(txtOperacion);

            arHBox = new HBox[4];
            arBtns = new Button[16];

            int posBtn = 0;
            for (int i = 0; i < arHBox.length; i++) {
                arHBox[i] = new HBox();
                arHBox[i].setSpacing(10);
                arHBox[i].setPadding(new Insets(5));
                for (int j = 0; j < 4; j++) {

                    // Instanciando cada boton y agregando texto a cada uno con una matriz paralela
                    arBtns[posBtn] = new Button(valores[posBtn]);
                    // fijar tamaño para los botones
                    arBtns [posBtn].setPrefSize(50,50);
                    //Agregando Listenner al boton
                    //arBtns[posBtn].addEventHandler(MouseEvent.MOUSE_CLICKED,objEvC);
                    //Agregando Listenner desde otra clase
                    arBtns[posBtn].addEventHandler(MouseEvent.MOUSE_CLICKED,new EventosCalculadora(valores[posBtn], txtOperacion));
                    //Agregando Listenner anidado
                    /*arBtns[posBtn].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    System.out.println("Hola desde el interior de tu corazon :)");
                                }
                            });*/
                    // Estilo al boton
                    arBtns[posBtn].setStyle("-fx-font: 15 arial;-fx-base: #272727;");
                    // Añadiendo a el arreglo de Horizontal Box cada boton
                    arHBox[i].getChildren().add(arBtns[posBtn]);
                    posBtn++;
                }

                vBox.getChildren().addAll(arHBox[i]);
            }
            // Añadiendo al vBox un nodo de tipo arreglo de Horizontal Box
            //vBox.getChildren().addAll(arHBox[0],arHBox[1],arHBox[2],arHBox[3]);
        }

        @Override
        public void handle(Event event) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Esta es una alerta informativa");
            alerta.setHeaderText("Este es el encabezado de laa alerta :)");
            alerta.setContentText("Aqui va todo el rollo de la alerta");
            alerta.showAndWait();
        }
    }
