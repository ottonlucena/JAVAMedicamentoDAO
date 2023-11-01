package service;

import dao.iDao;
import model.Medicamento;

import java.util.List;

public class MedicamentoService {
    private iDao<Medicamento> medicamentoiDao;

    public MedicamentoService(iDao<Medicamento> medicamentoiDao) {
        this.medicamentoiDao = medicamentoiDao;
    }

    public Medicamento guardarMedicamento(Medicamento medicamento){
        return medicamentoiDao.guardar(medicamento);
    }

    public List<Medicamento> listarMedicamentos(){
        return medicamentoiDao.listar();
    }
}
