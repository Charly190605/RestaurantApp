import java.util.ArrayList;

public class Menu {
    private ArrayList<Product> menu;

    //Constructor
    public Menu(){
        menu = new ArrayList<>();
    }

    public int getSize(){
        return menu.size();
    }

    //ADD TO MENU
    public void addProductToMenu(Product product) {
        boolean exists = false;
        for(Product product1 : menu) {
            if (product1.getName().equals(product.getName())) {
                exists = true;
            }
        }
        if(!exists){
            menu.add(product);
        }
    }

    //REMOVE FROM MENU
    public void removeProductFromMenu(int index){
        menu.remove(index);
    }

    //SHOW MENU
    public void showMenu(){
        int index = 0;
        if(menu.isEmpty()){
            System.out.println("----  EMPTY MENU  ----");
        }else{
            System.out.println("----  MENU  ----");
            for(Product product : menu){
                System.out.println(index + ". " + product);
                index++;
            }
        }
    }

    //SHOW PRODUCT
    public Product getProduct(int index){
        return menu.get(index);
    }
}
