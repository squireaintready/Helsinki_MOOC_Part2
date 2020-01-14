
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samuel Jo
 */
public class Printer {
    private Scanner reader;
    private List<String>lines;
    
    public Printer(String fileName) throws Exception{
        this.reader = new Scanner(new File(fileName));
        this.lines = new ArrayList<String>();
        
        while (this.reader.hasNextLine()){
            this.lines.add(reader.nextLine());
        }
    }
    
    public void printLinesWhichContain(String word){
        for (String string : this.lines){
            if (string.contains(word)){
                System.out.println(string);
            }
        }
    }
}    