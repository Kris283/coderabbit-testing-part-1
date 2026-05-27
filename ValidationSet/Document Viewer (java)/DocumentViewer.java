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
            System.out.println("Failed to setup files: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================================");
        System.out.println("   Employee Document Viewer              ");
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
        try {
            File baseDir = new File("demo_docs/");
            
            File requestedFile = new File(baseDir, filename);

            String canonicalBase = baseDir.getCanonicalPath();
            String canonicalRequested = requestedFile.getCanonicalPath();

            if (!canonicalRequested.startsWith(canonicalBase)) {
                System.out.println("\n[!] SECURITY VIOLATION: Path Traversal Attempt Detected!");
                System.out.println("Access denied to path outside of intended directory.");
                return; 
            }

            try (BufferedReader br = new BufferedReader(new FileReader(requestedFile))) {
                String line;
                System.out.println("\n--- Document Contents (" + requestedFile.getName() + ") ---");
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                System.out.println("----------------------------------------");
            } catch (FileNotFoundException e) {
                System.out.println("Error: Document not found.");
            }

        } catch (IOException e) {
            System.out.println("Error processing the file path.");
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