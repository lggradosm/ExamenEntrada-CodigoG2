package services;

import model.Instrumento;

import java.util.List;

public interface InstrumentoService {
    public void crearInstrumento(Instrumento instrumento);
    public List<Instrumento> obtenerInstrumentos ();
    public void prestarInstrumento (int instrumentoId,int usuarioId);
    public void eliminarInstrumento(int instrumentoId);
}
