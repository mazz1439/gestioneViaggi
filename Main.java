
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] gruppi = {"Francesi", "Tedeschi", "Spagnoli"};
        List<String> registroViaggi = Collections.synchronizedList(new ArrayList<>());

        // Creazione di un thread per ogni gruppo
        for (String gruppo : gruppi) {
            new Thread(new Gruppo(gruppo, registroViaggi)).start();
        }

        // Attesa per completare tutti i viaggi
        while (registroViaggi.size() < 6) {
            try {
                Thread.sleep(500); // Aspetta per sincronizzare il registro
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Salvataggio del registro su file
        Main.salvaRegistroSuFile(registroViaggi);
    }
}