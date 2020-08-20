package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MaisGestMenu extends JFrame{
    
    JButton registar = new JButton("Adicionar Gestor");
    JButton alterar = new JButton("Alterar Senha");
    
    public MaisGestMenu(String idGest){
        
        setTitle("Mais Configuracoes");
        setSize(500,320);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        JLabel showId = new JLabel("ID:"+idGest);
        showId.setBounds(400,265,80,20);
        add(showId);
        
        registar.setBounds(150, 95,200, 25);
        alterar.setBounds(150, 140,200, 25);
        
        add(registar);
        add(alterar);
        
        JButton voltar = new JButton("Voltar");
        voltar.setBounds(10,10,70,20);
        add(voltar);
        
        voltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new GestMenu(idGest);
                dispose();
            }
        });
        
        registar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    new GestRegister();
                } catch (IOException ex) {
                    Logger.getLogger(MaisGestMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                dispose();
            }
	});
        
        alterar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new AlterarSenhaGest(idGest);
                dispose();
            }
	});
    }
}
