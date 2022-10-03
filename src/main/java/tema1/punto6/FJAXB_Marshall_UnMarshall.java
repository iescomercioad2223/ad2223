/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema1.punto6;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author ProfVespertino
 */
public class FJAXB_Marshall_UnMarshall {

    private static final String LIBRERIA_XML = "./LIBRERIA_JAXB.xml";

    public static void main(String[] args) throws JAXBException, IOException {
        // Lista de LIbros
        ArrayList<Libro> libroLista = new ArrayList<Libro>();
        // Creamos varios libros
        Libro libro1 = new Libro();
        libro1.setIsbn("978-0060554736");
        libro1.setNombre("The Game");
        libro1.setAutor("Neil Strauss");
        libro1.setEditorial("Harpercollins");
        libroLista.add(libro1);
        Libro libro2 = new Libro();
        libro2.setIsbn("978-3832180577");
        libro2.setNombre("Feuchtgebiete");
        libro2.setAutor("Charlotte Roche");
        libro2.setEditorial("Dumont Buchverlag");
        libroLista.add(libro2);
        // Se crea La libreria y se le asigna la lista de libros
        Libreria libreria = new Libreria();
        libreria.setNombre("LIbreria sin limite");
        libreria.setLugar("Barrio Obrero");
        libreria.setLibros(libroLista);
        // Creamos el contexto necesario que será necesario para crear los otros objetos
        JAXBContext context = JAXBContext.newInstance(Libreria.class);
        // Creamos los objetos necesario para hacer marshall
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        // Lo mostramos por pantalla
        m.marshal(libreria, System.out);
        // Creamos el archivo XML
        m.marshal(libreria, new File(LIBRERIA_XML));
       
        // Creamos los objetos necearios para unmarshall
        Unmarshaller um = context.createUnmarshaller();
        System.out.println("Listado de libros (unmarshall)");
        Libreria libreria2 = (Libreria) um.unmarshal(new FileReader(LIBRERIA_XML));
        ArrayList<Libro> lista = libreria2.getLibro();
        for (Libro libro : lista) {
            System.out.println("Libro: " + libro.getNombre() + " de " + libro.getAutor());
        }
    }

}
