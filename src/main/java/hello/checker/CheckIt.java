package hello.checker;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class CheckIt {

    public static void main(String[] args) {
        String s = new CheckIt().run();
        System.out.println(s);
    }

    private String run() {
        @NonNull String s = randString();
        return s;
    }

    private String randString() {
        int rand = ThreadLocalRandom.current().nextInt();
        if (rand < 0) {
            return rand - 1 >= 0 ?
                    "a" :
                    Optional.of("").orElse(null);
        }
        return "b";
    }
}
