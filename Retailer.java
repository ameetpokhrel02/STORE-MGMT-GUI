public class Retailer extends Store {
    private int vatInclusivePrice;
    private int loyaltyPoint;
    private boolean isPaymentOnline;
    private String purchasedYear;

    // Constructor 1
    public Retailer(int storeId, String storeName, String location, String openingHour, double totalSales, double totalDiscount, int vatInclusivePrice, boolean isPaymentOnline, String purchasedYear) {
        super(storeId, storeName, location, openingHour, totalSales, totalDiscount);
        this.vatInclusivePrice = vatInclusivePrice;
        this.isPaymentOnline = isPaymentOnline;
        this.loyaltyPoint = 0; // Assuming loyalty points start at 0
        this.purchasedYear = purchasedYear;
    }

    // Constructor 2
    public Retailer(int storeId, String storeName, String location, String openingHour, double totalSales, double totalDiscount, double vatPrice, int loyaltyPoint2, boolean isPaymentOnline2, int purchasedYear2) {
        super(storeId, storeName, location, openingHour, totalSales, totalDiscount);
        this.vatInclusivePrice = (int) vatPrice;
        this.loyaltyPoint = loyaltyPoint2;
        this.isPaymentOnline = isPaymentOnline2;
        this.purchasedYear = Integer.toString(purchasedYear2);
    }

    // Accessor methods
    public int getVatInclusivePrice() {
        return vatInclusivePrice;
    }

    public int getLoyaltyPoint() {
        return loyaltyPoint;
    }

    public boolean isPaymentOnline() {
        return isPaymentOnline;
    }

    public String getPurchasedYear() {
        return purchasedYear;
    }

    // Mutator method for isPaymentOnline
    public void setPaymentOnline(boolean newIsPaymentOnline) {
        this.isPaymentOnline = newIsPaymentOnline;
    }

    // Method to set loyalty point
    public void setLoyaltyPoint(boolean isPaymentOnline, int newVatInclusivePrice) {
        if (isPaymentOnline) {
            this.loyaltyPoint = (int) (newVatInclusivePrice * 0.01); // Sets loyalty point based on the VAT inclusive price
        } else {
            this.loyaltyPoint = 0; // Reset loyalty points if not paid online
        }
    }

    // Method to remove product
    public void removeProduct() {
        if (purchasedYear.equals("2020") || purchasedYear.equals("2021") || purchasedYear.equals("2022")) {
            vatInclusivePrice = 0;
            loyaltyPoint = 0;
            isPaymentOnline = false;
        }
    }

    // Display method
    @Override
    public void display() {
        super.display();
        if (purchasedYear.equals("2020") || purchasedYear.equals("2021") || purchasedYear.equals("2022")) {
            System.out.println("VAT Inclusive Price: 0");
            System.out.println("Loyalty Point: 0");
            System.out.println("Purchased Year: " + purchasedYear);
            System.out.println("Product has been removed.");
        } else {
            System.out.println("VAT Inclusive Price: " + vatInclusivePrice);
            System.out.println("Loyalty Point: " + loyaltyPoint);
            System.out.println("Purchased Year: " + purchasedYear);
        }
    }
}
