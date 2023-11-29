package dao;

import model.Instrumento;
import model.Partitura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PartituraDaoImp implements PartituraDao{
    private Connection connection;

    public PartituraDaoImp(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearPartitura(Partitura partitura) {
        try{
            String sql = "INSERT INTO partituras(nombre_articulo, estado, is_loaned,autor,duracion) VALUES (?,?,?,?,?)";
            PreparedStatement psmt = connection.prepareStatement(sql);
            String nombre = partitura.getNombreArticulo();
            int estado = partitura.getEstado();
            boolean isLoaned = partitura.isLoaned();
            String autor = partitura.getAutor();
            int duracion = partitura.getDuration();
            psmt.setString(1, nombre);
            psmt.setInt(2, estado);
            psmt.setBoolean(3, isLoaned);
            psmt.setString(4, autor);
            psmt.setInt(5, duracion);
            psmt.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Partitura> obtenerPartituras() {
        try{
            String sql = "SELECT * from partituras WHERE estado = "+1;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Partitura> partituras = new ArrayList<>();
            while(resultSet.next()){
                int id  = resultSet.getInt("partitura_id");
                String nombre =resultSet.getString("nombre_articulo");
                int estado = resultSet.getInt("estado");
                boolean isLoaned = resultSet.getBoolean("is_loaned");
                String autor = resultSet.getString("autor");
                int duracion = resultSet.getInt("duracion");
                Partitura partitura = new Partitura(nombre,id,isLoaned,estado,autor,duracion);
                partituras.add(partitura);
            }
            return partituras;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public void prestarPartitura(int partituraId, int usuarioId) {
        try{
            String sql = "UPDATE partituras SET is_loaned = true WHERE instrumento_id = "+ partituraId;
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.executeUpdate();
            String sql2 = "INSERT INTO prestamo_partituras (partitura_id, usuario_id) VALUES (?,?)";
            psmt = connection.prepareStatement(sql2);
            psmt.setInt(1,partituraId);
            psmt.setInt(2,usuarioId);
            psmt.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminarPartitura(int partituraId) {
        try{
            String sql = "UPDATE partituras SET estado = 0 WHERE partitura_id = "+ partituraId;
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
