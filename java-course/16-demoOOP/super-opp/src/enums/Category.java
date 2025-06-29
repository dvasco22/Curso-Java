
package enums;

public enum Category {
    FOOD("Alimentación"), DRUGSTORE("Droguería"), HYGIENE("Higiene"), PETS("Mascotas");

    String name;

    Category(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
