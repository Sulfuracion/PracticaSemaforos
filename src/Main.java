public class Main {// Clase principal que inicia la simulación
    public static void main(String[] args) {
        // Crear una instancia de la estación de Marte
        EstacionMarte estacion = new EstacionMarte();

        // Crear e iniciar hilos para cada robot
        for (int i = 0; i < EstacionMarte.NUM_ROBOTS; i++) {
            Robot robot = new Robot(estacion);
            Thread thread = new Thread(robot);
            thread.start();
        }
    }
}

