import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

//https://beomseok95.tistory.com/277
public class Theater {
    Function<Integer, String> intToString = Objects::toString;
    Function<String, String> quote = s -> "'" + s + "'";
    private final SearchService searchService;

    protected Theater(SearchService searchService) {
        System.out.println("0");
        this.searchService = searchService;
    }

    public boolean findMovie(String userData) {
        return searchService.findMovie(userData);
    }

    public static void main(String args[]) {
        List<String> moives = Arrays.asList("아저씨", "마더", "해바라기");
        SearchService searchService = new SearchService(moives);

        Theater theater = new Theater(searchService);
        System.out.println("1");
        System.out.println(theater.findMovie("아저씨"));
    }
}


class SearchService {

    private final List<String> movies;

    public SearchService(List<String> movies) {
        this.movies = movies;
    }

    public boolean findMovie(String title) {
        System.out.println("2");
        return movies.contains(title);
    }
}