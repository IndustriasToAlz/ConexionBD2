
package conexionbd2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConexionBD {

    ConexionBD() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//CARGANDO EL DRIVER
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=prueba", "carlostoalz", "contigente3del9");
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM dbo.cliente");
            
            while (rs.next()) {                
                System.out.println(rs.getInt("COD_CLIENTE") + " " + rs.getString("NOM_CLIENTE") + " " + rs.getString("APE_CLEINTE") + " " + rs.getString("DIR_CLIENTE") + " " + rs.getString("TELEFONO_CLIENTE"));
            }
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public static void main(String[] args) {
        ConexionBD con = new ConexionBD();
    }
    
}
