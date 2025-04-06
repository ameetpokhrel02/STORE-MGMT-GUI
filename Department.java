public class Department extends Store {
    //variables
    private String productName;
    private double markedPrice;
    private double sellingPrice;
    private boolean isInSales;

    //constructor
    public Department(int storeId, String storeName, String location,
    String openingHour, double totalSales, double totalDiscount, String productName, double markedPrice) 
    {
        super(storeId, storeName, location, openingHour, totalSales, totalDiscount);
        this.productName = productName;
        this.markedPrice = markedPrice;
        this.isInSales = true;
        this.sellingPrice = 0;
    }

    public String getProductName() {
        return productName;
    }

    public double getMarkedPrice() {
        return markedPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public boolean isInSales() {
        return isInSales;
    }

    public void setMarkedPrice(double markedPrice) {
        this.markedPrice = markedPrice;
    }

    //Method to calculate discount price
    public void calculateDiscountPrice(boolean isInSales, double markedPrice) {
        if (isInSales) {
            double discount = 0;
            if (markedPrice >= 5000) {
                discount = 0.2;
            } else if (markedPrice >= 3000 && markedPrice < 5000) {
                discount = 0.1;
            } else if (markedPrice >= 1000 && markedPrice < 3000) {
                discount = 0.05;
            }
            sellingPrice = markedPrice - (markedPrice * discount);
            super.setTotalDiscount(super.getTotalDiscount() + (markedPrice - sellingPrice));
            super.setTotalSales(super.getTotalSales() + sellingPrice);
            // Set isInSales to false if product is sold
            this.isInSales = isInSales;
        }
    }

    //Method to display detail
    @Override
    public void display() {
        super.display();
        if (isInSales) {
            System.out.println("Product Name: " + productName);
            System.out.println("Marked Price: " + markedPrice);
        } else {
            System.out.println("Product Name: " + productName);
            System.out.println("Selling Price: " + sellingPrice);
        }
    }
}
