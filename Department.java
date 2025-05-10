// Department class inherits from Store
public class Department extends Store {
    // Variables specific to Department
    private String productName;
    private double markedPrice;
    private double sellingPrice;
    private boolean isInSales;

    // Constructor to initialize store and product details
    public Department(int storeId, String storeName, String location,
                      String openingHour, double totalSales, double totalDiscount,
                      String productName, double markedPrice) {
        // Call the constructor of the parent Store class
        super(storeId, storeName, location, openingHour, totalSales, totalDiscount);
        this.productName = productName;
        this.markedPrice = markedPrice;
        this.isInSales = true; // Initially, the product is in sales
        this.sellingPrice = 0; // Selling price will be set after discount calculation
    }

    // Getter for product name
    public String getProductName() {
        return productName;
    }

    // Getter for marked price
    public double getMarkedPrice() {
        return markedPrice;
    }

    // Getter for selling price
    public double getSellingPrice() {
        return sellingPrice;
    }

    // Getter to check if product is still in sales
    public boolean isInSales() {
        return isInSales;
    }

    // Setter to update marked price
    public void setMarkedPrice(double markedPrice) {
        this.markedPrice = markedPrice;
    }

    // Method to calculate discount based on marked price
    public void calculateDiscountPrice(boolean isInSales, double markedPrice) {
        if (isInSales) {
            double discount = 0;

            // Apply discount rate based on price range
            if (markedPrice >= 5000) {
                discount = 0.2; // 20% discount
            } else if (markedPrice >= 3000 && markedPrice < 5000) {
                discount = 0.1; // 10% discount
            } else if (markedPrice >= 1000 && markedPrice < 3000) {
                discount = 0.05; // 5% discount
            }

            // Calculate final selling price after discount
            sellingPrice = markedPrice - (markedPrice * discount);

            // Update total discount and total sales in the Store class
            super.setTotalDiscount(super.getTotalDiscount() + (markedPrice - sellingPrice));
            super.setTotalSales(super.getTotalSales() + sellingPrice);

            // Mark the item as no longer in sales
            this.isInSales = isInSales;
        }
    }

    // Method to display product and store details
    @Override
    public void display() {
        super.display(); // Call display method of Store class

        // Display product info based on whether it's sold or not
        if (isInSales) {
            System.out.println("Product Name: " + productName);
            System.out.println("Marked Price: " + markedPrice);
        } else {
            System.out.println("Product Name: " + productName);
            System.out.println("Selling Price: " + sellingPrice);
        }
    }
}

