/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema1.punto6;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

//Esto significa que la clases "Libreria.java" es el elemento raiz

@XmlRootElement
public class Libreria {

    //Wrapper
    @XmlElementWrapper(name = "ListaLibro")
    @XmlElement(name = "Libro")
    private ArrayList<Libro> ListaLibro;
    private String nombre;
    private String lugar;

    public ArrayList<Libro> getListaLibro() {
        return ListaLibro;
    }

    public void setListaLibro(ArrayList<Libro> ListaLibro) {
        this.ListaLibro = ListaLibro;
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
