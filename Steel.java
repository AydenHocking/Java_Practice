//Resource Steel
public class Steel extends Resource {
    public Steel(String name, int quantity, boolean isCritical){
        super("Steel");
        this.quantity = quantity;
        this.isCritical = isCritical;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int Quantity) {
        this.quantity = quantity;
    }
    public boolean isCritical() {
        return isCritical;
    }

    public void setCritical(boolean isCritical) {
        this.isCritical = isCritical;
    }
}