import model.Product;
import service.PriceComparatorAscending;
import service.PriceComparatorDescending;
import service.ProductManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ProductManagement productManagement = new ProductManagement();
        List<Product> productList = new ArrayList<>();
        System.out.println("=== Products List ===");
        System.out.println("<Input choice (below) to see the list>");

        int choice = -1;
        while (choice != 0) {
            displayChoiceList();
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.println("=== The Product List ===");
                    productList = productManagement.findAll();
                    display(productList);
                    break;

                case 2:
                    System.out.println("=== Add a product ===");
                    System.out.println("Input ID: ");
                    long id = input.nextLong();
                    System.out.println("Product's name: ");
                    input.nextLine();
                    String name = input.nextLine();
                    System.out.println("Product's price: ");
                    long price = input.nextLong();
                    Product addProduct = new Product(id, name, price);
                    productList.add(addProduct);
                    System.out.println();
                    display(productList);
                    break;

                case 3:
                    System.out.println("=== Delete a product with ID ===");
                    System.out.println("Input ID: ");
                    long idForDelete = input.nextLong();
                    productManagement.delete(idForDelete);
                    productList = productManagement.findAll();
                    display(productList);
                    break;

                case 4:
                    System.out.println("=== Update Name and Price of the product ===");
                    System.out.println("Input ID: ");
                    long idForUpdate = input.nextLong();
                    System.out.println("New Product's name: ");
                    input.nextLine();
                    String nameForUpdate = input.nextLine();
                    System.out.println("New Product's price: ");
                    long priceForUpdate = input.nextLong();
                    Product updateProduct = new Product(idForUpdate, nameForUpdate, priceForUpdate);
                    productManagement.update(idForUpdate, updateProduct);
                    productList = productManagement.findAll();
                    display(productList);
                    break;

                case 5:
                    System.out.println("=== Find a product with name ===");
                    List<Product> productListByName = new ArrayList<>();
                    System.out.println("Name: ");
                    String nameToFind = input.next();
                    productListByName = productManagement.findByName(nameToFind);
                    display(productListByName);
                    break;

                case 6:
                    System.out.println("=== Find a product with ID ===");
                    System.out.println("Input ID: ");
                    Long idToFind = input.nextLong();
                    System.out.println(productManagement.findByID(idToFind));
                    break;

                case 7:
                    PriceComparatorAscending priceComparatorAscending = new PriceComparatorAscending();
                    Collections.sort(productList, priceComparatorAscending);
                    System.out.println("=== The List After Sort (Ascending) ===");
                    display(productList);
                    break;

                case 8:
                    PriceComparatorDescending priceComparatorDescending = new PriceComparatorDescending();
                    Collections.sort(productList, priceComparatorDescending);
                    System.out.println("=== The List After Sort (Descending) ===");
                    display(productList);
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println();
                    System.out.println("Please input your choice!");
                    break;
            }
        }
    }

    public static void displayChoiceList() {
        System.out.println();
        System.out.println("------------------");
        System.out.println("What do you want?");
        System.out.println("1. Display product list");
        System.out.println("2. Add a product");
        System.out.println("3. Delete a product (with ID)");
        System.out.println("4. Update a product (with ID)");
        System.out.println("5. Find a product in list by name");
        System.out.println("6. Find a product in list by ID");
        System.out.println("7. Sort the list ascending");
        System.out.println("8. Sort the list descending");
        System.out.println("0. EXIT");
        System.out.println("------------------");
        System.out.println("-- Input your choice: --");
    }

    public static void display(List<Product> list) {
        for (Product product : list) {
            System.out.println(product);
        }
    }
}
