package domain.gifts;

import domain.interfaces.*;
import utils.Euro;

public class Book extends Gift implements HasMinimumAge, HasNotNullParameters {
    private final String title, author;
    private final int pages, minimumAge;

    public Book(String title, String author, int pages, Euro prijs) {
        super(prijs);
        checkNotNull(title);
        this.title = title;
        checkNotNull(author);
        this.author = author;
        if (pages < 1) throw new IllegalArgumentException("pages must be > 0");
        this.pages = pages;
        this.minimumAge = setMinimumAge();
    }

    private int setMinimumAge() {
        if (pages < 10) return 0;
        int result = 8;
        for (int i = 10; i < pages; i += 50) {
            result++;
        }
        return result;
    }

    @Override
    public int getMinimumAge() {
        return minimumAge;
    }

    @Override
    public String toString() {
        return """
                Book - "%s" by %s, %d pages
                        Minimum age: %d
                        %s
                """.formatted(title, author, pages, minimumAge, getPrice());
    }

    public String getTitle() {
        return title;
    }
}
