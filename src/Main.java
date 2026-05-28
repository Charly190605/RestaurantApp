import java.util.Scanner;

public class Main {

    //CLEAR CONSOLE
    public static void clearConsole() {
        for(int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static boolean isNumeric(String text){
        try{
            Integer.parseInt(text);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }


    //MENUS
    public static void showMainMenu(){
        System.out.println("-----  RESTAURANT APP  ----");
        System.out.println("1.- Menu Options");
        System.out.println("2.- Select Table");
        System.out.println("0.- Exit");
    }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //CREATE RESTAURANT AND ADD TABLES
        Restaurant myRestaurant = new Restaurant();
        for(int i = 1; i <= 10; i++){
            myRestaurant.addTable(new Table(i));
        }

        //CREATE MENU
        Menu myMenu = new Menu();

        //PRODUCT INFORMATION
        String myString;
        float myFloat;

        String optMenu;

        do{
            clearConsole();

            showMainMenu();

            System.out.print("[Option] -> ");
            optMenu = sc.nextLine();

            //VIEW MENU AND ADD MENU
            if(optMenu.equals("1")){
                String optionC;
                do{
                    clearConsole();

                    myMenu.showMenu();

                    System.out.println("\nA) Add Product");
                    System.out.println("E) Exit");
                    System.out.print("[OPTION] -> ");
                    optionC = sc.nextLine();

                    if(optionC.equals("A")){
                        //PRODUCT INFORMATION
                        System.out.print("\nProduct Name: ");
                        myString = sc.nextLine();
                        System.out.print("Product Prize: ");
                        myFloat = sc.nextFloat();

                        //ADDING PRODUCT TO MENU
                        Product product = new Product(myString, myFloat);
                        myMenu.addProductToMenu(product);
                    }
                }while(!optionC.equals("E"));
            }

            //SELECT TABLE
            if(optMenu.equals("2")) {
                clearConsole();
                String optTable;
                int tableNumber;

                System.out.print("Table Number -> ");
                tableNumber = Integer.parseInt(sc.nextLine());

                do {
                    clearConsole();
                    System.out.println(myRestaurant.getTable(tableNumber).toString());
                    System.out.println("\nA) Add to order");
                    System.out.println("R) Remove from order");
                    System.out.println("E) Exit");
                    optTable = sc.nextLine();

                    if (optTable.equals("A")) {
                        clearConsole();
                        String optAdd;
                        int index;
                        myMenu.showMenu();
                        System.out.print("\n[INDEX TO ADD] -> ");
                        optAdd = sc.nextLine();
                        if (isNumeric(optAdd)) {
                            index = Integer.parseInt(optAdd);
                            if (index >= 0 && index < myMenu.getSize()) {
                                myRestaurant.getTable(tableNumber).getOrder().addProduct(myMenu.getProduct(index));
                            }
                        }


                    }
                    if (optTable.equals("R")) {
                        clearConsole();
                        String optDel;
                        int index;

                        System.out.println(myRestaurant.getTable(tableNumber).getOrder());
                        System.out.println("[INDEX TO ELIMINATE] -> ");
                        optDel = sc.nextLine();

                        if (isNumeric(optDel)) {
                            index = Integer.parseInt(optDel);
                            myRestaurant.getTable(tableNumber).getOrder().removeProduct(index);
                        }
                    }
                } while (!optTable.equals("E"));
            }

        }while(!optMenu.equals("0"));
    }
}