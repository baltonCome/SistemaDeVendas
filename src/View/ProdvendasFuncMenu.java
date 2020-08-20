package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import Controlers.SalvarProdutos;
import Controlers.RegVendas;
import Models.Produtos;
import Models.Vendas;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;


public class ProdvendasFuncMenu extends JFrame{
    
    ArrayList<Produtos> produtos = new ArrayList<>();
    ArrayList<Vendas> vendas = new ArrayList<>();
    
    JButton vender = new JButton("Vender");
    JButton lista = new JButton("Lista de Produtos");
    JButton procurar = new JButton("Procurar Produto");
    JButton minhas = new JButton("Minhas Vendas");
    
    public ProdvendasFuncMenu(String idFunc){
        
        setTitle("Produtos e Vendas");
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
                dispose();
                new FuncMenu(idFunc);
                dispose();
            }
        });
       
        vender.setBounds(150,55,200,25);
        lista.setBounds(150,95,200,25);
        procurar.setBounds(150,135,200,25);
        minhas.setBounds(150,175,200,25);
        
        add(vender);
        add(lista);
        add(procurar);
        add(minhas);
        
        vender.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Venda(idFunc);
                dispose();
            }
	});
        
        lista.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Files.exists(Paths.get("Produtos.dat"))){
                    try {
                        if(!SalvarProdutos.mostrar().isEmpty()){
                            produtos = SalvarProdutos.mostrar();
                            JOptionPane.showMessageDialog(null, produtos ,"LISTA DE PRODUTOS", PLAIN_MESSAGE);
                        }
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(ProdutosGestMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
	});
        
        procurar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Files.exists(Paths.get("Produtos.dat"))){
                    try {
                        if(!SalvarProdutos.mostrar().isEmpty()){
                            produtos = SalvarProdutos.mostrar();
                            String idProd = JOptionPane.showInputDialog("ID do Produto a Exibir");
                            JOptionPane.showMessageDialog(null, SalvarProdutos.procurar(produtos, idProd), "INFO", INFORMATION_MESSAGE);
                        }
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(ProdutosGestMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
	});
        
        minhas.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Files.exists(Paths.get("Vendas.dat"))){
                    try {
                        if(!RegVendas.mostrar().isEmpty()){
                            vendas = RegVendas.mostrar();
                            if(RegVendas.procurar(vendas, idFunc)!= null){
                                JOptionPane.showMessageDialog(null, RegVendas.procurar(vendas, idFunc), "INFO", INFORMATION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(null, "Nenhuma Venda Efectuada", "INFO", INFORMATION_MESSAGE);
                            }
                        }
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(ProdvendasFuncMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
	});
    }   
    
}
