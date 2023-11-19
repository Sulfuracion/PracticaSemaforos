import java.util.concurrent.Semaphore;
class EstacionMarte {
    // Número de robots en la estación
    public static final int NUM_ROBOTS = 5;
    private static final int CANTIDAD_PIEDRAS = 10;

    // Semáforos para la batería y las unidades de Kriptonita
    private Semaphore bateria;
    private Semaphore kriptonita;

    // Constructor de la estación
    public EstacionMarte() {
        // Inicializar semáforos con recursos disponibles
        bateria = new Semaphore(1); // Solo una batería disponible
        kriptonita = new Semaphore(3); // Tres unidades de Kriptonita disponibles
    }

    // Método que simula el trabajo de un robot en la estación
    public void trabajar(Robot robot) throws InterruptedException {
        // Esperar por la batería y la unidad de Kriptonita
        bateria.acquire();
        kriptonita.acquire();

        System.out.println(robot + " ha salido a trabajar.");

        // Simular el trabajo (carga de piedras)
        for (int i = 0; i < CANTIDAD_PIEDRAS; i++) {
            System.out.println(robot + " cargando piedra " + (i + 1));
            Thread.sleep(100); // Simular el tiempo de carga
        }

        System.out.println(robot + " ha terminado de trabajar y vuelve a la estación.");

        // Liberar la unidad de Kriptonita y la batería
        kriptonita.release();
        bateria.release();
    }
}