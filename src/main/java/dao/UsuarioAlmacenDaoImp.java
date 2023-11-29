package dao;

import model.UsuarioAlmacen;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioAlmacenDaoImp implements UsuarioAlmacenDao{
    private Connection connection;

    public UsuarioAlmacenDaoImp(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearUsuarioAlmacen(UsuarioAlmacen usuario) {
        try{
            String sql = "INSERT INTO usuarios (username) VALUES (?)";
            PreparedStatement psmt = connection.prepareStatement(sql);
            String nombre = usuario.getUsername();
            psmt.setString(1, nombre);
            psmt.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<UsuarioAlmacen> obtenerUsuarios() {
        try{
            String query = "SELECT * FROM usuarios";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<UsuarioAlmacen> usuarioList = new ArrayList<>();
            while(resultSet.next()){
                int id = resultSet.getInt("usuario_id");
                String username = resultSet.getString("username");
                UsuarioAlmacen usuario = new UsuarioAlmacen(id,username);
                usuarioList.add(usuario);
            }
            return usuarioList;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return  null;
    }
}
