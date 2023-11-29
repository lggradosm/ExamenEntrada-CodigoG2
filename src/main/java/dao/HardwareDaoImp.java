package dao;

import model.Hardware;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HardwareDaoImp implements HardwareDao {
    private Connection connection;

    public HardwareDaoImp(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearHardware(Hardware hardware) {
        try{
            String sql = "INSERT INTO hardwares(nombre_articulo, estado, is_loaned,marca, modelo, version) VALUES (?,?,?,?,?,?)";
            PreparedStatement psmt = connection.prepareStatement(sql);
            String nombre = hardware.getNombreArticulo();
            int estado = hardware.getEstado();
            boolean isLoaned = hardware.isLoaned();
            String marca = hardware.getMarca();
            String modelo = hardware.getModelo();
            int version = hardware.getVersion();
            psmt.setString(1, nombre);
            psmt.setInt(2, estado);
            psmt.setBoolean(3, isLoaned);
            psmt.setString(4, marca);
            psmt.setString(5,modelo);
            psmt.setInt(6,version);
            psmt.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Hardware> obtenerHardwares() {
        try{
            String sql = "SELECT * from hardwares WHERE estado = "+1;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Hardware> hardwares = new ArrayList<>();
            while(resultSet.next()){
                int id  = resultSet.getInt("hardware_id");
                String nombre =resultSet.getString("nombre_articulo");
                int estado = resultSet.getInt("estado");
                boolean isLoaned = resultSet.getBoolean("is_loaned");
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                int version = resultSet.getInt("version");
                Hardware hardware = new Hardware(nombre,id,isLoaned,estado,marca,modelo,version);
                hardwares.add(hardware);
            }
            return hardwares;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void prestarHardware(int hardwareId, int usuarioId) {
        try{
            String sql = "UPDATE harwares SET is_loaned = true WHERE hardware_id = "+ hardwareId;
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.executeUpdate();
            String sql2 = "INSERT INTO prestamo_hardwares (hardware_id, usuario_id) VALUES (?,?)";
            psmt = connection.prepareStatement(sql2);
            psmt.setInt(1,hardwareId);
            psmt.setInt(2,usuarioId);
            psmt.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminarHardware(int hardwareId) {
        try{
            String sql = "UPDATE hardwares SET estado = 0 WHERE hardware_id = "+ hardwareId;
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
