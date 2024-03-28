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

        bookmarkRepository.save(new Bookmark(null,"Zoopla","https://www.zoopla.co.uk/",Instant.now()));

        bookmarkRepository.save(new Bookmark(null,"Unihome"," https://www.unihomes.co.uk/",Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"Skyes","https://www.sykescottages.co.uk/",Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"OpenRent","https://www.openrent.co.uk/",Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"RentGuarantor","https://rentguarantor.com/",Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"CouncilRent","https://www.councilexchangesite.co.uk/",Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"YourMove","https://www.your-move.co.uk/rent",Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"Tidal","https://www.tidal.wales/",Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"SwansLettings","https://swansalesandlettings.co.uk",Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"Market","https://www.onthemarket.com//",Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"Home","https://www.onthemarket.com//",Instant.now()));
        bookmarkRepository.save(new Bookmark(null,"StudentHome","https://www.onthemarket.com//",Instant.now()));



    }
}
