package sample.modelos;

public class Saucer {
    public String url, nombre;
    public double precio, descuento;

    public Saucer(String url, String nombre, double descuento, double precio) {
        this.url = url;
        this.nombre = nombre;
        this.descuento = descuento;
        this.precio = precio;
    }

    public Saucer(String url, String nombre, double precio) {
        this.url = url;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
