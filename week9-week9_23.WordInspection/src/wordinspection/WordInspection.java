/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Samuel Jo
 */
public class WordInspection  {

    private Scanner reader;
    private List<String> lines;
    private final String vowels = "aeiouyäö";

    public WordInspection(File file) throws Exception {
        this.lines = new ArrayList<String>();
        this.reader = new Scanner(file, "UTF-8");

        while (reader.hasNextLine()) {
            this.lines.add(reader.nextLine());
        }
    }

    public int wordCount() {
        return this.lines.size();
    }

    public List<String> wordsContainingZ(){
        List<String> containZ = new ArrayList<String>();
        for (String word : this.lines) {
            if (word.contains("z")) {
                containZ.add(word);
            }
        }
        return containZ;
    }

    public List<String> wordsEndingInL(){
        List<String> endInL = new ArrayList<String>();
        for (String word : this.lines) {
            if (word.endsWith("l")){
                endInL.add(word);
            }
        }
        return endInL;
    }

    public List<String> palindromes(){
        List<String> palindromes = new ArrayList<String>();
        
        for (String word : this.lines) {
            String reversedWord = "";
            for (int i = word.length () - 1; i >= 0; i--){
                reversedWord += word.charAt(i);
            }
            if (word.equals(reversedWord)){
                palindromes.add(word);
            }
        }
        return palindromes;
    }
    
    public List<String>wordsWhichContainAllVowels(){
        
        List<String>wordContainVowel = new ArrayList<String>();
        
        for (String word : this.lines){
            if (containsAllVowels(word)){
                wordContainVowel.add(word);
            }
        }
        return wordContainVowel;
    }
    
    public boolean containsAllVowels(String word){
        for (char vowel : this.vowels.toCharArray()){
            if (!word.contains("" + vowel)){
                return false;
            }
        }
        return true;
    }
}
