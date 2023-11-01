package dao;

import org.apache.log4j.Logger;
import service.MedicamentoService;

import java.sql.*;

public class BD {
    private static final Logger logger=Logger.getLogger(BD.class);
    private static final String SQL_DROP_TABLE="DROP TABLE IF EXISTS MEDICAMENTOS; " +
            "CREATE TABLE MEDICAMENTOS (ID INT PRIMARY KEY, CODIGO INT NOT NULL, NOMBRE VARCHAR(100) NOT NULL, " +
            "LABORATORIO VARCHAR(100) NOT NULL, PRECIO NUMERIC(10,2) NOT NULL, CANTIDAD INT NOT NULL)";

    public static void main(String[] args) {

    }
    public static void crearTabla(){
        Connection connection=null;
        try {
            logger.info("Creando base de datos.");
            connection=getConnection();
            Statement statement=connection.createStatement();
            statement.execute(SQL_DROP_TABLE);
        }catch (Exception e){
            logger.error(e.getMessage());
        }finally {
            try {
                connection.close();
            }catch (SQLException ex){
                logger.error(ex.getMessage());
            }
        }
    }
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/medicamentosTest", "sa", "sa");
    }
}
