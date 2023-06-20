import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class CharacterTest {

    @Test
    public void createdHealth1000() {
        Character c = new Character();
        assertEquals(c.getHealth(), 1000);
    }

    @Test
    public void createdLevel1() {
        Character c = new Character();
        assertEquals(c.getLevel(), 1);
    }

    @Test
    public void createdIsAlive() {
        Character c = new Character();
        assertTrue(c.isAlive());
    }


    @Test
    public void healSelf(){
        Character c = new Character();
        c.heal(c);
        assertEquals(1000, c.getHealth());
    }

    @Test
    public void healAlly(){
        Character c1 = new Character();
        Character c2 = new Character();
        Faction faction = new Faction("Candor");
        c1.joinFaction(faction);
        c2.joinFaction(faction);
        c2.setHealthTemp(500);
        c1.heal(c2);
        assertEquals(600, c2.getHealth());
    }

    @Test
    public void manaTest(){
        Character c1 = new Character();
        Character c2 = new Character();
        Faction faction = new Faction("Candor");
        c1.joinFaction(faction);
        c2.joinFaction(faction);
        c2.setHealthTemp(500);
        c1.heal(c2);
        assertEquals(10, c1.getMana());
    }
}
