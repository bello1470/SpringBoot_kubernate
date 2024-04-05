package com.bellotech.bookmarkerapi.domain;

import com.bellotech.bookmarkerapi.domain.Bookmark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {


    @Query(
            "select new com.bellotech.bookmarkerapi.domain.BookmarkDTO(s.id,s.title,s.url,s.createdAt) from Bookmark s "
    )
    Page<BookmarkDTO> findAllPages(Pageable pageable);
//
//    @Query("""
//
//            select new com.bellotech.bookmarkerapi.domain.BookmarkDTO(s.id,s.title,s.url,s.createdAt) from Bookmark s
//            where lower(s.title) like lower (concat('%', :query, '%'))
//             """)
//    Page<BookmarkDTO> searchBookmark(String query, Pageable pageable);
    Page<BookmarkDTO> searchByTitleContainingIgnoreCase(String query, Pageable pageable);
}
////////////////////////////