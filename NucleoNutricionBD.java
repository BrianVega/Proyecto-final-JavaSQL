package SQL;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.applet.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brian
 */
public class NucleoNutricionBD extends JFrame implements ActionListener{
    
    private java.awt.event.KeyEvent Tevt;
    private JMenuBar barraMenuPrincipal;
    private JMenu planAlimenticio, nutriologos, asignar, citas, pacientes, antropometria, consultas, ayuda;
    private JMenuItem opcionConsultarConsultas, opcionInsertarConsultas, opcionModificarConsultas, opcionEliminarConsultas, 
            opcionConsultarCitas, opcionInsertarCitas, opcionModificarCitas, opcionEliminarCitas,
            opcionConsultarNutriologos, opcionInsertarNutriologos, opcionModificarNutriologos, opcionEliminarNutriologos,
            opcionConsultarPacientes, opcionInsertarPacientes, opcionModificarPacientes, opcionEliminarPacientes,
            opcionConsultarPlanAlimenticio, opcionInsertarPlanAlimenticio, opcionModificarPlanAlimenticio, opcionEliminarPlanAlimenticio,
            opcionConsultarAntropometria, opcionInsertarAntropometria, opcionModificarAntropometria, opcionEliminarAntropometria,
            opcionConsultarAsignar, opcionInsertarAsignar, opcionModificarAsignar, opcionEliminarAsignar,
            opcionContacto, opcionAcercaDe;
    private JPanel jpanelNucleoNutricionBD;
    private ResultSet rs;
    //private JButton btnPlanAlimenticio;
    private JTable tablaConsulta;
    private JScrollPane scrollPane;
    private JLabel etiquetaBuscar, etiquetaInsertar =  new JLabel("Inserte los datos solicitados a continuación"), 
            etiquetaInsertar1 = new JLabel("ID Cita: "), etiquetaInsertar2 = new JLabel("ID Paciente: "), etiquetaInsertar3 = new JLabel("ID Nutriologo: "), etiquetaInsertar4 = new JLabel("ID Consulta"), etiquetaInsertar5 = new JLabel("Fecha Consulta");
    private int aux = 0;
    private JTextField consultaIdCita, consultaIdPaciente, consultaIdNutriologo, consultaIdConsulta, consultaFecha,
            campoBuscar;
    private JButton btnHide, btnGuardar;
    private JButton btnConsulta;
    //TextPrompt formatoTexto = new TextPrompt();

    //private JButton btnBuscar = new JButton("Buscar");

    //ConsultasSqlNutricionBD accederConsultasNutricionBD;
    BusquedaNutricionBD accederBusquedaNutricionBD = new BusquedaNutricionBD();
    ConsultasNutricionBD accederConsultasNutricionBD = new ConsultasNutricionBD();
    DefaultTableModel model = new DefaultTableModel();
    
    public NucleoNutricionBD(){
               
        this.setResizable(false);
        this.setSize(630,410);
        //this.setBounds(0,0,420,420);
        //this.setResizable(true);
        //this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("NutriDB - Brian Vega V1.0");
        initComponents();
    
    }//NucleoNutricionBD
    
    private void initComponents(){
        
        jpanelNucleoNutricionBD = new JPanel();//Crear panel
        jpanelNucleoNutricionBD.setBounds(0,0,630,410);
        jpanelNucleoNutricionBD.setBackground(Color.getHSBColor(50, 80, 100));//color panel
        jpanelNucleoNutricionBD.setLayout(null);//quitar diseno
                //this.getContentPane().add(jpanelNucleoNutricionBD);//agregar panel a ventana
                
        barraMenuPrincipal = new JMenuBar();

        barraMenuPrincipal.setBounds(0,0,30,20);
        setJMenuBar(barraMenuPrincipal);

                this.getContentPane().add(jpanelNucleoNutricionBD);//agregar panel a ventana

        
        // Consultas
        consultas = new JMenu("Consultas");
        barraMenuPrincipal.add(consultas);
        
        opcionConsultarConsultas = new JMenuItem("Consultar");
        opcionConsultarConsultas.addActionListener(this);
        consultas.add(opcionConsultarConsultas);
        
        opcionInsertarConsultas = new JMenuItem("Insertar");
        opcionInsertarConsultas.addActionListener(this);
        consultas.add(opcionInsertarConsultas);
        
        opcionModificarConsultas = new JMenuItem("Modificar");
        opcionModificarConsultas.addActionListener(this);
        consultas.add(opcionModificarConsultas);
        
        opcionEliminarConsultas = new JMenuItem("Eliminar");
        opcionEliminarConsultas.addActionListener(this);
        consultas.add(opcionEliminarConsultas);
        
        
        //Citas
        citas = new JMenu("Citas");
        barraMenuPrincipal.add(citas);
        
        opcionConsultarCitas = new JMenuItem("Consultar");
        opcionConsultarCitas.addActionListener(this);
        citas.add(opcionConsultarCitas);
        
        opcionInsertarCitas = new JMenuItem("Insertar");
        opcionInsertarCitas.addActionListener(this);
        citas.add(opcionInsertarCitas);
        
        opcionModificarCitas = new JMenuItem("Modificar");
        opcionModificarCitas.addActionListener(this);
        citas.add(opcionModificarCitas);
        
        opcionEliminarCitas = new JMenuItem("Eliminar");
        opcionEliminarCitas.addActionListener(this);
        citas.add(opcionEliminarCitas);
        
        consultaIdCita = new JTextField("");
        consultaIdPaciente = new JTextField(""); 
        consultaIdNutriologo = new JTextField("");
        consultaIdConsulta = new JTextField("");
        consultaFecha = new JTextField(""); 
        
        
        //Nutriologos
        nutriologos = new JMenu("Nutriologos");
        barraMenuPrincipal.add(nutriologos);
        
        opcionConsultarNutriologos = new JMenuItem("Consultar");
        opcionConsultarNutriologos.addActionListener(this);
        nutriologos.add(opcionConsultarNutriologos);
        
        opcionInsertarNutriologos = new JMenuItem("Insertar");
        opcionInsertarNutriologos.addActionListener(this);
        nutriologos.add(opcionInsertarNutriologos);
        
        opcionModificarNutriologos = new JMenuItem("Modificar");
        opcionModificarNutriologos.addActionListener(this);
        nutriologos.add(opcionModificarNutriologos);
        
        opcionEliminarNutriologos = new JMenuItem("Eliminar");
        opcionEliminarNutriologos.addActionListener(this);
        nutriologos.add(opcionEliminarNutriologos);

        //Pacientes
        pacientes = new JMenu("Pacientes");
        barraMenuPrincipal.add(pacientes);
        
        opcionConsultarPacientes = new JMenuItem("Consultar");
        opcionConsultarPacientes.addActionListener(this);
        pacientes.add(opcionConsultarPacientes);
        
        opcionInsertarPacientes = new JMenuItem("Insertar");
        opcionInsertarPacientes.addActionListener(this);
        pacientes.add(opcionInsertarPacientes);
        
        opcionModificarPacientes = new JMenuItem("Modificar");
        opcionModificarPacientes.addActionListener(this);
        pacientes.add(opcionModificarPacientes);
        
        opcionEliminarPacientes = new JMenuItem("Eliminar");
        opcionEliminarPacientes.addActionListener(this);
        pacientes.add(opcionEliminarPacientes);

        
        //PlanAlimenticio
        planAlimenticio = new JMenu("Plan Alimenticio");
        barraMenuPrincipal.add(planAlimenticio);
        
        opcionConsultarPlanAlimenticio = new JMenuItem("Consultar");
        opcionConsultarPlanAlimenticio.addActionListener(this);
        planAlimenticio.add(opcionConsultarPlanAlimenticio);
        
        opcionInsertarPlanAlimenticio = new JMenuItem("Insertar");
        opcionInsertarPlanAlimenticio.addActionListener(this);
        planAlimenticio.add(opcionInsertarPlanAlimenticio);
        
        opcionModificarPlanAlimenticio = new JMenuItem("Modificar");
        opcionModificarPlanAlimenticio.addActionListener(this);
        planAlimenticio.add(opcionModificarPlanAlimenticio);
        
        opcionEliminarPlanAlimenticio = new JMenuItem("Eliminar");
        opcionEliminarPlanAlimenticio.addActionListener(this);
        planAlimenticio.add(opcionEliminarPlanAlimenticio);
        
        
        //Atropometria
        antropometria = new JMenu("antropometría");
        barraMenuPrincipal.add(antropometria);
        
        opcionConsultarAntropometria = new JMenuItem("Consultar");
        opcionConsultarAntropometria.addActionListener(this);
        antropometria.add(opcionConsultarAntropometria);
        
        opcionInsertarAntropometria = new JMenuItem("Insertar");
        opcionInsertarAntropometria.addActionListener(this);
        antropometria.add(opcionInsertarAntropometria);
        
        opcionModificarAntropometria = new JMenuItem("Modificar");
        opcionModificarAntropometria.addActionListener(this);
        antropometria.add(opcionModificarAntropometria);
        
        opcionEliminarAntropometria = new JMenuItem("Eliminar");
        opcionEliminarAntropometria.addActionListener(this);
        antropometria.add(opcionEliminarAntropometria);
        
        
        //Asignar
        asignar = new JMenu("Asignar");
        barraMenuPrincipal.add(asignar);
        
        opcionConsultarAsignar = new JMenuItem("Consultar");
        opcionConsultarAsignar.addActionListener(this);
        asignar.add(opcionConsultarAsignar);
        
        opcionInsertarAsignar = new JMenuItem("Insertar");
        opcionInsertarAsignar.addActionListener(this);
        asignar.add(opcionInsertarAsignar);
        
        opcionModificarAsignar = new JMenuItem("Modificar");
        opcionModificarAsignar.addActionListener(this);
        asignar.add(opcionModificarAsignar);
        
        opcionEliminarAsignar = new JMenuItem("Eliminar");
        opcionEliminarAsignar.addActionListener(this);
        asignar.add(opcionEliminarAsignar);
        
        
        //Ayuda
        ayuda = new JMenu("Ayuda");
        barraMenuPrincipal.add(ayuda);
        
        opcionContacto = new JMenuItem("Contacto");
        opcionContacto.addActionListener(this);
        ayuda.add(opcionContacto);
        
        opcionAcercaDe = new JMenuItem("Acerca de");
        opcionAcercaDe.addActionListener(this);
        ayuda.add(opcionAcercaDe);
        
        
        //Ocultar
         btnHide = new JButton("Cerrar");
         btnHide.setBounds(20,296,80,25);
         btnHide.addActionListener(this);
         
         btnConsulta = new JButton("Búsqueda por llave");
         btnConsulta.setBounds(450,296,150,30);
         btnConsulta.addActionListener(this);
         btnConsulta.setVisible(false);
         jpanelNucleoNutricionBD.add(btnConsulta);
         
     
        
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(500,296,100,30);
        btnGuardar.addActionListener(this);
         
        etiquetaInsertar.setBounds(15, 10, 300, 30);
        etiquetaInsertar.setFont(new Font("Tahoma", Font.BOLD,12));//Fuente texto
        jpanelNucleoNutricionBD.add(etiquetaInsertar);
        etiquetaInsertar.setVisible(false);


// jpanelNucleoNutricionBD.add(btnGuardar);
    }//initComponents

    //-----------------------------EVENTOS------------------
    @Override
    public void actionPerformed(ActionEvent evt) {
       // scrollPane = new JScrollPane(tablaConsulta);
        
            //---------------------Consultas------------------
        if(evt.getSource() == opcionConsultarConsultas){
            disabled();
            consultarConsultas();
            jpanelNucleoNutricionBD.add(btnHide);
            btnConsulta.setVisible(true);
            btnHide.setVisible(true);
            aux=1;
            //hideComponents();
        }//consultar

        if(evt.getSource() == opcionInsertarConsultas){
            if(aux == 0){
            consultarConsultas();
            hideComponents();
            enabled();
            btnHide.setVisible(false);
            }
            disabled();
            insertarConsultas();
            jpanelNucleoNutricionBD.add(btnHide);
            jpanelNucleoNutricionBD.add(btnGuardar);
            etiquetaInsertar.setVisible(true);
            btnHide.setVisible(true);
            btnGuardar.setVisible(true);
            System.out.println("click Insertar consultas");

        }//Insertar   
        
        if(evt.getSource() == opcionModificarConsultas){
            disabled();
            modificarConsultas();
            jpanelNucleoNutricionBD.add(btnHide);
            //etiquetaInsertar.setVisible(true);
            //btnHide.setVisible(true);
            System.out.println("click Modificar consultas");  
            //accederConsultasNutricionBD.ConsultarConsultasNutricionBD();

        }//Modificar 
        
        if(evt.getSource() == opcionEliminarConsultas){
            disabled();
            eliminarConsultas();
            jpanelNucleoNutricionBD.add(btnHide);
            System.out.println("click Eliminar consultas");   


        }//Eliminar  
        
                //---------------------Citas------------------
        if(evt.getSource() == opcionConsultarCitas){
            System.out.println("click Consultar citas");
            //jpanelNucleoNutricionBD.setVisible(false);
            //accederConsultasNutricionBD = new ConsultasSqlNutricionBD("consulta");
            System.out.println("Regresamos jeje"); 
        }//consultar

        if(evt.getSource() == opcionInsertarCitas){
            System.out.println("click Insertar citas");
        }//Insertar   
        
        if(evt.getSource() == opcionModificarCitas){
            System.out.println("click Modificar citas");
        }//Modificar 
        
        if(evt.getSource() == opcionEliminarCitas){
            System.out.println("click Eliminar citas");
        }//Eliminar  
        
        
                //---------------------Nutriologos------------------
        if(evt.getSource() == opcionConsultarNutriologos){
            System.out.println("click Consultar Nutriologos");
            //jpanelNucleoNutricionBD.setVisible(false);
            //accederConsultasNutricionBD = new ConsultasSqlNutricionBD("consulta");
            System.out.println("Regresamos jeje"); 
        }//consultar

        if(evt.getSource() == opcionInsertarNutriologos){
            System.out.println("click Insertar Nutriologos");
        }//Insertar   
        
        if(evt.getSource() == opcionModificarNutriologos){
            System.out.println("click Modificar Nutriologos");
        }//Modificar 
        
        if(evt.getSource() == opcionEliminarNutriologos){
            System.out.println("click Eliminar Nutriologos");
        }//Eliminar  
        
        
                //---------------------Pacientes------------------
        if(evt.getSource() == opcionConsultarPacientes){
            System.out.println("click Consultar Pacientes");
            //jpanelNucleoNutricionBD.setVisible(false);
            //accederConsultasNutricionBD = new ConsultasSqlNutricionBD("consulta");
            System.out.println("Regresamos jeje"); 
        }//consultar

        if(evt.getSource() == opcionInsertarPacientes){
            System.out.println("click Insertar Pacientes");
        }//Insertar   
        
        if(evt.getSource() == opcionModificarPacientes){
            System.out.println("click Modificar Pacientes");
        }//Modificar 
        
        if(evt.getSource() == opcionEliminarPacientes){
            System.out.println("click Eliminar Pacientes");
        }//Eliminar  
        
        
                //---------------------Plan alimenticio------------------
        if(evt.getSource() == opcionConsultarPlanAlimenticio){
            System.out.println("click Consultar Plan alimenticio");
            //jpanelNucleoNutricionBD.setVisible(false);
           //accederConsultasNutricionBD = new ConsultasSqlNutricionBD("consulta");
            System.out.println("Regresamos jeje"); 
        }//consultar

        if(evt.getSource() == opcionInsertarPlanAlimenticio){
            System.out.println("click Insertar Plan alimenticio");
        }//Insertar   
        
        if(evt.getSource() == opcionModificarPlanAlimenticio){
            System.out.println("click Modificar Plan alimenticio");
        }//Modificar 
        
        if(evt.getSource() == opcionEliminarPlanAlimenticio){
            System.out.println("click Eliminar Plan alimenticio");
        }//Eliminar  
        
        
                //---------------------Antropometría------------------
        if(evt.getSource() == opcionConsultarAntropometria){
            System.out.println("click Consultar Antropometría");
            //jpanelNucleoNutricionBD.setVisible(false);
            //accederConsultasNutricionBD = new ConsultasSqlNutricionBD("consulta");
            System.out.println("Regresamos jeje"); 
        }//consultar

        if(evt.getSource() == opcionInsertarAntropometria){
            System.out.println("click Insertar Antropometría");
        }//Insertar   
        
        if(evt.getSource() == opcionModificarAntropometria){
            System.out.println("click Modificar Antropometría");
        }//Modificar 
        
        if(evt.getSource() == opcionEliminarAntropometria){
            System.out.println("click Eliminar Antropometría");
        }//Eliminar  
        
        
                //---------------------Asignar------------------
        if(evt.getSource() == opcionConsultarAsignar){
            System.out.println("click Consultar Asignar");
            //jpanelNucleoNutricionBD.setVisible(false);
            //accederConsultasNutricionBD = new ConsultasSqlNutricionBD("consulta");
            System.out.println("Regresamos jeje"); 
        }//consultar

        if(evt.getSource() == opcionInsertarAsignar){
            System.out.println("click Insertar Asignar");
        }//Insertar   
        
        if(evt.getSource() == opcionModificarAsignar){
            System.out.println("click Modificar Asignar");
        }//Modificar 
        
        if(evt.getSource() == opcionEliminarAsignar){
            System.out.println("click Eliminar Asignar");
        }//Eliminar  
        
        
                //---------------------Ayuda------------------


                //---------------------Ocultar componentes------------------
        if(evt.getSource() == btnHide){
                //model = new DefaultTableModel();
                //showComponents();
                hideComponents();
            enabled();
            btnHide.setVisible(false);
        }//HideComponents
        
        
        if(evt.getSource() == btnGuardar){
            if(consultaIdCita.getText().length()>0 && consultaIdCita.getText().length()<5 && consultaIdPaciente.getText().length()>0 && consultaIdPaciente.getText().length()<5 && consultaIdNutriologo.getText().length()>0 && consultaIdNutriologo.getText().length()<5 && consultaIdConsulta.getText().length()>0 && consultaIdConsulta.getText().length()<5 && consultaFecha.getText().length()>0 && consultaFecha.getText().length()<11){
               insertarConsultas2();
            }
            else
                JOptionPane.showMessageDialog(null, "Error en la inserción, no es posible guardar datos nulos o mayores a 4 dígitos", "ERROR",JOptionPane.ERROR_MESSAGE);

            

            
        }//click guardar, ejecutar insert into    
            
        if(evt.getSource() == btnConsulta){
            //System.out.println("ya me quiero dormiiiiiiiiiiir");
            accederBusquedaNutricionBD.BusquedaNutricionBD(1);
            accederBusquedaNutricionBD.setVisible(true);
        }//btnConsultaIndividual

        
        }//actionPerformed
    
    public void consultarConsultas(){
            //jpanelNucleoNutricionBD.setVisible(false);
            rs = accederConsultasNutricionBD.ConsultarConsultasNutricionBD();
            tablaConsulta = new JTable(model);
            scrollPane = new JScrollPane(tablaConsulta);
                scrollPane.setBackground(Color.getHSBColor(50, 80, 100));
                scrollPane.setBounds(0,0, 617, 200);
                scrollPane.setViewportView(tablaConsulta);
            model.addColumn("ID Cita");
            model.addColumn("ID Paciente");
            model.addColumn("ID Nutriologo");
            model.addColumn("ID Consulta");
            model.addColumn("Fecha de la consulta");
            try {
                while(rs.next()){
                    Object[] fila = new Object[5];
                    for(int i=0; i<5; i++){
                        fila[i] = rs.getObject(i+1);
                    }//for
                    model.addRow(fila);
                }//while
                //conexion.close()
            } catch (SQLException ex) {                    
                JOptionPane.showMessageDialog(null, "Error en la búsqueda, consulte a su desarrollador para soporte técnico", "ERROR",JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(NucleoNutricionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            jpanelNucleoNutricionBD.add(scrollPane);
                    //scrollPane.setVisible(true);

                                    //opcionConsultarConsultas.setEnabled(false);
                            model = new DefaultTableModel();
                    //btnBuscar.setVisible(true);
            //campoBuscar = new JTextField();
              //  campoBuscar.setBounds(350, 300, 130, 25);

            //jpanelNucleoNutricionBD.add(etiquetaBuscar);
            //jpanelNucleoNutricionBD.add(campoBuscar);
            
            
                        //jpanelNucleoNutricionBD.setVisible(true);
    }//consultarConsultas

    
    public void insertarConsultas(){
        
        etiquetaInsertar1.setBounds(15,50,50,20);
            jpanelNucleoNutricionBD.add(etiquetaInsertar1);
        consultaIdCita.setBounds(150,50,100,25);
            jpanelNucleoNutricionBD.add(consultaIdCita);
            
        etiquetaInsertar2.setBounds(15, 80, 100, 20);
            jpanelNucleoNutricionBD.add(etiquetaInsertar2);
        consultaIdPaciente.setBounds(150,80,100,25);
            jpanelNucleoNutricionBD.add(consultaIdPaciente);
            
        etiquetaInsertar3.setBounds(15, 110, 100, 20);
                    jpanelNucleoNutricionBD.add(etiquetaInsertar3);
        consultaIdNutriologo.setBounds(150,110,100,25);    
            jpanelNucleoNutricionBD.add(consultaIdNutriologo);
            
        etiquetaInsertar4.setBounds(15, 140, 100, 20);
                   jpanelNucleoNutricionBD.add(etiquetaInsertar4);     
        consultaIdConsulta.setBounds(150,140,100,25);    
            jpanelNucleoNutricionBD.add(consultaIdConsulta);
            
        etiquetaInsertar5.setBounds(15, 170, 100, 20);
                    jpanelNucleoNutricionBD.add(etiquetaInsertar5);            
        consultaFecha.setBounds(150,170,100,25);    
            jpanelNucleoNutricionBD.add(consultaFecha);
            
                    
        etiquetaInsertar1.setVisible(true);       
        etiquetaInsertar2.setVisible(true);
        etiquetaInsertar3.setVisible(true);
        etiquetaInsertar4.setVisible(true);
        etiquetaInsertar5.setVisible(true);

        consultaIdNutriologo.setVisible(true);
        consultaIdPaciente.setVisible(true);
        consultaIdCita.setVisible(true);
        consultaIdConsulta.setVisible(true);
        consultaFecha.setVisible(true);
       
    }//insertarConsultas
    
    
    private void insertarConsultas2() {
        String a = consultaIdCita.getText();
        String b = consultaIdPaciente.getText();
        String c = consultaIdNutriologo.getText();
        String d = consultaIdConsulta.getText();
        String e = consultaFecha.getText();
        
        int resultado = accederConsultasNutricionBD.insertarConsultasNutricionBD(a,b,c,d,e);
        if(resultado==1){
            JOptionPane.showMessageDialog(null, "Se ha realizado la inserción del nuevo registro"
                    + " con éxito", "ÉXITO",JOptionPane.INFORMATION_MESSAGE);
        }
        if(resultado == 0){
            JOptionPane.showMessageDialog(null, "Error en la inserción, no es posible crear registros repetidos, o con datos inexistentes. Consulte a"
                            + "su técnico para mayor información", "ERROR",JOptionPane.ERROR_MESSAGE);
        }

        consultaIdCita.setText("");
        consultaIdPaciente.setText("");
        consultaIdNutriologo.setText("");
        consultaIdConsulta.setText("");
        consultaFecha.setText("");
    }
    
    
    public void modificarConsultas(){
        accederBusquedaNutricionBD.BusquedaNutricionBD(2);
        accederBusquedaNutricionBD.setVisible(true);
        enabled();
    }//modificar Consultas
    
    public void eliminarConsultas(){
        //accederBusquedaNutricionBD.initComponents();
        //accederBusquedaNutricionBD.showComponents();
        accederBusquedaNutricionBD.BusquedaNutricionBD(3);
        accederBusquedaNutricionBD.setVisible(true);
        enabled();
                //accederBusquedaNutricionBD.setVisible(false);

    }//Eliminar Consultas
    
        public void showComponents(){
        etiquetaInsertar1.setVisible(true);
        etiquetaInsertar2.setVisible(true);
        etiquetaInsertar3.setVisible(true);
        etiquetaInsertar4.setVisible(true);
        etiquetaInsertar5.setVisible(true);
        etiquetaInsertar.setVisible(true);
        scrollPane.setVisible(true);
        consultaIdNutriologo.setVisible(true);
        consultaIdPaciente.setVisible(true);
        consultaIdCita.setVisible(true);
        consultaIdConsulta.setVisible(true);
        consultaFecha.setVisible(true);
        //opcionConsultarConsultas.setEnabled(true);
        etiquetaBuscar.setVisible(true);
        btnConsulta.setVisible(true); 
        //btnGuardar.setVisible(true);
        //btnHide.setVisible(true);
        campoBuscar.setVisible(true);
    }//hideComponents
    
    public void hideComponents(){
        etiquetaInsertar1.setVisible(false);
        etiquetaInsertar2.setVisible(false);
        etiquetaInsertar3.setVisible(false);
        etiquetaInsertar4.setVisible(false);
        etiquetaInsertar5.setVisible(false);
        etiquetaInsertar.setVisible(false);
        scrollPane.setVisible(false);
        consultaIdNutriologo.setVisible(false);
        consultaIdPaciente.setVisible(false);
        consultaIdCita.setVisible(false);
        consultaIdConsulta.setVisible(false);
        consultaFecha.setVisible(false);
        //opcionConsultarConsultas.setEnabled(true);
       //etiquetaBuscar.setVisible(false);
        btnGuardar.setVisible(false);
        btnConsulta.setVisible(false); 
        //btnHide.setVisible(false);
       // campoBuscar.setVisible(false);
    }//hideComponents

    private void enabled() {
        planAlimenticio.setEnabled(true);
        nutriologos.setEnabled(true);
        asignar.setEnabled(true);
        citas.setEnabled(true); 
        pacientes.setEnabled(true);
        antropometria.setEnabled(true); 
        consultas.setEnabled(true);
        ayuda.setEnabled(true);
    
    }

    private void disabled() {
        planAlimenticio.setEnabled(false);
        nutriologos.setEnabled(false);
        asignar.setEnabled(false);
        citas.setEnabled(false); 
        pacientes.setEnabled(false);
        antropometria.setEnabled(false); 
        consultas.setEnabled(false);
        ayuda.setEnabled(false);
        
    }


}//class extends
