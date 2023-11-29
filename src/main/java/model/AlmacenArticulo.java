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
    protected String marca;
    protected String modelo;
    protected int version;
    protected boolean isLoaned;
    protected  int estado;

    public AlmacenArticulo(String nombreArticulo, boolean isLoaned, int estado, String marca, String modelo,int version) {
        this.nombreArticulo = nombreArticulo;
        this.isLoaned = isLoaned;
        this.estado = estado;
        this.marca = marca;
        this.modelo = modelo;
        this.version = version;
    }

    public AlmacenArticulo(int articuloID, String nombreArticulo, boolean isLoaned, int estado, String marca, String modelo, int version) {
        this.nombreArticulo = nombreArticulo;
        this.isLoaned = isLoaned;
        this.estado = estado;
        this.marca = marca;
        this.modelo = modelo;
        this.articuloID = articuloID;
        this.version = version;
    }

    public abstract void showDetails();
}
