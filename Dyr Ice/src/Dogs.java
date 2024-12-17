public class Dogs extends Animal {
    protected String cost;
public Dogs(String species,String cost, String lifespan, String temper, String allergyFriendly) {
    super(species, lifespan, temper, allergyFriendly);
    this.cost = cost;
}


    public String getCost(){
        return this.cost;
    }

public String toString(){
    return " species: " + this.species + " ;" +
            " cost: " + this.cost + " ;" +
            " lifespan: " + this.lifespan + " ;" +
            " temper: " + this.temper + " ;" +
            " allergyFriendly: " + this.allergyFriendly;
    }
}
