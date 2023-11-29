package services;

import dao.PartituraDao;
import model.Partitura;

import java.util.List;

public class PartituraServiceImp implements PartituraService{
    private PartituraDao partituraDao;

    public PartituraServiceImp(PartituraDao partituraDao) {
        this.partituraDao = partituraDao;
    }

    @Override
    public void crearPartitura(Partitura partitura) {
        partituraDao.crearPartitura(partitura);
    }

    @Override
    public List<Partitura> obtenerPartituras() {
        return partituraDao.obtenerPartituras();
    }

    @Override
    public void prestarPartitura(int partituraId, int usuarioId) {
        partituraDao.prestarPartitura(partituraId,usuarioId);
    }

    @Override
    public void eliminarPartitura(int partituraId) {
        partituraDao.eliminarPartitura(partituraId);
    }
}
