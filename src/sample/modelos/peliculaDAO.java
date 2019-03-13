package sample.modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;

public class peliculaDAO {
    private  int idPelicula;
    private String nomPelicula;
    private int duracion;
    private String descPelicula;
    private String clase;
    private int idCategoria;

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getNomPelicula() {
        return nomPelicula;
    }

    public void setNomPelicula(String nomPelicula) {
        this.nomPelicula = nomPelicula;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getDescPelicula() {
        return descPelicula;
    }

    public void setDescPelicula(String descPelicula) {
        this.descPelicula = descPelicula;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void INSERT (){
        String consulta = "INSERT INTO tblPelicula(nomPelicula,duracion,descripcion,clase,idCategoria) " +
                "VALUES('"+nomPelicula+"',"+duracion+",'"+descPelicula+"','"+clase+"',"+idCategoria+")";
        try {
            Statement stmt = Conexion.con.createStatement();
            stmt.executeUpdate(consulta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void DELETE (){
        try {
            String query = "DELETE FROM tblpelicula WHERE  idPelicula = 1";
            Statement statement = Conexion.con.createStatement();
            statement.executeUpdate(query);
        }catch (Exception e){

        }
    }
    public void UPDATE (){
        try {
            String query = "UPDATE tblpelicula set nomPelicula = 'NuevaPrueba', duracion=110 WHERE  idPelicula = 1";
            Statement statement = Conexion.con.createStatement();
            statement.executeUpdate(query);
        }catch (Exception e){

        }
    }
    public ObservableList SELECT (){
        ObservableList <peliculaDAO> lista = FXCollections.observableArrayList();
        peliculaDAO objPDAO = null;
        String consulta = "SELECT * FROM tblPelicula ORDER BY nomPelicula";
        try{
            Statement stmt = Conexion.con.createStatement();
            ResultSet res = stmt.executeQuery(consulta);
            while (res.next()){
                objPDAO = new peliculaDAO();
                objPDAO.idPelicula      = res.getInt("idPelicula");
                objPDAO.nomPelicula     = res.getString("nomPelicula");
                objPDAO.duracion        = res.getInt("duracion");
                objPDAO.descPelicula    = res.getString("descripcion");
                objPDAO.clase           = res.getString("clase");
                objPDAO.idCategoria     = res.getInt("idCategoria");
                lista.add(objPDAO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;

    }
}
