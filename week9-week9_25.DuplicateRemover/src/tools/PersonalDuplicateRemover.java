/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Samuel Jo
 */
public class PersonalDuplicateRemover implements DuplicateRemover {
    private Set<String>remover;
    private int counter;

    public PersonalDuplicateRemover(){
        this.remover = new HashSet<String>();
    }

    //stores a characterString if not a duplicate
    @Override
    public void add(String characterString) {
        //ASSUME HASHSETS CANNOT CONTAIN DUPLICATES THUS
        boolean added = remover.add(characterString);
        if (!added){
            counter++;
        }
    }

    //returns number of duplicates
    @Override
    public int getNumberOfDetectedDuplicates() {
        return counter;
    }

    
    //returns an object which implements the interface Set<String>
    @Override
    public Set<String> getUniqueCharacterStrings() {
        return this.remover; 
   }

    //removes stored charactersStrings and resets amount of detected duplicates
    @Override
    public void empty() {
        this.remover.clear();
        counter = 0;
    }
    
}
