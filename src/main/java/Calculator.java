import java.util.Scanner;

public class Calculator {
    private final Product[] products;
    private int numProducts;
    private double totalCost;


    public Calculator() {
        products = new Product[100];
        numProducts = 0;
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
        products[numProducts] = product;
        numProducts++;

        System.out.println("Товар успешно добавлен!");
    }

    public void printProducts() {
        if (numProducts == 0) {
            System.out.println("Корзина пуста");
            return;
        }
        System.out.println("Список добавленных товаров:");
        for (int i = 0; i < numProducts; i++) {
            String formattedPrice = Formatter.formatTotalCost(products[i].getPrice());
            System.out.println((i+1) + ". " + products[i].getName() + " - " + formattedPrice);
        }
        String formattedTotalCost = Formatter.formatTotalCost(totalCost);
        System.out.println("Общая стоимость товаров: " + formattedTotalCost);
    }
    public void run() {
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