
package accounting;

import java.text.NumberFormat;
import java.util.Locale;

public class Item {

    static private final NumberFormat NF = NumberFormat.getCurrencyInstance(Locale.GERMANY);

    private Product product;
    private int amount;
    private int value;

    public int getValue() {
        return value;
    }

    public Item(Product product, int amount) {
        this.product = product;
        this.amount = amount;
        this.value = calculatePrice(amount);
    }

    private int calculatePrice(int items) {
        return items * product.getUnityPrice();
    }

    String renderInvoiceLine() {

        String start = "%-25s :   %s u. a %s".formatted(
                product.getSku() + " " + product.getName(), amount,
                NF.format(product.getUnityPrice()));

        String message = """
                %-50s..... Total %s
                """.formatted(
                start,
                NF.format(value));
        return message;
    }
}