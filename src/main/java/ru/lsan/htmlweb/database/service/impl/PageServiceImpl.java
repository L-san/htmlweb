package ru.lsan.htmlweb.database.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lsan.htmlweb.database.entity.Page;
import ru.lsan.htmlweb.database.repository.PageRepository;
import ru.lsan.htmlweb.database.service.PageService;

@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private PageRepository pageRepository;

    @Override
    public void createPage(String url) {
        Page page = new Page();
        page.setUrl(url);
        pageRepository.save(page);
    }

    @Override
    public void delete(Page page) {
        pageRepository.delete(page);
    }

    @Override
    public Page findPageByUrl(String url) {
        return pageRepository.findByUrl(url);
    }
}
