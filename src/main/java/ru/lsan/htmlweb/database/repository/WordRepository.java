package ru.lsan.htmlweb.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.lsan.htmlweb.database.entity.Word;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

    @Query("select b from Word b where b.page.url = :url")
    List<Word> findAllByPageUrl(@Param("url") String url);

}
