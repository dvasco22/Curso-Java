
package orders;

import java.util.HashSet;
import java.util.Set;

import containers.IContainer;
import products.IProduct;

public class Order implements IOrder {

    private String reference;
    private Set<IContainer> containers;

    public Order(String reference) {
        this.reference = reference;
        this.containers = new HashSet<>();
    }

    @Override
    public String getReference() {
        return reference;
    }

    @Override
    public Set<IContainer> getContainers() {
        return containers;
    }

    @Override
    public Set<IProduct> getCalculatedProducts() {
        Set<IProduct> products = new HashSet<>();
        for (IContainer container : containers) {
            products.addAll(container.getProducts());
        }
        return products;
    }

    @Override
    public void addContainer(IContainer container) {
        containers.add(container);
    }

    @Override
    public IContainer addProduct(IProduct product) {
        // TODO Añadir al container

        for (IContainer container : containers) {
            if (container.canInsert(product)) {
                // container.getProducts().add(product);
                product.putInto(container);
                return container;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String message = """
                Pedido: %s
                Hash: %s
                """.formatted(reference,
                super.toString());

        for (IContainer container : containers) {
            message += container;
        }

        return message;
    }
}