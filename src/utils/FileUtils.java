/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Luis
 */
public class FileUtils {

    private FileUtils() {
    }
    
    public static final String FICHEIRO_JOGO_GUARDADO = "JogoGuardado.bin";
    
//    public static JogoMaqEst carregaJogoDeFicheiroBinario(File f) throws IOException, ClassNotFoundException{
//       
//        ObjectInputStream in = null;
//        
//        try{
//            in = new ObjectInputStream(new FileInputStream(f));
//            return (JogoMaqEst)in.readObject();
//        }finally{
//            if(in != null){
//                in.close();
//            }
//        }
//    }
//    
    public static boolean saveSheet(File f, Object o) throws IOException{
        
        ObjectOutputStream out = null;

        try{
            out = new ObjectOutputStream(new FileOutputStream(f));
            out.writeObject(o);
            return true;  
        }catch(NotSerializableException ex){
            throw ex;
        }catch(InvalidClassException ex){
            throw ex;
        }catch(IOException ex ){
            throw ex;
        }finally{
            if(out != null){
                try {
                    out.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }
    }
    
}
