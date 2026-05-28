import java.util.ArrayList;

public class Order {
    private ArrayList<Product> products;

    private boolean isValidPos(int index){
        if(index >= 0 && index < products.size()) {
            return true;
        }
        return false;
    }

    public int getSize(){
        return products.size();
    }

    //Constructor
    public Order(){
        products = new ArrayList<>();
    }

    //Add and remove
    public void addProduct(Product product){
        boolean exists = false;
        for(Product product1 : products){
            if(product.getName().equals(product1.getName())){
                product1.setStock(product1.getStock() + 1);
                exists = true;
            }
        }
        if(!exists){
            products.add(product);
            product.setStock(product.getStock() + 1);
        }
    }

    public void removeProduct(int index){
        if(isValidPos(index)){
            if(products.get(index).getStock() > 1){
                products.get(index).setStock(products.get(index).getStock() - 1);
            }else{
                products.remove(index);
            }
        }else{
            System.out.println("Selecciona un index valido");
        }
    }

    //Money
    public float billTotal(){
        float total = 0;

        for(Product product : products) {
            total += product.getPrice() * product.getStock();
        }

        return total;
    }

    //toString
    @Override
    public String toString(){
        String result = "";
        if(products.isEmpty()){
            return "----  EMPTY ORDER  ----";
        }

        result += "----  ORDER  ----\n";
        for(Product product : products){
            result += product.getStock() + "x  " + product.getName() + " $" + product.getPrice()*product.getStock() + "\n";
        }
        result += "\n Total: $" + billTotal();
        return result;
    }
}
