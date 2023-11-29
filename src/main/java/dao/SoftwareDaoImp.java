package dao;

import model.Software;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SoftwareDaoImp implements SoftwareDao {
    private Connection connection;

    public SoftwareDaoImp(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearSoftware(Software software) {
        try{
            String sql = "INSERT INTO softwares(nombre_articulo, estado, is_loaned,autor,duracion) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement psmt = connection.prepareStatement(sql);
            String nombre = software.getNombreArticulo();
            int estado = software.getEstado();
            boolean isLoaned = software.isLoaned();
            String marca = software.getMarca();
            String modelo = software.getModelo();
            int version = software.getVersion();
            String licencia = software.getTipoLicencia();
            psmt.setString(1, nombre);
            psmt.setInt(2, estado);
            psmt.setBoolean(3, isLoaned);
            psmt.setString(4, marca);
            psmt.setString(5, modelo);
            psmt.setInt(6, version);
            psmt.setString(7, licencia);
            psmt.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Software> obtenerSoftwares() {
        try{
            String sql = "SELECT * from softwares WHERE estado = "+1;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Software> softwares = new ArrayList<>();
            while(resultSet.next()){
                int id  = resultSet.getInt("software_id");
                String nombre =resultSet.getString("nombre_articulo");
                int estado = resultSet.getInt("estado");
                boolean isLoaned = resultSet.getBoolean("is_loaned");
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                int version = resultSet.getInt("version");
                String licencia = resultSet.getString("tipo_licencia");
                Software software = new Software(id,nombre,isLoaned,estado,marca,modelo,version,licencia);
                softwares.add(software);
            }
            return softwares;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public void prestarSoftware(int softwareId, int usuarioId) {
        try{
            String sql = "UPDATE softwares SET is_loaned = true WHERE instrumento_id = "+ softwareId;
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.executeUpdate();
            String sql2 = "INSERT INTO prestamo_softwares (software_id, usuario_id) VALUES (?,?)";
            psmt = connection.prepareStatement(sql2);
            psmt.setInt(1,softwareId);
            psmt.setInt(2,usuarioId);
            psmt.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminarSoftware(int softwareId) {
        try{
            String sql = "UPDATE softwares SET estado = 0 WHERE software_id = "+ softwareId;
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
