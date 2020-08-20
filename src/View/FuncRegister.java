package View;

import Controlers.SalvarFuncionario;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Funcionario;
import ModelsDao.VerificacaoEGeracao;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;

public class FuncRegister extends JFrame{
    
    ArrayList <Funcionario> funcionario = new ArrayList<>();
    
    JButton register = new JButton("Registar");
    JLabel name = new JLabel("Nome");
    JLabel password = new JLabel("Senha");
    JLabel hiddenpass = new JLabel("Confirme a Senha");
    JTextField nome = new JTextField();
    JTextField senha = new JTextField();
    JPasswordField confirmar = new JPasswordField();
    
    public FuncRegister(String idGest) throws IOException {
        
        setTitle("Registo");
        setSize(500,320);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        
        JButton voltar = new JButton("Voltar");
        voltar.setBounds(10,10,70,20);
        add(voltar);
        voltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    new FuncionariosGestMenu(idGest);
                } catch (IOException ex) {
                    Logger.getLogger(FuncRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
                dispose();
            }
        });
        
        name.setBounds(150,30,100,20);
        nome.setBounds(150,55,200,20);
        password.setBounds(150,100,100,20);
        senha.setBounds(150,125,200,20);
        hiddenpass.setBounds(150,170,200,20);
        confirmar.setBounds(150,195,200,20);
       
        register.setBounds(175,250,150,25);
        
        add(name);
        add(nome);
        add(password);
        add(senha);
        add(hiddenpass);
        add(confirmar);
        add(register);
        
        String perfil = "Funcionario";
        VerificacaoEGeracao vege = new VerificacaoEGeracao();
        String id = vege.geraIdOperario(nome.getText() , perfil);
        
        register.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e1){
                
                if(vege.matches(confirmar.getPassword(),senha.getText())){
                    if(Files.exists(Paths.get("Funcionario.dat"))){
                        try {
                            if(!SalvarFuncionario.mostrar().isEmpty()){
                                funcionario = SalvarFuncionario.mostrar();
                            }
                        } catch (IOException | ClassNotFoundException ex) {
                            Logger.getLogger(FuncRegister.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    Funcionario func = new Funcionario(perfil,senha.getText(),nome.getText(), id);
                    funcionario.add(func);
                    try {
                        SalvarFuncionario.guardar(funcionario);
                        JOptionPane.showMessageDialog(null, "Funcionario Salvo ","ID: "+id, PLAIN_MESSAGE);
                    } catch (IOException ex) {
                        Logger.getLogger(FuncRegister.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Senhas Incopativeis", "ERRO", ERROR_MESSAGE);
                }  
            }
	});
    }
}
