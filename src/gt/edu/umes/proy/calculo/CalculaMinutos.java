	package gt.edu.umes.proy.calculo;

/** Punto de entrada de la aplicación de conversión a segundos. */
public class CalculaMinutos {
    public static void main(String[] args) {
        LogicaDelNegocio logica = new LogicaDelNegocio();
        try {
            long totalSegundos = logica.calcularSegundos(args);
            System.out.println("Total en segundos: " + totalSegundos);
        } catch (IllegalArgumentException | ArithmeticException excepcion) {
            System.err.println("Error: " + excepcion.getMessage());
            System.err.println(
                "Uso: java gt.edu.umes.proy.calculo.CalculaMinutos <meses> <semanas> <días> <horas> <minutos>"
            );
            System.exit(1);
        }
    }
}

/** 23/10/26 */