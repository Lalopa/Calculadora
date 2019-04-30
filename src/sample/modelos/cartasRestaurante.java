package sample.modelos;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;

public class cartasRestaurante {
    public VBox principal;

    public cartasRestaurante(String descripcion, double precio, double descuento,String url){

        principal= new VBox();
        principal.setId("Cartas");

        principal.setAlignment(Pos.CENTER);
        Label label1 = new Label(descripcion);
        Label label2= new Label(Double.toString(precio));
        Label labe3= new Label(Double.toString(descuento));
        Label label4= new Label(" ");
        label1.setFont(Font.font("Cambria",44));



        String a=url;
        ImageView iv1 = new ImageView(new Image(getClass().getResourceAsStream(a)));
        iv1.setFitHeight(130);
        iv1.setPreserveRatio(true);
        iv1.setSmooth(true);
        iv1.setCache(true);

        Button btn1=new Button("Add");

        DropShadow ds = new DropShadow();
        ds.setOffsetY(0.0);
        ds.setOffsetX(0.0);
        ds.setColor(Color.LIGHTGRAY);

        principal.setEffect(ds);
        principal.setSpacing(10);
        principal.setPadding(new Insets(15, 15, 15, 15));
        principal.getChildren().addAll(iv1,label1,label2,labe3, btn1);

    }




}