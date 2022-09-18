package tema1.punto4;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FLecturaFichAleatorio {
public static void main(String[] args) throws IOException {     
   File fichero = new File("C:\\Users\\Antonio\\Documents\\NetBeansProjects\\Ficheros\\Prueba\\AleatorioAlumno.dat");
   RandomAccessFile file = new RandomAccessFile(fichero, "r"); // Declaración del fichero aleatorio aleatorio para lectrua
   int  id, edad, pos;    
   Double nota;	
   char apellido[] = new char[10], aux; 
   pos=0;  // Se posiciona al principio del fichero
   for(;;){     // El for se utiliza para recorrer el fichero
	file.seek(pos); // Se posiciona en posición pos
	id=file.readInt();   // Se obtiene el identificador del alumno	  	  
    for (int i = 0; i < apellido.length; i++) {
         aux = file.readChar();//Se recorre el apellido caracter a caracter 
         apellido[i] = aux;    //Se guarda cada caracter en un array
    }     
    String apellidoS= new String(apellido); //Se transforma el array a cadena
	edad=file.readInt();    //Obtiene la edad
  	nota=file.readDouble();  //Obtiene el salario 
	System.out.println("ID: " + id + ", Apellido: "
        +  apellidoS + ", Edad: "+edad + ", "
        + "Nota media del curso: " + nota);        
	pos= pos + 36; // Al sumar 36 nos posicionamos en el siguiente alummno, cada alumo ocupa 36 Bytes 
	               // Cada empleado ocupa 36 bytes (4+20+4+8), es decir 4 para el id, 20 para el nombre,
                       // 4 para la edad y 8 para la nota. 
	               // Si se recorren todos los bytes sale del for	 	  
    if (file.getFilePointer()==file.length())break; } // Salida del bucle 
   file.close();  // Cierre del fichero 
   }
    
}
