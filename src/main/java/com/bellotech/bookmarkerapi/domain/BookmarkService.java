package com.bellotech.bookmarkerapi.domain;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@Transactional
@AllArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    private final BookmarkMapper bookmarkMapper;


    @Transactional(readOnly = true)
    public BookmarksDTO getBookmarks(Integer page) {

        int pageNo = page < 1 ? 0 : page - 1;

        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");


        Page<BookmarkDTO> bookmarkDTOPage = bookmarkRepository.findAllPages(pageable);
        return new BookmarksDTO(bookmarkDTOPage);
    }

    @Transactional(readOnly = true)
    public BookmarksDTO searchBookmark(String query, Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;

        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");


        Page<BookmarkDTO> bookmarkDTOPage = bookmarkRepository.searchByTitleContainingIgnoreCase(query, pageable);
        return new BookmarksDTO(bookmarkDTOPage);
    }

    public BookmarkDTO createdBookmark(BookmarkPayload bookmarkPayload) {

        Bookmark bookmark = new Bookmark(null, bookmarkPayload.getTitle(),bookmarkPayload.getUrl(), Instant.now());
        Bookmark savedBookmark = bookmarkRepository.save(bookmark);
        return bookmarkMapper.toBookmarkDTO(savedBookmark);
    }
}