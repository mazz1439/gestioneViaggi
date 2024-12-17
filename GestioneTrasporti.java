class GestioneTrasporti implements Runnable {
    private String gruppo;
    private Bus bus;
    private RivenditoreBiglietti rivenditore;
    private Traghetto traghetto;
    private StringBuilder log;

    public GestioneTrasporti(String gruppo, Bus bus, RivenditoreBiglietti rivenditore, Traghetto traghetto, StringBuilder log) {
        this.gruppo = gruppo;
        this.bus = bus;
        this.rivenditore = rivenditore;
        this.traghetto = traghetto;
        this.log = log;
    }

    @Override
    public void run() {
        synchronized (log) {
            log.append("Partenza dagli alloggi del gruppo: ").append(gruppo).append("\n");
            System.out.println("Partenza dagli alloggi del gruppo: " + gruppo);

            try {
                Thread.sleep(2000); // Simula il tempo del viaggio in autobus
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            log.append("Arrivo al porto del gruppo: ").append(gruppo).append("\n");
            System.out.println("Arrivo al porto del gruppo: " + gruppo);

            rivenditore.vendiBiglietti(gruppo, log);
            traghetto.trasporta(gruppo, log);
        }
    }
}
