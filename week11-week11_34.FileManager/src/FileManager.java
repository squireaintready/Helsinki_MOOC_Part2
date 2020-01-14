
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    List<String>readFile = new ArrayList<String>();
    Scanner read = new Scanner(System.in);

    public List<String> read(String file) throws FileNotFoundException {
        File objectFile = new File(file);
        read = new Scanner(objectFile);
        while (read.hasNext()){
            readFile.add(read.nextLine());
        }
        return readFile;
    }

    public void save(String file, String text) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.close();
    }

    public void save(String file, List<String> texts) throws IOException {
        FileWriter writer = new FileWriter(file);
        for(int i = 0; i < texts.size(); i++){
            writer.write(texts.get(i) + "\n");
        }
        writer.close();
    }
}
