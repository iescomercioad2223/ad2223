package tema1.punto2;

import java.io.File;

public class BEnumFichDirectorio {
public static void main(String[] args) {
  System.out.println("Archivos que existen en el directorio:");
  File f = new File("C:\\Users\\Antonio\\Documents\\NetBeansProjects\\Ficheros\\src\\ficheros");
  String[] archivos = f.list();
  for (int i = 0; i < archivos.length; i++) {
    System.out.println(archivos[i]);
  }
 }    
}
