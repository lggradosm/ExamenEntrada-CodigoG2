import dao.HardwareDaoImp;
import dao.SoftwareDaoImp;
import dao.UsuarioAlmacenDaoImp;
import model.Hardware;
import model.Software;
import model.UsuarioAlmacen;
import services.*;
import util.DatabaseConnection;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        boolean active = true;
        Scanner sc = new Scanner(System.in);
        DatabaseConnection connection = new DatabaseConnection();
        UsuarioAlmacenService usuarioAlmacenService = new UsuarioAlmacenImp(new UsuarioAlmacenDaoImp(connection.getConnection()));
        HardwareService hardwareService = new HardwareServiceImp(new HardwareDaoImp(connection.getConnection()));
        SoftwareService softwareService = new SoftwareServiceImp(new SoftwareDaoImp(connection.getConnection()));
        int seleccion ;
        while (active){
            System.out.println("1.Crear usuario");
            System.out.println("2.Añadir hardware");
            System.out.println("3.Añadir software");
            System.out.println("4.Prestar Articulo");
            System.out.println("5. Devolver Articulo");
            System.out.println("6. Mostrar Artículos");
            System.out.println("7. Mostrar Usuarios");
            System.out.println("8. Eliminar hardware");
            System.out.println("9. Eliminar software");
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
                    System.out.println("Ingresa nombre del hardware");
                    sc.nextLine();
                    String nombreHardware = sc.nextLine();
                    int estado = 1;
                    boolean isLoaned = false;
                    System.out.println("Ingresa el marca");
                    String marca = sc.nextLine();
                    System.out.println("Ingresea la modelo");
                    String modelo = sc.nextLine();
                    System.out.println("Ingresea la version");
                    int version = sc.nextInt();
                    Hardware hardware = new Hardware(nombreHardware,isLoaned,estado,marca,modelo,version);
                    hardwareService.crearHardware(hardware);
                    break;
                }
                case 3:
                {
                    System.out.println("Ingresa nombre de la software");
                    sc.nextLine();
                    String nombre = sc.nextLine();
                    int estado = 1;
                    boolean isLoaned = false;
                    System.out.println("Ingresa el marca");
                    String marca = sc.nextLine();
                    System.out.println("Ingresea la modelo");
                    String modelo = sc.nextLine();
                    System.out.println("Ingresea la version");
                    int version = sc.nextInt();
                    System.out.println("Ingresea la tipo de licencia");
                    String licencia = sc.nextLine();
                    Software software = new Software(nombre,isLoaned,estado,marca,modelo,version,licencia);
                    softwareService.crearSoftware(software);
                    break;
                }
                case 4:{
                    List<UsuarioAlmacen> usuarios = usuarioAlmacenService.obtenerUsuarios();
                    usuarios.forEach(usuarioAlmacen -> usuarioAlmacen.showUser());
                    System.out.println("Ingresa el id del usuario");
                    int usuario = sc.nextInt();
                    System.out.println("¿Qué tipo de articulo deseas?");
                    System.out.println("1. Hardware");
                    System.out.println("2. Software");
                    int sel = sc.nextInt();
                    switch (sel){
                        case 1: {
                            List<Hardware> hardwares = hardwareService.obtenerHardwares();
                            hardwares.forEach(hardware -> hardware.showDetails());
                            System.out.println("Seleccione el id del hardware a prestar");
                            int id = sc.nextInt();
                            hardwareService.prestarHardware(id,usuario);
                            break;
                        }
                        case 2:{
                            List<Software> softwares = softwareService.obtenerSoftwares();
                            softwares.forEach(software -> software.showDetails());
                            System.out.println("Seleccione el id de la software a prestar");
                            int id = sc.nextInt();
                            softwareService.prestarSoftware(id,usuario);
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
                    List<Hardware> hardwares =  hardwareService.obtenerHardwares();
                    List<Software> softwares = softwareService.obtenerSoftwares();
                    hardwares.forEach(hardware -> hardware.showDetails());
                    softwares.forEach(software -> software.showDetails());
                    break;
                }
                case 7:
                {
                    List<UsuarioAlmacen> usuarios = usuarioAlmacenService.obtenerUsuarios();
                    usuarios.forEach(usuario -> usuario.showUserDetails());
                    break;
                }
                case 8:{
                    List<Hardware> hardwares =  hardwareService.obtenerHardwares();
                    hardwares.forEach(hardware -> hardware.showDetails());
                    System.out.println("Seleccione el id del hardware a eliminar");
                    int id = sc.nextInt();
                    hardwareService.eliminarHardware(id);
                    break;
                }
                case 9: {
                    List<Software> softwares = softwareService.obtenerSoftwares();
                    softwares.forEach(software -> software.showDetails());
                    System.out.println("Seleccione el id de la software a eliminar");
                    int id = sc.nextInt();
                    softwareService.eliminarSoftware(id);
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
