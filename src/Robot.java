class Robot implements Runnable {// Clase que representa a un robot
    private static int contador = 1;
    private int id;
    private EstacionMarte estacion;

    // Constructor del robot
    public Robot(EstacionMarte estacion) {
        this.id = contador++;
        this.estacion = estacion;
    }

    // Método que se ejecuta cuando se inicia el hilo del robot
    @Override
    public void run() {
        while (true) {
            try {
                estacion.trabajar(this);
                Thread.sleep(500); // Esperar un tiempo antes de intentar trabajar nuevamente
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Representación en cadena del robot
    @Override
    public String toString() {
        return "Robot " + id;
    }
}