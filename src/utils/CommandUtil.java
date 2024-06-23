package utils;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import model.Command;

public class CommandUtil {

    private static Scanner scanner = ScannerUtil.getScanner();

    public static Command selectCommand(List<Command> commands) {
        System.out.println("--------------------------- Commands ---------------------------");
        for (var command : commands) {
            System.out.println(command);
        }
        System.out.println("-----------------------------------------------------------------");

        while (true) {
            System.out.print("Please select command ID from this list: ");
            int commandId = scanner.nextInt();
            Optional<Command> command = commands.stream().filter(i -> i.getId() == commandId).findFirst();
            if (command.isPresent()) {
                return command.get();
            } else {
                System.out.println("Invalid command ID. Please try again.");
            }
        }
    }
}
