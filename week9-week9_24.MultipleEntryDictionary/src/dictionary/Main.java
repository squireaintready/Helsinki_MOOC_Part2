package dictionary;

public class Main {
    public static void main(String[] args) {
        // Test your dictionary here
        MultipleEntryDictionary dict = new PersonalMultipleEntryDictionary();
        dict.add("kussi", "six");
        dict.add("sam", "samuel");
        
        System.out.println(dict.translate("kussi"));
        dict.remove("sam");
        System.out.println(dict.translate("sam"));
    }
}
