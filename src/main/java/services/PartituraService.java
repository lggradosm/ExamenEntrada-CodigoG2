package services;

import model.Partitura;

import java.util.List;

public interface PartituraService {
    public void crearPartitura(Partitura partitura);
    public List<Partitura> obtenerPartituras();
    public void prestarPartitura (int partituraId,int usuarioId);
    public void eliminarPartitura(int partituraId);

}
