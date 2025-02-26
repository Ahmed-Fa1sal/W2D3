public class StockPredictor {
    private Product product;
    private int averageDailySales;

    // Constructor
    public StockPredictor(Product product, int averageDailySales) {
        this.product = product;
        this.averageDailySales = averageDailySales;
    }

    // Predicts the number of days until stock runs out
    public int predictDaysUntilStockOut() {
        if (averageDailySales <= 0) {
            throw new IllegalArgumentException("Average daily sales must be greater than 0.");
        }
        return product.getStockLevel() / averageDailySales;
    }

    // Suggests a restocking strategy
    public String suggestRestockingStrategy() {
        int daysUntilStockOut = predictDaysUntilStockOut();
        if (daysUntilStockOut <= 0) {
            return "Stock is already depleted. Immediate restocking is required.";
        } else if (daysUntilStockOut <= product.getReorderThreshold()) {
            return "Stock is running low. Restock immediately.";
        } else {
            return "Stock is sufficient. No need to restock yet.";
        }
    }
}