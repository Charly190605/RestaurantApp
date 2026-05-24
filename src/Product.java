public class Product {
    private String name;
    private float price;

    //Constructor
    public Product(String name, float price){
        this.name = name;
        this.price = price;
    }

    //Getters
    public String getName(){
        return this.name;
    }
    public float getPrice(){
        return this.price;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(float price){
        this.price = price;
    }


    //toString
    @Override
    public String toString() {
        return this.name + " - $" + this.price;
    }

}
