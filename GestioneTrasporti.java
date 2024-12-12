

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
            log.append("Gestione del gruppo: ").append(gruppo).append("\n");
            log.append("Bus utilizzato: ").append(bus.getTarga()).append("\n");
            log.append("Rivenditore biglietti: ").append(rivenditore.getNome()).append("\n");
            log.append("Traghetto utilizzato: ").append(traghetto.getCodice()).append("\n\n");

            System.out.println(log.toString());
            log.setLength(0); // Pulisce il log per il prossimo gruppo
        }
    }
}