package pjm.microservice.dashboard.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Koneksi {

    private static final Logger log = LoggerFactory.getLogger(Koneksi.class);
    private Connection con = null;

    public Koneksi(String ds) throws SQLException, NamingException {
        this.KoneksiJboss(ds);
    }

    public Connection getConnection() {
        return con;
    }

    public void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {

            }
            con = null;
        }
    }

    private void KoneksiJboss(String CONTEXT) throws SQLException, NamingException {
        InitialContext ctx;
        DataSource ds;
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup(CONTEXT);
            con = ds.getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (NamingException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }


}
