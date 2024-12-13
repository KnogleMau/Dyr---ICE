public class Cats extends Animal {
    protected String origin;
    public Cats(String species,String origin,int lifeSpan,String temper,String allergyFriendly){
        super(species,lifeSpan,temper,allergyFriendly);
        this.origin = origin;
    }

    public String getOrigin(){
        return this.origin;
    }
    public String getSpecies() { return this.species; }


    public String toString() {
        return " Species: " + this.species + " :" +
                " Origin: " + this.origin + " :" +
                " LifeSpan: " + this.lifeSpan + " :" +
                " Temper: " + this.temper + " :" +
                " AllergyFriendly: " + this.AllergyFriendly;
    }
}
