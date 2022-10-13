/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema6.dao;



/**
 *
 * @author David
 */
public interface IDAO<T> {
    public void verTodos();
    public boolean insertar (T o);
    public boolean borrar (int id);
    public boolean modificar (int id, T nuevo);
    public T consultar (int id);
    
}
