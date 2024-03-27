package com.bellotech.bookmarkerapi.api;

import com.bellotech.bookmarkerapi.domain.Bookmark;
import com.bellotech.bookmarkerapi.domain.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @GetMapping("")
    public List<Bookmark> getBookmarks(){

        return bookmarkService.getBookmarks();
    }
}
