package tema1.punto4;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EEscribirFichAleatorio {
 public static void main(String[] args) throws IOException {      
   File fichero = new File("C:\\Users\\Antonio\\Documents\\NetBeansProjects\\Ficheros\\Prueba\\AleatorioAlumno.dat"); //Declaración del fichero aleatorio
   RandomAccessFile file = new RandomAccessFile(fichero, "rw");
   //Declaración de los arrays que contienen los datos
   String apellido[] = {"FERNANDEZ","LOPEZ","GOMEZ","CHEN",
                        "SERRANO","CASILLAS", "ALONSO"}; //Apellidos del alumno 
   int edad[] = {17, 20, 18, 17, 19, 21, 20};            //Edad de los alumnoa
   Double nota[]={7.5, 4.2, 6.5, 8.0, 3.2, 9.2, 9.9};       //Nota media de cada alumnos   
   StringBuffer buffer = null; //Buffer para almacenar apellido
   int n=apellido.length;      //Número de elementos que contiene el array
   
   for (int i=0;i<n; i++){     //Recorrido los arrays          	  
	 file.writeInt(i+1);   //Uso i+1 para identificar empleado
     buffer = new StringBuffer( apellido[i] );      
     buffer.setLength(10);     //10 caracteres que contiene el apellido
     file.writeChars(buffer.toString()); //Inserción de la apellido
	 file.writeInt(edad[i]);         //Inserción de la edad
	 file.writeDouble(nota[i]);      //Inserción de la nota
   }     
   file.close();   //Cierre del fichero 
   }
   
}
