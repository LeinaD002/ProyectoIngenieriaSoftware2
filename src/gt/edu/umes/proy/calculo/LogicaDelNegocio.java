package gt.edu.umes.proy.calculo;

/**
 * Valida los argumentos y convierte meses, semanas, días, horas y minutos a segundos.
 * Para este ejercicio, cada mes se considera de 30 días.
 */
public class LogicaDelNegocio {
    private static final long SEGUNDOS_POR_MINUTO = 60L;
    private static final long SEGUNDOS_POR_HORA = 60L * SEGUNDOS_POR_MINUTO;
    private static final long SEGUNDOS_POR_DIA = 24L * SEGUNDOS_POR_HORA;
    private static final long SEGUNDOS_POR_SEMANA = 7L * SEGUNDOS_POR_DIA;
    private static final long SEGUNDOS_POR_MES = 30L * SEGUNDOS_POR_DIA;
    private static final int CANTIDAD_ARGUMENTOS = 5;

    /**
     * Recibe los cinco argumentos en este orden: meses, semanas, días, horas, minutos.
     * @throws IllegalArgumentException si la cantidad de argumentos es incorrecta
     *         o alguno no representa un entero
     * @throws ArithmeticException si el resultado excede el rango de long
     */
    public long calcularSegundos(String[] argumentos) {
        if (argumentos == null || argumentos.length != CANTIDAD_ARGUMENTOS) {
            throw new IllegalArgumentException(
                "Se requieren exactamente 5 valores: meses semanas días horas minutos."
            );
        }

        long meses = parsearEntero(argumentos[0], "meses");
        long semanas = parsearEntero(argumentos[1], "semanas");
        long dias = parsearEntero(argumentos[2], "días");
        long horas = parsearEntero(argumentos[3], "horas");
        long minutos = parsearEntero(argumentos[4], "minutos");

        long total = Math.multiplyExact(meses, SEGUNDOS_POR_MES);
        total = Math.addExact(total, Math.multiplyExact(semanas, SEGUNDOS_POR_SEMANA));
        total = Math.addExact(total, Math.multiplyExact(dias, SEGUNDOS_POR_DIA));
        total = Math.addExact(total, Math.multiplyExact(horas, SEGUNDOS_POR_HORA));
        total = Math.addExact(total, Math.multiplyExact(minutos, SEGUNDOS_POR_MINUTO));
        return total;
    }

    private long parsearEntero(String valor, String nombreUnidad) {
        try {
            return Long.parseLong(valor);
        } catch (NumberFormatException excepcion) {
            throw new IllegalArgumentException(
                "El valor de " + nombreUnidad + " debe ser un número entero: " + valor
            );
        }
    }
}
