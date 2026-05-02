package calculadora;
/**
 * Enumeración que representa las operaciones disponibles en la calculadora.
 * <p>
 * Cada constante encapsula el nombre, símbolo, descripción e identificador
 * numérico de una operación, permitiendo generar el menú de forma dinámica.
 * </p>
 *
 * @author JarFP
 * @version 1.0
 */
public enum Operaciones {

    /** Suma dos números introducidos por el usuario. */
    SUMAR("Suma", "+", "Suma dos números", 1),

    /** Resta dos números introducidos por el usuario. */
    RESTAR("Resta", "-", "Resta dos números", 2),

    /** Multiplica dos números introducidos por el usuario. */
    MULTIPLICAR("Multiplicación", "*", "Multiplica dos números", 3),

    /** Divide dos números introducidos por el usuario. */
    DIVIDIR("División", "/", "Divide dos números", 4),

    /** Suma un número al resultado acumulado. */
    SUMAR_RES("Sumar al resultado", "+=", "Suma un número al resultado actual", 5),

    /** Resta un número al resultado acumulado. */
    RESTAR_RES("Restar al resultado", "-=", "Al resultado actual le resta un número", 6),

    /** Multiplica el resultado acumulado por un número. */
    MULTIPLICAR_RES("Multiplicar al resultado", "*=", "Multiplica un número al resultado actual", 7),

    /** Divide el resultado acumulado entre un número. */
    DIVIDIR_RES("Dividir al resultado", "/=", "Resultado actual dividido por un número", 8),

    /** Muestra el resultado acumulado actual. */
    RESULTADO("Mostrar resultado", "!", "Muestra el último resultado", 9),

    /** Genera un número aleatorio entre 1 y 100 y lo guarda como resultado. */
    RANDOM("Número aleatorio", "¿?", "Crea un número aleatorio 1-100", 10),

    /** Muestra las cinco últimas operaciones realizadas. */
    HISTORIAL("Historial", "h", "Muestra las cinco últimas operaciones", 11);

    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------

    /** Nombre descriptivo de la operación. */
    private final String nombreOperacion;

    /** Símbolo matemático asociado a la operación. */
    private final String simboloOperacion;

    /** Texto informativo que explica la operación. */
    private final String infoOperacion;

    /** Identificador numérico usado en el menú. */
    private final int idOperacion;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * Construye una constante de operación con todos sus datos.
     *
     * @param nombre  nombre descriptivo de la operación
     * @param simbolo símbolo matemático de la operación
     * @param info    descripción breve de la operación
     * @param id      identificador numérico para el menú
     */
	Operaciones (String nombre, String simbolo, String info, int id){
		this.nombreOperacion = nombre;
		this.simboloOperacion = simbolo;
		this.infoOperacion = info;
		this.idOperacion = id;
	}
    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------

    /**
     * Devuelve el nombre descriptivo de la operación.
     *
     * @return nombre de la operación
     */
    public String getNombre() { return nombreOperacion; }

    /**
     * Devuelve la descripción informativa de la operación.
     *
     * @return texto de información de la operación
     */
    public String getInfo() { return infoOperacion; }

    /**
     * Devuelve el símbolo matemático de la operación.
     *
     * @return símbolo de la operación
     */
    public String getSimbolo() { return simboloOperacion; }

    /**
     * Devuelve el identificador numérico de la operación.
     *
     * @return id de la operación
     */
    public int getId() { return idOperacion; }

    /**
     * Devuelve la línea de menú formateada con el id y el nombre.
     * Ejemplo: {@code "1.- Suma"}
     *
     * @return cadena con formato de opción de menú
     */
    public String getOpcionMenu() {return idOperacion + ".- " + nombreOperacion;}
	

}
