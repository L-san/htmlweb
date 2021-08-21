package ru.lsan.htmlweb.database.service;

import ru.lsan.htmlweb.database.entity.Page;

public interface PageService {

    void createPage(String url);

    void delete(Page page);

    Page findPageByUrl(String url);
}
