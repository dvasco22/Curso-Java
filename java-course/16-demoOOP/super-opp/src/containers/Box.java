
package containers;

import enums.ContainerType;
import products.IProduct;

public class Box extends Container {

    private int length;
    private int width;

    public Box(String reference, int length, int width, int height) {
        super(reference);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public ContainerType getType() {
        return ContainerType.BOX;
    }

    @Override
    public int calculateSurface() {
        return length * width;
    }

    @Override
    public boolean isResistantTo(IProduct product) {
        return true;
    }
}
