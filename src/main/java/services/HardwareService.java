package services;

import model.Hardware;

import java.util.List;

public interface HardwareService {
    public void crearHardware(Hardware hardware);
    public List<Hardware> obtenerHardwares ();
    public void prestarHardware (int hardwareId,int usuarioId);
    public void eliminarHardware(int hardwareId);
}
