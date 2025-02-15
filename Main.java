import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Product> listOfProducts = new ArrayList<>();
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. add product");
            System.out.println("2. remove product");
            System.out.println("3. update product");
            System.out.println("4. search product");
            System.out.println("5. list products");
            System.out.println("6. exit");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice){
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

                case 2:
                System.out.println("Enter the product name:" );
                String names = scanner.next();
                remove(names);
                break;

                case 3:
                System.out.println("Enter the product id:" );
                int id = scanner.nextInt();
                System.out.println("Enter the updated product prize:" );
                int price1 = scanner.nextInt();
                update(id,price1);
                break;

                case 4:
                System.out.println("enter the product id for the search:");
                int id1  = scanner.nextInt();
                search(id1);
                break;

                case 5:
                    printList();
                    break;
                case 6:
                    return;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }

        }

    }


    private static void printList() {


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

    public static void add(String name, int price, String description, int quantity) {
        Product product=new Product();
        product.setProductName(name);
        product.setProductPrice(price);
        product.setProductDescription(description);
        product.setProductQuantity(quantity);
        product.setProductId(listOfProducts.size()+1);
        listOfProducts.add(product);
    }

    //remove products
    public static void remove(String names) {
        for(Product product : listOfProducts){
            if(product.getProductName().equals(names)){
                listOfProducts.remove(product.getProductId()-1);
                break;
            }
        }
    }


    public static void update(int id ,int price1) {
        for(Product product : listOfProducts){
            if (product.getProductId() == id){
                product.setProductPrice(price1);
            }
        }
    }
    public static void search(int id1) {
        for (Product product : listOfProducts) {
            if (product.getProductId() == id1) {
                System.out.println("product name:" +"\t" +  product.getProductName());
             }
        } 
    }
}