
package local.collections.exercises.Ex05_Cards;

public enum Suits {
    HEARTS("Corazones","♥"), SPADES("Picas", "♠"), DIAMONDS("Diamantes", "♦"), CLUBS("Tréboles", "♣");
    
    String label;
    String icon;

    Suits(String label,String icon) {
        this.label = label;
        this.icon = icon;
    }
}
