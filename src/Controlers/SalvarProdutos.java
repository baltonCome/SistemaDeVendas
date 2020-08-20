package Controlers;

import Models.Produtos;
import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class SalvarProdutos {
    
    public static void guardar (ArrayList <Produtos> produtos ) throws IOException{
        
        if (!produtos.isEmpty()){
            try(FileOutputStream fos = new FileOutputStream("Produtos.dat")){
                try (ObjectOutputStream oos = new ObjectOutputStream(fos)){
                    oos.writeObject(produtos);
                    oos.flush();
                    oos.close();
                    fos.flush();
                    fos.close();
                }
            }
        }
    }
    
    public static ArrayList<Produtos> mostrar () throws IOException, ClassNotFoundException{
        
        try (FileInputStream fis = new FileInputStream("Produtos.dat")){
            try(ObjectInputStream ois = new ObjectInputStream(fis)){
                return (ArrayList<Produtos>) ois.readObject();
            }
        }
    }
    
    public static void apagar(ArrayList<Produtos> produto, String idProd){

        boolean found = false;
        if (Files.exists(Paths.get("Produtos.dat"))) {
            if (!produto.isEmpty()) {
                try {
                    Produtos procurado;
                    for (int i = 0; i < produto.size(); i++) {
                        if (idProd.equalsIgnoreCase(produto.get(i).getIdProduto())) {
                            found = true;
                            procurado = produto.get(i);
                            produto.remove(procurado);
                            JOptionPane.showMessageDialog(null, "Produto Removido","INFO",JOptionPane.PLAIN_MESSAGE);
                            break;
                        }
                    }
                    if (!found){
                        JOptionPane.showMessageDialog(null, "Produto Nao encontrado","INFO",JOptionPane.PLAIN_MESSAGE);
                    }
                    guardar(produto);
                } catch (HeadlessException | IOException e) {
                }
            }
        }
    }

    public static Produtos procurar(ArrayList<Produtos> produto, String idProd){

        Produtos procurado = null;
        if (Files.exists(Paths.get("Produtos.dat"))) {
            if (!produto.isEmpty()) {
                try {
                    for (int i = 0; i < produto.size(); i++) {
                        if (idProd.equalsIgnoreCase(produto.get(i).getIdProduto())) {
                            procurado = produto.get(i);
                            break;
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        return procurado;
    }
    
    public static String [] temStockPreco(ArrayList<Produtos> produto,String idProd, int quant){
        
        String [] dados = new String[4];
        boolean found = false;
        if (Files.exists(Paths.get("Produtos.dat"))) {
            if (!produto.isEmpty()) {
                try {
                    for (int i = 0; i < produto.size(); i++) {
                        if (idProd.equalsIgnoreCase(produto.get(i).getIdProduto()) && produto.get(i).getQuantProduto()>=quant ) {
                            int novaQuant = produto.get(i).getQuantProduto()-quant;
                            produto.get(i).setQuantProduto(novaQuant);
                            dados[0] = produto.get(i).getNomeProduto();
                            dados[1] = produto.get(i).getTipoProduto();
                            dados[2] = produto.get(i).getPrecoProduto()+"";
                            dados[3] = produto.get(i).getPrecoProduto()*quant+"";
                            break;
                        }
                    }
                    guardar(produto);
                } catch (IOException e) {
                }
            }
        }
        return dados;
    }
    
    public static String [] dados(ArrayList<Produtos> produto,String idProd, int quant){
        
        String [] dados = new String[4];
        boolean found = false;
        if (Files.exists(Paths.get("Produtos.dat"))) {
            if (!produto.isEmpty()) {
                for (int i = 0; i < produto.size(); i++) {
                    if (idProd.equalsIgnoreCase(produto.get(i).getIdProduto())) {
                        int novaQuant = produto.get(i).getQuantProduto()-quant;
                        produto.get(i).setQuantProduto(novaQuant);
                        dados[0] = produto.get(i).getNomeProduto();
                        dados[1] = produto.get(i).getTipoProduto();
                        dados[2] = produto.get(i).getPrecoProduto()+"";
                        dados[3] = produto.get(i).getPrecoProduto()*quant+"";
                        break;
                    }
                }
            }
        }
        return dados;
    }
}
