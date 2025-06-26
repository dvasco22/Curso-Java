package game;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//  Crea la clase Character con las propiedades    
//  name -> String
//  species -> char 
//  life -> int
//  strength -> int
//  role -> String
//  isZombi -> boolean

// Añade un método showCharacter para mostrar la información

public class Character {

    private static List<Character> characters = new ArrayList<Character>();

    public static void showList() {
        for (Character character : characters) {
            System.out.println(character.name);
        }
    }

    private static boolean isRepeatedName(String name) {
        for (Character character : characters) {
            if (character.name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    private UUID id;
    private String name;
    private Species species;
    private int life;
    private int strength;
    private Role role;
    private boolean isZombi;

    public Character(String name, Species species, int life, int strength, Role role, boolean isZombi) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.species = species;
        this.life = life;
        this.strength = strength;
        this.role = role;
        this.isZombi = isZombi;

        if (isRepeatedName(this.name)) {
            System.err.println("Error, nombre repetido: renombra el personaje");
            return;
        }
        characters.add(this);
    }

    public void renameInvalidCharacters(String name) {
        if (characters.contains(this)) {
            System.err.println("Invalid name");
            return;
        }
        ;
        this.name = name;
        characters.add(this);
    }

    public void showCharacter() {
        String zombiMessage = isZombi ? "Es un zombi" : "NO es un zombi";
        String message = """
                ==================
                Ficha de %s
                ==================
                Id: %s
                Especie: %s
                Role: %s
                Vida: %s
                Fuerza: %s
                %s
                """;
        System.out.println("");
        System.out.println(message.formatted(name,
                id,
                species.toString().toLowerCase(),
                role.toString().toLowerCase(),
                life, strength, zombiMessage));
    }

}