import dao.BD;
import dao.MedicamentoDAOH2;
import model.Medicamento;
import service.MedicamentoService;

public class Cliente {
    public static void main(String[] args) {
        //Creamos la tabla
        BD.crearTabla();
        //que vamos a guarda? Medicamentos
        Medicamento medicamento=new Medicamento(1,1234,"paracetamol","bayer",200.0,10);
        Medicamento medicamento1=new Medicamento(2,54321,"ketoprofeno","lor",150.0,15);
        //Quien se encarga de guardar?
        MedicamentoService servicio=new MedicamentoService(new MedicamentoDAOH2());
        servicio.guardarMedicamento(medicamento);
        servicio.guardarMedicamento(medicamento1);

    }
}
