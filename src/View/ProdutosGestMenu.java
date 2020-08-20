package View;

import Controlers.SalvarProdutos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Models.Produtos;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import Models.Vendas;
import Controlers.RegVendas;
import ModelsDao.VerificacaoEGeracao;
import javax.swing.JLabel;


public class ProdutosGestMenu extends JFrame{
    
    VerificacaoEGeracao vege = new VerificacaoEGeracao();
    ArrayList <Produtos> produtos = new ArrayList<>();
    
    JButton registar = new JButton("Registar Produto");
    JButton lista = new JButton("Lista de Produtos");
    JButton apagar = new JButton("Remover Produto");
    JButton procurar = new JButton("Procurar Produto");
    JButton relatorio = new JButton("Relatorio de Vendas");

    public ProdutosGestMenu(String id){
        
        setTitle("Produtos");
        setSize(500,320);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        registar.setBounds(150,20,200,25);
        lista.setBounds(150, 75,200, 25);
        apagar.setBounds(150, 128,200, 25);
        procurar.setBounds(150, 180,200, 25);
        relatorio.setBounds(150,233,200,25);
        
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
        
        add(registar);
        add(lista);
        add(apagar);
        add(procurar);
        add(relatorio);
        
        registar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    new ProdRegister(id);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(ProdutosGestMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        
        apagar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Files.exists(Paths.get("Produtos.dat"))){
                    try {
                        if(!SalvarProdutos.mostrar().isEmpty()){
                            produtos = SalvarProdutos.mostrar();
                            String idProd = JOptionPane.showInputDialog("ID do Produto a Eliminar");
                            SalvarProdutos.apagar(produtos, idProd);
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
                            if(SalvarProdutos.procurar(produtos, idProd)!= null){
                                JOptionPane.showMessageDialog(null, SalvarProdutos.procurar(produtos, idProd), "INFO", INFORMATION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(null, "Produto Nao encontrado", "INFO", INFORMATION_MESSAGE);
                            }
                        }
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(ProdutosGestMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
	});
        
        relatorio.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Files.exists(Paths.get("Vendas.dat"))){
                    try {
                        if(!RegVendas.mostrar().isEmpty()){
                            
                            ArrayList <Vendas> vendas = new ArrayList <>();
                            vendas = RegVendas.mostrar();
                            vege.geraRelatorio(vendas);
                        }
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(ProdutosGestMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
	});
    }
    
}
