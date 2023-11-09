import java.applet.Applet;
import java.util.*;
import java.util.stream.Collectors;

import javassist.bytecode.analysis.ControlFlow.Node;

public class GroceryReceiptBase {
    protected Map<String, Double> prices;
    protected Map<String, Double> discounts;

    public GroceryReceiptBase(Map<String, Double> prices, Map<String, Double> discounts) {
        this.prices = prices;
        this.discounts = discounts;
    }

    public Map<String, Double> getPrices() {
        return prices;
    }

    public Map<String, Double> getDiscounts() {
        return discounts;
    }

    public abstract List<String> calculateInvoice(List<String> shoppingList);
}
class Node{
	String name;
	int count;
}
public class GroceryReceipt extends GroceryReceiptBase {
    public GroceryReceipt(Map<String, Double> prices, Map<String, Double> discounts) {
        super(prices, discounts);
    }


    @Override
    public List<Grocery> calculateInvoice(List<Node> shoppingList) {
        Map<String, Integer> itemQuantities = new HashMap<>();
        for (Node item : shoppingList) {
            itemQuantities.put(item.name, itemQuantities.getOrDefault(item, 0) + item.count);
        }
        
        

        List<Grocery> invoice = new ArrayList<>();
        
//        for (String item : prices.keySet()) {
//            double price = prices.get(item);
//            double discount = discounts.getOrDefault(item, 0.0);
//            int quantity = itemQuantities.getOrDefault(item, 0);
//            double total = quantity * price - discount * quantity;
//            invoice.add(item, price, total);
//        }
        
        for( String itemName: itemQuantities.keySet() ) {
        	double price = prices.get(itemName);
        	double discount = discounts.getOrDefault(itemName, 0.0);
        	int quantity = itemQuantities.getOrDefault(itemName, 0);
          double total = quantity * price - discount * quantity;
//          invoice.add(new Grocery(itemName, price, total));
          invoice.add(new Grocery(itemName, price, total));
        }

        Collections.sort(invoice,(grocery1, grocery2)-> (int)(grocery1.getPrice()-grocery2.getPrice()));
        return invoice;
    }
}

public class Main {
    public static void main(String[] args) {
        Map<String, Double> prices = new HashMap<>();
        prices.put("2", 72.0);
        prices.put("222", 73.0);
        prices.put("74", 75.0);
        prices.put("76", 76.0);

        Map<String, Double> discounts = new HashMap<>();
        discounts.put("2", 2.0);
        discounts.put("74", 5.0);

        List<String> itemsPurchased = Arrays.asList("2", "2", "222", "74", "74", "76");

        GroceryReceipt groceryReceipt = new GroceryReceipt(prices, discounts);
        List<String> invoice = groceryReceipt.calculateInvoice(itemsPurchased);

        for (String item : invoice) {
            System.out.println(item);
        }
    }
}