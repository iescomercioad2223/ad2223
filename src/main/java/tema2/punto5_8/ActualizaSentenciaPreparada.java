/*
 *  Los métodos que permiten pasar parametros a las sentencias preparadas son:

    setBigDecimal(int parameterIndex, BigDecimal x)
    setBinaryStream(int parameterIndex, InputStream x)
    setDate(int parameterIndex, Date x)
    setDouble(int parameterIndex, double x)
    setInt(int parameterIndex, int x)
    setString(int parameterIndex, String x)
 */
package tema2.punto5_8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActualizaSentenciaPreparada {

    public static void main(String[] args) throws SQLException {
        String urljdbc = "jdbc:oracle:thin:@localhost:1521:XE";
        Connection conexion = DriverManager.getConnection(urljdbc, "scott", "tiger");
        PreparedStatement pstmt = conexion.prepareStatement("UPDATE EMP " + "SET SAL = ? WHERE empno = ?");

        pstmt.setInt(1, 1);
        pstmt.setInt(2, 7844);
        pstmt.executeUpdate();

        pstmt.close();
        conexion.close();
    }
}
