package ModelsDao;

import Models.Vendas;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class VerificacaoEGeracao {
    
    public VerificacaoEGeracao(){
    }
    
    public int contador() throws IOException{
        
        if(!Files.exists(Paths.get("Counter.txt"))){
            BufferedWriter bw = new BufferedWriter(new FileWriter("Counter.txt", true));
            bw.write("1");
            bw.flush();
            bw.close();
        }
        
        File actual = new File("Counter.txt");
        File next = new File("Next.txt");
        
        BufferedReader br = new BufferedReader(new FileReader(actual));
        BufferedWriter bw1 = new BufferedWriter(new FileWriter(next));
        
        String busca ="";
        String line = br.readLine();
        while (line != null){
            busca+=line;
            line = br.readLine();
        }
        int numero = Integer.parseInt(busca);
         
        numero+=1;
        br.close();
        
        bw1.write(numero+"");
        bw1.flush();
        bw1.close();
        
        actual.delete();
        next.renameTo(actual);
        return numero;
    }
    
    public String geraIdProd(String nome, int quantidade, String tipo) throws IOException{
        
        while(quantidade>100){
            quantidade-=10;
        }
        return nome.substring(0,1).toUpperCase()+quantidade+tipo.substring(0,1).toUpperCase()+nome.substring(nome.length()-1)+contador();
    }
    
    public String geraIdOperario(String nome, String perfil) throws IOException {
  
        String[] nomes = nome.split(" ");
        String[] alpha1 = nomes[0].split("");
        String[] alpha2 = nomes[nomes.length - 1].split("");
        return alpha1[0] + alpha2[0]+perfil.substring(0,1)+contador();
    }
    
    public boolean matches(char[] jPassField, String password){
        
        String concat ="";
        for (int i = 0; i<jPassField.length; i++){
            concat +=jPassField[i];
        }
        return password.equals(concat);
    }
    
    public void geraRelatorio(ArrayList<Vendas> venda) throws IOException{
        
        String rel =venda+"";
        
        BufferedWriter bw = new BufferedWriter(new FileWriter("Relatorio.txt",true));
        bw.write(rel);
        bw.flush();
        bw.close();
        
        open();
    }
    
    public static void open() throws IOException{
        
        String[] open = new String[2];
        open[0] = "notepad.exe";
        open[1] = "Relatorio.txt";
        
        Runtime rt = Runtime.getRuntime();
        
        rt.exec(open,null);
    }
}
