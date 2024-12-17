import javax.lang.model.element.AnnotationMirror;

public abstract class Animal {
    protected String species;
    protected String lifespan;
    protected String temper;
    protected String allergyFriendly;


    public Animal(String species,String lifespan,String temper,String allergyFriendly){

        this.species = species;
        this.lifespan = lifespan;
        this.temper = temper;
        this.allergyFriendly = allergyFriendly;
    }

    public String getSpecies(){
        return this.species;
    }

    public String getLifeSpan(){
        return this.lifespan;
    }

    public String getTemper(){
        return this.temper;
    }

    public String getAllergyFriendly(){
        return this.allergyFriendly;
    }

}
