package tema1.punto6;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;


public class CLecturaAlumnoXMLconSAX {

    public static void main(String[] args) throws SAXException, IOException {

        try {
            // Versión deprecada
            //XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
            // Versión nueva
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            parserFactory.setNamespaceAware(true);
            SAXParser parser = parserFactory.newSAXParser();
            XMLReader procesadorXML = parser.getXMLReader();
            
            GestionContenido gestor = new GestionContenido();
            procesadorXML.setContentHandler(gestor);
            InputSource fileXML = new InputSource("Alumnos.xml");
            procesadorXML.parse(fileXML);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CLecturaAlumnoXMLconSAX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static class GestionContenido extends DefaultHandler {

        public GestionContenido() {
            super();
        }
             
        
        //Significa sobre escribir, esto ayuda entre otras cosas 
        //a reducir el código, cuando se crea una clase que hereda
        //de otra clase, hereda todos sus métodos, propiedades y atributos 

        //Cuando se hace override significa que sobrescribes 
        //un método de la clase padre, ya sea para mejorar 
        //el método o para que se acople a su clase hija. 
        @Override
        public void startDocument() {
            System.out.println("Comienzo del documento XML");
        }

        @Override
        public void endDocument() {
            System.out.println("Fin del documento XML");
        }

        @Override
        public void startElement(String uri, String nombre, String nombreC, Attributes atrbs) {
            System.out.println("\t" + nombre);
        }

        @Override
        public void characters(char[] ch, int inicio, int longitud) {
            String car = new String(ch, inicio, longitud);
            car = car.replaceAll("[\t\n]", ""); //quitar saltos de linea
            System.out.println("\t\t" + car);
        }
    }
}
