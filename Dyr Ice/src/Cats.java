public class Cats extends Animal {
    protected String origin;
    public Cats(int id,String species,String origin,int lifeSpan,String temper,String allergyFriendly){
        super(id,species,lifeSpan,temper,allergyFriendly);
        this.origin = origin;
    }

    public String getOrigin(){
        return this.origin;
    }

    public String toString() {
        return "id: " + this.id +
                " species: " + this.species +
                " origin: " + this.origin +
                " lifeSpan: " + this.lifeSpan +
                " temper: " + this.temper +
                " allergyFriendly: " + this.AllergyFriendly;
    }
}
