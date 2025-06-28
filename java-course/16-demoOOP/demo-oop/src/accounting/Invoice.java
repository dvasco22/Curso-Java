
package accounting;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Invoice {

    static private final NumberFormat NF = NumberFormat.getCurrencyInstance(Locale.GERMANY);

    // propiedades y métodos static
    static private final Company BRAND = new Company("68323392y", "Boracay");
    static private byte lastId = 0;

    static private String generateID() {
        int year = LocalDate.now().getYear();
        String id = String.valueOf(year) + '/' + ++lastId;
        return id;
    }

    // declaración de propiedades privadas

    private String id;
    private Company client;
    private List<Item> items = new ArrayList<>();
    private double iva;
    private double total = 0;
    private Payments paymentMethod;

    // constructor
    public Invoice(Company client, Product product, int amount, double iva, Payments method) {
        this.id = Invoice.generateID();
        this.client = client;
        // this.items.add(new Item(product, amount));
        // this.total = this.items.get(0).value; // Initialize total with the first
        // item's value
        this.client = client;
        this.iva = iva;
        this.paymentMethod = method;
        addItem(product, amount);
    }

    public Invoice(Company client, Product product, int amount, Payments method) {
        this(client, product, amount, 1.21, method);
    }

    public Invoice(Company client, Product product, int amount) {
        this(client, product, amount, 1.21, Payments.TRANSFER);
    }

    public void addItem(Product product, int amount) {
        Item item = new Item(product, amount);
        this.items.add(item);
        this.total += item.getValue(); // Update total with the new item's value
    }

    public double calculatePrice() {
        return total * this.iva;
    }

    private String renderDate() {
        return LocalDate.now().toString();
    }

    private String renderItems() {
        String itemsList = "";
        for (Item item : items) {
            itemsList += item.renderInvoiceLine();
        }
        return itemsList;
    }

    private String renderPayment() {

        double totalWithIva = calculatePrice();
        double totalIva = totalWithIva - total;

        String ivaPercentage = String.format("%.0f", (this.iva - 1) * 100) + "%";

        return """
                Total (sin iva): %s
                Iva (%s): %s
                Total (con iva): %s
                ----------------------------------------------

                Forma de pago: %s
                """.formatted(
                NF.format(total),
                ivaPercentage,
                NF.format(totalIva),
                NF.format(totalWithIva),
                paymentMethod.toString());

    }

    // System.out.printf("Total Price: %s\n", totalPrice));

    public void printInvoice() {

        String invoice = """
                %s
                %s

                Factura %s
                Fecha: %s
                ------------------------------------------------------------------------

                %s

                ------------------------------------------------------------------------
                %s
                ----------------------------------------------
                Gracias por su compra
                ----------------------------------------------

                """.formatted(
                BRAND.renderHeader(),
                client.renderClient(),
                id,
                renderDate(),
                renderItems(),
                renderPayment());

        System.out.println(invoice);
    }
}
