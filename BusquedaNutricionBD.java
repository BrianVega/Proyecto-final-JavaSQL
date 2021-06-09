package SQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Brian
 */
public class BusquedaNutricionBD extends JFrame implements ActionListener{
    
    private ResultSet rs;
    private PreparedStatement miPreparedStatement;
    Connection sql = Conexion.getConexion();//Creamos la conexión
    String opc;
    private JLabel title, txtIdCita, txtIdPaciente, txtIdNutriologo, txtIdConsulta, labelModificar;
    private JPanel jpanelbusquedaNutricionBD;
    private JTextField campoBuscarIdCita, campoBuscarIdPaciente, campoBuscarIdNutriologo, campoBuscarIdConsulta;
    private JButton btnBuscar, btnCancelar, btnEliminar, btnRegresar, btnModificar;
    private JTable tabla;
    DefaultTableModel model = new DefaultTableModel();
    ConsultasNutricionBD accederConsultasNutricionBD = new ConsultasNutricionBD();
    private JScrollPane scrollPane;
    
    void BusquedaNutricionBD(int n){
        if(n==1){
            opc = "buscar";
        }
        else
            if(n==2){
                opc = "modificar";
            }
        else
                if(n==3){
                    opc = "eliminar";
                }
        
        this.setResizable(false);
        this.setSize(315,180);
        //this.setBounds(0,0,420,420);
        //this.setResizable(true);
        //this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("NutriDB - Brian Vega V1.0");
       // this.setUndecorated(true);
        initComponents(n);
        busqueda();

        
    }//constructor
    
    public void busqueda(){
        title.setVisible(true);
        campoBuscarIdCita.setVisible(true);
        campoBuscarIdPaciente.setVisible(true);
        campoBuscarIdNutriologo.setVisible(true);
        campoBuscarIdConsulta.setVisible(true);
        txtIdCita.setVisible(true);
        txtIdPaciente.setVisible(true);
        txtIdNutriologo.setVisible(true);
        txtIdConsulta.setVisible(true);
        btnBuscar.setVisible(true);
        //btnCancelar.setVisible(true);
        //btnEliminar.setVisible(true);

    }
    
    public void initComponents(int n){
        jpanelbusquedaNutricionBD = new JPanel();//Crear panel
            jpanelbusquedaNutricionBD.setBounds(0,0,315,180);
            jpanelbusquedaNutricionBD.setBackground(Color.getHSBColor(50, 80, 100));//color panel
            jpanelbusquedaNutricionBD.setLayout(null);//quitar diseno
            this.getContentPane().add(jpanelbusquedaNutricionBD);//agregar panel a ventana
        
        title = new JLabel("Ingrese la llave del dato que desea " + opc);
            title.setBounds(15,10,280,25);
            title.setFont(new Font("ARIAL", Font.BOLD,13));//Fuente texto
            //title.setForeground(Color.gray);
            jpanelbusquedaNutricionBD.add(title);
            
            
        labelModificar = new JLabel("Modifique los datos que desee alterar, recuerde que no es"
                + "posible editar llaves primarias ");
            labelModificar.setBounds(15,70,560,25);
            labelModificar.setFont(new Font("ARIAL", Font.BOLD,12));//Fuente texto
            labelModificar.setVisible(false);
            //title.setForeground(Color.gray);
            jpanelbusquedaNutricionBD.add(labelModificar);
        
        campoBuscarIdCita = new JTextField();
            campoBuscarIdCita.setBounds(10,50,60,25);
            campoBuscarIdCita.setVisible(false);
            jpanelbusquedaNutricionBD.add(campoBuscarIdCita);
            
        campoBuscarIdPaciente = new JTextField();
            campoBuscarIdPaciente.setBounds(75,50,60,25);
            campoBuscarIdPaciente.setVisible(false);
            jpanelbusquedaNutricionBD.add(campoBuscarIdPaciente);
            
        campoBuscarIdNutriologo = new JTextField();
            campoBuscarIdNutriologo.setBounds(145,50,60,25);  
            campoBuscarIdNutriologo.setVisible(false);
            jpanelbusquedaNutricionBD.add(campoBuscarIdNutriologo);
            
        campoBuscarIdConsulta = new JTextField();
            campoBuscarIdConsulta.setBounds(225,50,60,25); 
            campoBuscarIdConsulta.setVisible(false);
            jpanelbusquedaNutricionBD.add(campoBuscarIdConsulta);
            
            
        txtIdCita = new JLabel("ID Cita");
            txtIdCita.setBounds(10,75,60,25);     
            txtIdCita.setVisible(false);
            txtIdCita.setFont(new Font("ARIAL", Font.BOLD,11));//Fuente texto
            jpanelbusquedaNutricionBD.add(txtIdCita);   
            
        txtIdPaciente = new JLabel("ID Paciente");
            txtIdPaciente.setBounds(75,75,80,25);   
            txtIdPaciente.setFont(new Font("ARIAL", Font.BOLD,11));//Fuente texto    
            txtIdPaciente.setVisible(false);
            jpanelbusquedaNutricionBD.add(txtIdPaciente);
        
        txtIdNutriologo = new JLabel("ID Nutriologo");
            txtIdNutriologo.setBounds(145,75,80,25);
            txtIdNutriologo.setFont(new Font("ARIAL", Font.BOLD,11));//Fuente texto   
            txtIdNutriologo.setVisible(false);
            jpanelbusquedaNutricionBD.add(txtIdNutriologo);   
            
        txtIdConsulta = new JLabel("ID Consulta");
            txtIdConsulta.setBounds(225,75,80,25);    
            txtIdConsulta.setFont(new Font("ARIAL", Font.BOLD,11));//Fuente texto    
            txtIdConsulta.setVisible(false);
            jpanelbusquedaNutricionBD.add(txtIdConsulta);
            
            
        btnBuscar = new JButton("Buscar");
            btnBuscar.setBounds(107,110,80,25);
            btnBuscar.addActionListener(this);     
            btnBuscar.setVisible(false);
            jpanelbusquedaNutricionBD.add(btnBuscar);
            
        btnCancelar = new JButton("Regresar");
            btnCancelar.setBounds(10,110,100,25);
            btnCancelar.addActionListener(this);       
            btnCancelar.setVisible(false);            
            jpanelbusquedaNutricionBD.add(btnCancelar);
            
            
        btnRegresar = new JButton("Regresar");
            btnRegresar.setBounds(10,110,100,25);
            btnRegresar.addActionListener(this);       
            btnRegresar.setVisible(false);            
            jpanelbusquedaNutricionBD.add(btnRegresar);
            
        
            
        btnEliminar = new JButton("Eliminar");
            btnEliminar.setBounds(490,110,100,25);
            btnEliminar.addActionListener(this); 
            btnEliminar.setVisible(false);
            jpanelbusquedaNutricionBD.add(btnEliminar);
            
        btnModificar = new JButton("Modificar");
            btnModificar.setBounds(490,110,100,25);
            btnModificar.addActionListener(this); 
            btnModificar.setVisible(false);
            jpanelbusquedaNutricionBD.add(btnModificar);  
           
            
        model = new DefaultTableModel();   

        tabla = new JTable(model); 
            tabla.setVisible(false);
        
        
    }//initComponents

    @Override
    public void actionPerformed(ActionEvent evt) {
        int r=0;
        if(evt.getSource() == btnBuscar){
            if(campoBuscarIdCita.getText().length() > 0 && campoBuscarIdCita.getText().length() < 5 && campoBuscarIdPaciente.getText().length() > 0 && campoBuscarIdPaciente.getText().length() < 5 && campoBuscarIdNutriologo.getText().length() > 0 && campoBuscarIdNutriologo.getText().length() < 5 && campoBuscarIdConsulta.getText().length() > 0 && campoBuscarIdConsulta.getText().length() < 5){
            try{    
                sql = Conexion.getConexion();//Creamos la conexión
                miPreparedStatement=sql.prepareStatement( "select * from consulta where Id_cita = ? and Id_paciente = ? and Id_nutriologo = ? and Id_consulta = ? " );
                
                miPreparedStatement.setString(1, campoBuscarIdCita.getText());
                miPreparedStatement.setString(2, campoBuscarIdPaciente.getText());
                miPreparedStatement.setString(3, campoBuscarIdNutriologo.getText());
                miPreparedStatement.setString(4, campoBuscarIdConsulta.getText());

                //rs = miPreparedStatement.executeQuery();
                rs = miPreparedStatement.executeQuery();
                System.out.println(rs);
                r=1;
                //System.out.println("aaaaaa" + z);
                //informe = "Se ha insertado el nuevo registro de manera exitosa";
            } catch(SQLException er){
                    JOptionPane.showMessageDialog(null, "No se ha encontrado el registro solicitado", "Búsqueda sin éxito",JOptionPane.ERROR_MESSAGE);                    er.printStackTrace();
              
            }//catch
            
                if(r==1){
                   tabla = new JTable(model);
                   scrollPane = new JScrollPane(tabla);
                        scrollPane.setBackground(Color.getHSBColor(50, 80, 100));
                        scrollPane.setBounds(0,0, 600, 40);
                        scrollPane.setViewportView(tabla);
                    model.addColumn("ID Cita");
                    model.addColumn("ID Paciente");
                    model.addColumn("ID Nutriologo");
                    model.addColumn("ID Consulta");
                    model.addColumn("Fecha de la consulta");
                            // tabla = new JTable(model);
                    try{
                        while(rs.next()){
                            Object[] fila = new Object[5];
                            for(int i=0; i<5; i++){
                                fila[i] = rs.getObject(i+1);
                            }//for
                             model.addRow(fila); 
                        }//while
                                                    
                        jpanelbusquedaNutricionBD.add(scrollPane);  

                    title.setVisible(false);
                    campoBuscarIdCita.setVisible(false);
                    campoBuscarIdPaciente.setVisible(false);
                    campoBuscarIdNutriologo.setVisible(false);
                    campoBuscarIdConsulta.setVisible(false);
                    txtIdCita.setVisible(false);
                    txtIdPaciente.setVisible(false);
                    txtIdNutriologo.setVisible(false);
                    txtIdConsulta.setVisible(false);
                    btnBuscar.setVisible(false);
                    
                    if(opc.equalsIgnoreCase("eliminar")){
                        btnCancelar.setVisible(true);
                        btnEliminar.setVisible(true);
                        //labelModificar.setVisible(false);

                    }
                    if(opc.equalsIgnoreCase("modificar")){
                        labelModificar.setVisible(true);
                        btnCancelar.setVisible(true);
                        if(!"".equals(campoBuscarIdCita.getText())){
                            btnModificar.setVisible(true);
                        }
                    }
                    
                    if(opc.equalsIgnoreCase("buscar")){
                        btnRegresar.setVisible(true); 
                    }
                    
                    this.setSize(610,180);


                    
                    } catch(SQLException e){
                    
                    }//catch
                    
                }//imprimir tabla
        }
        else{                
                JOptionPane.showMessageDialog(null, "Error en la búsqueda, no es posible rastrear datos no válidos (nulos o mayores a 4 dígitos)", "ERROR",JOptionPane.ERROR_MESSAGE);
        }
        }//btnBuscar;
        if(evt.getSource() == btnCancelar){
            hideComponents();
            this.setVisible(false);
        }//btnCancelar
        
        if(evt.getSource() == btnModificar){
            System.out.println("Modificar");
            int fila = tabla.getSelectedRow();
            //Checar la linea de abajoooo 06/06/2021 - 4:32 AM
            try{
            String e = tabla.getValueAt(0, 4).toString();
            System.out.println(e+"\n\n"+campoBuscarIdCita.getText()+"\n"+campoBuscarIdPaciente.getText()+"\n"+campoBuscarIdNutriologo.getText()+"\n"+campoBuscarIdConsulta.getText());
            int m = accederConsultasNutricionBD.modificarConsultasNutricionBD(e, campoBuscarIdCita.getText(), campoBuscarIdPaciente.getText(), campoBuscarIdNutriologo.getText(), campoBuscarIdConsulta.getText());
            
            JOptionPane.showMessageDialog(null, "Se ha modificado el registro con éxito","ÉXITO",JOptionPane.INFORMATION_MESSAGE);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error en la Modificación, no es posible modificar registros que no existen","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            
        }//btnModificar
        
        
        if(evt.getSource() == btnRegresar){
            hideComponents();
            this.setVisible(false);
        }//btnRegresar
        
        if(evt.getSource() == btnEliminar){
            int z=accederConsultasNutricionBD.eliminarConsultasNutricionBD(campoBuscarIdCita.getText(), campoBuscarIdPaciente.getText(), campoBuscarIdNutriologo.getText(), campoBuscarIdConsulta.getText());
            if(z!=0){
                        JOptionPane.showMessageDialog(null, "Se ha eliminado el registro con éxito","ÉXITO",JOptionPane.INFORMATION_MESSAGE);
                        hideComponents();
                        this.setVisible(false);
            }
            else{
                        JOptionPane.showMessageDialog(null, "Error en la eliminación, no es posible eliminar registros que no existen"
                            + "en el sistema", "ERROR",JOptionPane.ERROR_MESSAGE);
                            hideComponents();
                            this.setVisible(false);
            }
        }//btnEliminar
        
    }//actionPerdormed
    
    public void hideComponents(){
        
                    labelModificar.setVisible(false);
                    title.setVisible(true);
                    campoBuscarIdCita.setVisible(true);
                    campoBuscarIdPaciente.setVisible(true);
                    campoBuscarIdNutriologo.setVisible(true);
                    campoBuscarIdConsulta.setVisible(true);
                    txtIdCita.setVisible(true);
                    txtIdPaciente.setVisible(true);
                    txtIdNutriologo.setVisible(true);
                    txtIdConsulta.setVisible(true);
                    btnBuscar.setVisible(true);
                    btnCancelar.setVisible(true);
                    btnEliminar.setVisible(true);
                    scrollPane.setVisible(false);
                    model = new DefaultTableModel();
                    tabla.setVisible(false);
                    this.getContentPane().remove(jpanelbusquedaNutricionBD);//quitar panel a ventana

    }

    //private JPanel jpanelbusquedaNutricionBD;

    
}//BusquedaNuttricionBD extends JFrame
