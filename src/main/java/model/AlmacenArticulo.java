package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AlmacenArticulo {
    protected String nombreArticulo;
    protected int articuloID;
    protected boolean isLoaned;
    protected  int estado;

    public AlmacenArticulo(String nombreArticulo, boolean isLoaned, int estado) {
        this.nombreArticulo = nombreArticulo;
        this.isLoaned = isLoaned;
        this.estado = estado;
    }

    public abstract void showDetails();
}
