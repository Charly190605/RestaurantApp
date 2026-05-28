public class Product {
    private String name;
    private float price;
    private int stock;

    //Constructor
    public Product(String name, float price){
        this.name = name;
        this.price = price;
        this.stock = 0;
    }

    //Getters
    public String getName(){
        return this.name;
    }
    public float getPrice(){
        return this.price;
    }
    public int getStock(){ return this.stock; }

    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(float price){
        this.price = price;
    }
    public void setStock(int stock){ this.stock = stock; }

    //toString
    @Override
    public String toString() {
        return this.name + " - $" + this.price;
    }

}
