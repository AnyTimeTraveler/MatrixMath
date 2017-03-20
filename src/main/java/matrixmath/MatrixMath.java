package matrixmath;

import matrixmath.calculations.IMathOperation;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author simon
 * Created on 20.03.17
 */
public class MatrixMath {

    public static void main(String[] args) {

        List<IMathOperation> operations = getOperations();

        System.out.println("Welcome to the simple math calculator!");
        while (true) {
            System.out.println();
            for (int i = 0; i < operations.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + operations.get(i).getName());
                System.out.println("\t" + operations.get(i).getDescription().replaceAll("\n", "\n\t"));
            }
            System.out.println("[" + (operations.size() + 1) + "] Exit");
            int selection = UserInput.getInteger("Please select an action: ");
            if (selection == operations.size() + 1)
                return;
            operations.get(selection - 1).execute();
        }
    }

    private static List<IMathOperation> getOperations() {
        List<IMathOperation> operations = new ArrayList<>();

        Reflections calculationsReflector = new Reflections("matrixmath.calculations");
        Set<Class<? extends IMathOperation>> classes = calculationsReflector.getSubTypesOf(IMathOperation.class);

        classes.forEach(clazz -> {
            try {
                operations.add(clazz.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        return operations;
    }
}
