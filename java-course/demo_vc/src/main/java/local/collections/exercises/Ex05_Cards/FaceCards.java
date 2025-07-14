package local.collections.exercises.Ex05_Cards;

public enum FaceCards {
    ACE("As","A"), JACK ("Jack", "J"), QUEEN("Reina", "Q"), KING ("Rey","K");

    private FaceCards(String label, String icon) {
        this.label = label;
        this.icon = icon;
    }
    String label;
    String icon;

}
