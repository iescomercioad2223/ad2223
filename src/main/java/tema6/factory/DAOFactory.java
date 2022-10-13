/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema6.factory;

import java.sql.Connection;

/**
 *
 * @author David
 */
public abstract class DAOFactory {
    // Sistemas de datos soportados
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int SQLITE = 3;

    
    public static DAOFactory getDAOFactory(int bd) {
        switch (bd) {
            case MYSQL:
                return new DAOFactoryMySQL();
            case ORACLE:
                return new DAOFactoryOracle();
            case SQLITE:
                return new DAOFactorySQLite();
        }
        return null;
    }
    
    public abstract Connection getConexion();
    public abstract boolean closeConexion();


}