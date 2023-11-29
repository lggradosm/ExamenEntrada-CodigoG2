package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioAlmacen {
    private int userID;

    private String username;
    private List<AlmacenArticulo> loanedItems;

    public UsuarioAlmacen( int userID,String username) {
        this.username = username;
        this.userID = userID;
    }

    public UsuarioAlmacen(String username) {
        this.username = username;
    }

    public void showUserDetails(){
        System.out.println("{\nid: "+this.userID+"\nNombre de usuario: "+this.username );
        if(loanedItems != null)
         loanedItems.forEach(item -> System.out.println(item));
        System.out.println("}");
    }

    public void showUser(){
        System.out.println("{\nid: "+this.userID+"\nNombre de usuario: "+this.username );
    }
}
