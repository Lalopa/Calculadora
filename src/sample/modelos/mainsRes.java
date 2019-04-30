package sample.modelos;

public class mainsRes {
    static int cantidad;
    public String nombre;
    public cartasRestaurante lista[];


    public mainsRes(String nombre) {
        this.nombre = nombre;
        cantidad ++;
    }

    public mainsRes(String nombre, cartasRestaurante[] lista) {
        this.nombre = nombre;
        this.lista = lista;
        cantidad ++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public cartasRestaurante[] getLista() {
        return lista;
    }

    public void setLista(cartasRestaurante[] lista) {
        this.lista = lista;
    }

    public static int getCantidad() {
        return cantidad;
    }

    public static void setCantidad(int cantidad) {
        mainsRes.cantidad = cantidad;
    }
}
