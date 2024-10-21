package fr.epsi.i1cap2024produits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CharacterTest {

    @Test
    public void testCharacterInitialization() {
        // Test de création d'un personnage avec un niveau de départ à 1
        Character character = new Character("Gandalf", "Mage");
        assertEquals("Gandalf", character.getName());
        assertEquals("Mage", character.getClassType());
        assertEquals(1, character.getLevel());
    }

    @Test
    public void testLevelUp() {
        // Test de la méthode levelUp qui doit augmenter le niveau de 1
        Character character = new Character("Legolas", "Archer");
        character.levelUp();
        assertEquals(2, character.getLevel());
    }
}