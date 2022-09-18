/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.punto5;

import java.nio.file.Path;
import java.nio.file.Paths;

public class APathEjemplo {

    public static void main(String args[]) {
        Path path = Paths.get("C:/Users/alumno/PathEjemplo");
        System.out.println(" path = " + path);
        System.out.println(" is absoute ? = " + path.isAbsolute());
        System.out.println(" file short name = " + path.getFileName());
        System.out.println(" parent = " + path.getParent());
        System.out.println(" uri = " + path.toUri());
        path = Paths.get("/home/PathEjemplo");
        System.out.println(" path = " + path);
        System.out.println(" is absoute ? = " + path.isAbsolute());
        System.out.println(" file short name = " + path.getFileName());
        System.out.println(" parent = " + path.getParent());
        System.out.println(" uri = " + path.toUri());
    }
}
