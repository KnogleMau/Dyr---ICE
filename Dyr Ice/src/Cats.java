public class Cats extends Animal {
    public Cats(int id,String species,String origin,int lifeSpan,String temper,String allergyFriendly){
        super(id,species,origin,lifeSpan,temper,allergyFriendly);
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
