import java.util.ArrayList;

public class Order {
    private ArrayList<OrderItem> items;

    private boolean isValidPos(int index){
        if(index >= 0 && index < items.size()) {
            return true;
        }
        return false;
    }

    public int getSize(){
        return items.size();
    }

    //Constructor
    public Order(){
        items = new ArrayList<>();
    }

    //Add and remove
    public void addProduct(Product product){
        boolean exists = false;
        for(OrderItem item : items){
            if(item.getProduct().getName().equals(product.getName())){
                item.increaseQuantity();
                exists = true;
            }
        }
        if(!exists){
            items.add(new OrderItem(product));
        }
    }

    public void removeProduct(int index){
        if(isValidPos(index)){
            if(items.get(index).getQuantity() > 1){
                items.get(index).decreaseQuantity();
            }else{
                items.remove(index);
            }
        }else{
            System.out.println("Selecciona un index valido");
        }
    }

    //Money
    public float billTotal(){
        float total = 0;

        for(OrderItem item : items) {
            total += item.getSubtotal();
        }

        return total;
    }

    //toString
    @Override
    public String toString(){
        String result = "";
        if(items.isEmpty()){
            return "----  EMPTY ORDER  ----";
        }

        result += "----  ORDER  ----\n";
        for(OrderItem item : items){
            result += item.getQuantity() + "x  " + item.getProduct().getName() + " $" + item.getProduct().getPrice()* item.getQuantity() + "\n";
        }
        result += "\n Total: $" + billTotal();
        return result;
    }
}
