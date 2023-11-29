package dao;

import model.UsuarioAlmacen;

import java.util.List;

public interface UsuarioAlmacenDao {
    public void crearUsuarioAlmacen(UsuarioAlmacen usuario);
    public List<UsuarioAlmacen> obtenerUsuarios ();
}
