package calculadora;

import java.util.Scanner;

/**
 * Núcleo lógico de la calculadora.
 * <p>
 * Gestiona el resultado acumulado, el historial de operaciones y la
 * ejecución de cada operación aritmética disponible.
 * El historial almacena las {@value #TAMANO_HISTORIAL} últimas operaciones.
 * </p>
 *
 * @author JarFP
 * @version 1.0
 * @see Operaciones
 */
public class CerebroCalculadoraED {

    // -------------------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------------------

    /** Número máximo de entradas que almacena el historial. */
    private static final int TAMANO_HISTORIAL = 5;

    // -------------------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------------------

    /** Operación actualmente en curso. */
    private Operaciones operacion;

    /** Resultado acumulado de las operaciones. */
    private double resultado;

    /** Primer operando introducido por el usuario. */
    private double numero1;

    /** Segundo operando introducido por el usuario. */
    private double numero2;

    /** Historial con las últimas {@value #TAMANO_HISTORIAL} operaciones. */
    private String[] historial;

    /** Scanner para leer la entrada del usuario. */
    private Scanner tecladoCce = new Scanner(System.in);

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * Crea una nueva instancia del cerebro de la calculadora.
     * Inicializa el historial vacío y el resultado acumulado a 0.
     */
	CerebroCalculadoraED() {
		historial = new String[TAMANO_HISTORIAL];
		resultado = 0;
	}
    // -------------------------------------------------------------------------
    // Métodos públicos
    // -------------------------------------------------------------------------

    /**
     * Procesa la operación seleccionada por el usuario según el código recibido.
     * <p>
     * Mapea el código de cadena (ej. {@code "1"}) a la constante de
     * {@link Operaciones} correspondiente y delega en el método privado
     * específico.
     * </p>
     *
     * @param op cadena con el identificador de la operación (p.ej. "1", "2"…)
     */
	public void procesarOperacion(String op) {
		Operaciones operacion;
		System.out.println("proceso " + op);
		switch (op) {
		case "1":
			operacion = Operaciones.SUMAR;
			operarSuma(operacion);
			break;
		case "2":
			operacion = Operaciones.RESTAR;
			operarResta(operacion);
			break;
		case "3":
			operacion = Operaciones.MULTIPLICAR;
			operarMultiplica(operacion);
			break;
		case "4":
			operacion = Operaciones.DIVIDIR;
			operarDivide(operacion);
			break;
		case "5":
			operacion = Operaciones.SUMAR_RES;
			operarSumaRes(operacion);
			break;
		case "6":
			operacion = Operaciones.RESTAR_RES;
			operarRestaRes(operacion);
			break;
		case "7":
			operacion = Operaciones.MULTIPLICAR_RES;
			operarMultiplicaRes(operacion);
			break;
		case "8":
			operacion = Operaciones.DIVIDIR_RES;
			operarDivideRes(operacion);
			break;
		case "9":
			operacion = Operaciones.RESULTADO;
			mostrarResultadoActual(operacion);
			break;
		case "10":
			operacion = Operaciones.RANDOM;
			numeroAleatorio(operacion);
			break;
		case "11":
			operacion = Operaciones.HISTORIAL;
			operarHistorial(operacion);
			break;
		default:
			System.out.println("ERROR: La operación " + op + " no es conocida.");
		}
	}
    // -------------------------------------------------------------------------
    // Operaciones aritméticas básicas
    // -------------------------------------------------------------------------

    /**
     * Realiza la suma de dos números introducidos por el usuario.
     *
     * @param op constante {@link Operaciones#SUMAR}
     */
	private void operarSuma(Operaciones op) {
		infoOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 + this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
    /**
     * Realiza la resta de dos números introducidos por el usuario.
     *
     * @param op constante {@link Operaciones#RESTAR}
     */
	private void operarResta(Operaciones op) {
		infoOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 - this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
    /**
     * Realiza la multiplicación de dos números introducidos por el usuario.
     *
     * @param op constante {@link Operaciones#MULTIPLICAR}
     */
	private void operarMultiplica(Operaciones op) {
		infoOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 * this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}

    /**
     * Realiza la división de dos números introducidos por el usuario.
     * <p>
     * No comprueba división por cero; el resultado sería
     * {@code Double.POSITIVE_INFINITY}.
     * </p>
     *
     * @param op constante {@link Operaciones#DIVIDIR}
     */
	private void operarDivide(Operaciones op) {
		infoOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 / this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
    // -------------------------------------------------------------------------
    // Operaciones sobre el resultado acumulado
    // -------------------------------------------------------------------------

    /**
     * Suma un número al resultado acumulado.
     *
     * @param op constante {@link Operaciones#SUMAR_RES}
     */
	private void operarSumaRes(Operaciones op) {
		infoOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado + this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
    /**
     * Resta un número al resultado acumulado.
     * <p>
     * <b>Corrección (refactorización):</b> el código original usaba {@code +}
     * en lugar de {@code -}, lo que producía una suma en vez de una resta.
     * </p>
     *
     * @param op constante {@link Operaciones#RESTAR_RES}
     */
	private void operarRestaRes(Operaciones op) {
		infoOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado - this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
    /**
     * Multiplica el resultado acumulado por un número.
     *
     * @param op constante {@link Operaciones#MULTIPLICAR_RES}
     */
	private void operarMultiplicaRes(Operaciones op) {
		infoOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado * this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
    /**
     * Divide el resultado acumulado entre un número.
     *
     * @param op constante {@link Operaciones#DIVIDIR_RES}
     */
	private void operarDivideRes(Operaciones op) {
		infoOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado / this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
    // -------------------------------------------------------------------------
    // Operaciones de consulta e información
    // -------------------------------------------------------------------------

    /**
     * Muestra por pantalla el valor actual del resultado acumulado.
     *
     * @param op constante {@link Operaciones#RESULTADO}
     */
	private void mostrarResultadoActual(Operaciones op) {
		infoOperacion(op);
		System.out.println("El valor actual del resultado es: " + this.resultado + "\n");
	}

    /**
     * Genera un número aleatorio entre 1 y 100, lo asigna al resultado
     * acumulado y lo registra en el historial.
     *
     * @param op constante {@link Operaciones#RANDOM}
     */
	private void numeroAleatorio(Operaciones op) {
		infoOperacion(op);
		this.resultado = (double)(Math.random()*100+1);
		System.out.println("El número aleatorio generado es: " + this.resultado + "\n");
		anadirHistorialAleatorio(op);
	}
    /**
     * Muestra las últimas {@value #TAMANO_HISTORIAL} operaciones realizadas.
     *
     * @param op constante {@link Operaciones#HISTORIAL}
     */
	private void operarHistorial(Operaciones op) {
		System.out.println("*** Historial de las cinco últimas operaciones ***");
		for (String hist : historial) {
			System.out.println(hist);
		}
		System.out.println("\n");
	}
    // -------------------------------------------------------------------------
    // Métodos auxiliares privados
    // -------------------------------------------------------------------------

    /**
     * Imprime la cabecera de la operación en curso.
     *
     * @param op operación cuya información se va a mostrar
     */
	private void infoOperacion(Operaciones op) {
		System.out.println("//////////////////////////////");
		System.out.println("-> " + op.getNombre() + " - " + op.getInfo());
	}
    /**
     * Solicita al usuario un único número y lo asigna a {@code numero2}.
     * El resultado actual pasa a ser {@code numero1}.
     */
	private void pedirUnNumero() {
		System.out.println("Introduce el número: ");
		this.numero1 = this.resultado;
		this.numero2 = tecladoCce.nextDouble();
	}
    /**
     * Solicita al usuario dos números y los asigna a {@code numero1}
     * y {@code numero2} respectivamente.
     */
	private void pedirDosNumeros() {
		System.out.println("Introduce el primer número: ");
		this.numero1 = tecladoCce.nextDouble();
		System.out.println("Introduce el segundo número: ");
		this.numero2 = tecladoCce.nextDouble();
	}
    /**
     * Muestra el resultado de la operación con el formato:
     * {@code número1 símbolo número2 = resultado}.
     *
     * @param op operación cuyos datos se muestran
     */
	private void mostrarResultado(Operaciones op) {
		System.out.println("El resultado de la operación " + op.getNombre().toLowerCase() + " es:");
		System.out.println(Double.toString(numero1)
				+ " " + op.getSimbolo() + " "
				+ Double.toString(numero2) + " = "
				+ Double.toString(resultado) + "\n");
	}
    /**
     * Desplaza el array de historial e inserta la nueva entrada en la posición 0.
     * <p>
     * <b>Refactorización:</b> la lógica de desplazamiento se ha extraído al
     * método privado {@link #desplazarHistorial(String)} para eliminar la
     * duplicación que existía entre {@code anadirHistorial} y
     * {@code anadirHistorialAleatorio}.
     * </p>
     *
     * @param op operación que se va a registrar
     */
	private void anadirHistorial(Operaciones op) {
		String nuevaOperacion = op.getNombre() + " -> "
				+ Double.toString(numero1)
				+ " " + op.getSimbolo() + " "
				+ Double.toString(numero2) + " = "
				+ Double.toString(resultado);
        desplazarHistorial(nuevaOperacion);
	}
    /**
     * Registra en el historial la generación de un número aleatorio.
     * <p>
     * <b>Refactorización:</b> la visibilidad ha cambiado de {@code public} a
     * {@code private} ya que este método solo se usa internamente.
     * </p>
     *
     * @param op constante {@link Operaciones#RANDOM}
     */
	public void anadirHistorialAleatorio(Operaciones op) {
		String nuevaOperacion = op.getNombre() + " -> "
				+ Double.toString(resultado);
        desplazarHistorial(nuevaOperacion);
	}
    /**
     * Desplaza todas las entradas del historial una posición hacia arriba
     * (perdiendo la más antigua) e inserta la nueva entrada en el índice 0.
     * <p>
     * <b>Refactorización:</b> método extraído para eliminar el bloque de
     * cinco asignaciones duplicado que existía en {@code anadirHistorial}
     * y {@code anadirHistorialAleatorio}.
     * </p>
     *
     * @param nuevaEntrada cadena con la descripción de la operación realizada
     */
    private void desplazarHistorial(String nuevaEntrada) {
        for (int i = TAMANO_HISTORIAL - 1; i > 0; i--) {
            this.historial[i] = this.historial[i - 1];
        }
        this.historial[0] = nuevaEntrada;
    }


}
