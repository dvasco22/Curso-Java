
import java.util.Scanner;

public class Shop2 {

    static final double SHIRT_PRICE = 16;
    static final double TROUSER_PRICE = 22;

    static int[] getDataByScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Vendemos paquetes de pantalones %s EU\n", SHIRT_PRICE);
        System.out.printf("Vendemos paquetes de camisetas a %s EU\n", TROUSER_PRICE);
        System.out.println("Dime el número de paquetes de pantalones");
        int packetsTrousers = scanner.nextInt();
        System.out.println("Dime el número de paquetes de camisetas");
        int packetsShirts = scanner.nextInt();
        System.out.println("");
        scanner.close();
        int[] result = { packetsTrousers, packetsShirts };
        return result;
        // return new int[]{packetsTrousers, packetsShirts};
    }

    public static void main(String[] args) {

        int[] numPackets = getDataByScanner();

        int numPacketsTrousers = numPackets[0];
        int numPacketsShirt = numPackets[1];
        int numPacketsTotal = numPacketsTrousers + numPacketsShirt;

        // int [numPacketsTrousers, numPacketsShirt] = getDataByScanner();

        double discount = 0.15;
        int shippingByPacket = 0;
        double promotion = 0;

        if (numPacketsTotal < 5) {
            System.out.printf("Número de paquetes insuficiente (%s)", numPacketsTotal);
            return;
        } else if (numPacketsTotal < 10) {
            discount = 0.05;
            shippingByPacket = 10;
        } else if (numPacketsTotal < 20) {
            discount = 0.1;
            shippingByPacket = 5;
        }

        double total = numPacketsShirt * SHIRT_PRICE + numPacketsTrousers * TROUSER_PRICE; // 100
        double finalDiscount = total * discount; // 10% -> 10
        double totalShipping = numPacketsTotal * shippingByPacket;
        double finalPrice = total - finalDiscount + totalShipping;

        if (total >= 1000) {
            promotion = total * 0.10;
            finalPrice = finalPrice - promotion;
            System.out.println("""
                    Paquetes de pantalones      %d
                    Paquetes de camisetas       %d
                    Número de paquetes total    %d
                    -----------------------------------
                    Precio total del producto   %.2f EU
                    Descuento aplicado          %.2f EU
                    Gastos de envío             %.2f EU
                    ------------------------------------
                    PROMOCIÓN
                    Descuento                   %.2f EU
                    ------------------------------------
                    TOTAL                       %.2f EU
                    """.formatted(numPacketsTrousers, numPacketsShirt,
                    numPacketsTotal, total, finalDiscount, totalShipping,
                    promotion, finalPrice));
        } else {
            double amountToPromotion = 1000 - total;

            System.out.println("""
                    Paquetes de pantalones      %d
                    Paquetes de camisetas       %d
                    Número de paquetes total    %d
                    -----------------------------------
                    Precio total del producto   %.2f EU
                    Descuento aplicado          %.2f EU
                    Gastos de envío             %.2f EU
                    ------------------------------------
                    PROMOCIÓN NO APLICADA
                    Cantidad que falta          %.2f EU
                    ------------------------------------
                    TOTAL                       %.2f EU
                    """.formatted(numPacketsTrousers, numPacketsShirt,
                    numPacketsTotal, total, finalDiscount, totalShipping,
                    amountToPromotion, finalPrice));
        }
    }

}
