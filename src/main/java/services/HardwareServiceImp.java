package services;

import dao.HardwareDao;
import model.Hardware;

import java.util.List;

public class HardwareServiceImp implements HardwareService {
    private HardwareDao hardwareDao;

    public HardwareServiceImp(HardwareDao hardwareDao) {
        this.hardwareDao = hardwareDao;
    }

    @Override
    public void crearHardware(Hardware hardware) {
        hardwareDao.crearHardware(hardware);
    }

    @Override
    public List<Hardware> obtenerHardwares() {
        return hardwareDao.obtenerHardwares();
    }

    @Override
    public void prestarHardware(int hardwareId, int usuarioId) {
        hardwareDao.prestarHardware(hardwareId,usuarioId);
    }

    @Override
    public void eliminarHardware(int hardwareId) {
        hardwareDao.eliminarHardware(hardwareId);
    }
}
