/*
 * Para probar este ejercicio sobre la misma base de datos de AEROLINEAS 
 * introducimos el siguiente procedimiento almacenado en ORACLE
DELIMITER @@
CREATE OR REPLACE PROCEDURE AD.modificar_plaza (pnum NUMBER, pcod_vuelo VARCHAR2, ptp VARCHAR2, pfum VARCHAR2) AS
BEGIN
    UPDATE PASAJEROS 
    SET TIPO_PLAZA = ptp, FUMADOR=pfum 
    WHERE PASAJEROS.NUM = pnum AND PASAJEROS.COD_VUELO=pcod_vuelo;
END; @@
DELIMITER ; 

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
            cn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.83:1521:XE", "SYSTEM", "docker");

            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{ CALL AD.modificar_plaza (123, 'IB-SP-4567', 'TU', 'SI') }");
            // Ejecuta el procedimiento almacenado
            cst.execute();
            System.out.println("Modificada la plaza");
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
