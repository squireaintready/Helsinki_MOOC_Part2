/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Samuel Jo
 */
public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {
    private Map<String, Set<String>> dictionary;
    
    public PersonalMultipleEntryDictionary(){
        this.dictionary = new HashMap<String, Set<String>>();
    }

    @Override
    public void add(String word, String entry) {
        if (!this.dictionary.containsKey(word)){
            this.dictionary.put(word, new HashSet<String>());
        }
        
        Set<String> finished = this.dictionary.get(word);
        this.dictionary.get(word).add(entry);
    }

    @Override
    public Set<String> translate(String word) {
        Set<String>translation = null;
        if (this.dictionary.containsKey(word)){
            translation = this.dictionary.get(word);
        }
        return translation;
    }

    @Override
    public void remove(String word) {
        if (this.dictionary.containsKey(word)){
            this.dictionary.remove(word);
        }
    }
    
}
