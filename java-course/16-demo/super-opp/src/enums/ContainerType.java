
package enums;

public enum ContainerType {

    // BAG, BOX

    BAG("bolsa"), BOX("caja");

    String name;

    ContainerType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
