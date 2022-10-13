/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema6.dao;


import java.sql.Connection;
import tema6.factory.DAOFactory;

/**
 *
 * @author David
 */
public class DepartamentoDAO implements IDAO<Departamento> {
    private Connection conexion;

    public DepartamentoDAO(String persistenceUnitName) {
        DAOFactory factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        conexion = factoria.getConexion();
    }

    @Override
    public void verTodos() {       

    }

    @Override
    public boolean insertar(Departamento o) {
       return false;
    }

    @Override
    public boolean borrar(int id) {
       return false;
    }

    @Override
    public boolean modificar(int id, Departamento nuevo) {
      return false;
    }

    @Override
    public Departamento consultar(int id) {
       return null;
    }
}
