package com.bellotech.bookmarkerapi.api;

import com.bellotech.bookmarkerapi.domain.Bookmark;
import com.bellotech.bookmarkerapi.domain.BookmarkRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BookmarkControllerTest {

@Autowired
    private MockMvc mockMvc;

@Autowired
    BookmarkRepository bookmarkRepository;

private List<Bookmark> bookmarks;

@BeforeEach
void setUp(){
    bookmarkRepository.deleteAllInBatch();

    bookmarks = new ArrayList<>();

    bookmarks.add(new Bookmark(null,"Zoopla","https://www.zoopla.co.uk/", Instant.now()));

    bookmarks.add(new Bookmark(null,"Unihome"," https://www.unihomes.co.uk/",Instant.now()));
    bookmarks.add(new Bookmark(null,"Skyes","https://www.sykescottages.co.uk/",Instant.now()));
    bookmarks.add(new Bookmark(null,"OpenRent","https://www.openrent.co.uk/",Instant.now()));
    bookmarks.add(new Bookmark(null,"RentGuarantor","https://rentguarantor.com/",Instant.now()));
    bookmarks.add(new Bookmark(null,"CouncilRent","https://www.councilexchangesite.co.uk/",Instant.now()));
    bookmarks.add(new Bookmark(null,"YourMove","https://www.your-move.co.uk/rent",Instant.now()));
    bookmarks.add(new Bookmark(null,"Tidal","https://www.tidal.wales/",Instant.now()));
    bookmarks.add(new Bookmark(null,"SwansLettings","https://swansalesandlettings.co.uk",Instant.now()));
    bookmarks.add(new Bookmark(null,"Market","https://www.onthemarket.com//",Instant.now()));
    bookmarks.add(new Bookmark(null,"Home","https://www.onthemarket.com//",Instant.now()));
    bookmarks.add(new Bookmark(null,"StudentHome","https://www.onthemarket.com//",Instant.now()));
bookmarkRepository.saveAll(bookmarks);


}

@Test
    void shouldBookmarks() throws Exception {

    mockMvc.perform(get("/api/bookmarks"))
            .andExpect(status()
                    .isOk())
            .andExpect( jsonPath("$.totalElement", CoreMatchers.equalTo(12 )));


}
}