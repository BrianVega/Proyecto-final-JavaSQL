/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.awt.Color;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Brian
 */
public class  ConsultasNutricionBD extends JFrame {
        
    private ResultSet rs;
    private Statement miStatement;
    private PreparedStatement miPreparedStatement;
    Connection sql = Conexion.getConexion();//Creamos la conexión

    ConsultasNutricionBD() {
    }//constructor

     
        //--------------------------------Consultar----------------
    
    ResultSet ConsultarConsultasNutricionBD(){
        Connection sql = Conexion.getConexion();//Creamos la conexión
        Statement miStatement;
                try { 
                    sql = Conexion.getConexion();//Creamos la conexión
                    miStatement = sql.createStatement();//inicializamos el obj statement
                    rs = miStatement.executeQuery("SELECT * FROM consulta");
        /*while(rs.next()){
         System.out.println(rs.getString(1)+ "----" + rs.getString(2) +  "----" + rs.getString(3) +  "----" + rs.getString(4) +  "----" + rs.getDate(5));
        }*/
                    System.out.println("PRUEBA - Todo bien hasta el momento");
                    //consulta();
                    
                } catch (SQLException e){   
                    JOptionPane.showMessageDialog(null, "Error en la búsqueda, consulte a su desarrollador para soporte técnico", "ERROR",JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
    }//catch
    return rs;
    }//OpcionesConsultasNutricionBD
    
     
        //--------------------------------Insertar----------------
    
    int insertarConsultasNutricionBD(String a, String b, String c, String d, String e){  
        //System.out.println("a: "+a +" b:"+b +"c:"+ c +" d" + d + "e: "+e);
        int z=0;
        String informe;
            try{    
                sql = Conexion.getConexion();//Creamos la conexión
                miPreparedStatement=sql.prepareStatement( "insert into consulta values(?,?,?,?,?)" );
                    //miStatement = sql.createStatement();
                miPreparedStatement.setString(1, a);
                miPreparedStatement.setString(2, b);
                miPreparedStatement.setString(3, c);
                miPreparedStatement.setString(4, d);
                miPreparedStatement.setString(5, e);
                //rs = miPreparedStatement.executeQuery();
                z = miPreparedStatement.executeUpdate();
                        //System.out.println("aaaaaa" + z);
                informe = "Se ha insertado el nuevo registro de manera exitosa";
            } catch(SQLException er){
                informe = "Error en la inserción, no es posible crear registros repetidos o con datos no válidos, consulte a"
                            + " su técnico para mayor información";
                    er.printStackTrace();
                z=0;    
            }//catch
            return z;
         //return rs;
    }// insertarConsultasNutricionBD
     
        //--------------------------------Modificar---------------- 
        int modificarConsultasNutricionBD(/*String a, String b, String c, String d,*/ String e, String f, String g, String h, String i) {
             int z=0;
        String informe;
            try{    
                sql = Conexion.getConexion();//Creamos la conexión
                miPreparedStatement=sql.prepareStatement( "UPDATE consulta SET Fecha_consulta = ? where Id_cita = ? and Id_paciente = ? and Id_nutriologo = ? and Id_consulta = ?" );
                    //miStatement = sql.createStatement();
                miPreparedStatement.setString(1, e);
               // miPreparedStatement.setString(2, b);
                //miPreparedStatement.setString(3, c);
                //miPreparedStatement.setString(4, d);
                //miPreparedStatement.setString(5, e);
                miPreparedStatement.setString(2, f);
                miPreparedStatement.setString(3, g);
                miPreparedStatement.setString(4, h);
                miPreparedStatement.setString(5, i);
                
                z = miPreparedStatement.executeUpdate();
                        //System.out.println("aaaaaa" + z);
                informe = "Se ha Modificado registro de manera exitosa";
            } catch(SQLException er){
                informe = "Error en la modificación, consulte a"
                            + "su técnico para mayor información";
                    er.printStackTrace();
                z=0;    
            }//catch
            return z;
        }//modificarConsultasNutricionBD
    
        //--------------------------------Eliminar----------------
    int eliminarConsultasNutricionBD(String a, String b, String c, String d){  
        //System.out.println("a: "+a +" b:"+b +"c:"+ c +" d" + d + "e: "+e);
        int z=0;
        String informe;
            try{    
                sql = Conexion.getConexion();//Creamos la conexión
                miPreparedStatement=sql.prepareStatement( "DELETE FROM CONSULTA WHERE Id_cita = ? and Id_paciente = ? and Id_nutriologo = ? and Id_consulta = ?" );
                    //miStatement = sql.createStatement();
                miPreparedStatement.setString(1, a);
                miPreparedStatement.setString(2, b);
                miPreparedStatement.setString(3, c);
                miPreparedStatement.setString(4, d);
                z = miPreparedStatement.executeUpdate();
                        //System.out.println("aaaaaa" + z);
                informe = "Se ha insertado el nuevo registro de manera exitosa";
            } catch(SQLException er){
                informe = "Error en la inserción, no es posible crear registros repetidos, consulte a"
                            + "su técnico para mayor información";
                    er.printStackTrace();
                z=0;    
            }//catch
            return z;

    }// insertarConsultasNutricionBD
    
}//ConsultasNutricionBD
