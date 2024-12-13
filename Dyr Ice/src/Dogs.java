public class Dogs extends Animal {
    protected int cost;
public Dogs(String species,int cost, int lifeSpan, String temper, String allergyFriendly) {
    super(species, lifeSpan, temper, allergyFriendly);
    this.cost = cost;
}


    public int getCost(){
        return this.cost;
    }

public String toString(){
    return " species: " + this.species + " ; " +
            " cost: " + this.cost + " ;" +
            " lifespan: " + this.lifeSpan + " ;" +
            " temper: " + this.temper + " ;" +
            " allergyFriendly: " + this.AllergyFriendly;
    }
}
