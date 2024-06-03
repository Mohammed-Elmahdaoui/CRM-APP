import controller.CRMController;
import view.CRMView;

public class Main {
    public static void main(String[] args) {
        CRMController controller = new CRMController();
        CRMView view = new CRMView(controller);
        view.displayMenu();
    }
}
