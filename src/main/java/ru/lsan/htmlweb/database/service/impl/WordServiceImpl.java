package ru.lsan.htmlweb.database.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lsan.htmlweb.database.entity.Page;
import ru.lsan.htmlweb.database.entity.Word;
import ru.lsan.htmlweb.database.repository.WordRepository;
import ru.lsan.htmlweb.database.service.WordService;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordRepository wordRepository;

    @Override
    public void createWord(String value, int count, Page page) {
        Word word = new Word();
        word.setValue(value);
        word.setCount(count);
        word.setPage(page);
        wordRepository.save(word);
    }

    @Override
    public void delete(Word word) {
        wordRepository.delete(word);
    }

    @Override
    public List<Word> getAllByPageUrl(String url) {
        return wordRepository.findAllByPageUrl(url);
    }
}
