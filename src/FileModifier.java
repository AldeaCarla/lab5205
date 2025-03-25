import java.io.*;

public class FileModifier {
    public static void main(String[] args) {
        String inputFile = "in.txt";
        String outputFile = "out.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            StringBuilder modifiedA = new StringBuilder();
            StringBuilder modifiedB = new StringBuilder();


            while ((line = reader.readLine()) != null) {
                modifiedA.append(line).append("\n\n");  // a) Adăugăm newline suplimentar
                modifiedB.append(line.replace(".", ".\n")).append("\n");
            }


            writer.write(modifiedA.toString());
            writer.write("\n" + "-".repeat(50) + "\n\n"); // Separator între variante
            writer.write(modifiedB.toString());

            System.out.println("Modificările au fost salvate în " + outputFile);

        } catch (IOException e) {
            System.err.println("Eroare la citire/scriere: " + e.getMessage());
        }

        System.out.println("\nConținutul fișierului 'in.txt':");
        citesteFisier(inputFile);
        System.out.println("\nConținutul fișierului 'out.txt':");
        citesteFisier(outputFile);
    }


    private static void citesteFisier(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea fișierului " + filePath + ": " + e.getMessage());
        }
    }
}
