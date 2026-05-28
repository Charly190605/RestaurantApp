public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product){
        this.product = product;
        quantity = 1;
    }

    public Product getProduct(){
        return this.product;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void increaseQuantity(){
        this.quantity++;
    }

    public void decreaseQuantity(){
        this.quantity--;
    }


    public float getSubtotal(){
        return product.getPrice() * quantity;
    }
}
