package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Partitura extends AlmacenArticulo{
    private String autor;
    private int duration;

    public Partitura(String nombreArticulo, int articuloID, boolean isLoaned, int estado, String autor, int duration) {
        super(nombreArticulo, articuloID, isLoaned, estado);
        this.autor = autor;
        this.duration = duration;
    }

    public Partitura(String nombreArticulo, boolean isLoaned, int estado, String autor, int duration) {
        super(nombreArticulo, isLoaned, estado);
        this.autor = autor;
        this.duration = duration;
    }

    @Override
    public void showDetails() {
        System.out.println("{id: "+articuloID+"\nNombre: "+nombreArticulo+"\nEstado: "
                +(isLoaned?"Prestado":"Disponible")+"\nAutor: "+this.autor+ "\nDuración (min): "+this.duration+"}" );
    }
}
