package services;

import model.Software;

import java.util.List;

public interface SoftwareService {
    public void crearSoftware(Software software);
    public List<Software> obtenerSoftwares();
    public void prestarSoftware (int softwareId,int usuarioId);
    public void eliminarSoftware(int softwareId);

}
