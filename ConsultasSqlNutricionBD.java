 package SQL;
//Clase para recibir y retornar datos en relacióna  las consultas del núcleo

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Brian
 */
public class ConsultasSqlNutricionBD {
    private ResultSet rs;
    
    public ConsultasSqlNutricionBD(String parametro){
    try {
        
       Connection sql = Conexion.getConexion();//Creamos la conexión
       Statement miStatement = sql.createStatement();//inicializamos el obj statement
       rs = miStatement.executeQuery("SELECT * FROM consulta");
        while(/*rs*/rs.next()){
         System.out.println(rs.getString(1)+ "----" + rs.getString(2) +  "----" + rs.getString(3) +  "----" + rs.getString(4) +  "----" + rs.getDate(5));
            //System.out.println(rs.getString(1) + " -- " + rs.getString(2) + " -- " + rs.getString(3) + " -- " + rs.getString(4) + rs.getDate(1));
        }
        //rs.close();
        System.out.println("PRUEBA - Todo bien hasta el momento");
                
        
    } catch (SQLException e){   
        JOptionPane.showMessageDialog(null, "Error en la búsqueda, consulte a su desarrollador para soporte técnico", "ERROR",JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
}//catch

    }//constructor consultasNutricionBD
}
