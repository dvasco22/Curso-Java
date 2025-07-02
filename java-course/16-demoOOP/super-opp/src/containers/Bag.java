
package containers;

import enums.ContainerType;
import products.IProduct;

public class Bag extends Container {

    private int length;
    // private int width;

    public Bag(String reference, int length, int height, int resistance) {
        super(reference);
        this.length = length;
        this.height = height;
        this.resistance = resistance;
    }

    @Override
    public ContainerType getType() {
        return ContainerType.BAG;
    }

    // d=2*r
    // L=2*pi*r por definicion de perímetro
    // L=pi*d -> d=L/pi
    private int calculateDiameter() {
        return (int) ((2 * length) / Math.PI);
    }

    // A=2*pi*r*r
    @Override
    public int calculateSurface() {
        int radio = calculateDiameter() / 2;
        return (int) (Math.PI * radio * radio);
    }

    @Override
    public boolean isResistantTo(IProduct product) {
        return resistance >= product.getWeight();
    }

}