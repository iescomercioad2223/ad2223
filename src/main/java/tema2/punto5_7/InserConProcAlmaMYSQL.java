/*
 * Para probar este ejercicio será necesario incluir en la BD de MYSQL la siguiente tabla
    CREATE TABLE `clientes` (
      `Cod_Cliente` int(3) NOT NULL DEFAULT '0',
      `Nombre` tinytext,
      `Telefono` tinytext,
      PRIMARY KEY (`Cod_Cliente`)
    );

 * Además deberemos incluir el siguiente procedimiento
DELIMITER $$
CREATE DEFINER=`usuario`@`%` PROCEDURE `insertaCliente`(cod_cliente tinyint, nombre varchar(50), telefono integer)
begin
insert into clientes values (cod_cliente, nombre, telefono);
commit;
end$$
DELIMITER ;
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
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Cadena de conexión para conectar con MySQL en localhost,
            //seleccionar la base de datos llamada ‘test’
            // con usuario y contraseña del servidor de MySQL: root y admin
            String connectionUrl = "jdbc:mysql://192.168.1.83:3306/prueba?user=usuario&password=adad";
            // Obtener la conexión
            Connection con = DriverManager.getConnection(connectionUrl);

            // El procedimiento almacenado tendrá tres parámetros
            CallableStatement prcProcedimientoAlmacenado
                    = con.prepareCall("{ call insertaCliente (?,?,?) }");
               
            // cargar parametros en el procedimiento almacenado
            prcProcedimientoAlmacenado.setInt("cod_cliente", 10);
            prcProcedimientoAlmacenado.setString("nombre", "Juan Jose");
            prcProcedimientoAlmacenado.setInt("telefono", 625345643);
         
            // ejecutar el procedimiento
            prcProcedimientoAlmacenado.execute();

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Exceción: " + cE.toString());
        }

    }

}
