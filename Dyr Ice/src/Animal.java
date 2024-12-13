import javax.lang.model.element.AnnotationMirror;

public abstract class Animal {
    protected int id;
    protected String species;
    protected int lifeSpan;
    protected String temper;
    protected String AllergyFriendly;


    public Animal(int id,String species,int lifeSpan,String temper,String allergyFriendly){
        this.id = id;
        this.species = species;
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
