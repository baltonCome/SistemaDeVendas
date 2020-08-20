package Controlers;

import static Controlers.SalvarFuncionario.guardar;
import Models.Funcionario;
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


public class SalvarFuncionario {
    
    public static void guardar (ArrayList <Funcionario> funcionario ) throws IOException{
        
        if (!funcionario.isEmpty()){
            try(FileOutputStream fos = new FileOutputStream("Funcionario.dat")){
                try (ObjectOutputStream oos = new ObjectOutputStream(fos)){
                    oos.writeObject(funcionario);
                    oos.flush();
                    oos.close();
                    fos.flush();
                    fos.close();
                }
            }
        }
    }
    
    public static ArrayList<Funcionario> mostrar () throws IOException, ClassNotFoundException{
        
        try (FileInputStream fis = new FileInputStream("Funcionario.dat")){
            try(ObjectInputStream ois = new ObjectInputStream(fis)){
                return (ArrayList<Funcionario>) ois.readObject();
            }
        }
    }
    
    public static void alterarSenha(ArrayList<Funcionario> funcionario, String id, String senha) throws IOException{

        boolean found = false;
        if (Files.exists(Paths.get("Funcionario.dat"))) {
            if (!funcionario.isEmpty()) {
                try {
                    int i = 0;
                    for (i = 0; i < funcionario.size(); i++) {
                        if (id.equalsIgnoreCase(funcionario.get(i).getId())) {
                            found = true;
                            break;
                        }
                    }
                    if (found){
                        funcionario.get(i).setSenha(senha);
                    }
                    guardar(funcionario);
                }catch(IOException e){
                }
            }
        }
    }
    
    public static void apagar(ArrayList<Funcionario> funcionario, String idFunc){

        boolean found = false;
        if (Files.exists(Paths.get("Funcionario.dat"))) {
            if (!funcionario.isEmpty()) {
                try {
                    Funcionario procurado;
                    for (int i = 0; i < funcionario.size(); i++) {
                        if (idFunc.equalsIgnoreCase(funcionario.get(i).getId())) {
                            found = true;
                            procurado = funcionario.get(i);
                            funcionario.remove(procurado);
                            break;
                        }
                    }
                    if (!found){
                        JOptionPane.showMessageDialog(null, "Funcionario Nao encontrado","INFO",JOptionPane.PLAIN_MESSAGE);
                    }
                    guardar(funcionario);
                } catch (HeadlessException | IOException e) {
                }
            }
        }
    }
    
    public static boolean isFuncionario(ArrayList<Funcionario> funcionario, String id, char[] jPassField){
        
        boolean matches = false;
        
        String concat ="";
        for (int i = 0; i<jPassField.length; i++){
            concat +=jPassField[i];
        }
       
        if(Files.exists(Paths.get("Funcionario.dat"))){
            if(!funcionario.isEmpty()){
                try{
                    for(int i = 0; i<funcionario.size(); i++){
                        if(id.equalsIgnoreCase(funcionario.get(i).getId()) && concat.equals(funcionario.get(i).getSenha())){
                            matches = true;
                        }
                    }
                }catch(Exception e){
                }
            }
        }
        return matches;
    }
}
