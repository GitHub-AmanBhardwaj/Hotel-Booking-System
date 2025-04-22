import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelBookingSystem {
    private static List<Booking> bookings = new ArrayList<>();
    private static int bookingCounter = 0;
    private static Scanner scanner = new Scanner(System.in);

    static class Booking {
        private String guestId;
        private String guestName;
        private String roomType;
        private String roomId;

        public Booking(String guestId, String guestName, String roomType, String roomId) {
            this.guestId = guestId;
            this.guestName = guestName;
            this.roomType = roomType;
            this.roomId = roomId;
        }

        public String getGuestId() { return guestId; }
        public String getGuestName() { return guestName; }
        public String getRoomType() { return roomType; }
        public String getRoomId() { return roomId; }
    }

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    bookRoom();
                    break;
                case 2:
                    deleteBooking();
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    System.out.println("Thank you for using the Hotel Booking System!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n=== Hotel Booking System ===");
        System.out.println("1. Book a Room");
        System.out.println("2. Delete a Booking");
        System.out.println("3. View All Bookings");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (1-4): ");
    }

    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void bookRoom() {
        System.out.print("Enter Guest ID: ");
        String guestId = scanner.nextLine().trim();

        System.out.print("Enter Guest Name: ");
        String guestName = scanner.nextLine().trim();

        System.out.println("Choose Room Type:");
        System.out.println("1. Single Room");
        System.out.println("2. Double Room");
        System.out.println("3. Suite");
        System.out.print("Enter choice (1-3): ");

        String roomType;
        switch (scanner.nextLine().trim()) {
            case "1":
                roomType = "Single Room";
                break;
            case "2":
                roomType = "Double Room";
                break;
            case "3":
                roomType = "Suite";
                break;
            default:
                System.out.println("Invalid room type! Booking cancelled.");
                return;
        }

        if (guestId.isEmpty() || guestName.isEmpty()) {
            System.out.println("Guest ID and Name cannot be empty!");
            return;
        }

        String roomId = String.format("B%03d", ++bookingCounter);
        bookings.add(new Booking(guestId, guestName, roomType, roomId));
        System.out.println("Booking successful! Room Number: " + roomId);
    }

    private static void deleteBooking() {
        System.out.print("Enter Guest ID to delete booking: ");
        String guestId = scanner.nextLine().trim();

        if (guestId.isEmpty()) {
            System.out.println("Guest ID cannot be empty!");
            return;
        }

        boolean found = false;
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getGuestId().equals(guestId)) {
                bookings.remove(i);
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Booking for Guest ID " + guestId + " deleted successfully!");
        } else {
            System.out.println("No booking found for Guest ID " + guestId);
        }
    }

    private static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        System.out.println("\n=== Booking Summary ===");
        System.out.println("Total Bookings: " + bookings.size());
        System.out.println("Guest ID\tGuest Name\tRoom Type\tRoom No.");
        System.out.println("------------------------------------------------");

        for (Booking booking : bookings) {
            System.out.printf("%-15s%-20s%-15s%s%n",
                booking.getGuestId(),
                booking.getGuestName(),
                booking.getRoomType(),
                booking.getRoomId());
        }
    }
}
