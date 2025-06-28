
package containers;

import java.util.Set;

import enums.ContainerType;
import products.IProduct;

public interface IContainer {

    // Getters

    String getReference();

    int getVolume();

    int getSurface();

    int getResistance();

    ContainerType getType();

    Set<IProduct> getProducts();

    // Lógica de negocio
    int volumeDisposable();

    boolean canInsert(IProduct product);

    boolean isResistantTo(IProduct product);
}
