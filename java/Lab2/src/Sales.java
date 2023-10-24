public class Sales extends Employee {
    private Product product;

    // No-argument constructor
    public Sales() {
    }

    // Constructor with parameters
    public Sales(String name, String staffId, int age, Product product) {
        super(name, staffId, age);
        this.product = product;
    }

    // Getter for product
    public Product getProduct() {
        return product;
    }

    // Setter for product
    public void setProduct(Product product) {
        this.product = product;
    }
}
