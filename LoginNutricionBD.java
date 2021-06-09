package SQL;
/**
 *
 * @author Brian
 */
//Clase para logear al usuario y validar sus credenciales
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
public class LoginNutricionBD extends JFrame /*implements ActionListener*/{
    
    private ImageIcon imagenUser;
    private JLabel pass, user, jimagenUser, prueba;
    private JPasswordField campoPass;
    private JTextField campoUser;
    private JButton botonAcceder;
    private String userG="Magdalena", passG="Mca2603", auxUserG, auxPassG;
    
    public LoginNutricionBD(){
        //fondoLoginNutricionBD.setIcon(new ImageIcon(getClass().getResource("FondoManzanas.jpg")));
        //this.getContentPane().setBackground(Color.getHSBColor(50, 80, 100));
        this.setSize(420,420);
        //this.setBounds(0,0,420,420);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Iniciar sesión");
        initComponents();
   //     Formulario formulario1 = new Formulario();
    }//LoginNutricionBD
         
    private void initComponents(){
        NucleoNutricionBD accederNucleoNutricionBD = new NucleoNutricionBD();//para acceder a la siguiente ventanaa

        JPanel jpanelLoginNutricionBD = new JPanel();//Crear panel
        jpanelLoginNutricionBD.setBackground(Color.getHSBColor(50, 80, 100));//color panel
        jpanelLoginNutricionBD.setLayout(null);//quitar diseno
        this.getContentPane().add(jpanelLoginNutricionBD);//agregar panel a ventana
        
        imagenUser = new ImageIcon("icono_user.png");
        jimagenUser = new JLabel();
        jimagenUser.setBounds(110,30,200,200);
        jimagenUser.setIcon(new ImageIcon(imagenUser.getImage().getScaledInstance(200,200, Image.SCALE_SMOOTH)));
        jpanelLoginNutricionBD.add(jimagenUser);
        

        user = new JLabel("Usuario: ");
        //user.setOpaque(true);//quitar estilos
        user.setBounds(72, 260, 100, 30);
        user.setFont(new Font("Tahoma", Font.BOLD,20));//Fuente texto
        jpanelLoginNutricionBD.add(user);
        
        pass = new JLabel("Contraseña: ");
        //pass.setOpaque(true);//quitar estilos
        //pass.setForeground(Color.white);//color letra
        pass.setBounds(35, 295, 130, 30);
        pass.setFont(new Font("Tahoma", Font.BOLD,20));//Fuente texto
        jpanelLoginNutricionBD.add(pass);
        
        campoUser = new JTextField();
        campoUser.setBounds(180, 263, 130, 25);
       // campoUser.setBackground(Color.white);
        jpanelLoginNutricionBD.add(campoUser);
        
        campoPass = new JPasswordField();
        campoPass.setBounds(180, 298, 130, 25);
        //campoPass.setBackground(Color.white);
        jpanelLoginNutricionBD.add(campoPass);
        
        /*prueba = new JLabel();
        prueba.setBounds(50, 200, 300, 40);
        jpanelLoginNutricionBD.add(prueba);*/
        
        botonAcceder = new JButton("Acceder");
        botonAcceder.setBounds(290, 330, 100, 30);
        botonAcceder.setEnabled(true);//habilitar botón
        jpanelLoginNutricionBD.add(botonAcceder);
        
        ActionListener oyenteAcceder = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(evt.getSource() == botonAcceder){
                    auxUserG = campoUser.getText();
                    auxPassG = campoPass.getText();
                    if(auxUserG.equals(userG) && auxPassG.equals(passG)){
                        accederNucleoNutricionBD.setVisible(true);
                        setVisible(false);
                        //JOptionPane.showMessageDialog(null, "PRUEBA - COINCIDENCIA ENCONTRADA");
                    }//Credenciales coinciden
                    else{
                        if(auxUserG.equals(userG))
                            JOptionPane.showMessageDialog(null, "La contraseña es incorrecta", "ERROR",JOptionPane.ERROR_MESSAGE);
                        else
                            if(auxPassG.equals(passG))
                                JOptionPane.showMessageDialog(null, "El usuario es incorrecto", "ERROR",JOptionPane.ERROR_MESSAGE);
                            else 
                                if(!auxUserG.equals(userG) && !auxPassG.equals(passG))
                                  JOptionPane.showMessageDialog(null, "Los datos proporcionados son incorrectos", "ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }//evt==botonAcceder
                
                //prueba.setText("Todo bien " +  campoUser.getText() + " - Contraseña: " + campoPass.getText());
            }
        };
        botonAcceder.addActionListener(oyenteAcceder);
    }//initComponents
}//class extends
