/*
 * Para probar este ejercicio será necesario incluir en la BD de MYSQL la siguiente tabla
    CREATE TABLE `clientes` (
      `Cod_Cliente` int(3) NOT NULL DEFAULT '0',
      `Nombre` tinytext,
      `Telefono` tinytext,
      PRIMARY KEY (`Cod_Cliente`)
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1$$

 * Además deberemos incluir el siguiente procedimiento
  CREATE DEFINER=`root`@`localhost` PROCEDURE `insertaCliente`(IN Cod_Cliente INTEGER, IN Nombre TinyText,IN Telefono TinyText )
    BEGIN
    INSERT INTO clientes
	VALUES (Cod_Cliente,
		Nombre,
		Telefono);

    END
*/
package tema2.punto5_7;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InserConProcAlmaMYSQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Cargar el driver de mysql
            Class.forName("com.mysql.jdbc.Driver");

            // Cadena de conexión para conectar con MySQL en localhost,
            //seleccionar la base de datos llamada ‘test’
            // con usuario y contraseña del servidor de MySQL: root y admin
            String connectionUrl = "jdbc:mysql://localhost/test?"
                    + "user=root&password=admin";
            // Obtener la conexión
            Connection con = DriverManager.getConnection(connectionUrl);

            // El procedimiento almacenado tendrá tres parámetros
            CallableStatement prcProcedimientoAlmacenado
                    = con.prepareCall("{ call insertaCliente(?, ?,?) }");

            // cargar parametros en el procedimiento almacenado
            prcProcedimientoAlmacenado.setInt("Cod_Cliente", 765);
            prcProcedimientoAlmacenado.setString("Nombre", "Antonio Pérez");
            prcProcedimientoAlmacenado.setString("Telefono", "950121314");

            // ejecutar el procedimiento
            prcProcedimientoAlmacenado.execute();

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Exceción: " + cE.toString());
        }

    }

}
