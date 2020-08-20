package View;


import Controlers.SalvarProdutos;
import Controlers.RegVendas;
import Models.Produtos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import Models.Vendas;

public class Venda extends JFrame{
    
    ArrayList <Produtos> produtos = new ArrayList<>();
    ArrayList <Vendas> vendas = new ArrayList <>();
    
    JLabel nomeCliente =  new JLabel("Nome do Cliente");
    JTextField inserirNome = new JTextField();
    JLabel idProd = new JLabel("ID do Produto");
    JTextField inserirId = new JTextField();
    JLabel quantidade = new JLabel("Quantidade");
    JTextField inserirQuant = new JTextField();
    JButton continuar = new JButton("Confirmar");
    
    public Venda(String idFunc){
        
        setTitle("Venda");
        setSize(500,320);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        JLabel showId = new JLabel("ID:"+idFunc);
        showId.setBounds(400,265,80,20);
        add(showId);
        
        JButton voltar = new JButton("Voltar");
        voltar.setBounds(10,10,70,20);
        add(voltar);
        voltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new ProdvendasFuncMenu(idFunc);
                dispose();
            }
        });
        
        nomeCliente.setBounds(150,30,100,20);
        inserirNome.setBounds(150,55,200,20);
        idProd.setBounds(150,100,100,20);
        inserirId.setBounds(150,125,200,20);
        quantidade.setBounds(150,170,200,20);
        inserirQuant.setBounds(150,195,200,20);
       
        continuar.setBounds(175,250,150,25);
        
        add(nomeCliente);
        add(inserirNome);
        add(idProd);
        add(inserirId);
        add(quantidade);
        add(inserirQuant);
        add(continuar);
        
        continuar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Files.exists(Paths.get("Produtos.dat"))){
                    try {
                        if(!SalvarProdutos.mostrar().isEmpty()){
                            produtos = SalvarProdutos.mostrar();
                                                      
                            if(SalvarProdutos.temStockPreco(produtos, inserirId.getText(), Integer.parseInt(inserirQuant.getText())) != null){
                                String [] dados = new String[4];
                                dados = SalvarProdutos.dados(produtos, inserirId.getText(), Integer.parseInt(inserirQuant.getText()));
                                String nomeProd = dados[0];
                                String categoria = dados[1];
                                double precoUni = Double.parseDouble(dados[2]);
                                double total = Double.parseDouble(dados[3]);
                                
                                if(Files.exists(Paths.get("Vendas.dat"))){ 
                                    if(!RegVendas.mostrar().isEmpty()){
                                        vendas = RegVendas.mostrar();
                                    }   
                                }
                                Vendas venda = new Vendas(inserirNome.getText(),nomeProd, inserirId.getText(),Integer.parseInt(inserirQuant.getText()), categoria, precoUni, total, idFunc);
                                vendas.add(venda);
                                RegVendas.guardar(vendas);
                                
                                new ConfirmarVenda(inserirNome.getText(), nomeProd, inserirId.getText(), Integer.parseInt(inserirQuant.getText()), categoria, precoUni, total, idFunc);                              
                            }else{
                                JOptionPane.showMessageDialog(null, "Operacao nao sucedida", "INFO", INFORMATION_MESSAGE);
                            }
                        }                  
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                dispose();
            }
	});
    }

}
