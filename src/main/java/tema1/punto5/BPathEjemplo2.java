/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.punto5;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Iterator;

public class BPathEjemplo2 {

    public static void main(String args[]) {
        FileSystem sistemaFicheros = FileSystems.getDefault();
        Path rutaFichero = sistemaFicheros.getPath("C:\\Users\\alumno\\PathEjemplo");
        System.out.println(rutaFichero.getFileName());
        System.out.println(rutaFichero.getParent().getFileName());
        Path rutaDirectorio = sistemaFicheros.getPath("C:\\Users\\alumno");
        Iterator<Path> it = rutaDirectorio.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getFileName());
        }
    }

}
