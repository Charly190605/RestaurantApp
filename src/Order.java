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
    public void removeProduct(int index){
        products.remove(index);
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
        int index = 0;
        if(products.isEmpty()){
            System.out.println("----  EMPTY ORDER  ----");
        }else{
            System.out.println("----  ORDER  ----");
            for(Product product : products){
                System.out.println(index + ". " + product);
                index++;
            }
            System.out.println("\nTotal: $" + billTotal());
        }
    }
}
