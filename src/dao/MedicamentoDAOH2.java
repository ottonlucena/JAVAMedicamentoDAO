package dao;

import model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MedicamentoDAOH2 implements iDao<Medicamento>{
    private static final Logger logger=Logger.getLogger(MedicamentoDAOH2.class);

    private static final String SQL_INSERT="INSERT INTO MEDICAMENTOS VALUES(?,?,?,?,?,?)";
    @Override
    public Medicamento guardar(Medicamento medicamento) {
        logger.info("Iniciando operaciones de guardar.");
        Connection connection=null;
        try {
            //Debemos conectarnos a la BBDD
            connection=BD.getConnection();
            PreparedStatement ps=connection.prepareStatement(SQL_INSERT);
            //Insertamos los datos a los parametros dinamicos
            ps.setInt(1,medicamento.getId());
            ps.setInt(2,medicamento.getCodigo());
            ps.setString(3,medicamento.getNombre());
            ps.setString(4,medicamento.getLaboratorio());
            ps.setDouble(5,medicamento.getPrecio());
            ps.setInt(6,medicamento.getCantidad());
            //Ejecutamos lo que insertamos.
            ps.execute();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return medicamento;
    }
}
