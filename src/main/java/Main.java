import mvc.controller.CalculatorController;
import mvc.view.CalculatorView;

public class Main {
    public static void main(String[] args) {

        // Initilizam view-ul
        CalculatorView view = new CalculatorView();

        // Initializam controller-ul, al carui constructor primeste ca parametru view-ul
        CalculatorController controller = new CalculatorController(view);
    }
}
