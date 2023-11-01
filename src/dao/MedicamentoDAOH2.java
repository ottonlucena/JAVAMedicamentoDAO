package dao;

import model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MedicamentoDAOH2 implements iDao<Medicamento>{
    private static final Logger logger=Logger.getLogger(MedicamentoDAOH2.class);

    private static final String SQL_INSERT="INSERT INTO MEDICAMENTOS VALUES(?,?,?,?,?,?)";
    private static final String SQL="SELECT * FROM MEDICAMENTOS";

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
            //Para mostrar con resultSet
//            Statement st=connection.createStatement();
//            ResultSet rs=st.executeQuery(SQL);
//            while (rs.next()){
//                logger.info(rs.getInt(1)+ rs.getInt(2) +  rs.getString(3));
//            }

        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return medicamento;
    }

    @Override
    public List<Medicamento> listar() {
        Connection connection=null;
        List<Medicamento> medicamentoList = new ArrayList<>();
        try {
            connection=BD.getConnection();
            PreparedStatement ps=connection.prepareStatement(SQL);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Medicamento medicamento=crearMedicamento(rs);
                medicamentoList.add(medicamento);
            }
            logger.info("Medicamentos: " + medicamentoList);

        }catch (Exception e){
            logger.error("listar" + e.getMessage());
        }
        return medicamentoList;
    }

    private Medicamento crearMedicamento(ResultSet rs) throws Exception{
        return new Medicamento(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6));
    }
}
