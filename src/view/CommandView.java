package view;

import java.util.List;
import java.util.Scanner;

import model.Article;
import model.Command;
import model.Customer;
import utils.DataStore;
import utils.ScannerUtil;
import static utils.ConsoleHelpers.clearScreen;

public class CommandView {
    private final List<Command> commands = DataStore.getCommands();
    private final List<Article> articles = DataStore.getArticles();
    private final List<Customer> customers = DataStore.getCustomers();
    private final Scanner scanner = ScannerUtil.getScanner();

    public CommandView() {}

    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Command Menu:");
            System.out.println("1. Create Command");
            System.out.println("2. View Commands");
            System.out.println("3. Delete Command");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            try {
                int option = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                switch (option) {
                    case 1:
                        createCommand();
                        break;
                    case 2:
                        viewCommands(false);
                        break;
                    case 3:
                        deleteCommand();
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("\uD83D\uDE14 Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("\uD83D\uDE14 Invalid option. Please try again.");
            }
        }
    }

    private void createCommand() {
        System.out.println("########################### - Create a new command - ###########################");
        var command = new Command();

        System.out.println("--------------------------- customers ---------------------------");
        for (var customer : customers) {
            System.out.println(customer);
        }
        System.out.println("-----------------------------------------------------------------");

        while (true) {
            System.out.print("Please select customer ID from this list to create your new command or 'I' to exit:");
            var customerId = scanner.nextLine();

            if (customerId.equals("I") || customerId.equals("i")) {
                System.out.println("\uD83D\uDE2D Operation finished");
                return;
            }

            var customer = customers.stream().filter(i -> i.getId() == Integer.parseInt(customerId)).findFirst();
            if (customer.isPresent()) {
                command.setCustomer(customer.get());
                break;
            } else {
                System.out.println("\uD83D\uDE14 Invalid customer id. Please try again.");
            }
        }

        // This is to prevent an error from occurring when using `scanner.nextInt()` followed by `scanner.nextLine()`
        scanner.nextLine();


        System.out.println("--------------------------- articles ---------------------------");
        for (var article : articles) {
            System.out.println(article);
        }
        System.out.println("-----------------------------------------------------------------");

        while (true) {
            // select article id
            System.out.print("Please select an Article ID or type 'I' to exit the command :");
            var articleId = scanner.nextLine();
            if (articleId.equals("I") || articleId.equals("i")) {
                break;
            }
            var article = articles.stream().filter(i -> i.getId() == Integer.parseInt(articleId)).findFirst();
            if (article.isEmpty()) {
                System.out.println("\uD83D\uDE14 Invalid ID. Please try again.");
                continue;
            }
            command.AddArticle(article.get());
        }

        commands.add(command);
        System.out.println("your new command has been successfully created with id " + command.getId());
        System.out.println("###################################################################################");
    }

    private void viewCommands(boolean inOtherView) {
        clearScreen();
        if (inOtherView) {
            System.out.println("Command List :");
        } else {
            System.out.println("########################### - Command List - ########################");
        }

        for (Command command : commands) {
            System.out.println(command);
        }

        if (commands.isEmpty()) {
            clearScreen();
            System.out.println("\uD83D\uDE2D No command found :");
        }

        if (inOtherView) {
            System.out.println("--------------");
        } else {
            System.out.println("#####################################################################");
        }
    }

    private void deleteCommand() {
        clearScreen();
        System.out.println("########################### - Delete command: - ###########################");
        viewCommands(true);
        System.out.print("Enter command ID to delete or 'I' to exit: ");
        var id = scanner.nextLine();

        if (id.equals("I") || id.equals("i")) {
            System.out.println("\uD83D\uDE2D Operation finished");
            return;
        }

        var result = commands.removeIf(command -> command.getId() == Integer.parseInt(id));
        if (result) {
            clearScreen();
            System.out.println("\uD83D\uDE00 Command deleted.");
        } else {
            System.out.printf("\uD83D\uDE14 Command not found with this ID {%s}.%n", id);
        }
        System.out.println("###########################################################################");
    }
}
