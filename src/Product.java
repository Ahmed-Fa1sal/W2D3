import java.util.UUID;

public class Product {
    private UUID productId;
    private String name;
    private double price;
    private int stockLevel;
    private int reorderThreshold;

    // Constructor
    public Product(String name, double price, int stockLevel, int reorderThreshold) {
        this.productId = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.stockLevel = stockLevel;
        this.reorderThreshold = reorderThreshold;
    }

    // Getters
    public UUID getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return String.format("$%.1f", price);
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public int getReorderThreshold() {
        return reorderThreshold;
    }

    // Setters
    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    // Method to sell a product
    public void sellProduct(int quantity) {
        if (quantity > stockLevel) {
            throw new IllegalArgumentException("Not enough stock available.");
        }
        stockLevel -= quantity;
    }

    // Override toString() for better representation
    @Override
    public String toString() {
        return "Product ID: " + productId + "\n" +
                "Name: " + name + "\n" +
                "Price: " + getPrice() + "\n" +
                "Stock Level: " + stockLevel + "\n" +
                "Reorder Threshold: " + reorderThreshold;
    }
}