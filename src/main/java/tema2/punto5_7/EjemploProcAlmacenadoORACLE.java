/*
 * Para probar este ejercicio será necesario tener creada la tabla employeee y 
 * el siguiente procedimiento almacenado
 CREATE OR REPLACE PROCEDURE remove_emp (employee_id NUMBER) AS
   tot_emps NUMBER;
   BEGIN
      DELETE FROM employees
      WHERE employees.employee_id = remove_emp.employee_id;
            tot_emps := tot_emps - 1;
   END;
 */
package tema2.punto5_7;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EjemploProcAlmacenadoORACLE {

    public static void main(String[] args) {

        Connection cn = null;

        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            // Conecta con la base de datos XE con el usuario scott y la contraseña tiger
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");

            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call remove_emp (104)}");
            // Ejecuta el procedimiento almacenado
            cst.execute();
            System.out.println("borrado");
            cst.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
}
