package tema1.punto4;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CEscribirFichData {

    public static void main(String[] args) throws IOException {

        File fichero = new File("FichData.dat");
        FileOutputStream fileout = new FileOutputStream(fichero);
        DataOutputStream dataOS = new DataOutputStream(fileout);

        String departamento[] = {"Contabilidad", "Informática", "Dirección", "Análisis", "Finanzas", "Hardware"};

        int numempleados[] = {3, 10, 2, 5, 4, 8};

        for (int i = 0; i < numempleados.length; i++) {
            dataOS.writeUTF(departamento[i]); //inserta nombre
            dataOS.writeInt(numempleados[i]);  //inserta edad
        }
        dataOS.close();    //cierra el fichero stream 
    }

}
