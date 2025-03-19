import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class PizzaOrderQueue {
    private Queue<String> pizzaOrders;

    public PizzaOrderQueue() {
        pizzaOrders = new LinkedList<>();
    }

    public void addOrder(String order) {
        pizzaOrders.add(order);
        System.out.println("Order added: " + order);
    }

    private void displayNextOrder() {
        if (!pizzaOrders.isEmpty()) {
            System.out.println("Next order: " + pizzaOrders.peek());
        } else {
            System.out.println("No orders in the queue.");
        }
    }

    private String processOrder() {
        if (!pizzaOrders.isEmpty()) {
            return pizzaOrders.poll();
        }
        return null;
    }

    private void removeAllOrders() {
        pizzaOrders.clear();
        System.out.println("All orders removed from the queue.");
    }

    private boolean isQueueEmpty() {
        return pizzaOrders.isEmpty();
    }

    public void handleQueue() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Choose what you want to do with pizza orders:");
                System.out.println("1. Add an order");
                System.out.println("2. Display the next order");
                System.out.println("3. Process an order");
                System.out.println("4. Remove all orders");
                System.out.println("5. Check if the queue is empty");
                System.out.println("Enter your choice (1 - 5)");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                switch (choice) {
                    case 1:
                        System.out.println("Enter the order details:");
                        String order = scanner.nextLine();
                        addOrder(order);
                        break;
                    case 2:
                        displayNextOrder();
                        break;
                    case 3:
                        if (!isQueueEmpty()) {
                            System.out.println("Processed order: " + processOrder());
                        } else {
                            System.out.println("No orders in the queue.");
                        }
                        break;
                    case 4:
                        removeAllOrders();
                        break;
                    case 5:
                        if (isQueueEmpty()) {
                            System.out.println("The queue is empty");
                        } else {
                            System.out.println("The queue is not empty");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}    
