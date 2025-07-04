
package containers;

import java.util.Set;

import enums.ContainerType;
import products.IProduct;

public interface IContainer {

    // Getters

    String getReference();

    // int getResistance();
    ContainerType getType();
    // no es necesario implemetar getType en la clase container
    // ya que es abstracta, pero si se debe implenetar en todas
    // las clases hijas

    Set<IProduct> getProducts();

    // Propiedades calculadas

    int calculateSurface();

    int calculateVolume();

    // Lógica de negocio
    int volumeAvailable();

    boolean canInsert(IProduct product);

    boolean isResistantTo(IProduct product);
}