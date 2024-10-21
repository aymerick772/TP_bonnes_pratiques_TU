package fr.epsi.i1cap2024produits;

// Character.java
public class Character {
    private String name;
    private String classType;
    private int level;

    // Constructeur qui initialise le personnage avec un niveau de départ de 1
    public Character(String name, String classType) {
        this.name = name;
        this.classType = classType;
        this.level = 1;
    }

    // Méthode pour augmenter le niveau du personnage de 1
    public void levelUp() {
        this.level += 1;
    }

    // Getters pour accéder aux attributs
    public String getName() {
        return name;
    }

    public String getClassType() {
        return classType;
    }

    public int getLevel() {
        return level;
    }

    // Méthode toString pour un affichage facile
    @Override
    public String toString() {
        return "Nom: " + name + ", Classe: " + classType + ", Niveau: " + level;
    }
}
