/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema1.punto6;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;

//Esto significa que la clases "Libreria.java" es el elemento raiz

@XmlRootElement(name="Libreria")// Nombre de la etiqueta raiz 
// Orden de las etiquetas dentro de "Libreria", si no sale como quiere
// Se deberá poner el nombre de las propiedades: libros, nombre y lugar
@XmlType(propOrder = {"libros", "nombre", "lugar" }) 
public class Libreria {
  
    @XmlElementWrapper(name = "Libros") // Etiqueta que engloba los nodos Libro
    @XmlElement(name = "Libro") // Etiqueta para cada Libro individual <libro> ... </libro>
    private ArrayList<Libro> libros; // 
    private String nombre;
    private String lugar;

    // OJO el get no se puede llamar getLibros. JAXB produce este error
    // Porque el name de XMLElement es Libro por tanto lo llamaremos getLibro()
    // La clase tiene dos propiedades con el mismo nombre "libros"
    // this problem is related to the following location:
    // at public java.util.ArrayList tema1.punto6.Libreria.getLibros()
    public ArrayList<Libro> getLibro() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLugar() {
        return lugar;
    }
}
