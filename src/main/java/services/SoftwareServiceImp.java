package services;

import dao.SoftwareDao;
import model.Software;

import java.util.List;

public class SoftwareServiceImp implements SoftwareService {
    private SoftwareDao softwareDao;

    public SoftwareServiceImp(SoftwareDao softwareDao) {
        this.softwareDao = softwareDao;
    }

    @Override
    public void crearSoftware(Software software) {
        softwareDao.crearSoftware(software);
    }

    @Override
    public List<Software> obtenerSoftwares() {
        return softwareDao.obtenerSoftwares();
    }

    @Override
    public void prestarSoftware(int softwareId, int usuarioId) {
        softwareDao.prestarSoftware(softwareId,usuarioId);
    }

    @Override
    public void eliminarSoftware(int softwareId) {
        softwareDao.eliminarSoftware(softwareId);
    }
}
