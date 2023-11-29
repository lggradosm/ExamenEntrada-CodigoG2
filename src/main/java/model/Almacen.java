package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Almacen {
    private List<AlmacenArticulo> articulos;

    public void addArt(AlmacenArticulo articulo){

    }

    public void showAllArt(){
        articulos.forEach(articulo -> System.out.println(articulo));
    }

    public void loanArt(int articuloId){

    }

    public void reutrnArt(int articuloId){

    }


}
