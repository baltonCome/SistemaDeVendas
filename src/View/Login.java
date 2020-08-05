package View;

import Models.Gestor;
import Models.Funcionario;
import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame {
    
    
    JButton entrar = new JButton("Entrar");
    JCheckBox show = new JCheckBox("Mostrar");
    JLabel user = new JLabel("Usuario ID: ");
    JTextField userText = new JTextField();
    JLabel pass = new JLabel("Senha: ");
    JPasswordField password = new JPasswordField();

    Login (){

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
        
        entrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
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
}
