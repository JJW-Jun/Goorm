import java.util.Arrays;
import java.util.List;
//https://beomseok95.tistory.com/277
public class Dictionary {
    private final List<String> words;
    private final LookupService lookupService;

    public Dictionary(List<String> words) {
        this.words = words;
        this.lookupService = new LookupService(words);
    }

    public boolean isFirstElement(String userData) {
        return lookupService.isFirstElement(userData);
    }
    public static void main(String args []){
        List<String> lst = Arrays.asList("a", "b", "c", "d");
        Dictionary dictionary = new Dictionary(lst);
        System.out.println(dictionary.isFirstElement(null));
    }
}

class LookupService {

    List<String> words;
    public LookupService(List<String> words) {
        this.words = words;
    }

    public boolean isFirstElement(String userData) {
        System.out.println("==========find");
        return words.get(0).contains(userData);
    }

}


