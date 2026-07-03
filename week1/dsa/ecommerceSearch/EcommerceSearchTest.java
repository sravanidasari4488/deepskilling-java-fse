package week2.ecommerceSearch;

public class EcommerceSearchTest {

    public static void main(String[] args) {

        Product[] products = {
                new Product("P101", "Wireless Mouse", "Electronics"),
                new Product("P102", "Mechanical Keyboard", "Electronics"),
                new Product("P103", "USB-C Hub", "Accessories"),
                new Product("P104", "Laptop Stand", "Accessories"),
                new Product("P105", "Noise Cancelling Headphones", "Electronics")
        };

        Product[] sortedProducts = SearchAlgorithms.sortByName(products);
        String searchName = "Laptop Stand";

        Product linearResult = SearchAlgorithms.linearSearch(products, searchName);
        Product binaryResult = SearchAlgorithms.binarySearch(sortedProducts, searchName);

        System.out.println("Linear search: " + linearResult);
        System.out.println("Binary search: " + binaryResult);
    }
}
