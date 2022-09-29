/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.punto6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

//El programa java que recorre el documento para extraer los titulos
public class EStaxXMLListaLibros {

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        String tag = null;
        int eventType;
        // Creamos el flujo
        XMLInputFactory xmlif = XMLInputFactory.newInstance();
        XMLStreamReader xmlsr = xmlif.createXMLStreamReader(new FileReader("books.xml"));
        System.out.println("Lista de libros");

        // Iteramos con el cursor a lo largo del documento
        while (xmlsr.hasNext()) {
            eventType = xmlsr.next(); // Cogemos el evento causado de forma secuencial
            
            switch (eventType) {
                case XMLEvent.START_ELEMENT: // Principio de etiqueta
                    tag = xmlsr.getLocalName(); // Cogemos el nombre de la etiqueta
                    if (tag.equals("title")) {
                        System.out.println(xmlsr.getElementText());
                    }
                    break;
                case XMLEvent.END_DOCUMENT: // Fin de documento
                    System.out.println("Fin del documento");
                    break;
            }
        }
    }
}
