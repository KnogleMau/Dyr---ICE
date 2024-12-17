public class Cats extends Animal {
    protected String origin;
    public Cats(String species,String origin, String lifespan,String temper,String allergyFriendly){
        super(species,lifespan,temper,allergyFriendly);
        this.origin = origin;
    }

    public String getOrigin(){
        return this.origin;
    }

    @Override
    public String getSpecies(){return this.species;}

    public String toString() {
        return " Species: " + this.species + " ||| " +
                " Origin: " + this.origin + " ||| " +
                " LifeSpan: " + this.lifespan + " ||| " +
                " Temper: " + this.temper + " ||| " +
                " AllergyFriendly: " + this.allergyFriendly;
    }
}
