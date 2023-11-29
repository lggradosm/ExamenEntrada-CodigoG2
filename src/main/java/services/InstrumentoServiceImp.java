package services;

import dao.InstrumentoDao;
import model.Instrumento;

import java.util.List;

public class InstrumentoServiceImp implements InstrumentoService {
    private InstrumentoDao instrumentoDao;

    public InstrumentoServiceImp(InstrumentoDao instrumentoDao) {
        this.instrumentoDao = instrumentoDao;
    }

    @Override
    public void crearInstrumento(Instrumento instrumento) {
        instrumentoDao.crearInstrumento(instrumento);
    }

    @Override
    public List<Instrumento> obtenerInstrumentos() {
        return instrumentoDao.obtenerInstrumentos();
    }

    @Override
    public void prestarInstrumento(int instrumentoId, int usuarioId) {
        instrumentoDao.prestarInstrumento(instrumentoId,usuarioId);
    }

    @Override
    public void eliminarInstrumento(int instrumentoId) {
        instrumentoDao.eliminarInstrumento(instrumentoId);
    }
}
