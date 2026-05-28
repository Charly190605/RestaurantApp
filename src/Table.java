public class Table {
    private int tableNumber;
    private Order order;

    public Table(int tableNumber){
        this.tableNumber = tableNumber;
        order  = new Order();
    }

    public Order getOrder(){
        return order;
    }

    public int getTableNumber(){
        return this.tableNumber;
    }

    @Override
    public String toString(){
        return "Table #" + this.getTableNumber() + "\n" + this.order;
    }
}
