package sample.Events;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.function.DoubleBinaryOperator;

public class EventosCalculadora  implements EventHandler {

    String valor;
    TextField txtOperacion;
    static boolean banderaTexto = false , banderaIgual = false, banderaPrimer = false;
    static String valor1 = "0", valor2 = "";
    static ArrayList <String> anterior = new ArrayList<>();
    static String ultimo="";
    static int contador=0;


    public EventosCalculadora(String valor, TextField txtOperacion) {
        this.txtOperacion = txtOperacion;
        this.valor = valor;
    }

    @Override
    public void handle(Event event) {
        //System.out.println(event.getSource());
        if (banderaTexto)
            txtOperacion.setText("");
        banderaTexto = false;
        switch (valor) {
            case ".":
                if (banderaIgual)
                    txtOperacion.setText("");
                banderaIgual = false;
                String pr=txtOperacion.getCharacters().toString();
                char _toCompare='.';
                int veces=0;
                char []caracteres=pr.toCharArray();
                for(int i=0;i<=caracteres.length-1;i++){
                    if(_toCompare ==caracteres[i]){
                        veces+=2;
                    }}
                if (veces!=2)
                    txtOperacion.appendText(valor);
                break;
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                if (banderaIgual)
                    txtOperacion.setText("");
                banderaIgual = false;
                txtOperacion.appendText(valor);
                break;
            case "=":
                if (!anterior.equals("")) {
                    if (!txtOperacion.getText().equals("")) {
                        anterior.add(txtOperacion.getText());
                        igual();
                        anterior = new ArrayList<>();
                        banderaIgual = true;
                    }
                    else {
                        txtOperacion.setText("Ingresa valores");
                        banderaTexto = true;
                    }
                }
                else {
                    txtOperacion.setText("Ingresa valores");
                    banderaTexto = true;
                }
                break;
            default:
                operaciones(valor);
        }

    }

    public void operaciones(String valor) {
        switch (valor) {
            case "+":
                if (!txtOperacion.getText().equals("")) {
                    anterior.add(txtOperacion.getText());
                    contador++;
                    anterior.add("+");
                    txtOperacion.setText("");
                    contador++;
                }
                else {
                    txtOperacion.setText("Ingresa valores");
                    banderaTexto=true;
                }
                break;
            case "-":
                if (!txtOperacion.getText().equals("")) {
                    anterior.add(txtOperacion.getText());
                    contador++;
                    anterior.add("-");
                    txtOperacion.setText("");
                    contador++;
                }
                else {
                    txtOperacion.setText("Ingresa valores");
                    banderaTexto=true;
                }
                break;
            case "*":
                if (!txtOperacion.getText().equals("")) {
                    anterior.add(txtOperacion.getText());
                    contador++;
                    anterior.add("*");
                    txtOperacion.setText("");
                    contador++;
                }
                else {
                    txtOperacion.setText("Ingresa valores");
                    banderaTexto=true;
                }
                break;
            case "/":
                if (!txtOperacion.getText().equals("")) {
                    anterior.add(txtOperacion.getText());
                    contador++;
                    anterior.add("/");
                    txtOperacion.setText("");
                    contador++;
                }
                else {
                    txtOperacion.setText("Ingresa valores");
                    banderaTexto=true;
                }
                break;
        }
    }
    public void igual (){
        if (anterior.get(0).equals("."))
            anterior.add(0,"0");
        valor1 = anterior.get(0);
        for (int i = 1 ; i < anterior.size(); i+=2){
            switch ((anterior.get(i))){
                case "+": {
                    checar(i);
                    valor1 = "" + (Double.parseDouble(valor1) + Double.parseDouble(anterior.get(i+1)));
                    ultimo = "+";
                }break;
                case "-":{
                    checar(i);
                    valor1 = "" + (Double.parseDouble(valor1) - Double.parseDouble(anterior.get(i+1)));
                    ultimo = "-";
                }break;
                case "*":{
                    checar(i);
                    valor1 = "" + (Double.parseDouble(valor1) * Double.parseDouble(anterior.get(i+1)));
                    ultimo = "*";
                }break;
                case "/":{
                    checar(i);
                    valor1 = "" + (Double.parseDouble(valor1) / Double.parseDouble(anterior.get(i+1)));
                    ultimo = "/";
                }break;
                default:
                    valor1 = anterior.get(i);
                    System.out.println();
            }
        }
        valor2 = "";
        txtOperacion.setText(valor1);
        valor1 = "";
    }
    public void checar(int i){
        if (anterior.get(i-1).equals("."))
            anterior.add(i-1,"0");
        if (anterior.get(i+1).equals("."))
            anterior.add(i+1,"0");
    }

    private void ultimo() {
        if (!valor1.equals("")&&!ultimo.equals("")) {
            switch ((ultimo)) {
                case "+": {
                    if (valor1.equals("."))
                        valor1 = "0";
                    if (!valor2.equals(""))
                        valor1 = "" + (Double.parseDouble(valor1) + Double.parseDouble(valor2));
                }
                break;
                case "-": {
                    if (valor1.equals("."))
                        valor1 = "0";
                    if (!valor2.equals(""))
                        valor1 = "" + (Double.parseDouble(valor2) - Double.parseDouble(valor1));
                }
                break;
                case "*": {
                    if (valor1.equals("."))
                        valor1 = "0";
                    if (!valor2.equals(""))
                        valor1 = "" + (Double.parseDouble(valor1) * Double.parseDouble(valor2));
                }
                break;
                case "/": {
                    if (valor1.equals("."))
                        valor1 = "0";
                    if (!valor2.equals(""))
                        valor1 = "" + (Double.parseDouble(valor2) / Double.parseDouble(valor1));
                }
                break;
            }
            valor2 = "";
            txtOperacion.setText(valor1);
            valor1 = "";
        }
        else {
            valor2 = "";
            txtOperacion.setText("Ingrese Valores");
            valor1 = "";
        }
    }
    /*public void operaciones(String valor) {
        switch (valor) {
            case "+":
                if (!txtOperacion.getText().equals(""))
                    if (!valor1.equals("")) {
                        valor2 = txtOperacion.getText();
                        valor1 = "" + (Double.parseDouble(valor1) + Double.parseDouble(txtOperacion.getText()));
                        txtOperacion.setText(valor1);
                    } else {
                        valor1 = txtOperacion.getText();
                        txtOperacion.setText("");
                        anterior = valor;
                    }
                else {
                    txtOperacion.setText("Ingresa valores");
                    banderaTexto=true;
                }
                break;
            case "-":
                if (!txtOperacion.equals(""))
                    if (!valor1.equals("")) {
                        valor2 = txtOperacion.getText();
                        valor1 = "" + (Double.parseDouble(valor1) - Double.parseDouble(valor2));
                        txtOperacion.setText(valor1);
                    } else {
                        valor1 = txtOperacion.getText();
                        txtOperacion.setText("");
                        anterior = valor;
                    }
                else {
                    txtOperacion.setText("Ingresa valores");
                    banderaTexto=true;
                }
                break;
            case "*":
                if (!txtOperacion.equals(""))
                    if (!valor1.equals("")) {
                        valor2 = txtOperacion.getText();
                        valor1 = "" + (Double.parseDouble(valor1) * Double.parseDouble(valor2));
                        txtOperacion.setText(valor1);
                    } else {
                        valor1 = txtOperacion.getText();
                        txtOperacion.setText("");
                        anterior = valor;
                    }
                else {
                    txtOperacion.setText("Ingresa valores");
                    banderaTexto=true;
                }
                break;
            case "/":
                if (!txtOperacion.equals(""))
                    if (!valor1.equals("")) {
                        valor2 = txtOperacion.getText();
                        if (!valor2.equals("0"))
                            valor1 = "" + (Double.parseDouble(valor1) / Double.parseDouble(valor2));
                        else {
                            txtOperacion.setText("No se puede dividir entre cero");
                            banderaTexto = true;
                        }
                        valor2 = null;
                        txtOperacion.setText(valor1);
                        anterior = valor;
                    } else {
                        valor1 = txtOperacion.getText();
                        txtOperacion.setText("");
                    }
                else {
                    txtOperacion.setText("Ingresa valores");
                    banderaTexto=true;
                }
                break;
        }
    }*/
}
