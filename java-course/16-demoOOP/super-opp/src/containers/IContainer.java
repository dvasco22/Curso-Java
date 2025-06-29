
package containers;

import java.util.Set;

import enums.ContainerType;
import products.IProduct;

public interface IContainer {

    // Getters

    String getReference(); // ok

    // int getResistance();
    ContainerType getType();
    // no es necesario implemetar getType en la clase container
    // ya que es abstracta, pero si se debe implenetar en todas
    // las clases hijas

    Set<IProduct> getProducts(); // ok

    // Propiedades calculadas

    int calculateSurface();

    int calculateVolume(); // ok

    // Lógica de negocio
    int volumeDisposable(); // ok

    boolean canInsert(IProduct product); // ok

    boolean isResistantTo(IProduct product); // ok
}
