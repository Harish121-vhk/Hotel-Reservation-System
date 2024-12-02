

public class Reservation {
    private String guestName;
    private Room room;
    private String checkInDate;
    private String checkOutDate;
    private double amountPaid;

    public Reservation(String guestName, Room room, String checkInDate, String checkOutDate, double amountPaid) {
        this.guestName = guestName;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.amountPaid = amountPaid;
    }

    public String getGuestName() {
        return guestName;
    }

    // Method to display the reservation details
    public void viewReservationDetails() {
        System.out.println("\nReservation Details:");
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Number: " + room.getRoomNumber());
        System.out.println("Room Category: " + room.getCategory());
        System.out.println("Check-in Date: " + checkInDate);
        System.out.println("Check-out Date: " + checkOutDate);
        System.out.println("Amount Paid: $" + amountPaid);
    }
}
