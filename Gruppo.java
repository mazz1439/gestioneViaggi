
import java.util.*;

class Gruppo implements Runnable {

    private final String nomeGruppo;
    private final List<String> registroViaggi;

    public Gruppo(String nomeGruppo, List<String> registroViaggi) {
        this.nomeGruppo = nomeGruppo;
        this.registroViaggi = registroViaggi;
    }

    @Override
    public void run() {
        try {
            // Partenza dagli alloggi
            notifyEvent("Partenza dagli alloggi");
            Thread.sleep(1000);

            // Arrivo al porto
            notifyEvent("Arrivo al porto");
            Thread.sleep(1000);

            // Pagamento del biglietto
            notifyEvent("Pagamento del biglietto");
            Thread.sleep(1000);

            // Imbarco sul traghetto
            synchronized (registroViaggi) {
                notifyEvent("Imbarco sul traghetto");
                Thread.sleep(1000);

                // Partenza dal porto
                notifyEvent("Partenza dal porto");
                Thread.sleep(2000); // Simula il viaggio verso l'isola

                // Ritorno al porto
                notifyEvent("Ritorno al porto");
                registroViaggi.add(nomeGruppo + " hanno completato il viaggio.");
            }
        } catch (InterruptedException e) {
            System.err.println(nomeGruppo + ": Interrotto durante l'esecuzione.");
        }
    }

    private void notifyEvent(String event) {
        System.out.println(nomeGruppo + ": " + event);
    }
}
