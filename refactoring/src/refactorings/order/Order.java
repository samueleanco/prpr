package refactorings.order;

public class Order {
    private Product product;
    private int quantity;

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.calculatePriceForQuantity(quantity);
    }

    public int getQuantity() {
        return quantity;
    }
}

