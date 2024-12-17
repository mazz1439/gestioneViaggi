
import java.io.*;
import java.util.*;

public class AgenziaViaggi {
    public static void main(String[] args) throws IOException {
        ArrayList<GestioneTrasporti> gestoreTrasportiList = new ArrayList<>();

        Bus b1 = new Bus("AB123AA");
        Bus b2 = new Bus("AB123BB");
        Bus b3 = new Bus("AB123CC");

        RivenditoreBiglietti rv1 = new RivenditoreBiglietti("Lorenzo");
        RivenditoreBiglietti rv2 = new RivenditoreBiglietti("Giovanni");
        RivenditoreBiglietti rv3 = new RivenditoreBiglietti("Maria");

        Traghetto t = new Traghetto("TG344FF");
        StringBuilder s = new StringBuilder();

        gestoreTrasportiList.add(new GestioneTrasporti("francesi", b1, rv1, t, s));
        gestoreTrasportiList.add(new GestioneTrasporti("tedeschi", b2, rv2, t, s));
        gestoreTrasportiList.add(new GestioneTrasporti("spagnoli", b3, rv3, t, s));

        ArrayList<Thread> gestoreThreadsThreadList = new ArrayList<>();
        for (GestioneTrasporti gt : gestoreTrasportiList) {
            Thread n = new Thread(gt);
            gestoreThreadsThreadList.add(n);
            n.start();
        }

        for (Thread tThread : gestoreThreadsThreadList) {
            try {
                tThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("viaggi_effettuati.txt"))) {
            writer.write("Data: " + new Date() + "\n");
            writer.write(s.toString());
        }

        System.out.println("Simulazione completata. ");
    }
}