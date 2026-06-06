import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    String category;
    boolean booked;
    String customerName;

    Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.booked = false;
        this.customerName = "";
    }
}

public class HotelReservationSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Deluxe"));
        rooms.add(new Room(103, "Suite"));

        while (true) {

            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Booking Details");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewRooms();
                    break;

                case 2:
                    bookRoom();
                    break;

                case 3:
                    cancelBooking();
                    break;

                case 4:
                    viewBookings();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static void viewRooms() {

        System.out.println("\nAvailable Rooms:");

        for (Room room : rooms) {

            String status = room.booked ? "Booked" : "Available";

            System.out.println(
                    "Room " + room.roomNumber +
                    " | " + room.category +
                    " | " + status);
        }
    }

    static void bookRoom() {

        System.out.print("Enter Room Number: ");
        int roomNo = sc.nextInt();
        sc.nextLine();

        for (Room room : rooms) {

            if (room.roomNumber == roomNo) {

                if (room.booked) {
                    System.out.println("Room already booked!");
                    return;
                }

                System.out.print("Enter Customer Name: ");
                String name = sc.nextLine();

                room.booked = true;
                room.customerName = name;

                System.out.println("Payment Successful!");
                System.out.println("Room Booked Successfully!");

                return;
            }
        }

        System.out.println("Room not found!");
    }

    static void cancelBooking() {

        System.out.print("Enter Room Number: ");
        int roomNo = sc.nextInt();

        for (Room room : rooms) {

            if (room.roomNumber == roomNo) {

                if (!room.booked) {
                    System.out.println("Room is not booked.");
                    return;
                }

                room.booked = false;
                room.customerName = "";

                System.out.println("Booking Cancelled!");
                return;
            }
        }

        System.out.println("Room not found!");
    }

    static void viewBookings() {

        System.out.println("\n===== BOOKING DETAILS =====");

        for (Room room : rooms) {

            if (room.booked) {

                System.out.println(
                        "Room: " + room.roomNumber +
                        " | Category: " + room.category +
                        " | Customer: " + room.customerName);
            }
        }
    }
}