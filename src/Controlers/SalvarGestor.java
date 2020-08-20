package Controlers;

import Models.Gestor;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SalvarGestor {
    
    public static void guardar (ArrayList <Gestor> gestor ) throws IOException{
        
        if (!gestor.isEmpty()){
            try(FileOutputStream fos = new FileOutputStream("Gestor.dat")){
                try (ObjectOutputStream oos = new ObjectOutputStream(fos)){
                    oos.writeObject(gestor);
                    oos.flush();
                    oos.close();
                    fos.flush();
                    fos.close();
                }
            }
        }
    }
    
    public static ArrayList<Gestor> mostrar () throws IOException, ClassNotFoundException{
        
        try (FileInputStream fis = new FileInputStream("Gestor.dat")){
            try(ObjectInputStream ois = new ObjectInputStream(fis)){
                return (ArrayList<Gestor>) ois.readObject();
            }
        }
    }
    
    public static void alterarSenha(ArrayList<Gestor> gestor, String id, String senha) throws IOException{

        boolean found = false;
        if (Files.exists(Paths.get("Gestor.dat"))) {
            if (!gestor.isEmpty()) {
                try {
                    int i = 0;
                    for (i = 0; i < gestor.size(); i++) {
                        if (id.equalsIgnoreCase(gestor.get(i).getId())) {
                            found = true;
                            break;
                        }
                    }
                    if (found){
                        gestor.get(i).setSenha(senha);
                    }
                    guardar(gestor);
                }catch(IOException e){
                }
            }
        }
    }
    
    public static boolean isGestor(ArrayList<Gestor> gestor, String id, char[] jPassField){
        
        boolean matches = false;
        
        String concat ="";
        for (int i = 0; i<jPassField.length; i++){
            concat +=jPassField[i];
        }
       
        if(Files.exists(Paths.get("Gestor.dat"))){
            if(!gestor.isEmpty()){
                try{
                    for(int i = 0; i<gestor.size(); i++){
                        if(id.equalsIgnoreCase(gestor.get(i).getId()) && concat.equals(gestor.get(i).getSenha())){
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
