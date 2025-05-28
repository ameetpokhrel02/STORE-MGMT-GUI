public class Store {
    // It declare private attributes for store class
    private int storeId;
    private String storeName; 
    private String location; 
    private String openingHour; 
    private double totalSales; 
    private double totalDiscount; 

    // Constructor to initialize the store attributes
    public Store(int storeId, String storeName, String location, String openingHour) {
        // Initialize the store attributes with the provided parameters
        this.storeId = storeId;
        this.storeName = storeName;
        this.location = location;
        this.openingHour = openingHour;
        this.totalSales = 0;
        this.totalDiscount = 0;
    }

    public Store(int storeId2, String storeName2, String location2, String openingHour2, double totalSales2,
            double totalDiscount2) {
        this(storeId2, storeName2, location2, openingHour2);
        this.totalSales = totalSales2;
        this.totalDiscount = totalDiscount2;
    }

    // Getter method which help to find retrieve store id
    public int getStoreId() {
        return storeId;
    }

    // Getter method to retrieve the store name
    public String getStoreName() {
        return storeName;
    }

    // Getter method which help to retrieve the store location
    public String getLocation() {
        return location;
    }

    // Getter method that help to retrieve store opening hour
    public String getOpeningHour() {
        return openingHour;
    }

    // Getter method which help to retrieve total sales
    public double getTotalSales() {
        return totalSales;
    }

    // Getter Method that help to set total sales
    public void setTotalSales(double newTotalSales) {
        totalSales += newTotalSales;
    }

    // Getter method help to find retrieve total discount
    public double getTotalDiscount() {
        return totalDiscount;
    }

    // Method which set the total discount
    public void setTotalDiscount(double newTotalDiscount) {
        totalDiscount += newTotalDiscount;
    }

    // Method that display the store details 
    public void display() {
        // Check if total sales and total discount are zero
        if (totalSales == 0 && totalDiscount == 0) {
            System.out.println("Store " + storeId + " has no sales or discounts.");
        } else {
            // It display the store details-
            System.out.println("Store " + storeId + " details:");
            System.out.println("Name: " + storeName);
            System.out.println("Location: " + location);
            System.out.println("Opening Hour: " + openingHour);
            System.out.println("Total Sales: " + totalSales);
            System.out.println("Total Discount: " + totalDiscount);
        }
    }
}
