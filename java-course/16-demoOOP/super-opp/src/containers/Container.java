
/*package containers;

import java.util.Set;

import enums.ContainerType;
import products.IProduct;

public abstract class Container implements IContainer {

    private String reference;
    private ContainerType type;
    private int resistance;
    private int surface;
    private int volume;
    private Set<IProduct> products;

    public Container(String reference) {
        this.reference = reference;
    }

    @Override
    public String getReference() {
        return reference;
    }

    @Override
    public ContainerType getType() {
        return type;
    }

    @Override
    public int getResistance() {
        return resistance;
    }

    @Override
    public int getSurface() {
        return surface;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public Set<IProduct> getProducts() {
        return products;
    }

    @Override
    public boolean canInsert(IProduct product) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isResistantTo(IProduct product) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int volumeDisposable() {
        // TODO Auto-generated method stub
        return 0;
    }

}
*/

package containers;

import java.util.Set;
import products.IProduct;

public abstract class Container implements IContainer {

    private String reference;
    protected int resistance;
    protected int height;

    private Set<IProduct> products;

    public Container(String reference) {
        this.reference = reference;
    }

    @Override
    public String getReference() {
        return reference;
    }

    @Override
    public Set<IProduct> getProducts() {
        return products;
    }

    @Override
    public int calculateVolume() {
        return calculateSurface() * height;
    }

    @Override
    public boolean canInsert(IProduct product) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isResistantTo(IProduct product) {
        // TODO Auto-generated method stub
        // resistance
        return false;
    }

    @Override
    public int volumeDisposable() {

        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        String message = """
                %s ref. %s
                Hash: %s
                """.formatted(
                getType(),
                reference,
                super.toString());

        return message;
    }

}
