package com.mruruc.contentcalendar.Repository;

import com.mruruc.contentcalendar.model.Content;
import org.springframework.data.repository.ListCrudRepository;

public interface ContentRepository extends ListCrudRepository<Content,Integer> {
}
