package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class Hardware extends AlmacenArticulo{

    public Hardware(String nombreArticulo, int articuloID, boolean isLoaned, int estado, String marca, String modelo,int version) {
        super(articuloID,nombreArticulo, isLoaned, estado,marca, modelo,version);
    }

    public Hardware(String nombreArticulo, boolean isLoaned, int estado, String marca,String modelo, int version) {
        super(nombreArticulo, isLoaned, estado,marca,modelo,version);
    }

    @Override
    public void showDetails() {
        System.out.println("{id: "+this.articuloID+"\nNombre: "+this.nombreArticulo+"\nEstado: "+(this.isLoaned?"Prestado":"Disponible")+"\nMarca: "+this.marca+"\nModelo: "+this.modelo+"}" );
    }

}
