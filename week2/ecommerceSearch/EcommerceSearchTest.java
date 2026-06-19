package week2.ecommerceSearch;

/*
 * EXERCISE 2: E-COMMERCE SEARCH FUNCTION — ANALYSIS
 *
 * 1. Big O Notation
 *    Big O describes how runtime or space grows as input size (n) increases.
 *    It helps compare algorithms independently of hardware and focus on scalability.
 *
 * 2. Search Scenarios (by product name)
 *    Linear Search:
 *      - Best case:    O(1)  — target is the first element
 *      - Average case: O(n)  — target is near the middle on average
 *      - Worst case:   O(n)  — target is last or not found
 *
 *    Binary Search (requires sorted array):
 *      - Best case:    O(1)  — target is at the middle index
 *      - Average case: O(log n)
 *      - Worst case:   O(log n)
 *
 * 3. Comparison
 *    Linear Search: simple, works on unsorted data, O(n) per query.
 *    Binary Search: O(log n) per query, but data must stay sorted (maintenance cost).
 *
 * 4. Which is More Suitable for E-commerce?
 *    - Small catalogs or infrequent searches: linear search is acceptable.
 *    - Large catalogs with frequent name-based lookups: binary search (or HashMap/Trie)
 *      is better for read performance.
 *    - Real platforms often use HashMap for exact ID lookup O(1), inverted indexes
 *      or search engines (Elasticsearch) for full-text search, since users search
 *      by partial names, categories, and filters — not just exact sorted names.
 *    - Binary search fits when products are sorted by name and exact-name lookup is needed.
 */
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

        System.out.println("--- Linear Search (unsorted array) ---");
        Product linearResult = SearchAlgorithms.linearSearch(products, searchName);
        printResult(linearResult);

        System.out.println("\n--- Binary Search (sorted array by name) ---");
        Product binaryResult = SearchAlgorithms.binarySearch(sortedProducts, searchName);
        printResult(binaryResult);

        System.out.println("\n--- Search for non-existent product ---");
        printResult(SearchAlgorithms.linearSearch(products, "Gaming Chair"));
        printResult(SearchAlgorithms.binarySearch(sortedProducts, "Gaming Chair"));

        System.out.println("\n--- Sorted product list (for binary search) ---");
        for (Product product : sortedProducts) {
            System.out.println("  " + product.getProductName());
        }
    }

    private static void printResult(Product product) {
        if (product == null) {
            System.out.println("  Product not found.");
        } else {
            System.out.println("  Found: " + product);
        }
    }
}
