package ru.lsan.htmlweb.database.service;

import ru.lsan.htmlweb.database.entity.Page;
import ru.lsan.htmlweb.database.entity.Word;

import java.util.List;

public interface WordService {

    void createWord(String value, int count, Page page);

    void delete(Word word);

    List<Word> getAllByPageUrl(String url);
}
