/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.punto6;

 
import javax.xml.stream.*;
import java.io.*;

/**
 * Ejemplo de lectura de datos con StAX a través del método: cursor API
 * Utilizando cursores
 */


public class DStaxXMLStreamReaderApp {

    /**
     * Imprime por la salida estandar el alumno más mauor de entre todos los alumnos
     */
    public static void main(String[] args) {
        FileReader reader = null;
        XMLStreamReader parser = null;
        int edadSeleccionada = Integer.MIN_VALUE, edad = 0, eventCode;
        String apellidoSeleccionado = null, apellido = null, tag;
     
        try {
            // Creación del analizador XML "parser"
            reader = new FileReader("Alumnos.xml");
            parser = XMLInputFactory.newInstance().createXMLStreamReader(reader);
            
            // Parser es una colección
            while (parser.hasNext()) {
                eventCode = parser.next();
                if (eventCode == XMLStreamConstants.START_ELEMENT) { // Principio de una etiqueta
                    tag = parser.getLocalName();
                    if ("apellido".equals(tag)) {
                        apellido = parser.getElementText();
                    } else if ("edad".equals(tag)) {
                        edad = Integer.valueOf(parser.getElementText());
                        if (edad > edadSeleccionada) {
                            edadSeleccionada = edad;
                            apellidoSeleccionado = apellido;
                        }
                    }
                }
            }

            System.out.println("El alumno más mayor : " + apellidoSeleccionado);
        } catch (Exception ex) {
            // Para este tutorial no hacemos nada más que imprimir la excepción
            System.out.println(ex);
        } finally {
            try {
                reader.close();
            } catch (Exception ex) {
            }
            try {
                parser.close();
            } catch (Exception ex) {
            }
        }
    }
}
