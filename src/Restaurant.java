import java.util.ArrayList;

public class Restaurant {
    private ArrayList<Table> tables;

    public Restaurant(){
        tables = new ArrayList<>();
    }

    public void addTable(Table table){
        tables.add(table);
    }

    public void removeTable(int index){
        tables.remove(index);
    }

    public Table getTable(int index){
        for(Table table : tables){
            if(table.getTableNumber() == index){
                return table;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        String result = "";
        for(Table table : tables){
            result += table + "\n\n";
        }
        return result;
    }
}
