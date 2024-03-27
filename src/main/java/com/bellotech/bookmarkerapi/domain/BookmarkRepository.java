package com.bellotech.bookmarkerapi.domain;

import com.bellotech.bookmarkerapi.domain.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
}
