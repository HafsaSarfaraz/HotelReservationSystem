public class Room_Type {
    int id;
    String Type;
    String capacity;
    String features;
    double price;
    boolean isBooked;  // New field to track the booking status

    public Room_Type(int id, String Type, String capacity, String features, double price) {
        this.id = id;
        this.Type = Type;
        this.capacity = capacity;
        this.features = features;
        this.price = price;
        this.isBooked = false;  // By default, the room is not booked
    }

    @Override
    public String toString() {
        if (isBooked) {
            return "Room " + id + " (" + Type + ") is already booked.";
        } else {
            return "ID: " + id + "\nType: " + Type + "\nCapacity: " + capacity +
                    "\nFeatures: " + features + "\nPrice: " + price;
        }
    }
}
