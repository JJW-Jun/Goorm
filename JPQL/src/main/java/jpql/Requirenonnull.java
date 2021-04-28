package jpql;

import lombok.NonNull;

import java.util.List;
import java.util.Objects;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.springframework.util.Assert.notNull;

public class Requirenonnull {
    public static void main(String args[]) {
        notNull(null);
    }

//    static void notNull(@NonNull String str) {
//        System.out.println("====================");
//        assertNotNull(str);
//        System.out.println("====================");
//        System.out.println(str);
//    }
}
class Theater {

    private final List<String> movies;
    private final SearchService searchService;

    public Theater(@NonNull List<String> movies) {
        System.out.println("0");
        assertNotNull(movies, "message");
        this.movies = movies;
        this.searchService = new SearchService(movies);
    }

    public boolean findMovie(String userData) {
        return searchService.findMovie(userData);
    }

    public static void main(String args[]) {

        Theater theater = new Theater(null);
        System.out.println("1");
        boolean findMovie = theater.findMovie("아저씨");
    }
}


class SearchService {

    List<String> movies;

    public SearchService(List<String> movies) {
        this.movies = movies;
    }

    public boolean findMovie(String title) {
        return movies.get(0).contains(title);
    }
}