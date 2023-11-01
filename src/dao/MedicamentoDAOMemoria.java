package dao;

import model.Medicamento;
import org.apache.log4j.Logger;

import java.util.List;

public class MedicamentoDAOMemoria implements iDao<Medicamento>{
   private static final Logger logger=Logger.getLogger(MedicamentoDAOMemoria.class);
   private List<Medicamento> medicamentoList;

    public MedicamentoDAOMemoria(List<Medicamento> medicamentoList) {
        this.medicamentoList = medicamentoList;
    }

    @Override
    public Medicamento guardar(Medicamento medicamento) {
        int id=medicamentoList.size()+1;
        medicamentoList.add(medicamento);
        Medicamento medicamentoGuardado=new Medicamento(id,medicamento.getCodigo(),medicamento.getNombre(),medicamento.getLaboratorio(),medicamento.getPrecio(),medicamento.getCantidad());

        logger.info("Se guardo medicamento: " + medicamentoGuardado);
        return medicamentoGuardado;
    }

    @Override
    public List listar() {
        return null;
    }
}
