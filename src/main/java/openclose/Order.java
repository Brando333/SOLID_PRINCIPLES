package openclose;

public class Order {

    public Shipping shipping;
    public double weight;
    public double price;
    public int amount;


    public Order(Shipping shipping, double weight, double price, int amount) {
        this.shipping = shipping;
        this.weight = weight;
        this.price = price;
        this.amount = amount;
    }


    public double getCost() {
        switch (shipping) {
            case LAND -> {
                if (amount >= 100) {
                    return amount * price;
                }
                return Math.max(100, amount * price + (amount * weight * 1.50));
            }
            case SEA -> {
                return Math.max(250, amount * price + (amount * weight * 2.30));
            }
            case AIR -> {
                return Math.max(300, amount * price + (amount * weight * 3.00));
            }
            default -> throw new RuntimeException("Invalid shipping");
        }
    }


    @Override
    public String toString() {
        return "Order{" +
               "shipping=" + shipping +
               ", weight=" + weight +
               ", price=" + price +
               '}';
    }
}
