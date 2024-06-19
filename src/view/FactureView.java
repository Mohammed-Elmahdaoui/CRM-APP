package view;

import java.util.List;
import java.util.Scanner;
import model.Facture;

public class FactureView {
    private List<Facture> factures;
    private Scanner scanner;

    public FactureView(List<Facture> factures, Scanner scanner) {
        this.factures = factures;
        this.scanner = scanner;
    }

    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Facture Menu:");
            System.out.println("1. Create Facture");
            System.out.println("2. View Factures");
            System.out.println("3. Update Facture");
            System.out.println("4. Delete Facture");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    createFacture();
                    break;
                case 2:
                    viewFactures();
                    break;
                case 3:
                    updateFacture();
                    break;
                case 4:
                    deleteFacture();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void createFacture() {
        System.out.print("Enter facture ID: ");
        int idFacture = scanner.nextInt();
        System.out.print("Enter client ID: ");
        int idClient = scanner.nextInt();
        System.out.print("Enter commande ID: ");
        int idCommande = scanner.nextInt();

        factures.add(new Facture(idFacture, idClient, idCommande));
        System.out.println("Facture created.");
    }

    private void viewFactures() {
        System.out.println("Factures:");
        for (Facture facture : factures) {
            System.out.println(facture);
        }
    }

    private void updateFacture() {
        System.out.print("Enter facture ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (Facture facture : factures) {
            if (facture.getIdFacture() == id) {
                System.out.print("Enter new client ID: ");
                facture.setIdClient(scanner.nextInt());
                System.out.print("Enter new commande ID: ");
                facture.setIdCommande(scanner.nextInt());
                System.out.println("Facture updated.");
                return;
            }
        }
        System.out.println("Facture not found.");
    }

    private void deleteFacture() {
        System.out.print("Enter facture ID to delete: ");
        int id = scanner.nextInt();

        factures.removeIf(facture -> facture.getIdFacture() == id);
        System.out.println("Facture deleted.");
    }
}

