package utils;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import model.Issue;

public class IssueUtil {

    private static Scanner scanner = ScannerUtil.getScanner();

    public static Issue selectIssue(List<Issue> issues) {
        System.out.println("--------------------------- Issues ---------------------------");
        for (var issue : issues) {
            System.out.println(issue);
        }
        System.out.println("-----------------------------------------------------------------");

        while (true) {
            System.out.print("Please select issue ID from this list: ");
            int issueId = scanner.nextInt();
            Optional<Issue> issue = issues.stream().filter(i -> i.getId() == issueId).findFirst();
            if (issue.isPresent()) {
                return issue.get();
            } else {
                System.out.println("Invalid issue ID. Please try again.");
            }
        }
    }
}
