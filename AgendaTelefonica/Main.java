package AgendaTelefonica;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AgendaTelefonica agenda = new AgendaTelefonica();
        Scanner scanner = new Scanner(System.in);

        while (true) { /**mientras no escoja la opcion salir mostrar el menu*/
            System.out.println("\nMENU PARA GESTIONAR CONTACTOS DE UNA AGENDA TELEFÓNICA 📖☎️ ");
            System.out.print("Escoge una opción: ");
            System.out.println("\n1 Añadir un contacto nuevo");
            System.out.println("2 Buscar un contacto existente");
            System.out.println("3 Listar contactos existentes");
            System.out.println("4 Eliminar un contacto");
            System.out.println("5 Modificar teléfono de contacto existente");
            System.out.println("6 Consultar si la agenda está llena");
            System.out.println("7 Consultar cuántos espacios libres hay");
            System.out.println("8 SALIR");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    try {
                        /**try-catch= es una estructura que permite manejar errores sin que el programa se cierre. si durante la ejecucion del programa ocurre una excepción(error), el programa no se detiene, sino que pasa a ejecutar el código dentro del bloque catch.*/
                        Contacto nuevo = new Contacto(nombre, apellido, telefono);
                        agenda.añadirContacto(nuevo);
                    } catch (IllegalArgumentException e) { /**el flujo salta al bloque catch, donde se captura la excepción en la variable e. y se imprime un mensaje de error*/
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "2":
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    apellido = scanner.nextLine();
                    agenda.buscaContacto(nombre, apellido);
                    break;
                case "3":
                    agenda.listarContactos();
                    break;
                case "4":
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    apellido = scanner.nextLine();
                    agenda.eliminarContacto(new Contacto(nombre, apellido, ""));
                    break;
                case "5":
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    apellido = scanner.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    telefono = scanner.nextLine();
                    agenda.modificarTelefono(nombre, apellido, telefono);
                    break;
                case "6":
                    if (agenda.agendaLlena()) {
                        System.out.println("La agenda ya está llena.");
                    } else {
                        System.out.println("La agenda NO está llena.");
                    }
                    break;
                case "7":
                    System.out.println("Espacios libres: " + agenda.espacioLibres());
                    break;
                case "8":
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
