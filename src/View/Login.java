package View;

import Controlers.SalvarFuncionario;
import Controlers.SalvarGestor;
import Models.Gestor;
import Models.Funcionario;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class Login extends JFrame {
    
    
    JButton entrar = new JButton("Entrar");
    JCheckBox show = new JCheckBox("Mostrar");
    JLabel user = new JLabel("Usuario ID: ");
    JTextField userText = new JTextField();
    JLabel pass = new JLabel("Senha: ");
    JPasswordField password = new JPasswordField();
    
    ArrayList <Gestor> gestor = new ArrayList<>();
    ArrayList <Funcionario> funcionario = new ArrayList<>();

    Login () throws IOException {

        setTitle("Login");
        setSize(400,180);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        entrar.setBounds(145,95,100,25);
        show.setBounds(300,60,70,20);
        show.setSelected(false);
        
        user.setBounds(30,30,80,20);
        userText.setBounds(100,30,200,20);

        pass.setBounds(30,60,80,20);
        password.setBounds(100,60,200,20);

        add(entrar);    
        add(show);
        add(userText);
        add(user);
        add(pass);
        add(password);
        
        if(!Files.exists(Paths.get("Gestor.dat"))){                 
            try {
                new GestRegister();
                dispose();
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        entrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    gestor = SalvarGestor.mostrar();
                    if(SalvarGestor.isGestor(gestor, userText.getText(), password.getPassword())){  
                        new GestMenu(userText.getText());
                        dispose();
                    }
                    
                    if (Files.exists(Paths.get("Funcionario.dat"))){   
                        if(!SalvarFuncionario.mostrar().isEmpty()){
                            funcionario = SalvarFuncionario.mostrar();
                            if(SalvarFuncionario.isFuncionario(funcionario, userText.getText(), password.getPassword())){
                                new FuncMenu(userText.getText());
                                dispose();
                            }
                        }
                    }
                    
                    if(!SalvarGestor.isGestor(gestor, userText.getText(), password.getPassword()) && !SalvarFuncionario.isFuncionario(funcionario, userText.getText(), password.getPassword())){
                        JOptionPane.showMessageDialog(null,"Dados Nao reconhecidos", "ERRO", ERROR_MESSAGE);
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ea){
                if(show.isSelected()){
                    password.setEchoChar((char)0);
                }
            }
        });
    }
    
    public static void main(String[]args) throws IOException{
        new Login();
    }
}
