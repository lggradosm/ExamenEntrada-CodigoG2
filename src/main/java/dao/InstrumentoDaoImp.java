package dao;

import model.Instrumento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InstrumentoDaoImp implements InstrumentoDao{
    private Connection connection;

    public InstrumentoDaoImp(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearInstrumento(Instrumento instrumento) {
        try{
            String sql = "INSERT INTO instrumentos(nombre_articulo, estado, is_loaned,desDuenio) VALUES (?,?,?,?)";
            PreparedStatement psmt = connection.prepareStatement(sql);
            String nombre = instrumento.getNombreArticulo();
            int estado = instrumento.getEstado();
            boolean isLoaned = instrumento.isLoaned();
            String desDuenio = instrumento.getDesDueño();
            psmt.setString(1, nombre);
            psmt.setInt(2, estado);
            psmt.setBoolean(3, isLoaned);
            psmt.setString(4, desDuenio);
            psmt.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Instrumento> obtenerInstrumentos() {
        try{
            String sql = "SELECT * from instrumentos WHERE estado = "+1;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Instrumento> instrumentos = new ArrayList<>();
            while(resultSet.next()){
                int id  = resultSet.getInt("instrumento_id");
                String nombre =resultSet.getString("nombre_articulo");
                int estado = resultSet.getInt("estado");
                boolean isLoaned = resultSet.getBoolean("is_loaned");
                String dueño = resultSet.getString("desDuenio");
                Instrumento instrumento = new Instrumento(nombre,id,isLoaned,estado,dueño);
                instrumentos.add(instrumento);
            }
            return instrumentos;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void prestarInstrumento(int instrumentoId, int usuarioId) {
        try{
            String sql = "UPDATE instrumentos SET is_loaned = true WHERE instrumento_id = "+ instrumentoId;
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.executeUpdate();
            String sql2 = "INSERT INTO prestamo_instrumentos (instrumento_id, usuario_id) VALUES (?,?)";
            psmt = connection.prepareStatement(sql2);
            psmt.setInt(1,instrumentoId);
            psmt.setInt(2,usuarioId);
            psmt.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminarInstrumento(int instrumentoId) {
        try{
            String sql = "UPDATE instrumentos SET estado = 0 WHERE instrumento_id = "+ instrumentoId;
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
