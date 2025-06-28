
import java.text.NumberFormat;
import java.util.Locale;

import accounting.Company;
import accounting.Invoice;
import accounting.Payments;
import accounting.Product;

public class Economy {
    public static void main(String[] args) {
        // Create a company
        Company company = new Company("B12345678", "Tech Solutions");
        Product product = new Product("LT123", "Laptop 123", 1_000);

        // Create an invoice for the company
        Invoice invoice = new Invoice(company, product, 2, 1.21, Payments.TRANSFER);

        // Add extra items to the invoice
        Product product1 = new Product("MT001", "Monitor XT 27", 300);
        invoice.addItem(product1, 2);

        Product product2 = new Product("M001", "Mouse M 23", 50);
        invoice.addItem(product2, 5);

        // Calculate & print total price
        double totalPrice = invoice.calculatePrice();
        System.out.println("");

        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        System.out.printf("Total Price: %s\n", nf.format(totalPrice));

        // Print the invoice
        invoice.printInvoice();
    }

}
