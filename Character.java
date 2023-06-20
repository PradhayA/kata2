/*
A Character can Heal a Character.

* Dead characters cannot be healed
* Healing cannot raise health above 1000

A Character can only Heal itself.
 */

import java.util.HashSet;
import java.util.Set;

public class Character {

	private Set<Character> allies = new HashSet<>();
    private int health = 1000;
    private int level = 1;
    private boolean alive = true;
	private Set<Faction> factions = new HashSet<>();

	public int getHealth() {
		return health;
	}

	public int getLevel() {
		return level;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setHealthTemp(int newhealth){
		health = newhealth;
	}

	public void joinFaction(Faction faction){
		this.factions.add(faction);
		faction.addMember(this);
		for (Character ally: faction.getMembers()){
			this.allies.add(ally); // Add ally to current ally list
			ally.allies.add(this); // Allies have character added to them
		}
	}

	public void leaveFaction(Faction faction){
		if (!factions.contains(faction)){
			return;
		}
		this.factions.remove(faction);
		faction.removeMember(this);
		for (Character ally: faction.getMembers()){
			this.allies.remove(ally); // Remove ally from current ally list
			ally.allies.remove(this); // Allies have character removed from them
		}
	}

	public void heal(Character character){
		int healRate = 100;
		if (character == this || (allies.contains(character) && character.isAlive())){
			character.health = Math.min(character.getHealth() + healRate, 1000);
		}
	}

	public static void main(String[] args){
		Character character1 = new Character();
		Character character2 = new Character();
		Faction fact1 = new Faction("Candor");
		character1.joinFaction(fact1);
		character1.heal(character2);
		System.out.println(character1.getHealth());
	}
}
