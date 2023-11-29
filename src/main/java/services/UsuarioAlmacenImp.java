package services;

import dao.UsuarioAlmacenDao;
import model.UsuarioAlmacen;

import java.util.List;

public class UsuarioAlmacenImp implements UsuarioAlmacenService{
    private UsuarioAlmacenDao usuarioAlmacenDao;

    public UsuarioAlmacenImp(UsuarioAlmacenDao usuarioAlmacenDao) {
        this.usuarioAlmacenDao = usuarioAlmacenDao;
    }

    @Override
    public void crearUsuarioAlmacen(UsuarioAlmacen usuario) {
        usuarioAlmacenDao.crearUsuarioAlmacen(usuario);
    }

    @Override
    public List<UsuarioAlmacen> obtenerUsuarios() {
        return usuarioAlmacenDao.obtenerUsuarios();
    }
}
