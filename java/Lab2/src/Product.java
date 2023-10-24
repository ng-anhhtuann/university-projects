public class Product {
    private int price;
    private int interest;

    // No-argument constructor
    public Product() {
    }

    // Constructor with parameters
    public Product(int price, int interest) {
        this.price = price;
        this.interest = interest;
    }

    // Getter for price
    public int getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(int price) {
        this.price = price;
    }

    // Getter for interest
    public int getInterest() {
        return interest;
    }

    // Setter for interest
    public void setInterest(int interest) {
        this.interest = interest;
    }
}
