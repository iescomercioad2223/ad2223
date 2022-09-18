/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.punto5;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileEjemplo5 {

    public static void main(String args[]) {
        Path sourcePath = Paths.get("C:\\Users\\alumno\\FileEjamplo\\hola.txt");
        Path destinationPath = Paths.get("C:\\Users\\alumno\\FileEjamplo\\destino\\hola.txt");
        try {
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (FileAlreadyExistsException e) {
            System.out.println("el destino existe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
