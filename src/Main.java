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
        System.out.println("2.- Order Options");
        System.out.println("3.- Remove a product from order");
        System.out.println("0.- Exit");
    }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Menu myMenu = new Menu();
        Order myOrder = new Order();
        String myString;
        float myFloat;

        String optMenu;

        Product p1 = new Product("Taco", 15);
        Product p2 = new Product("Fish", 150);
        Product p3 = new Product("Lemonade", 50);

        do{
            String optionC;
            clearConsole();
            showMainMenu();
            System.out.println("[Option] -> ");
            optMenu = sc.nextLine();

            //VIEW MENU AND ADD MENU
            if(optMenu.equals("1")){
                do{
                    clearConsole();
                    myMenu.showMenu();
                    System.out.println("\nA) Add Product");
                    System.out.println("E) Exit");
                    optionC = sc.nextLine();

                    if(optionC.equals("A")){
                        //PRODUCT INFORMATION
                        System.out.println("\nProduct Name: ");
                        myString = sc.nextLine();
                        System.out.println("Product Prize: ");
                        myFloat = sc.nextFloat();

                        //ADDING PRODUCT TO MENU
                        Product product = new Product(myString, myFloat);
                        myMenu.addProductToMenu(product);
                    }
                }while(!optionC.equals("E"));
            }

            //ADD TO ORDER
            if(optMenu.equals("2")){
                clearConsole();

                System.out.println("\n\n----  ADD TO ORDER  ----\n");
                do{
                    clearConsole();
                    myMenu.showMenu();
                    System.out.println("\nAdd to order? Select an index or choose one of the below options");
                    System.out.println("V) View Order");
                    System.out.println("E) Exit");
                    System.out.println("[OPTION] -> ");
                    optionC = sc.nextLine();

                    int index;

                    //VERIFY IF ITS ONE OF THE MENU PRODUCTS
                    if(isNumeric(optionC)){
                        index = Integer.parseInt(optionC);
                        myOrder.addProduct(myMenu.getProduct(index));
                    }

                    //VIEW CURRENT ORDER
                    if(optionC.equals("V")){
                        clearConsole();
                        myOrder.showOrder();
                        System.out.println("\nPress [ENTER] to continue");
                        sc.nextLine();
                    }
                }while(!optionC.equals("E"));
            }

            //REMOVE FROM ORDER
            if(optMenu.equals("3")){
                clearConsole();
                int index;
                myOrder.showOrder();
                System.out.println("[REMOVE] -> ");
                optionC = sc.nextLine();

                index = Integer.parseInt(optionC);
                myOrder.removeProduct(index);
            }

        }while(!optMenu.equals("0"));
    }
}