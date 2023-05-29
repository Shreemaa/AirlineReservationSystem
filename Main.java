import java.util.Scanner;

// Class representing the Airline Reservation System
class AirlineReservationSystem {
    private final boolean[] seats;
    private final int totalSeats;

    // Constructor to initialize the system with total seats
    public AirlineReservationSystem(int totalSeats) {
        this.totalSeats = totalSeats;
        seats = new boolean[totalSeats];
    }

    // Method to reserve a seat
    public void reserveSeat() {
        int seatNumber = -1;
        for (int i = 0; i < totalSeats; i++) {
            if (!seats[i]) {
                seatNumber = i;
                seats[i] = true; // Marking the seat as reserved
                break;
            }
        }

        if (seatNumber != -1) {
            System.out.println("Seat number " + seatNumber + " reserved successfully.");
        } else {
            System.out.println("Sorry, no seats available.");
        }
    }

    // Method to display the seat map
    public void displaySeatMap() {
        System.out.println("Seat Map:");
        for (int i = 0; i < totalSeats; i++) {
            if (seats[i]) {
                System.out.println("Seat number " + i + ": Reserved");
            } else {
                System.out.println("Seat number " + i + ": Available");
            }
        }
    }
}

// Main class to handle user interaction
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total number of seats: ");
        int totalSeats = scanner.nextInt();

        AirlineReservationSystem reservationSystem = new AirlineReservationSystem(totalSeats);

        while (true) {
            System.out.println("1. Reserve a seat");
            System.out.println("2. Display seat map");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> reservationSystem.reserveSeat();
                case 2 -> reservationSystem.displaySeatMap();
                case 3 -> {
                    System.out.println("Thank you for using the Airline Reservation System. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
