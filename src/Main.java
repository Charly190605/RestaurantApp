import java.util.Scanner;

public class Main {

    //CLEAR CONSOLE
    public static void clearConsole() {
        for(int i = 0; i < 50; i++) {
            System.out.println();
        }
    }


    //MENUS
    public static void showMainMenu(){
        System.out.println("-----  RESTAURANT APP  ----");
        System.out.println("1.- View Menu");
        System.out.println("2.- Add to order");
        System.out.println("3.- View current Order");
        System.out.println("0.- Exit");
    }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Order myOrder = new Order();
        String myString;
        float myFloat;

        int optMenu;

        Product p1 = new Product("Taco", 15);
        Product p2 = new Product("Fish", 150);
        Product p3 = new Product("Lemonade", 50);

        do{
            int option;
            clearConsole();
            showMainMenu();
            System.out.println("[Option] -> ");
            optMenu = sc.nextInt();

            //VIEW MENU
            if(optMenu == 1){
                do{
                    clearConsole();
                    System.out.println("----  MENU  ----");
                    System.out.println("1. " + p1);
                    System.out.println("2. " + p2);
                    System.out.println("3. " + p3);
                    System.out.println("0. Back");
                    option = sc.nextInt();
                }while(option != 0);
            }

            //ADD TO ORDER
            if(optMenu == 2){
                clearConsole();

                System.out.println("\n\n----  ADD TO ORDER  ----");
                do{
                    clearConsole();
                    System.out.println("----  MENU  ----");
                    System.out.println("1. " + p1);
                    System.out.println("2. " + p2);
                    System.out.println("3. " + p3);
                    System.out.println("4. View Order");
                    System.out.println("0. Back");
                    System.out.println("[Option] -> ");
                    option = sc.nextInt();

                    if(option == 1){
                        myOrder.addProduct(p1);
                    }
                    if(option == 2){
                        myOrder.addProduct(p2);
                    }
                    if(option == 3){
                        myOrder.addProduct(p3);
                    }
                    if(option == 4){
                        clearConsole();
                        myOrder.showOrder();
                        sc.nextLine();
                        sc.nextLine();
                    }
                }while(option != 0);
            }

            //CURRENT ORDER
            if(optMenu == 3){
                clearConsole();
                myOrder.showOrder();
                sc.nextLine();
                sc.nextLine();
            }

        }while(optMenu != 0);
    }
}