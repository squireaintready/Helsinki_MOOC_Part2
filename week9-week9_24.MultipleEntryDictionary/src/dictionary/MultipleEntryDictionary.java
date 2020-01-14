package dictionary;

import java.util.Set;

public interface MultipleEntryDictionary {
    //add a new entry to a word, maintaining old ones.
    void add(String word, String entry);
    //retursn a set object with all entries of the word, or null reference if not contained.
    Set<String> translate(String word);
    //removes a word and all entries from dictionary.
    void remove(String word);
}
