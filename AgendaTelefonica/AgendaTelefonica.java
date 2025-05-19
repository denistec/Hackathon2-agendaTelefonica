package AgendaTelefonica;

import java.util.ArrayList; /**clase que implementa una lista dinamica*/
import java.util.List; /**interfaz con métodos para manejar listas */

public class AgendaTelefonica {
    public List<Contacto> contactos;
    public int maxContactos;
    //constructor
    public AgendaTelefonica(int maxContactos) {
        this.maxContactos = maxContactos;
        this.contactos = new ArrayList<>();
    }
    /**Constructor vacio que llama al constructor lleno: (agendaTelefonica (int max))*/
    public AgendaTelefonica() {
        this(10); /**Crea una agenda con capacidad máxima 10*/
    }

    public boolean añadirContacto(Contacto contacto) {
        if (contacto == null) return false;
        if (existeContacto(contacto)) { /**llama al metodo existeContacto, al que se le pasa como argumento la variable contacto.*/
            System.out.println("el contacto ya existe");
            return false;
        }
        if (agendaLlena()) {
            System.out.println("la agenda tiene un límite de 10 contactos, ya está llena");
            return false;
        }
        contactos.add(contacto);
        System.out.println("contacto añadido correctamente");
        return true;
    }

    /**verifica si la lista contiene un objeto igual al que se pasa como parámetro.*/
    public boolean existeContacto(Contacto contacto) {
        return contactos.contains(contacto);
    }

    public void listarContactos() {
        System.out.println("Contactos existentes en la agenda:");
        for (Contacto c : contactos) { /**para cada objeto en la lista "contactos" imprime el contacto actual de c/vuelta*/
            System.out.println(c);
        }
    }
    public void buscaContacto(String nombre, String apellido) {
        for (Contacto c : contactos) {
            /**verifica si el objeto Contacto llamado c tiene el mismo nombre y apellido que los que se pasan como parámetros*/
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                System.out.println("Teléfono: " + c.getTelefono());
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    public boolean eliminarContacto(Contacto contacto) {
        if (contactos.remove(contacto)) {
            System.out.println("Contacto eliminado."); /** si el contacto fue encontrado y eliminado*/
            return true;
        } else {
            System.out.println("Contacto no encontrado.");
            return false;
        }
    }
    public boolean modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        for (Contacto c : contactos) {/**recorre la lista contactos buscando nombre y apellido ignorando mayúsculas y minúsculas*/
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                c.setTelefono(nuevoTelefono); /**si encuentra el contacto actualiza el número*/
                System.out.println("Teléfono actualizado.");
                return true;
            }
        }
        System.out.println("Contacto no encontrado.");
        return false;
    }

    public boolean agendaLlena() {
        return contactos.size() >= maxContactos; /**contactos.size() muestra el total actual de elementos de la lista*/
    }

    public int espacioLibres() {
        return maxContactos - contactos.size();
    }
}
