package ru.lsan.htmlweb.parser.service.impl;

import org.springframework.stereotype.Service;
import ru.lsan.htmlweb.parser.service.PageLoaderService;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

@Service
public class PageLoaderServiceImpl implements PageLoaderService {
    @Override
    public String loadPage(String urlString) {
        StringBuilder buffer = new StringBuilder();
        try {
            final URL url = new URL(urlString);
            URLConnection urlConnection;

            urlConnection = url.openConnection();
            urlConnection.connect();

            Scanner scUrl = new Scanner(urlConnection.getInputStream());

            while (scUrl.hasNext()) {
                buffer.append(scUrl.nextLine());
            }
            scUrl.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return buffer.toString();
    }
}
