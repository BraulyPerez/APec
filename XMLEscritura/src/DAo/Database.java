package DAo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    private static String db = "xmlgenerada";
    private static String user = "root";
    private static String pass = "root";
    private static String hots = "localhost:3306";
    private static String server = "jdbc:mysql://" + hots + "/" + db;
    
    public static  Connection getConnection() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection(server,user,pass);
        } catch (Exception e) {
            System.out.println(String.valueOf(e));
        }
        return cn;
    }   
    public static ResultSet getTabla(String Consulta) {
        Connection cn= getConnection();
        Statement st;
        ResultSet datos= null;
        try {
            st= cn.createStatement();
            datos= st.executeQuery(Consulta);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return datos;
    }
}
