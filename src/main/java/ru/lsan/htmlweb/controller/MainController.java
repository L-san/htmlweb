package ru.lsan.htmlweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lsan.htmlweb.PageCreationDto;
import ru.lsan.htmlweb.database.entity.Page;
import ru.lsan.htmlweb.database.entity.Word;
import ru.lsan.htmlweb.database.service.PageService;
import ru.lsan.htmlweb.database.service.WordService;
import ru.lsan.htmlweb.parser.service.PageLoaderService;
import ru.lsan.htmlweb.parser.service.ParserService;
import ru.lsan.htmlweb.statistics.StatisticsService;

import java.util.List;
import java.util.NavigableMap;

@EnableAutoConfiguration
@Controller
public class MainController {

    @Autowired
    private PageLoaderService pageLoaderService;

    @Autowired
    private ParserService parserService;

    @Autowired
    private PageService pageService;

    @Autowired
    private WordService wordService;

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/")
    public String index(Model model) {
        PageCreationDto pageForm = new PageCreationDto();
        pageForm.addPage(new Page());
        model.addAttribute("form", pageForm);
        return "search";
    }


    @PostMapping("/show")
    public String show(@ModelAttribute PageCreationDto form, Model model) {
        String url = form.getPages().get(0).getUrl();
        Page page;
        String pageContent;
        String pageText = null;
        NavigableMap<String, Integer> wordsMap;

       if((page = pageService.findPageByUrl(url))==null){
            //если страницы нет создать новую и записать слова в базу
            pageContent = pageLoaderService.loadPage(url);
            pageService.createPage(url);
            page = pageService.findPageByUrl(url);
            if (pageContent != null) {
                pageText = parserService.parse(pageContent);
            }

            if (pageText != null) {
                wordsMap = statisticsService.countEntries(pageText);
                for (String key : wordsMap.keySet()) {
                    wordService.createWord(key, wordsMap.get(key), page);
                }
            }
        }

        List<Word> wordList = wordService.getAllByPageUrl(url);

        model.addAttribute("words", wordList);

        return "results";
    }
}
