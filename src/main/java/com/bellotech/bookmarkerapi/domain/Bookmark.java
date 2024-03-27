package com.bellotech.bookmarkerapi.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Entity
@Data
@Table(name = "bookmarks")
@RequiredArgsConstructor
public class Bookmark {

    @Id
    @SequenceGenerator(name = "bm_seq_gen", sequenceName = "bm_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bm_seq_gen")
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String url;
    private Instant createdAt;


}
