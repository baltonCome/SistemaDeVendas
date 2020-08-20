package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GestMenu extends JFrame {
    
    JButton produtos = new JButton("Produtos");
    JButton funcionarios = new JButton("Funcionarios");
    JButton mais = new JButton("Mais Config.");
    
    public GestMenu(String id){
        
        setTitle("Menu Do Gestor");
        setSize(500,320);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        JLabel showId = new JLabel("ID:"+id);
        showId.setBounds(400,265,80,20);
        add(showId);
        
        JButton voltar = new JButton("Voltar");
        voltar.setBounds(10,10,70,20);
        add(voltar);
        voltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    new Login();
                } catch (IOException ex) {
                    Logger.getLogger(GestRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
                dispose();
            }
        });
        
        produtos.setBounds(165, 75,150, 25);
        funcionarios.setBounds(165, 128,150, 25);
        mais.setBounds(165, 180,150, 25);
        
        add(produtos);
        add(funcionarios);
        add(mais);
        
        
        produtos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new ProdutosGestMenu(id);
                dispose();
            }
	});
        
        funcionarios.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    new FuncionariosGestMenu(id);
                } catch (IOException ex) {
                    Logger.getLogger(GestMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                dispose();
            }
	});
        
        mais.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new MaisGestMenu(id);
                dispose();
            }
	});
    }
    
}
