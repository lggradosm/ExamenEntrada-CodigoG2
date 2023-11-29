package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Software extends AlmacenArticulo{
    private String tipoLicencia;

    public Software( int articuloID,String nombreArticulo, boolean isLoaned, int estado, String marca, String modelo,int version,String tipoLicencia) {
        super(articuloID,nombreArticulo, isLoaned, estado,marca, modelo,version);
        this.tipoLicencia = tipoLicencia;
    }

    public Software(String nombreArticulo, boolean isLoaned, int estado, String marca,String modelo,int version,String tipoLicencia) {
        super(nombreArticulo, isLoaned, estado,marca,modelo,version);
        this.tipoLicencia = tipoLicencia;
    }

    @Override
    public void showDetails() {
        System.out.println("{id: "+this.articuloID+"\nNombre: "+this.nombreArticulo+"\nEstado: "+
                (this.isLoaned?"Prestado":"Disponible")+"\nMarca: "+this.marca+"\nModelo: "+this.modelo+"\nTipo Licencia"+tipoLicencia+"}" );

    }
}
