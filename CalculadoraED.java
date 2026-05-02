
package calculadora;

import java.util.Scanner;
/**
 * Clase principal de la aplicación CalculadoraED.
 * <p>
 * Contiene el punto de entrada {@link #main(String[])} que gestiona el
 * bucle principal de interacción con el usuario: muestra el menú,
 * recoge la entrada, la valida y delega la ejecución en
 * {@link CerebroCalculadoraED}.
 * </p>
 *
 * <p>El usuario puede salir en cualquier momento introduciendo {@code x}.</p>
 *
 * @author JarFP
 * @version 1.0
 * @see CerebroCalculadoraED
 * @see Operaciones
 */

public class CalculadoraED {

    /**
     * Punto de entrada de la aplicación.
     * <p>
     * Crea el {@link CerebroCalculadoraED}, abre el {@link Scanner} de
     * teclado y ejecuta el bucle principal hasta que el usuario introduce
     * {@code x}.
     * </p>
     *
     * @param args argumentos de línea de comandos (no se utilizan)
     */
	public static void main(String[] args) {
		
		CerebroCalculadoraED cce = new CerebroCalculadoraED();
		Scanner teclado = new Scanner(System.in);
		String entrada;
		do {
			imprimirCabecera();
			imprimirSeleccionOp();
			
			entrada = teclado.next();
			if (validarEntrada(entrada)) {
				cce.procesarOperacion(entrada);
			}else {
				System.out.println("Entrada no reconocida");
			}
		} while (!entrada.equals("x"));
		imprimirDespedida();
	}

    // -------------------------------------------------------------------------
    // Métodos de presentación
    // -------------------------------------------------------------------------

    /**
     * Imprime la cabecera decorativa de la calculadora en la consola.
     */

	private static void imprimirCabecera() {
		System.out.println("*----------------------------------*");
		System.out.println("*----------Calculadora ED----------*");
		System.out.println("*----------------------------------*");
	}

    /**
     * Imprime el mensaje de despedida al salir de la aplicación.
     */

	private static void imprimirDespedida() {
		System.out.println("*-----------------------------------------*");
		System.out.println("*----¡Gracias por usar Calculadora ED!----*");
		System.out.println("*-----------------------------------------*");
	}

    /**
     * Recorre todos los valores del enum {@link Operaciones} e imprime
     * cada opción de menú, seguida de la instrucción para salir.
     */

	private static void imprimirSeleccionOp() {
		Operaciones[] ops = Operaciones.values();
		for(Operaciones op: ops)
		{
			System.out.println(op.getOpcionMenu());
	    }
		System.out.println("¿Qué operación desea realizar? (x para terminar)");
	}

    // -------------------------------------------------------------------------
    // Validación
    // -------------------------------------------------------------------------

    /**
     * Comprueba si la cadena introducida por el usuario es una entrada válida.
     * <p>
     * Se considera válida si es {@code "x"} (salir) o si coincide con el
     * identificador numérico de alguna {@link Operaciones}.
     * </p>
     *
     * @param entrada cadena introducida por el usuario
     * @return {@code true} si la entrada es válida; {@code false} en caso contrario
     */

	private static boolean validarEntrada(String entrada) {
		if (entrada.equals("x")) {
			return true;
		} else {
			boolean opValida = false;
			Operaciones[] ops = Operaciones.values();
			for(Operaciones op: ops)
			{
				if(Integer.toString(op.getId()).equals(entrada)) {
					opValida = true;
				}
		    }
			return opValida;
		}
	}
	
	

}
