
package tema2.punto5_5;


import java.sql.*;
/*
Antes de realizar el ejercicio es necesario:
1) Tener instalado el oracle express 11g
2) Tener creado el usuario AD/AD
CREATE USER AD identified by AD
   default tablespace system
   quota 100M on system;

 GRANT ALL PRIVILEGES TO AD;
3) Lanzar el scrip de BD. AEROLINEAS_BD_SCRIPT.sql
4) Añadir en el proyecto la dependencia 
        <dependency>
            <groupId>com.oracle.database.jdbc</groupId>
            <artifactId>ojdbc8</artifactId>
            <version>21.7.0.0</version>
        </dependency>

Se trata de hacer una aplicación en Java que acceda a una base de datos Oracle de una aerolínea. 
Para ello será necesaria la conexión a las tablas VUELOS y PASAJEROS de una BD Oracle. 
Se adjunta el SCRIPT de la BD para Oracle (AEROLINEA_BD_SCRIPT.sql).

Consta de los siguientes apartados:

1) Mostrar y pedir información de la base de datos en general.
2) Mostrar la información de la tabla pasajeros.
3) Ver la información de los pasajeros de un vuelo, pasando el código de vuelo como parámetro.
4) Insertar un vuelo cuyos valores se pasan como parámetros.
5) Borrar el vuelo que se metió anteriormente en el que se pasa por parámetro su número de vuelo.
6) Modificar los vuelos de fumadores a no fumadores.

Para ejecutar el proyecto lo metéis en la siguiente ruta C:\Users\Antonio\Documents\NetBeansProjects
Para pasar los parámetros se hace lo siguiente: Nos situamos en el proyecto/clic derecho/propiedades
*/
public class AAerolinea {

    public static int i = 1;

    public static void main(String[] args) {
      try {
            Class.forName("oracle.jdbc.OracleDriver"); // Para comprobar la clase
            Connection conexion = null;
            // Conectamos con la base de datos
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@192.168.66.129:1521:XE", "AEROLINEA", "docker");
            // Selecciono toda la información de la base de datos
            Statement sentencia = conexion.createStatement();
            String sqlTodo = "SELECT * FROM vuelos, pasajeros";
            ResultSet resultadoTodo = sentencia.executeQuery(sqlTodo);

            System.out.println("1) Mostrar y pedir información de la base de datos");
            // Muestra las 3 primeras columnas de 2 filas de la tabla vuelos       
            System.out.println("Mostrar y pedir información de la base de datos en general.");
            while (resultadoTodo.next() && i < 3) {
                String COD_VUELO = resultadoTodo.getString(1);// 1
                String HORA = resultadoTodo.getString(2); // 2
                String DESTINO = resultadoTodo.getString(3); // 3
                System.out.printf("COD_VUELO: %s, HORA: %s, DESTINO: %s .\n", COD_VUELO, HORA, DESTINO);
                i++;
            }

            System.out.println("2) Mostrar la información de la tabla pasajeros");
            i = 1; // Reset i
            String sqlPasajeros = "SELECT * FROM pasajeros";
            ResultSet resultadoPasajeros = sentencia.executeQuery(sqlPasajeros);
            System.out.println("Mostrar la información de la tabla pasajeros.");
            while (resultadoPasajeros.next()) {
                String NUM = resultadoPasajeros.getString(1);// 1
                String COD_VUELO = resultadoPasajeros.getString(2); // 2
                String TIPO_PLAZA = resultadoPasajeros.getString(3); // 3
                String FUMADOR = resultadoPasajeros.getString(4); // 3
                System.out.printf("NUM: %s, COD_VUELO: %s, TIPO_PLAZA: %s, FUMADOR: %s .\n ", NUM, COD_VUELO, TIPO_PLAZA, FUMADOR);
                i++;
            }

            System.out.println("3) Ver la información de los pasajeros de un vuelo, pasando el código de vuelo como parámetro.");
            PreparedStatement queryCOD_VUELO = conexion.prepareStatement("SELECT * FROM pasajeros WHERE COD_VUELO = ?");
            queryCOD_VUELO.setString(1, "FR-DC-4667"); // Query FR-DC-4667
            ResultSet resultadoQueryCOD_VUELO = queryCOD_VUELO.executeQuery();
            System.out.println("Ver la información de los pasajeros de un vuelo, pasando el código de vuelo como parámetro.");
            resultadoQueryCOD_VUELO.next();
            System.out.printf("NUM: %s, COD_VUELO: %s, TIPO_PLAZA: %s, FUMADOR: %s .\n ", resultadoQueryCOD_VUELO.getString(1), resultadoQueryCOD_VUELO.getString(2), resultadoQueryCOD_VUELO.getString(3), resultadoQueryCOD_VUELO.getString(4));

            System.out.println("4) Insertar un vuelo cuyos valores se pasan como parámetros ");
            System.out.println("Insertar un vuelo cuyos valores se pasan como parámetros.");
            PreparedStatement insertVUELO = conexion.prepareStatement("INSERT INTO vuelos VALUES (?,?,?,?,?,?,?,?)");
            insertVUELO.setString(1, "FR-PR-5000"); // COD_VUELO
            insertVUELO.setString(2, "21/05/99 15:30"); // HORA
            insertVUELO.setString(3, "Madrid"); // DESTINO
            insertVUELO.setString(4, "Paris"); // PROCEDENCIA
            insertVUELO.setInt(5, 30); // PLAZAS FUMADOR
            insertVUELO.setInt(6, 120); // PLAZAS NO FUMADOR
            insertVUELO.setInt(7, 90); // PLAZAS TURISTA
            insertVUELO.setInt(8, 60); // PLAZAS PRIMERA
            insertVUELO.executeUpdate();

            System.out.println("5) Borrar el vuelo que se metió anteriormente en el que se pasa por parámetro su número de vuelo");
            System.out.println("Borrar el vuelo que se metió anteriormente en el que se pasa por parámetro su número de vuelo.");
            PreparedStatement borrarVUELO = conexion.prepareStatement("DELETE FROM vuelos WHERE COD_VUELO = ?");
            borrarVUELO.setString(1, "FR-PR-5000"); // COD_VUELO
            borrarVUELO.executeUpdate();
//
            System.out.println("6) Modificar los vuelos de fumadores a no fumadores ");
            System.out.println("Modificar los vuelos de fumadores a no fumadores.");
            PreparedStatement cambiarFumadores = conexion.prepareStatement("UPDATE vuelos SET vuelos.PLAZAS_FUMADOR = vuelos.PLAZAS_NO_FUMADOR");
            cambiarFumadores.executeUpdate();

        } catch (SQLException se) {
            System.out.println("SQL Excepcion " + se);
        } catch (ClassNotFoundException exc) {
            System.out.println("No clase " + exc);
        }

    }

}
