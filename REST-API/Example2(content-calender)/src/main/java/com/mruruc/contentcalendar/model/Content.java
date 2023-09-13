package com.mruruc.contentcalendar.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
@Table( name="content")
public record Content(
        @Id
        @NotNull
        Integer id,
        @NotBlank
        String title,
        @Column(value ="description")
        String desc,
        Status status,
        @Column(value ="content_type")
        Type contentType,
        @Column(value ="date_created")
        LocalDateTime dateCreated,
        @Column(value ="date_updated")
        LocalDateTime dateUpdated,
        @Column(value ="url")
        String url

) {
}
