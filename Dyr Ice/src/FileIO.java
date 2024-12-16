import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class FileIO {

    String dogMorfemFile;

    public ArrayList<String> morfemFileReader(String path)
    {
        ArrayList<String> morfems = new ArrayList<>();
        File morfemFile = new File(path);

        try {

            Scanner scan = new Scanner(morfemFile);
            while (scan.hasNextLine()) {
                String dogMorfemFile = scan.nextLine();

                morfems.add(dogMorfemFile);
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Could not find the file");
        }
        return morfems;
    }
}
