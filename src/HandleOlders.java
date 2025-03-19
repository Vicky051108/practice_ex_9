import java.util.ArrayList;
import java.util.Scanner;

class HandleOrders {
    private ArrayList<CustomPizza> customPizzas;

    public HandleOrders() {
        customPizzas = new ArrayList<>();
    }

    public void handleOrder() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Do you want to order a custom pizza? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                StringBuilder customPizzaToppings = new StringBuilder();
                double customPizzaPrice = 0;
                while (true) {
                    System.out.println("Enter a topping (or 'done' to finish):");
                    String topping = scanner.nextLine();
                    if (topping.equalsIgnoreCase("done")) {
                        break;
                    }
                    customPizzaToppings.append(topping).append(", ");
                    customPizzaPrice += 1.5; // Assume each topping costs $1.5
                }
                if (customPizzaToppings.length() > 0) {
                    customPizzaToppings.delete(customPizzaToppings.length() - 2, customPizzaToppings.length());
                }
                CustomPizza customPizza = new CustomPizza(customPizzaToppings.toString(), customPizzaPrice);
                customPizzas.add(customPizza);
            }
        }
    }

    public void displayCustomPizzas() {
        for (CustomPizza pizza : customPizzas) {
            System.out.println(pizza);
        }
    }

    public static void main(String[] args) {
        HandleOrders handleOrders = new HandleOrders();
        handleOrders.handleOrder();
        handleOrders.displayCustomPizzas();
    }
}    


