import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.StringJoiner;

public class List {

     // Insereaza inaintea fiecarui element par din lista simplu inlantuita dublul sau.

    public static void insertDoubleBeforeEvens(LinkedList<Integer> list) {
        ListIterator<Integer> iterator = list.listIterator();

        while (iterator.hasNext()) {
            Integer current = iterator.next();
            if (current % 2 == 0) {
                // Inseram dublul inaintea elementului par
                iterator.previous(); // Revenim la pozitia anterioara
                iterator.add(current * 2);
                iterator.next(); // Ne mutam inapoi la elementul original
            }
        }
    }

    // Afisam elementele listei intr-un format usor de citit.

    public static void displayList(LinkedList<Integer> list) {
        if (list.isEmpty()) {
            System.out.println("Lista este goala!");
            return;
        }
        StringJoiner joiner = new StringJoiner(" -> ");
        list.forEach(num -> joiner.add(num.toString()));
        System.out.println(joiner);
    }

        public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti elementele listei (numere intregi). Introduceti 'stop' pentru a termina:");

        while (true) {
            System.out.print("Element: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("stop")) {
                break;
            }
            try {
                int number = Integer.parseInt(input);
                list.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Te rog sa introduci un numar intreg sau 'stop' pentru a termina.");
            }
        }
        System.out.println("\nLista initiala:");
        displayList(list);

        insertDoubleBeforeEvens(list);

        System.out.println("\nLista dupa inserarea dublurilor elementelor pare:");
        displayList(list);
        scanner.close();
    }
}
