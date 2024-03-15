import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<User> users = new ArrayList<>();
    private static List<Event> events = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Event Management System");
            System.out.println("1. Register User");
            System.out.println("2. Create Event");
            System.out.println("3. List Events");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    createEvent(scanner);
                    break;
                case 3:
                    listEvents();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        User user = new User(name, email);
        users.add(user);
        System.out.println("User registered successfully.");
    }

    private static void createEvent(Scanner scanner) {
        System.out.print("Enter event name: ");
        String name = scanner.nextLine();
        System.out.print("Enter event date (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();
        System.out.print("Enter event location: ");
        String location = scanner.nextLine();
        System.out.print("Enter event description: ");
        String description = scanner.nextLine();
        Event event = new Event(name, dateStr, location, description);
        events.add(event);
        System.out.println("Event created successfully.");
    }

    private static void listEvents() {
        if (events.isEmpty()) {
            System.out.println("No events available.");
        } else {
            System.out.println("Events:");
            for (Event event : events) {
                System.out.println(event.getName() + " - " + event.getDate());
            }
        }
    }
}
