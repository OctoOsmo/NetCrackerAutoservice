import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by al on 15.12.2015.
 */
public class DataBaseAppender {
    final Logger log = LogManager.getLogger(DataBaseAppender.class);

    private Connection conn;

    public DataBaseAppender() throws SQLException {
        Properties dbProps = new Properties();
        InputStream propFile;
        try {
            propFile = new FileInputStream("dbProperties.txt");
            dbProps.load(propFile);
            log.debug("trying to connect to database on url = " + dbProps.getProperty("url"));
            conn = DriverManager.getConnection(dbProps.getProperty("url"), dbProps);
            log.info("Connection established");
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
            throw new SQLException("Connection failure", e);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new SQLException("Connection failure", e);
        }
    }

    public void saveCar(Car car) throws SQLException {
        String strQuery = "insert into \"$tableName\" (name, owner) values(?,?)";
        String query = strQuery.replace("$tableName", car.getId().toString());
        try (PreparedStatement ps  = conn.prepareStatement(query)){
            ps.setString(1, car.getName());
            ps.setString(2, car.getOwner());
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new SQLException("Unexpected prepared statement error", e);
        }
    }
}
