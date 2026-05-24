import java.util.ArrayList;

public class Order {
    private ArrayList<Product> products;


    //Constructor
    public Order(){
        products = new ArrayList<>();
    }

    //Add and remove
    public void addProduct(Product product){
        products.add(product);
    }
    public void removeProduct(Product product){
        products.remove(product);
    }

    //Money
    public float billTotal(){
        float total = 0;

        for(Product product : products) {
            total += product.getPrice();
        }

        return total;
    }

    //toString
    public void showOrder(){
        System.out.println("----  ORDER  ----");
        for(Product product : products){
            System.out.println(product);
        }
        System.out.println("\nTotal: $" + billTotal());
        System.out.println("\nPress [ENTER] to continue");
    }
}
