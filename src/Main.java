public class Main {
    public static void main(String[] args) {
        // Create products
        Product laptop = new Product("Laptop", 1200.0, 20, 5);
        Product smartphone = new Product("Smartphone", 800.0, 10, 3);

        // Create stock predictors for the products
        StockPredictor laptopPredictor = new StockPredictor(laptop, 5); // Average daily sales for Laptop: 5
        StockPredictor phonePredictor = new StockPredictor(smartphone, 3); // Average daily sales for Smartphone: 3

        // Display product details
        System.out.println("Product Details: " + laptop);
        System.out.println("Product Details: " + smartphone);

        // Predict days until stock runs out for Laptop
        int daysUntilStockOutLaptop = laptopPredictor.predictDaysUntilStockOut();
        System.out.println("\nStock Prediction for Laptop:");
        System.out.println("Days until stock runs out: " + daysUntilStockOutLaptop);

        // Suggest restocking strategy for Laptop
        String restockingStrategyLaptop = laptopPredictor.suggestRestockingStrategy();
        System.out.println("Restocking Strategy: " + restockingStrategyLaptop);

        // Predict days until stock runs out for Smartphone
        int daysUntilStockOutPhone = phonePredictor.predictDaysUntilStockOut();
        System.out.println("\nStock Prediction for Smartphone:");
        System.out.println("Days until stock runs out: " + daysUntilStockOutPhone);

        // Suggest restocking strategy for Smartphone
        String restockingStrategyPhone = phonePredictor.suggestRestockingStrategy();
        System.out.println("Restocking Strategy: " + restockingStrategyPhone);

        // Simulate selling some products for Laptop
        try {
            laptop.sellProduct(20);
            System.out.println("\nAfter selling 20 units of Laptop, stock level: " + laptop.getStockLevel());

            // Update prediction after sales for Laptop
            daysUntilStockOutLaptop = laptopPredictor.predictDaysUntilStockOut();
            System.out.println("Updated days until stock runs out: " + daysUntilStockOutLaptop);

            restockingStrategyLaptop = laptopPredictor.suggestRestockingStrategy();
            System.out.println("Updated Restocking Strategy: " + restockingStrategyLaptop);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Simulate selling some products for Smartphone
        try {
            smartphone.sellProduct(5);
            System.out.println("\nAfter selling 5 units of Smartphone, stock level: " + smartphone.getStockLevel());

            // Update prediction after sales for Smartphone
            daysUntilStockOutPhone = phonePredictor.predictDaysUntilStockOut();
            System.out.println("Updated days until stock runs out: " + daysUntilStockOutPhone);

            restockingStrategyPhone = phonePredictor.suggestRestockingStrategy();
            System.out.println("Updated Restocking Strategy: " + restockingStrategyPhone);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}