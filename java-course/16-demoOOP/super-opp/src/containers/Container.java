
package containers;

import java.util.Set;
import products.IProduct;

public abstract class Container implements IContainer {

    private String reference;
    protected int resistance;
    protected int height;

    private Set<IProduct> products; // est datos

    public Container(String reference) { // const.
        this.reference = reference;
    }

    @Override
    public String getReference() { // ok
        return reference;
    }

    @Override
    public Set<IProduct> getProducts() { // ok
        return products;
    }

    @Override
    public int calculateVolume() { // ok
        return calculateSurface() * height;
    }

    @Override
    public boolean canInsert(IProduct product) { // ok
        // TODO Auto-generated method stub
        return false;
    }

    /*
     * @Override
     * public boolean isResistantTo(IProduct product) { // ok
     * // TODO Auto-generated method stub
     * // resistance
     * return false;
     * }
     */

    @Override
    public int volumeDisposable() { // ok

        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * Override la clase toString de OBJECT
     * la cual esta definida asi ;
     * public String toString() {
     * return getClass().getName() + "@" + Integer.toHexString(hashCode());
     * }
     */
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
