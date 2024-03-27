package com.bellotech.bookmarkerapi;

import com.bellotech.bookmarkerapi.domain.Bookmark;
import com.bellotech.bookmarkerapi.domain.BookmarkRepository;
import com.bellotech.bookmarkerapi.domain.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class SeedData implements CommandLineRunner {

    private final BookmarkRepository bookmarkRepository;
    @Override
    public void run(String... args) throws Exception {

        Bookmark bookmark1 = new Bookmark();
        bookmark1.setTitle("Zoopla");
        bookmark1.setUrl("https://www.zoopla.co.uk/");
        bookmark1.setCreatedAt(Instant.now());
        bookmarkRepository.save(bookmark1);

        bookmarkRepository.save(new Bookmark("OnTheMarket","https://www.zoopla.co.uk/",Instant.now()));
    }
}
