/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.punto5;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.io.IOException;
//import java.nio.file.FileAlreadyExistsException; //en caso de querer sobrescribir el directorio destino

public class FileEjemplo4 {

    public static void main(String args[]) {
        Path sourcePath = Paths.get("C:\\Users\\alumno\\origen");
        Path destinationPath = Paths.get("C:\\Users\\alumno\\FileEjamplo\\destino");
        try {
            Files.copy(sourcePath, destinationPath);
            //Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (FileAlreadyExistsException e) {
            System.out.println("el fichero existe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
