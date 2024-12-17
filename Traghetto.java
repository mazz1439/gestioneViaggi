class Traghetto {
    private String codice;
    private boolean disponibile = true;

    public Traghetto(String codice) {
        this.codice = codice;
    }

    public synchronized void trasporta(String gruppo, StringBuilder log) {
        while (!disponibile) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        disponibile = false;
        log.append("Imbarco sul traghetto del gruppo: ").append(gruppo).append("\n");
        System.out.println("Imbarco sul traghetto del gruppo: " + gruppo);

        log.append("Partenza dal porto del gruppo: ").append(gruppo).append("\n");
        System.out.println("Partenza dal porto del gruppo: " + gruppo);

        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.append("Ritorno al porto del traghetto\n");
        System.out.println("Ritorno al porto del traghetto");

        disponibile = true;
        notifyAll();
    }

    public String getCodice() {
        return codice;
    }
}