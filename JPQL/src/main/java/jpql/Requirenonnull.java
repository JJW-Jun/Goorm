package jpql;

import lombok.NonNull;

public class Requirenonnull {
    public static void main(String args[]) {
        notNull(null);

    }

    static void notNull(@NonNull String str) {
        System.out.println(str);
    }
}
