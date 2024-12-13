public class Dogs extends Animal {
    protected String cost;
public Dogs(String species,String cost, int lifeSpan, String temper, String allergyFriendly) {
    super(species, lifeSpan, temper, allergyFriendly);
    this.cost = cost;
}


    public String getCost(){
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
