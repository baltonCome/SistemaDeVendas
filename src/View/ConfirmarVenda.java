package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ConfirmarVenda extends JFrame {
    
    JLabel nomeCliente = new JLabel("Nome do Cliente: ");
    JLabel nomeProduto = new JLabel("Nome do Produto: ");
    JLabel iDProduto = new JLabel("ID do Produto: ");
    JLabel nrProdutos = new JLabel("Quantidade: ");
    JLabel tipoProduto = new JLabel("Categoria: ");
    JLabel precoProduto = new JLabel("Preco: ");
    JLabel valorGasto = new JLabel("Preco total: ");
    
    JButton confirmar = new JButton("OKay Okay");
    
    public ConfirmarVenda(String cliente, String produto, String idProd, int quant, String categoria, double precoUnitario, double precoTotal, String idFunc){
        
        JLabel mostraNome = new JLabel(cliente);
        JLabel mostraProd = new JLabel(produto);
        JLabel mostraId = new JLabel(idProd);
        JLabel mostraQuant = new JLabel(quant+"");
        JLabel mostraCate = new JLabel(categoria);
        JLabel mostraPreco = new JLabel(precoUnitario+"");
        JLabel mostraTotal = new JLabel(precoTotal+"");
        
        setTitle("Produto Vendido");
        setSize(500,320);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        JLabel showId = new JLabel("ID:"+idFunc);
        showId.setBounds(400,265,80,20);
        add(showId);
        
        nomeCliente.setBounds(85,30,150,20);
        nomeProduto.setBounds(85,60,150,20);
        iDProduto.setBounds(85,90,150,20);
        nrProdutos.setBounds(85,120,150,20);
        tipoProduto.setBounds(85,150,150,20);
        precoProduto.setBounds(85,180,150,20);
        valorGasto.setBounds(85,210,150,20);
        
        mostraNome.setBounds(250,30,150,20);
        mostraProd.setBounds(250,60,150,20);
        mostraId.setBounds(250,90,150,20);
        mostraQuant.setBounds(250,120,150,20);
        mostraCate.setBounds(250,150,150,20);
        mostraPreco.setBounds(250,180,150,20);
        mostraTotal.setBounds(250,210,150,20);
        
        confirmar.setBounds(155,250,200,20);
        
        add(nomeCliente);
        add(nomeProduto);
        add(iDProduto);
        add(nrProdutos);
        add(tipoProduto);
        add(precoProduto);
        add(valorGasto);
        
        add(mostraNome);
        add(mostraProd);
        add(mostraId);
        add(mostraQuant);
        add(mostraCate);
        add(mostraPreco);
        add(mostraTotal);
        
        add(confirmar);
        
        confirmar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e1){
               dispose();
               new ProdvendasFuncMenu(idFunc);
           }
        });
    }
}
