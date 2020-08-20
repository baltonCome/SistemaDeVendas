package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FuncMenu extends JFrame {
    
    JButton produtos = new JButton("Vendas e Produtos");
    JButton alterar = new JButton("Alterar Senha");
   
    public FuncMenu(String id){
        
        
        setTitle("Menu Do Funcionario");
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
        alterar.setBounds(165, 128,150, 25);
        
        add(produtos);
        add(alterar);
        
        
        produtos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new ProdvendasFuncMenu(id);
                dispose();
            }
	});
        
        alterar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new AlterarSenhaFunc(id);
                dispose();
            }
	});
        
    }
}
