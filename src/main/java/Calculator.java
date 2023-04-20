import java.util.Scanner;
import java.util.ArrayList;

public class Calculator {
    private final ArrayList<Product> products;
    private double totalCost;


    public Calculator() {
        products = new ArrayList<>();
        totalCost = 0;
    }

    public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название товара: ");
        String name = scanner.nextLine();

        double price;
        while (true) {
            System.out.print("Введите стоимость товара (в формате рубли,копейки): ");
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                if (price <= 0) {
                    System.out.println("Стоимость не может быть отрицательной или равна нулю, повторите ввод.");
                } else {
                    break;
                }
            } else {
                System.out.println("Не введена стоимость, повторите ввод.");
                scanner.next();
            }
        }

        Product product = new Product(name, price);
        totalCost += price;
        products.add(product);

        System.out.println("Товар успешно добавлен!");
    }

    public void printProducts() {
        if (products.size() == 0) {
            System.out.println("Корзина пуста");
            return;
        }
        System.out.println("Список добавленных товаров:");
        for (int i = 0; i < products.size(); i++) {
            String formattedPrice = Formatter.formatTotalCost(products.get(i).getPrice());
            System.out.println((i+1) + ". " + products.get(i).getName() + " - " + formattedPrice);
        }
        String formattedTotalCost = Formatter.formatTotalCost(totalCost);
        System.out.println("Общая стоимость товаров: " + formattedTotalCost);
    }
    public void makeBasketProducts() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Хотите добавить товар? (Введите Да или Завершить): ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("Да")) {
                addProduct();
            } else if (answer.equalsIgnoreCase("Завершить")) {
                break;
            } else {
                System.out.println("Неверный ответ. Попробуйте ещё раз.");
            }
        }
        printProducts();
    }

    public double getTotalCost() {

        return totalCost;
    }
}