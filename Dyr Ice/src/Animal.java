import javax.lang.model.element.AnnotationMirror;

public abstract class Animal {
    protected int id;
    protected String species;
    protected int cost;
    protected int lifeSpan;
    protected String temper;
    protected String AllergyFriendly;
    protected String origin;

    public Animal(int id,String species,int cost,int lifeSpan,String temper,String allergyFriendly){
        this.id = id;
        this.species = species;
        this.cost = cost;
        this.lifeSpan = lifeSpan;
        this.temper = temper;
        this.AllergyFriendly = allergyFriendly;
    }

    public Animal(int id,String species,String origin,int lifeSpan,String temper,String allergyFriendly){
        this.id = id;
        this.species = species;
        this.origin = origin;
        this.lifeSpan = lifeSpan;
        this.temper = temper;
        this.AllergyFriendly = allergyFriendly;
    }

    public int getId(){
        return this.id;
    }

    public String getSpecies(){
        return this.species;
    }

    public int getCost(){
        return this.cost;
    }

    public String getOrigin(){
        return this.origin;
    }

    public int getLifeSpan(){
        return this.lifeSpan;
    }

    public String getTemper(){
        return this.temper;
    }

    public String getAllergyFriendly(){
        return this.AllergyFriendly;
    }

}
