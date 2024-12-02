public class Room {
    private int roomNumber;
    private String category;
    private boolean available;
    private double price;

    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.available = true; // Rooms are available by default
        this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    // Mark room as booked
    public void bookRoom() {
        this.available = false;
    }

    // Cancel the booking and mark room as available
    public void cancelBooking() {
        this.available = true;
    }
}

