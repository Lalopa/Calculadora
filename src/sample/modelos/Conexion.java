package sample.modelos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static String host = "localhost";
    private static String bd = "Mexflix";
    private static String users = "topicos2";
    private static String password = "12345678";
    public static Connection con;

    public static void getConexion() {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://"+host+"/"+bd,users,password);
        }catch (Exception e){

        }
    }
}
