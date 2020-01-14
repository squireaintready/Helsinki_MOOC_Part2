/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Samuel Jo
 */
public class MindfulDictionary {
    private Map<String, String>dictionary;
    private File file;
    private Scanner reader;
    
    public MindfulDictionary(){
        this.dictionary = new HashMap<String, String>();
    }
    
    public MindfulDictionary(String file) throws FileNotFoundException{
        this();
        this.file = new File(file);
    }
    
    public boolean save(){
        /*dictionary contacts are written to the file whose name
        was given as a parameter to the constructor.
        false if unable to fave. otherwise true.
        */
        try{
            FileWriter writer = new FileWriter(this.file);
            saveWords(writer);
            writer.close();
        }catch (Exception e){
            return false;
        }return true;
    }
    
    public void saveWords(FileWriter writer) throws IOException{
        List<String>alreadyInFile = new ArrayList<String>();
        for (String word : this.dictionary.keySet()){
            String translation = this.dictionary.get(word);
            if (!alreadyInFile.contains(word)){
                String pair = word + ":" + this.dictionary.get(word);
                writer.write(pair + "\n");
                alreadyInFile.add(translation);
            }
        }
    }
    
    public boolean load(){
        try{
            Scanner reader = new Scanner(this.file);
            loadDictionary(reader);
            reader.close();
        }catch (Exception e){
            return false;
        }
        return true;
    }
    
    public void loadDictionary(Scanner reader){
        while(reader.hasNextLine()){
            String line = reader.nextLine();
            String[] parts = line.split(":");
            String word = parts[0];
            String translation = parts[1];
            this.dictionary.putIfAbsent(word, translation);
            this.dictionary.putIfAbsent(translation, word);
        }
    }
    
    public void remove(String word){
        if (this.dictionary.containsKey(word)
        || (this.dictionary.containsValue(word))){
            String trans = this.dictionary.get(word);
            this.dictionary.remove(word);
            this.dictionary.remove(trans);
        }
    }
    
    public void add(String word, String translation){
        if (!this.dictionary.containsKey(word)) {
            this.dictionary.put(word, translation);
            this.dictionary.put(translation, word);
        }
    }
    
    public String translate(String word){
        return this.dictionary.get(word);
    }
    
}
