/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema6.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class DAOFactoryMySQL extends DAOFactory {

    private Connection conexion = null;
    private String DRIVER = "com.mysql.jdbc.Driver";
    private String IP = "10.0.0.1";
    private int PORT = 1520;
    private String BD = "nombreBD";
    private String USUARIO = "usuario";
    private String CLAVE = "password";

    public DAOFactoryMySQL() {
    }

    @Override
    public Connection getConexion() {
        String URL;
        
        try {
            if (conexion == null) {
                URL = "jdbc:mysql://" + IP + "/" + BD + ":" + PORT;
                Class.forName(DRIVER);
                conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOFactoryMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOFactoryMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.conexion;
    }

    @Override
    public boolean closeConexion() {
        try {
            conexion.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOFactoryMySQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    

}
