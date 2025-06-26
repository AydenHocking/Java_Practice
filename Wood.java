//Resource Wood
public class Wood extends Resource {
    public Wood(String name, int quantity, boolean isCritical){
        super("Wood");
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