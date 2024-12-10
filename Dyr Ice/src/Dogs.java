public class Dogs extends Animal {
public Dogs(int id, String species, int cost, int lifeSpan, String temper, String allergyFriendly) {
    super(id, species, cost, lifeSpan, temper, allergyFriendly);
}

public String toString(){
    return "id: " + this.id + ", " +
            " species: " + this.species + ", " +
            " cost: " + this.cost + ", " +
            " lifespan: " + this.lifeSpan + ", " +
            " temper: " + this.temper + ", " +
            " allergyFriendly: " + this.AllergyFriendly +"!";

    }
}
