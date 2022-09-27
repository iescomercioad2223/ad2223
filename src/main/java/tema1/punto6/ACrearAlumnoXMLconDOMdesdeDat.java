package tema1.punto6;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

public class ACrearAlumnoXMLconDOMdesdeDat {

    public static void main(String argv[]) throws IOException {
        File fichero = new File("AleatorioAlumno.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");
        int id, edad, pos = 0; // Nos posiciona al principio del fichero aleatorio        
        Double nota;
        char apellido[] = new char[10], aux;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = (Document) implementation.createDocument(null, "Alumnos", null);
            document.setXmlVersion("1.0"); // Versión de XML con la que vamos a trabajar
            for (;;) {
                file.seek(pos); // Fijamos la primera posición 
                id = file.readInt(); // Se obtiene el identificador del alumno	  	  
                for (int i = 0; i < apellido.length; i++) {
                    aux = file.readChar(); // Se recorren los caracteres del apellido 
                    apellido[i] = aux;
                }  // Los caracteres del apellido se guardan en un vector
                String apellidoS = new String(apellido); // El vector se convierte en cadena
                edad = file.readInt();  // Se obetiene la edad
                nota = file.readDouble();  // Seobtiene la nota media del alumno	  
                if (id > 0) { // Id validados desde la posición primera
                    Element raiz = document.createElement("alumno"); //nodo empleado
                    document.getDocumentElement().appendChild(raiz);
                    CrearElemento("id", Integer.toString(id), raiz, document); //Se incorpora el ID
                    CrearElemento("apellido", apellidoS.trim(), raiz, document); // Se incorpora el Apellido 
                    CrearElemento("edad", Integer.toString(edad), raiz, document); // Se incorpora la edad
                    CrearElemento("nota", Double.toString(nota), raiz, document); // Se incorpora la nota 
                }
                pos = pos + 36; // Nos posicionamos en la siguiete posicion del siguiente alumno tal y como se explico	  	  
                if (file.getFilePointer() == file.length()) {
                    break;
                }
            } // Se va recorriendo el fichero	
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("Alumnos.xml"));  // Nombre del fichero XML      
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            Result console = new StreamResult(System.out);
            transformer.transform(source, console);
        } catch (ParserConfigurationException | DOMException | IOException | TransformerException e) {
            System.err.println("Error: " + e);
        }
        file.close();  // Cierre del fichero aleatorio .dat 	
    } // Fin del programa principal (main)
    // Inserción de los datos del alumno que se le invoca desde el programa principal (main=

    static void CrearElemento(String datoEmple, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoEmple); // Creamos el nodo hijo
        Text text = document.createTextNode(valor); // Se le da el valor
        raiz.appendChild(elem); // Pegamos el elemento hijo a la raiz
        elem.appendChild(text); // Pegamos el valor del nodo	 	
    }
}
