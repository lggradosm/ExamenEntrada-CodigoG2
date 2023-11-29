import dao.InstrumentoDaoImp;
import dao.PartituraDaoImp;
import dao.UsuarioAlmacenDaoImp;
import model.AlmacenArticulo;
import model.Instrumento;
import model.Partitura;
import model.UsuarioAlmacen;
import services.*;
import util.DatabaseConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        boolean active = true;
        Scanner sc = new Scanner(System.in);
        DatabaseConnection connection = new DatabaseConnection();
        UsuarioAlmacenService usuarioAlmacenService = new UsuarioAlmacenImp(new UsuarioAlmacenDaoImp(connection.getConnection()));
        InstrumentoService instrumentoService = new InstrumentoServiceImp(new InstrumentoDaoImp(connection.getConnection()));
        PartituraService partituraService = new PartituraServiceImp(new PartituraDaoImp(connection.getConnection()));
        int seleccion ;
        while (active){
            System.out.println("1.Crear usuario");
            System.out.println("2.Añadir instrumento");
            System.out.println("3.Añadir partitura");
            System.out.println("4.Prestar Articulo");
            System.out.println("5. Devolver Articulo");
            System.out.println("6. Mostrar Artículos");
            System.out.println("7. Mostrar Usuarios");
            System.out.println("8. Eliminar instrumento");
            System.out.println("9. Eliminar partitura");
            System.out.println("10. Salir");

            seleccion = sc.nextInt();
            switch (seleccion){
                case 1: {
                    System.out.println("Ingresa el nuevo usuario");
                    sc.nextLine();
                    String username = sc.nextLine();
                    usuarioAlmacenService.crearUsuarioAlmacen(new UsuarioAlmacen(username));
                    System.out.println("Usuario agregado exitosamente");
                    break;
                }
                case 2:{
                    System.out.println("Ingresa nombre del instrumento");
                    sc.nextLine();
                    String nombreInstrumento = sc.nextLine();
                    int estado = 1;
                    boolean isLoaned = false;
                    System.out.println("Ingresa nombre del Dueño");
                    String dueño = sc.nextLine();
                    Instrumento instrumento = new Instrumento(nombreInstrumento,isLoaned,estado,dueño);
                    instrumentoService.crearInstrumento(instrumento);
                    break;
                }
                case 3:
                {
                    System.out.println("Ingresa nombre de la partitura");
                    sc.nextLine();
                    String nombre = sc.nextLine();
                    int estado = 1;
                    boolean isLoaned = false;
                    System.out.println("Ingresa nombre del autor");
                    String autor = sc.nextLine();
                    System.out.println("Ingresa la duracion en minutos");
                    int duracion = sc.nextInt();
                    Partitura partitura = new Partitura(nombre,isLoaned,estado,autor,duracion);
                    partituraService.crearPartitura(partitura);
                    break;
                }
                case 4:{
                    List<UsuarioAlmacen> usuarios = usuarioAlmacenService.obtenerUsuarios();
                    usuarios.forEach(usuarioAlmacen -> usuarioAlmacen.showUser());
                    System.out.println("Ingresa el id del usuario");
                    int usuario = sc.nextInt();
                    System.out.println("¿Qué tipo de articulo deseas?");
                    System.out.println("1. Instrumento");
                    System.out.println("2. Partitura");
                    int sel = sc.nextInt();
                    switch (sel){
                        case 1: {
                            List<Instrumento> instrumentos = instrumentoService.obtenerInstrumentos();
                            instrumentos.forEach(instrumento -> instrumento.showDetails());
                            System.out.println("Seleccione el id del instrumento a prestar");
                            int id = sc.nextInt();
                            instrumentoService.prestarInstrumento(id,usuario);
                            break;
                        }
                        case 2:{
                            List<Partitura> partituras = partituraService.obtenerPartituras();
                            partituras.forEach(partitura -> partitura.showDetails());
                            System.out.println("Seleccione el id de la partitura a prestar");
                            int id = sc.nextInt();
                            partituraService.prestarPartitura(id,usuario);
                            break;
                        }
                        default:
                            System.out.println("Opción incorrecta");
                    }
                    break;
                }

                case 5:
                    break;
                case 6:
                {
                    List<Instrumento> instrumentos =  instrumentoService.obtenerInstrumentos();
                    List<Partitura> partituras = partituraService.obtenerPartituras();
                    instrumentos.forEach(instrumento -> instrumento.showDetails());
                    partituras.forEach(partitura -> partitura.showDetails());
                    break;
                }
                case 7:
                {
                    List<UsuarioAlmacen> usuarios = usuarioAlmacenService.obtenerUsuarios();
                    usuarios.forEach(usuario -> usuario.showUserDetails());
                    break;
                }
                case 8:{
                    List<Instrumento> instrumentos =  instrumentoService.obtenerInstrumentos();
                    instrumentos.forEach(instrumento -> instrumento.showDetails());
                    System.out.println("Seleccione el id del instrumento a eliminar");
                    int id = sc.nextInt();
                    instrumentoService.eliminarInstrumento(id);
                    break;
                }
                case 9: {
                    List<Partitura> partituras = partituraService.obtenerPartituras();
                    partituras.forEach(partitura -> partitura.showDetails());
                    System.out.println("Seleccione el id de la partitura a eliminar");
                    int id = sc.nextInt();
                    partituraService.eliminarPartitura(id);
                    break;
                }
                case 10:
                {
                    active = false;
                    break;
                }
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        }


    }
}
