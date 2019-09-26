package DAo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbDao {

    private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public void Conectar() throws Exception {
        String msg = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/opensoucer?user=root&password=root");
        } catch (Exception e) {
            msg = "No pude Conectarme";
        }
    }

    public void Cerrar() throws Exception {
        try {
            if (cn == null) {
                if (cn.isClosed() == false) {
                    cn.close();
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
