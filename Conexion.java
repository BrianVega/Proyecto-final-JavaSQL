package SQL;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Brian
 */
public class Conexion {
    public static Connection getConexion(){
        String conexionUrl = "jdbc:sqlserver://localhost:1433;"
                + "database=nutricion;"
                + "user=sa;"
                + "password=briandb1;"
                + "loginTimeout=30;";
        try{
            Connection con = DriverManager.getConnection(conexionUrl);
            return con;
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error en la búsqueda, consulte a su desarrollador para soporte técnico", "ERROR",JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.toString());
            return null;
        }
    }
}
