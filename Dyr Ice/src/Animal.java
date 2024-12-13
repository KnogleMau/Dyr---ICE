import javax.lang.model.element.AnnotationMirror;

public abstract class Animal {
    protected String species;
    protected int lifeSpan;
    protected String temper;
    protected String AllergyFriendly;


    public Animal(String species,int lifeSpan,String temper,String allergyFriendly){

        this.species = species;
        this.lifeSpan = lifeSpan;
        this.temper = temper;
        this.AllergyFriendly = allergyFriendly;
    }

    public String getSpecies(){
        return this.species;
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
