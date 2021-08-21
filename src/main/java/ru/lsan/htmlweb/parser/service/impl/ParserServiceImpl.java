package ru.lsan.htmlweb.parser.service.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import ru.lsan.htmlweb.parser.service.ParserService;

@Service
public class ParserServiceImpl implements ParserService {

    @Override
    public String parse(String html) {
        Document doc = Jsoup.parse(html);
        String text = doc.body().text();
        return text;
    }
}
