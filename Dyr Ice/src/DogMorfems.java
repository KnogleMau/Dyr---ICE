public class DogMorfems {

    protected String gender;
    protected String size;
    protected String nameCriteria;
    protected String morfem;

    public DogMorfems(String gender, String size, String nameCriteria, String morfem)
    {
        this.gender = gender;
        this.size = size;
        this.nameCriteria = nameCriteria;
        this.morfem = morfem;
    }

    public String getGender()
    {
        return gender;
    }

    public String getSize()
    {
        return size;
    }

    public String getNameCriteria() {
        return nameCriteria;
    }

    public String getMorfem()
    {
        return morfem;
    }

    public String toString()
    {
        return "Gender: "+ this.gender+ " Size: " + this.size +
                "\n nameCriteria: " + this.nameCriteria + " Morfem: " + this.morfem;
    }
}