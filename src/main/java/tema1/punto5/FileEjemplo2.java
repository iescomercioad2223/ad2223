/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.punto5;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
// Crea un nuevo fichero o directorio o lo borra si ya existe

public class FileEjemplo2 {

    public static void main(String args[]) {
        Path path = Paths.get("C:\\Users\\alumno\\prueba");
        try {
            if (Files.exists(path)) {
                Files.delete(path);
            } else {
                Files.createFile(path);
            }
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
    }
}
