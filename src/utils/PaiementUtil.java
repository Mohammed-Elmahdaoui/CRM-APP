package utils;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import model.Paiement;

public class PaiementUtil {

    private static Scanner scanner = ScannerUtil.getScanner();

    public static Paiement selectPaiement(List<Paiement> paiements) {
        System.out.println("--------------------------- Paiements ---------------------------");
        for (var paiement : paiements) {
            System.out.println(paiement);
        }
        System.out.println("-----------------------------------------------------------------");

        while (true) {
            System.out.print("Please select paiement ID from this list: ");
            int paiementId = scanner.nextInt();
            Optional<Paiement> paiement = paiements.stream().filter(i -> i.getId() == paiementId).findFirst();
            if (paiement.isPresent()) {
                return paiement.get();
            } else {
                System.out.println("Invalid paiement ID. Please try again.");
            }
        }
    }
}
