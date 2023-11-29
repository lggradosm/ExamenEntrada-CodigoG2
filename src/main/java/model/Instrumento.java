package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instrumento extends AlmacenArticulo{
    private String desDueño;

    public Instrumento(String nombreArticulo, int articuloID, boolean isLoaned, int estado, String desDueño) {
        super(nombreArticulo, articuloID, isLoaned, estado);
        this.desDueño = desDueño;
    }

    public Instrumento(String nombreArticulo, boolean isLoaned, int estado, String desDueño) {
        super(nombreArticulo, isLoaned, estado);
        this.desDueño = desDueño;
    }

    @Override
    public void showDetails() {
        System.out.println("{id: "+this.articuloID+"\nNombre: "+this.nombreArticulo+"\nEstado: "+(this.isLoaned?"Prestado":"Disponible")+"}" );
    }

}
