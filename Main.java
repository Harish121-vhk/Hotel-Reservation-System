import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Room> rooms = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Adding sample rooms to the hotel
        addRooms();

        boolean running = true;

        while (running) {
            // Displaying the main menu to the user
            System.out.println("\nHotel Reservation System");
            System.out.println("1. Search for Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    searchAvailableRooms();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    viewBookingDetails();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Adds sample rooms to the system
    private static void addRooms() {
        rooms.add(new Room(101, "Single", 100.0));
        rooms.add(new Room(102, "Single", 120.0));
        rooms.add(new Room(201, "Double", 150.0));
        rooms.add(new Room(202, "Double", 170.0));
        rooms.add(new Room(301, "Suite", 250.0));
    }

    // Searches for available rooms based on category input
    private static void searchAvailableRooms() {
        System.out.print("\nEnter room category (Single/Double/Suite): ");
        String category = scanner.nextLine();

        boolean found = false;
        for (Room room : rooms) {
            if (room.isAvailable() && room.getCategory().equalsIgnoreCase(category)) {
                System.out.println("Room Number: " + room.getRoomNumber() + " | Price: $" + room.getPrice());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available rooms found for the category: " + category);
        }
    }

    // Makes a reservation for a room
    private static void makeReservation() {
        System.out.print("\nEnter guest name: ");
        String guestName = scanner.nextLine();
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter check-in date (YYYY-MM-DD): ");
        String checkInDate = scanner.nextLine();
        System.out.print("Enter check-out date (YYYY-MM-DD): ");
        String checkOutDate = scanner.nextLine();

        Room roomToReserve = null;
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                roomToReserve = room;
                break;
            }
        }

        if (roomToReserve == null) {
            System.out.println("Room is not available or invalid room number.");
            return;
        }

        double totalAmount = roomToReserve.getPrice();
        System.out.print("Total Amount: $" + totalAmount + ". Enter payment amount: ");
        double paymentAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (paymentAmount < totalAmount) {
            System.out.println("Payment is insufficient. Reservation not made.");
            return;
        }

        // Process payment (basic validation)
        if (paymentAmount >= totalAmount) {
            System.out.println("Payment successful! Reserving room...");
            roomToReserve.bookRoom();
            Reservation reservation = new Reservation(guestName, roomToReserve, checkInDate, checkOutDate, paymentAmount);
            reservations.add(reservation);

            System.out.println("Reservation confirmed!");
            reservation.viewReservationDetails();
        }
    }

    // View reservation details for a guest
    private static void viewBookingDetails() {
        System.out.print("\nEnter guest name to view booking details: ");
        String guestName = scanner.nextLine();

        boolean found = false;
        for (Reservation reservation : reservations) {
            if (reservation.getGuestName().equalsIgnoreCase(guestName)) {
                reservation.viewReservationDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No booking found for the guest: " + guestName);
        }
    }
}
