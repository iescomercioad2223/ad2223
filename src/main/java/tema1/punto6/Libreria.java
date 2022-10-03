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
@XmlType(propOrder = {"libros", "nombre", "lugar" }) // Orden de las etiquetas dentro de "Libreria"
public class Libreria {

    //Wrapper
    @XmlElementWrapper(name = "Libros")
    @XmlElement(name = "Libro")
    private ArrayList<Libro> libros;
    private String nombre;
    private String lugar;

    public ArrayList<Libro> getLibro() {
        return libros;
    }

    public void setLibro(ArrayList<Libro> listaLibro) {
        this.libros = listaLibro;
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
