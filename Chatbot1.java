import java.util.ArrayList;
import java.util.Scanner;


class MenuItem {
   private String name;
   private double price;
   private int calories;


   public MenuItem(String name, double price, int calories) {
       this.name = name;
       this.price = price;
       this.calories = calories;
   }


   public String getName() {
       return name;
   }


   public double getPrice() {
       return price;
   }


   public int getCalories() {
       return calories;
   }


   @Override
   public String toString() {
       return String.format("%-30s $%.2f  (%d Cal)", name, price, calories);
   }
}


public class Chatbot1 {
   private ArrayList<MenuItem> menu;
   private Scanner scanner;


   public Chatbot1() {
       scanner = new Scanner(System.in);
       menu = new ArrayList<>();
       menu.add(new MenuItem("Soft Taco", 1.79, 180));
       menu.add(new MenuItem("Crunchy Taco", 1.79, 170));
       menu.add(new MenuItem("Cheesy Gordita Crunch", 5.19, 490));
       menu.add(new MenuItem("Chalupa Supreme", 5.19, 360));
       menu.add(new MenuItem("Cheesy Bean and Rice Burrito", 1.39, 420));
       menu.add(new MenuItem("Chicken Quesadilla", 5.19, 520));
       menu.add(new MenuItem("Spicy Potato Soft Taco", 1.29, 240));
       menu.add(new MenuItem("Crunchwrap Supreme", 5.59, 540));
       menu.add(new MenuItem("Beefy 5-Layer Burrito", 3.99, 490));
       menu.add(new MenuItem("Nachos BellGrande", 6.19, 740));
       menu.add(new MenuItem("Cinnamon Twists", 1.49, 170));
   }


   public void startChat() {
       System.out.println("Hello, and welcome to Pleasanton’s finest Taco Bell!");
       System.out.println("I’m your friendly assistant. Type 'menu' to see our delicious offerings, 'order' to place an order, or 'bye' to leave.");
       System.out.println("I’ll guide you every step of the way. Let's get started!");


       while (true) {
           System.out.print("User: ");
           String userInput = scanner.nextLine().trim();


           if (userInput.equalsIgnoreCase("bye") || userInput.equalsIgnoreCase("quit") || userInput.equalsIgnoreCase("exit")) {
               System.out.println("TacoBell: It was great chatting with you! Have a taco-tastic day!");
               break;
           } else {
               respond(userInput);
           }
       }
   }


   private void displayMenu() {
       System.out.println("TacoBell: Here's our menu:");
       System.out.println("---------------------------------------------------");
       for (MenuItem item : menu) {
           System.out.println(item);
       }
       System.out.println("---------------------------------------------------");
       System.out.println("TacoBell: When you're ready to order, just type 'order'.");
   }


   private void handleOrder() {
       ArrayList<MenuItem> order = new ArrayList<>();
       double totalCost = 0;


       System.out.println("TacoBell: What would you like to order? You can enter multiple items separated by commas.");
       System.out.println("For example: Soft Taco, Crunchy Taco, Nachos BellGrande");
       String orderInput = scanner.nextLine().trim();
       String[] items = orderInput.split(",");


       for (String itemName : items) {
           boolean found = false;
           for (MenuItem item : menu) {
               if (itemName.trim().equalsIgnoreCase(item.getName())) {
                   order.add(item);
                   totalCost += item.getPrice();
                   found = true;
                   break;
               }
           }
           if (!found) {
               System.out.println("TacoBell: Sorry, we don't have \"" + itemName.trim() + "\" on the menu.");
           }
       }


       if (order.isEmpty()) {
           System.out.println("TacoBell: It seems like you didn't order anything valid. Please try again.");
       } else {
           System.out.println("TacoBell: Here's a summary of your order:");
           for (MenuItem item : order) {
               System.out.println(" - " + item.getName() + ": $" + item.getPrice());
           }
           System.out.printf("TacoBell: Your total is $%.2f. Your order will be ready in 15 - 30 minutes!\n", totalCost);
           System.out.println("To exit the bot, please type exit. To talk to a live representative please call 341-758-(4903)");
       }
   }


   private void respond(String input) {
       if (input.toLowerCase().contains("hello") || input.toLowerCase().contains("hi") || input.toLowerCase().contains("hey")) {
           System.out.println("TacoBell: Hi there! How can I make your day more delicious?");
       } else if (input.toLowerCase().contains("menu")) {
           displayMenu();
       } else if (input.toLowerCase().contains("order")) {
           handleOrder();
       } else if (input.toLowerCase().contains("don't want") || input.toLowerCase().contains("do not want")) {
           System.out.println("TacoBell: No problem! If you'd like to exit, just type 'exit'.");
       } else {
           System.out.println(randomResponse());
       }
   }


   private String randomResponse() {
       String[] responses = {
           "TacoBell: I'm not sure I understand. Try typing 'menu' or 'order'.",
           "TacoBell: Hmm, could you say that differently? I can show you the menu or take an order.",
           "TacoBell: Oops, I didn’t catch that. Type 'menu' to see our offerings or 'order' to start ordering.",
           "TacoBell: Sorry, I'm only trained to help with menu and orders. Type 'menu' to check out the options!"
       };
       return responses[(int) (Math.random() * responses.length)];
   }


   public static void main(String[] args) {
       Chatbot1 chatbot = new Chatbot1();
       chatbot.startChat();
   }
}



