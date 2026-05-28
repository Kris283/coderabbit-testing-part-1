import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class DocumentViewer {

    public static void main(String[] args) {
        try {
            setupDemoEnvironment();
        } catch (IOException e) {
            System.out.println("Failed to setup demo files: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================================");
        System.out.println("   Employee Document Viewer (Demo)       ");
        System.out.println("=========================================");
        System.out.println("Available documents: policy.txt, menu.txt");
        System.out.println("Type 'exit' to quit.");

        while (true) {
            System.out.print("\nEnter document name to read: ");
            String filename = scanner.nextLine();

            if (filename.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }

            readDocument(filename);
        }

        scanner.close();
    }

    private static void readDocument(String filename) {
        // VULNERABILITY: Concatenating unsanitized user input directly into a file path.
        String baseDirectory = "demo_docs/";
        File file = new File(baseDirectory + filename);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("\n--- Document Contents (" + file.getName() + ") ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("----------------------------------------");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Document not found.");
        } catch (IOException e) {
            System.out.println("Error reading the document.");
        }
    }

    // Helper method to create some files so you can test the system immediately
    private static void setupDemoEnvironment() throws IOException {
        Files.createDirectories(Paths.get("demo_docs"));
        
        // Safe files inside the designated directory
        Files.write(Paths.get("demo_docs/policy.txt"), "Company Policy: Always wear your ID badge.".getBytes());
        Files.write(Paths.get("demo_docs/menu.txt"), "Cafeteria Menu: Pizza on Fridays.".getBytes());
        
        // Sensitive file OUTSIDE the designated directory
        Files.write(Paths.get("secret_passwords.txt"), "Admin Password: super_secret_admin_123!\nDatabase: db_admin_999".getBytes());
    }
}