/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.punto3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BLeerFichEOF {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("origen.txt"));
        int codigo = br.read();//lee el primer caracter 
        char caracter;
        //mientras el código no sea -1 (EOF) continuo leyendo
        while (codigo != -1) {
            caracter = (char) codigo; //casting
            System.out.print(caracter);
            codigo = br.read(); //lee un caracter 
        }
    }
}
