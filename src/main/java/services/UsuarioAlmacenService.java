package services;

import model.UsuarioAlmacen;

import java.util.List;

public interface UsuarioAlmacenService {
    public void crearUsuarioAlmacen(UsuarioAlmacen usuario);
    public List<UsuarioAlmacen> obtenerUsuarios ();
}
