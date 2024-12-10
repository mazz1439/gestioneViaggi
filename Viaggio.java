import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Viaggio {
    public static void salvaRegistroSuFile(List<String> registroViaggi) {
        String nomeFile = "registro_viaggi_" + LocalDate.now() + ".txt";
        try (FileWriter scrittore = new FileWriter(nomeFile)) {
            scrittore.write("Data: " + LocalDate.now() + "\n");
            scrittore.write("Registro Viaggi:\n");
            for (String voce : registroViaggi) {
                scrittore.write(voce + "\n");
            }
            System.out.println("Registro salvato in: " + nomeFile);
        } catch (IOException e) {
            System.err.println("Errore nel salvataggio del file: " + e.getMessage());
        }
    }
}