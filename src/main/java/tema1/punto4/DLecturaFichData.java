package tema1.punto4;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DLecturaFichData {

    public static void main(String[] args) throws IOException {
        File fichero = new File("FichData.dat");
        FileInputStream filein = new FileInputStream(fichero);
        DataInputStream dataIS = new DataInputStream(filein);

        String n;
        int e;

        try {
            while (true) {
                n = dataIS.readUTF(); //recupera el nombre del departamento
                e = dataIS.readInt(); //recupera el número de empleados del departamento
                System.out.println("Nombre departamento: " + n + ", Numero de empleados: " + e);
            }
        } catch (EOFException eo) {
        }

        dataIS.close();  //cerrar stream   
    }

}
