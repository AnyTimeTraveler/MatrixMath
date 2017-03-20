import calculations.IMathOperation;

/**
 * Created by simon on 20.03.17.
 */
public class MatrixMath {
    private static IMathOperation[] operations = {};

    public static void main(String[] args) {
        System.out.println("Welcome to the simple math calculator!");
        while (true) {
            System.out.println();
            for (int i = 0; i < operations.length; i++) {
                System.out.println("[" + (i + 1) + "] " + operations[i].getName());
                System.out.println("\t" + operations[i].getDescription().replaceAll("\n", "\n\t"));
            }
            System.out.println("[" + (operations.length + 1) + "] Exit");
            int selection = UserInput.getInteger("Please select an action: ");
            if (selection == operations.length + 1)
                return;
            operations[selection - 1].execute();
        }
    }
}
