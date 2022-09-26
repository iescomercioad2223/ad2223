
package tema1.punto6;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class BLecturaAlumnoXMLconDOM {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("Alumnos.xml"));
            document.getDocumentElement().normalize();

            System.out.println("Elemento raiz: "+ document.getDocumentElement().getNodeName()); 
            //crea una lista con todos los nodos empleado
            NodeList empleados = document.getElementsByTagName("alumno");
            //recorrer la lista
            for(int i=0;i<empleados.getLength();i++)
            {
                Node emple = empleados.item(i); //obtener un nodo
                if(emple.getNodeType()==Node.ELEMENT_NODE) //tipo de nodo
                {
                    Element elemento = (Element)emple; //obtener los elementos del nodo
                    System.out.println("\nID: "+ getNodo("id",elemento));
                    System.out.println("Apellido: "+ getNodo("apellido",elemento));
                    System.out.println("Edad: "+ getNodo("edad",elemento));
                    System.out.println("Nota: "+ getNodo("nota",elemento));
                    System.out.println();
                }
            }
        } catch (Exception e) {e.printStackTrace();}
    }

    //Obtener la informacion de un nodo
    private static String getNodo(String etiqueta, Element elemen) {
        NodeList nodo=elemen.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valornodo = (Node) nodo.item(0);
        return valornodo.getNodeValue(); //devuelve el valor del nodo
    }
}
       
