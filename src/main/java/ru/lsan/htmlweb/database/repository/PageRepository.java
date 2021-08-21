package ru.lsan.htmlweb.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.lsan.htmlweb.database.entity.Page;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {

    @Query("select b from Page b where b.url = :url")
    Page findByUrl(@Param("url") String url);

}
