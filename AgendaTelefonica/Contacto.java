package AgendaTelefonica;

public class Contacto {
    public String nombre;
    public String apellido;
    public String telefono;

//constructor
    public Contacto(String nombre, String apellido, String telefono) {
        if (nombre == null || nombre.trim().isEmpty() /** metodo de String que devuelve true si la cadena está vacía */ || apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre y apellido no pueden estar vacíos"); /**esta linea detiene la ejecución si los valores pasados no cumplen alguna condicion (throw= lanza una excepción). (new= crea la exepción), (IllegalArgumentException: indica que uno de los argumentos pasados al metodo es invalido) */
        }
        this.nombre = nombre.trim();
        this.apellido = apellido.trim();
        this.telefono = telefono;
    }

    //getters & setters
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    @Override
    //equals= metodo heredado de Object(clase base de Java) que sirve para comparar si dos objetos son iguales de acuerdo a ciertos criterios:
    public boolean equals(Object obj) { /** obj= es el objeto que se compara con this*/
        if (this == obj) return true;
        if (!(obj instanceof Contacto)) return false; /** instanceof= verifica si el objeto es una instancia de la clase contacto. Esto se usa para que no se llame a un objeto que no sea del tipo contacto y evitar errores */
        Contacto otro = (Contacto) obj; /**convierte obj a un objeto de tipo contacto*/
        return this.nombre.equalsIgnoreCase(otro.nombre) &&
                this.apellido.equalsIgnoreCase(otro.apellido);
                /**equalsIgnoreCase= compara dos cadenas de texto ignorando mayúsculas y minúsculas */
    }

    @Override
    public int hashCode() { /** Es un metodo que devuelve un número entero código hash para el objeto.*/
        return nombre.toLowerCase().hashCode()/***/ + apellido.toLowerCase().hashCode(); /**calcula el hash de nombre y lo suma, entonces si dos contactos tienen el mismo nombre y apellido tendrán el mismo hash.*/
    }

    @Override
    /** devuelve el objeto en forma de texto */
    public String toString() {
        return nombre + " " + apellido + " - " + telefono;
    }
}
