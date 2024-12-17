import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
public class CreateName {
    ArrayList<String> selectedCriterias;
    ArrayList<DogMorfems> dogMorf = new ArrayList<>();
    ArrayList<DogMorfems> selectedDogMorf1 = new ArrayList<>();
    ArrayList<DogMorfems> selectedDogMorf2 = new ArrayList<>();
    public int index;
    int inp1;
    int inp2;
    int inp3;
    int inp4;
    int inp5;


    String choice3;
    String choice4;
    String choice5;

    String result= "1";

    public void findMorfem(ArrayList<String> morfems) {
        //ArrayList<MaleDogs> dogMorf = new ArrayList<>();  rykket til klassens atributer for at andre metoder kan tilgå den
        try{
            for (String s : morfems) {
                String[] dogM = s.split(",");
                String gen = dogM[0];
                String size = dogM[1].trim();
                String criteria = dogM[2].trim();
                String morf = dogM[3].trim();
                DogMorfems morfem = new DogMorfems(gen, size, criteria, morf);
                dogMorf.add(morfem);
            }
        }
        catch (Exception e){
            System.out.println("could not create objects");
        }
        // return dogMorf;
    }

    public ArrayList<String> runCriteriaSelections(ArrayList<Integer> input) {
        selectedCriterias = new ArrayList<>();
        TextUI selectTrait = new TextUI();
/*
        String genderVariable = Integer.toString(input.get(0)); //changes int genderChoise to a String
        selectedCriterias.add(genderVariable); //adds genderChoise to ArrayList
        String dogSizeVariable = Integer.toString(input.get(1));// changes int dogSizechoise to a String
        selectedCriterias.add(dogSizeVariable); // adds dogSizechoise to ArrayList  */
        //String genderVariable = Integer.toString()


        String genderVariable =Integer.toString(input.get(0));
        String dogSizeVariable =Integer.toString(input.get(1));
        String selectTrait1 = Integer.toString((inp3));
        String selectTrait2 = Integer.toString((inp4));
        String selectTrait3 = Integer.toString((inp5));

        selectedCriterias.add(genderVariable);
        selectedCriterias.add(dogSizeVariable);

        if(selectTrait1.equals(0))
        {
            selectedCriterias.add(selectTrait2);
            selectedCriterias.add(selectTrait3);
        }
         else if(selectTrait2.equals(0))
        {
        selectedCriterias.add(selectTrait1);
        selectedCriterias.add(selectTrait3);
         }
         else if(selectTrait3.equals(0))
         {
         selectedCriterias.add(selectTrait1);
         selectedCriterias.add(selectTrait2);
         }





        //selectedCriterias.add(selectTrait2);
       // selectedCriterias.add(selectTrait1);
      //  selectedCriterias.add(selectTrait3);

     // String critiriaType1 = criteriaNumberChoice1;
        //String genderVariable =Integer.toString(input.get(2));
        //int criteriaCombination = selectedCriteria;
/*
        if (criteriaCombination == 1) {
            selectedCriterias.add(selectTrait.selectSpecificTraits("Please select one of the following genres:\n" +
                    "Royal: press [1]\nPredator: press [2]\nFantasy: press [3]\n" +
                    "Sport: press [4]\nFarm: press [5]\nAgillity: press [6]\nFamily: press [7]"));
            selectedCriterias.add(selectTrait.selectSpecificTraits("Please select one of the following personalyties:\n" +
                    "Extrovert: press [1]\nCalm: press [2]\nSneaky: press [3]\nClumpsy: press [4]"));
        } else if (criteriaCombination == 2) {
            selectedCriterias.add(selectTrait.selectSpecificTraits("Please select one of the following genres:\n" +
                    "Royal: press [1]\nPredator: press [2]\nFantasy: press [3]\n" +
                    "Sport: press [4]\nFarm: press [5]\nAgillity: press [6]\nFamily: press [7]"));
            selectedCriterias.add(selectTrait.selectSpecificTraits("Please select one of the following appearances:\n" +
                    "Cool: press [1]\nMuscular: press [2]\nConfused: press [3]\nBlack: press [4]\n" +
                    "White: press [5]\nFurry: press [6]"));
        } else if (criteriaCombination == 3) {
            selectedCriterias.add(selectTrait.selectSpecificTraits("Please select one of the following personalyties:\n" +
                    "Extrovert: press [1]\nCalm: press [2]\nSneaky: press [3]\nClumpsy: press [4]"));
            selectedCriterias.add(selectTrait.selectSpecificTraits("Please select one of the following appearances:\n" +
                    "Cool: press [1]\nMuscular: press [2]\nConfused: press [3]\nBlack: press [4]\n" +
                    "White: press [5]\nFurry: press [6]"));
        }*/
        return selectedCriterias;
    }


    public void createDogName(int inp1, int inp2) {
        FileIO file = new FileIO();
        findMorfem(file.morfemFileReader("C:\\Users\\thran\\Desktop\\Datamatiker\\1.Semester\\Dyr---ICE\\Dyr Ice\\anyMorfem.txt"));

        TextUI textUI = new TextUI();
        runCriteriaSelections(textUI.promptNumericDogNameTraits(1));

        String chosenGender = "";
        String chosenDogSize = "";

        if (selectedCriterias.get(0).equals("1")) {
            chosenGender = "female";
        } else if (selectedCriterias.get(0).equals("2")) {
            chosenGender = "male";
        }

        if (selectedCriterias.get(1).equals("1")) {
            chosenDogSize = "large";
        } else if (selectedCriterias.get(1).equals("2")) {
            chosenDogSize = "small";
        }
        for (DogMorfems d : dogMorf) {
            if (d.gender.equals(chosenGender) && d.size.equals(chosenDogSize) && d.nameCriteria.equals(selectedCriterias.get(2)))
            {
                selectedDogMorf1.add(d);
            }
        }
        for (DogMorfems d1 : dogMorf) {
            if (d1.gender.equals(chosenGender) && d1.size.equals(chosenDogSize) && d1.nameCriteria.equals(selectedCriterias.get(3))) {
                selectedDogMorf2.add(d1);
            }
        }


        int randomIndex1 = (int) (Math.random()*selectedDogMorf1.size());
        int randomIndex2 = (int) (Math.random()*selectedDogMorf2.size());
        DogMorfems dog1;
        DogMorfems dog2;

        dog1 = selectedDogMorf1.get(randomIndex1);
        dog2 = selectedDogMorf2.get(randomIndex2);

        String dog2Name= dog2.getMorfem();
        dog2Name.equalsIgnoreCase(dog2Name);
        result = dog1.getMorfem() + dog2Name;


        System.out.println(dog1.getMorfem() + " " + dog2Name);

    }
/*
    public DogMorfems getDogMorf(int i)
    {
        return dogMorf.get(i);
    }  */

}
