package Practice;

public class Item implements Class {
    private String product;
    private int qty;
    private int unitPrice;
    private  static int a ;


    public Item(String product, int qty, int unitPrice) {
        this.product = product;
        this.qty = qty;
        this.unitPrice = unitPrice;

    }
    public Item() {

    }


    public int price() {
        return this.qty * this.unitPrice;
    }

    public void increaseQuantity() {
        this.qty += 1;   }

    public String toString() {
        return this.product + ": " + this.qty;
    }

    @Override
    public String fun() {
        return null;
    }
}
