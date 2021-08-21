package ru.lsan.htmlweb.statistics;

import java.util.NavigableMap;

public interface StatisticsService {

    NavigableMap<String, Integer> countEntries(String words);

}
