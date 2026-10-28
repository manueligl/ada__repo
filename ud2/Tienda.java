import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Tienda {

    private String url="jdbc:mysql://localhost:3306/";
    private String user="root";
    private String password="1234";
    private Connection con;

    public Tienda() throws SQLException {

        con = DriverManager.getConnection(url, user, password);
    }

    public boolean realizarOperacionDML(String sql) throws SQLException {

        Statement st = con.createStatement();

        return st.execute(sql);
    }

    public boolean realizarInserción(String password, String usuario, String direccion, String telefono) throws SQLException {

        Statement st = con.createStatement();

        return st.execute("INSERT INTO clientes VALUES ('" + password + "', '" + usuario + "', '" + direccion + "', '" + telefono + "');");
    }

    public boolean realizarActualización(String password, String usuario, String direccion, String telefono) throws SQLException {

        Statement st = con.createStatement();

         return st.execute("UPDATE cliente SET password = '" + password + "', usuario = '" + usuario + "', direccion = '" + direccion + "', telefono = '" + telefono + "' WHERE usuario = '" + usuarioBuscar + "';");

    }

    public boolean realizarBorrado(String usuario) throws SQLException {

    Statement st = con.createStatement();

    return st.execute("DELETE FROM cliente WHERE usuario = '" + usuario + "';");
    
    }
}