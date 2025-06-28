
package accounting;

// public enum Payments {
//     BIZUM, 
//     CARD,
//     TRANSFER;
// }

public enum Payments {
    BIZUM("Bizum"),
    CARD("Tarjeta de Crédito"),
    TRANSFER("Transferencia");

    private String name;

    private Payments(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
