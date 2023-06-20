import java.util.HashSet;
import java.util.Set;

public class Faction {
    private String name;
    private Set<Character> members = new HashSet<>();

    public Faction(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Set<Character> getMembers(){
        return members;
    }

    public void addMember(Character character){
        members.add(character);
    }

    public void removeMember(Character character){
        members.remove(character);
    }
}
