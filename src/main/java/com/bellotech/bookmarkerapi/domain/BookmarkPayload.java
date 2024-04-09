package com.bellotech.bookmarkerapi.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class BookmarkPayload {

    @NotBlank(message = "title must not be blank")
   private String title;
    @NotBlank(message = "url must not be empty")
   private String url;

}
