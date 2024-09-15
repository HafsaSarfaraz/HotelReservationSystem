import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Room_Type> roomTypes = new ArrayList<>();
        ArrayList<Boolean> paymentStatus = new ArrayList<>();
        paymentStatus.add(false);

        System.out.println("Welcome to Hotel Reservation System");

        // Adding room types
        Room_Type r1 = new Room_Type(1, "Standard", "Single Person", "Wifi Available", 23000);
        Room_Type r2 = new Room_Type(2, "Deluxe", "Family", "Wifi Available", 45000);
        Room_Type r3 = new Room_Type(3, "Suite", "Double", "Wifi Available and Air Conditioning", 30000);
        roomTypes.add(r1);
        roomTypes.add(r2);
        roomTypes.add(r3);

        while (true) {
            System.out.println("\n1- See Available Rooms \n2- Exit");
            int input = sc.nextInt();
            sc.nextLine();  // Consuming the newline left after nextInt()

            if (input == 1) {
                // Display available rooms
                for (Room_Type room : roomTypes) {
                    System.out.println("----------------------------------------------------");
                    System.out.println(room.toString());
                }

                System.out.println("Do you want to make a reservation (YES/NO)?");
                String choice = sc.nextLine();

                if (choice.equalsIgnoreCase("Yes")) {
                    System.out.println("Select the room by their ID:");
                    int id = sc.nextInt();
                    sc.nextLine();  // Consume newline

                    // Find the room by ID
                    Room_Type selectedRoom = null;
                    for (Room_Type room : roomTypes) {
                        if (room.id == id) {
                            selectedRoom = room;
                            break;
                        }
                    }

                    if (selectedRoom != null) {
                        if (selectedRoom.isBooked) {
                            System.out.println("Sorry, the room is already booked.");
                        } else {
                            System.out.println("Enter Check-in Date (DD/MM/YYYY): ");
                            String checkin = sc.nextLine();
                            System.out.println("Enter Check-out Date (DD/MM/YYYY): ");
                            String checkout = sc.nextLine();
                            System.out.println("Enter Your Name: ");
                            String name = sc.nextLine();
                            System.out.println("Enter Your Contact No: ");
                            String contactNo = sc.nextLine();

                            // Display reservation details
                            System.out.println("Room of ID " + selectedRoom.id + " is reserved.");
                            System.out.println("Reservation Details:");
                            System.out.println("Room Type: " + selectedRoom.Type);
                            System.out.println("Check-In Date: " + checkin);
                            System.out.println("Check-Out Date: " + checkout);
                            System.out.println("Total Price: " + selectedRoom.price);

                            // Payment processing
                            System.out.println("Are you paying through credit or debit?");
                            String paymentMethod = sc.nextLine();

                            if (paymentMethod.equalsIgnoreCase("credit")) {
                                System.out.println("Enter your credit card number: ");
                                String creditCardNumber = sc.nextLine();
                                System.out.println("You paid your payment successfully.");
                                paymentStatus.add(true);  // Payment successful
                            } else if (paymentMethod.equalsIgnoreCase("debit")) {
                                System.out.println("Enter your debit card number: ");
                                String debitCardNumber = sc.nextLine();
                                System.out.println("You paid your payment successfully.");
                                paymentStatus.add(true);  // Payment successful
                            } else {
                                System.out.println("Invalid payment method.");
                            }

                            // Mark the room as booked
                            selectedRoom.isBooked = true;
                        }
                    } else {
                        System.out.println("Invalid room ID.");
                    }
                } else if (choice.equalsIgnoreCase("No")) {
                    System.out.println("Returning to main menu.");
                } else {
                    System.out.println("Invalid input.");
                }
            } else if (input == 2) {
                System.out.println("Exiting the system. Thank you!");
                break;
            } else {
                System.out.println("Invalid option. Please select a valid option.");
            }
        }

        sc.close();
    }
}
