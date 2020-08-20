package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Models.Produtos;
import Controlers.SalvarProdutos;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ModelsDao.VerificacaoEGeracao;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;

public class ProdRegister extends JFrame{
    
    ArrayList<Produtos> produtos = new ArrayList();
    
    String [] tipos = {"Comestivel", "Nao Comestivel"};
    
    JLabel nomeProd = new JLabel("Nome do produto: ");
    JLabel quantidade = new JLabel("Quantidade: ");
    JLabel categoria = new JLabel("Categoria: ");
    JLabel preco = new JLabel("Preco: ");
    
    JTextField inserirNome = new JTextField();
    JTextField inserirQuant = new JTextField();
    JComboBox <String> tipo = new JComboBox<>(tipos);
    JTextField inserirPreco = new JTextField();
    
    JButton registar = new JButton("Registar");
    
    public ProdRegister(String id) throws IOException, ClassNotFoundException, FileNotFoundException {
        
        setTitle("Registo De Produto");
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
                new ProdutosGestMenu(id);
            }
        });
        
        nomeProd.setBounds(70,50,150,20);
        quantidade.setBounds(70,90,150,20);
        categoria.setBounds(70,130,150,20);
        preco.setBounds(70,170,150,20);
        
        inserirNome.setBounds(220,50,200,20);
        inserirQuant.setBounds(220,90,200,20);
        tipo.setBounds(220,130,200,20);
        inserirPreco.setBounds(220,170,200,20);
        
        registar.setBounds(175,230,150,30);
        
        add(nomeProd);
        add(quantidade);
        add(categoria);
        add(preco);
        
        add(inserirNome);
        add(inserirQuant);
        add(tipo);
        add(inserirPreco);
        
        add(registar);
        
        String selectedCombo = (String)tipo.getSelectedItem();
        VerificacaoEGeracao vege = new VerificacaoEGeracao();
        
        registar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                String id= "";
                try {
                    id = vege.geraIdProd(inserirNome.getText(), Integer.parseInt(inserirQuant.getText()), selectedCombo);
                } catch (IOException ex) {
                    Logger.getLogger(ProdRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(Files.exists(Paths.get("Produtos.dat"))){
                    try {
                        if(!SalvarProdutos.mostrar().isEmpty()){
                            produtos = SalvarProdutos.mostrar();
                        }
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(ProdRegister.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                Produtos prod = new Produtos(inserirNome.getText(),id,Integer.parseInt(inserirQuant.getText()),selectedCombo,Double.parseDouble(inserirPreco.getText()));
                produtos.add(prod);
                try {
                    SalvarProdutos.guardar(produtos);
                } catch (IOException ex) {
                    Logger.getLogger(ProdRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Produto Salvo ","ID: "+id, PLAIN_MESSAGE);
            }
	});
    } 
}
