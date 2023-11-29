package dao;

import model.Hardware;

import java.util.List;

public interface HardwareDao {
    public void crearHardware(Hardware hardware);
    public List<Hardware> obtenerHardwares ();

    public void prestarHardware (int hardwareId,int usuarioId);
    public void eliminarHardware(int hardwareId);

}
