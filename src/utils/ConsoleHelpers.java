package utils;

public class ConsoleHelpers {
    public static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");

            // if Windows
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                // if linux
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }
}
