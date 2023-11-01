package test;

import dao.MedicamentoDAOH2;
import model.Medicamento;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.MedicamentoService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MedicamentoTest {
    private MedicamentoService medicamentoService;
    @BeforeAll
    static void doBefore()throws Exception{
        Connection connection=null;
        try {
            Class.forName("org.h2.Driver");
            connection= DriverManager.getConnection("jdbc:h2:~/medicamentosTest FROM 'create.sql'", "sa", "sa");
            System.out.println("Conectado correctamente.");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
         try {
             connection.close();
         }catch (Exception ex){
             ex.printStackTrace();
         }
        }
    }

    @Test
    void probandoAgregar(){
        medicamentoService=new MedicamentoService(new MedicamentoDAOH2());
        Medicamento medicamento=new Medicamento(6,1234,"paracetamol","bayer",200.0,10);
        Medicamento medicamentoPrueba=medicamentoService.guardarMedicamento(medicamento);
        List<Medicamento> listaMedicamentos=medicamentoService.listarMedicamentos();
        System.out.println(listaMedicamentos);
        assertNotNull(medicamentoPrueba,"El medicamento guardado no debeira ser nulo");
        assertEquals(medicamento.getId(), medicamentoPrueba.getId(), "IDs no coinciden");
        assertEquals(medicamento.getCodigo(), medicamentoPrueba.getCodigo(), "Códigos no coinciden");
        //assertTrue(listaMedicamentos.contains(medicamento), "El medicamento guardado no está en la lista de medicamentos");

    }

}
