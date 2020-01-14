package tools;

import java.util.Set;

public interface DuplicateRemover {
    //stores a characterString if not a duplicate
    void add(String characterString);
    //returns number of duplicates
    int getNumberOfDetectedDuplicates();
    //returns an object which implements the interface Set<String>
    Set<String> getUniqueCharacterStrings();
    //removes stored charactersStrings and resets amount of detected duplicates
    void empty();
}
