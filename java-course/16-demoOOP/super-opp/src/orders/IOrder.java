/* 
package orders;

import java.util.Set;

import containers.IContainer;
import products.IProduct;

public interface IOrder {

    // Getters

    String getReference();

    Set<IContainer> getContainers();

    Set<IProduct> getProducts();

    // Lógica de negocio

    void addContainer(IContainer container);

    IContainer addProduct(IProduct product);

}*/

package orders;

import java.util.Set;

import containers.IContainer;
import products.IProduct;

public interface IOrder {

    // Getters

    String getReference();

    Set<IContainer> getContainers();

    // Lógica de negocio

    void addContainer(IContainer container);

    Set<IProduct> getCalculatedProducts();

    IContainer addProduct(IProduct product);

}
