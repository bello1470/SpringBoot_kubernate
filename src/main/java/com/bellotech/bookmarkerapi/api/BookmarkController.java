package com.bellotech.bookmarkerapi.api;

import com.bellotech.bookmarkerapi.domain.BookmarkDTO;
import com.bellotech.bookmarkerapi.domain.BookmarkPayload;
import com.bellotech.bookmarkerapi.domain.BookmarksDTO;
import com.bellotech.bookmarkerapi.domain.BookmarkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @GetMapping("")
    public BookmarksDTO getBookmarks(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                    @RequestParam(name = "query", defaultValue = "") String query){

        if (query == null || query.trim().isEmpty()){

            return bookmarkService.getBookmarks(page);
        }


        return bookmarkService.searchBookmark(query,page);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookmarkDTO createdBookmark(@RequestBody @Valid BookmarkPayload bookmarkPayload) {

        return bookmarkService.createdBookmark(bookmarkPayload);

    }
}
