import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Product> listOfProducts = new ArrayList<>();
    public static void main(String[] args) {
        // continue running of the app or web
        while (true) {
            System.out.println("1. add product");
            System.out.println("2. remove product");
            System.out.println("3. update product");
            System.out.println("4. search product");
            System.out.println("5. list products");
            System.out.println("6. exit");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            //switch case based on the user input
            switch (choice){

                //add product
                case 1:
                    System.out.println("product name: ");
                    String name = scanner.next();
                    System.out.println("product price: ");
                    int price = scanner.nextInt();
                    System.out.println("product description: ");
                    String description = scanner.next();
                    System.out.println("product quantity: ");
                    int quantity = scanner.nextInt();
                    add(name,price,description,quantity);
                    break;

                //remove product
                case 2:
                    System.out.println("Enter the product name:" );
                    String names = scanner.next();
                    remove(names);
                    break;

                //update product
                case 3:
                    System.out.println("Enter the product id:" );
                    int id = scanner.nextInt();
                    System.out.println("Enter the updated product prize:" );
                    int price1 = scanner.nextInt();
                    update(id,price1);
                    break;

                //search product
                case 4:
                    System.out.println("enter the product id for the search:");
                    int id1  = scanner.nextInt();
                    search(id1);
                    break;

                // print all the available products
                case 5:
                    printList();
                    break;

                //dynamic search (based on the user filter i.e . name, price, quantity)any one
                case 6:
                    System.out.println("Enter the user desired field for the filter:" );
                    System.out.println("1.prize value from low to high");
                    System.out.println("2.Prize high to low");
                    System.out.println("3.based on range");
                    int chose = scanner.nextInt();
                    switch(chose){
                        case 1:
                            ascending(listOfProducts);
                            break;

                        case 2:
                            descending(listOfProducts);
                            break; 
                        
                        case 3:
                            System.out.println("provide Start price");
                            int start = scanner.nextInt();
                            System.out.println("provide End price");
                            int end =  scanner.nextInt();
                            System.out.println("Select order 1.ascending 2.descending");
                            int order =  scanner.nextInt();
                            Range(start,end,order);        
                        default:
                            break;

                           
                    }
                    break;


                // exit while loop to end the app or web
                case 7:
                    return;

                //default for the wrong input for switch case
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
            scanner.close();
        }

    }

    //print all the available products from the db
    private static void printList() {

        //basic list for all the product and used for print all case 
        for (Product product : listOfProducts) {
            
            if( product != null){
                System.out.println("product unique id:" + product.getProductId());
                System.out.println("product name:" + product.getProductName());
                System.out.println("product price:" + product.getProductPrice());
                System.out.println("product description:" + product.getProductDescription());
                System.out.println("product Quality:" + product.getProductQuantity());
            }
            else{
                System.out.println("No products in the list");
            }
        }
    }

    //add product to the db
    public static void add(String name, int price, String description, int quantity) {
        Product product=new Product();
        product.setProductName(name);
        product.setProductPrice(price);
        product.setProductDescription(description);
        product.setProductQuantity(quantity);
        product.setProductId(listOfProducts.size()+1);
        listOfProducts.add(product);
    }

    //remove products from the db
    public static void remove(String names) {
        for(Product product : listOfProducts){
            if(product.getProductName().equals(names)){
                listOfProducts.remove(product.getProductId()-1);
                break;
            }
        }
    }

    //update products detail
    public static void update(int id ,int price1) {
        for(Product product : listOfProducts){
            if (product.getProductId() == id){
                product.setProductPrice(price1);
            }
        }
    }

    // search products
    public static void search(int id1) {
        for (Product product : listOfProducts) {
            if (product.getProductId() == id1) {
                System.out.println("product name:" +"\t" +  product.getProductName());
             }
        } 
    }

    //filtering the product
    public static void ascending(List<Product>products) {
        products.sort(Comparator.comparingInt((Product dummy) -> dummy.getProductPrice()));
            for (Product product : products) {
                System.out.println("product unique id:" + product.getProductId());
                System.out.println("product name:" + product.getProductName());
                System.out.println("product price:" + product.getProductPrice());
                System.out.println("product description:" + product.getProductDescription());
                System.out.println("product Quality:" + product.getProductQuantity());
            }
    }

    public static void descending(List<Product>products) {
        products.sort(Comparator.comparingInt((Product dummy) -> dummy.getProductPrice()).reversed());
            for (Product product : products) {
                System.out.println("product unique id:" + product.getProductId());
                System.out.println("product name:" + product.getProductName());
                System.out.println("product price:" + product.getProductPrice());
                System.out.println("product description:" + product.getProductDescription());
                System.out.println("product Quality:" + product.getProductQuantity());
            }
    }

    public static void Range(int start, int end,int order){
        //if order is ascending
        List<Product> dummy = new ArrayList<>();   
        for(Product tmpObj : listOfProducts){
            if(tmpObj.getProductPrice() >= start && tmpObj.getProductPrice() <=end){
                dummy.add(tmpObj);
            }
        }
        if(order == 1){
            ascending(dummy);
        }else{
            descending(dummy);
        }
    }
}