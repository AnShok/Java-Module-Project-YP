import java.util.Scanner;
public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfGuests;

        while (true) {
            System.out.println("На скольких человек необходимо разделить счёт.: ");
            if (scanner.hasNextInt()) {
                numberOfGuests = scanner.nextInt();
                if (numberOfGuests == 1) {
                    System.out.println("Нет смысла делить, вы пришли одни. Повторите попытку.");
                } else if (numberOfGuests < 1) {
                    System.out.println("Некорректное значение для подсчета. Повторите попытку.");
                } else {
                    break;
                }
            } else {
                System.out.println("Введено не число. Повторите попытку.");
                scanner.next();
            }
        }

        Calculator calculator = new Calculator();
        calculator.run();

        double totalCost = calculator.getTotalCost();
        double costPerGuest = Math.round(totalCost / numberOfGuests * 100.0) / 100.0;
        String formattedTotalCost = Formatter.formatTotalCost(costPerGuest);
        System.out.println("Каждый гость должен заплатить: " + formattedTotalCost);
    }
}
