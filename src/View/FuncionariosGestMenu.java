package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import Controlers.SalvarFuncionario;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import Models.Funcionario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class FuncionariosGestMenu extends JFrame{
    
    JButton registar = new JButton("Registar Func.");
    JButton remover = new JButton("Remover Func.");
    JButton listar = new JButton("Listar Func.");
    
    public FuncionariosGestMenu(String id) throws IOException {
        
        setTitle("Funcionarios");
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
                dispose();
                new GestMenu(id);
            }
        });
        
        registar.setBounds(150, 75,200, 25);
        remover.setBounds(150, 128,200, 25);
        listar.setBounds(150, 180,200, 25);
        
        add(registar);
        add(remover);
        add(listar);
        
        registar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    new FuncRegister(id);
                    dispose();
                } catch (IOException ex) {
                    Logger.getLogger(FuncionariosGestMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
	});
        
        remover.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (Files.exists(Paths.get("Funcionario.dat"))){ 
                    try {
                        if(!SalvarFuncionario.mostrar().isEmpty()){
                            ArrayList<Funcionario> remover = SalvarFuncionario.mostrar();
                            String id = JOptionPane.showInputDialog("ID Do Funcionario: ");
                            SalvarFuncionario.apagar(remover, id);
                        }
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(FuncionariosGestMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Sem Dados Registados", "AVISO", INFORMATION_MESSAGE);
                }
            }
	});
        
        listar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (Files.exists(Paths.get("Funcionario.dat"))){ 
                    try {
                        if(!SalvarFuncionario.mostrar().isEmpty()){
                            ArrayList<Funcionario> exibicao = SalvarFuncionario.mostrar();
                            JOptionPane.showMessageDialog(null, exibicao, "LISTA", INFORMATION_MESSAGE);
                        }
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(FuncionariosGestMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Sem Dados Registados", "AVISO", INFORMATION_MESSAGE);
                }
            }
        });
    }
    
}
