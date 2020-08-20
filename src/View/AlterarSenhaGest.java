package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Controlers.SalvarGestor;
import Models.Gestor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ModelsDao.VerificacaoEGeracao;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;


public class AlterarSenhaGest extends JFrame{
    
    JLabel id = new JLabel("Insira o ID:");
    JLabel senhaAtual = new JLabel("Senha Actual:");
    JLabel senhaNova = new JLabel("Nova Senha:");
    JLabel redoNova = new JLabel("Repita a Nova Senha:");
    
    JTextField inserirId = new JTextField();
    JPasswordField inserirAtual = new JPasswordField();
    JTextField inserirNova = new JTextField();
    JPasswordField inserirRedo = new JPasswordField();
    
    JButton confirmar = new JButton("Confirmar");
    
    public AlterarSenhaGest(String gestId){
        
        setTitle("Alterar Senha");
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
                new MaisGestMenu(gestId);
            }
        });
        
        id.setBounds(50,30,150,20);
        senhaAtual.setBounds(50,70,150,20);
        senhaNova.setBounds(50,110,150,20);
        redoNova.setBounds(50,150,150,20);
        
        inserirId.setBounds(200,30,200,23);
        inserirAtual.setBounds(200,70,200,23);
        inserirNova.setBounds(200,110,200,23);
        inserirRedo.setBounds(200,150,200,23);
        
        confirmar.setBounds(160,220,150,25);
        
        add(id);
        add(senhaAtual);
        add(senhaNova);
        add(redoNova);
        
        add(inserirId);
        add(inserirAtual);
        add(inserirNova);
        add(inserirRedo);
        
        add(confirmar);
        
        VerificacaoEGeracao vege = new VerificacaoEGeracao();
        
        confirmar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    if(!SalvarGestor.mostrar().isEmpty()){
                        
                        ArrayList <Gestor> gestor = SalvarGestor.mostrar();
                        if(SalvarGestor.isGestor(gestor, inserirId.getText(), inserirAtual.getPassword())){
                            
                            if (vege.matches(inserirRedo.getPassword(), inserirNova.getText())){
                                
                                SalvarGestor.alterarSenha(gestor, inserirId.getText(), inserirNova.getText());
                                JOptionPane.showMessageDialog(null, "Senha Alterada", "AVISO", INFORMATION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(null, "Senhas Nao Compativeis", "AVISO", INFORMATION_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Perfil Nao encontrado", "AVISO", INFORMATION_MESSAGE);
                        }
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(AlterarSenhaGest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
	});
    }
}
