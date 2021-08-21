package ru.lsan.htmlweb.statistics.impl;

import org.springframework.stereotype.Service;
import ru.lsan.htmlweb.statistics.StatisticsService;

import java.util.ArrayList;
import java.util.NavigableMap;
import java.util.TreeMap;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final String[] regex = new String[]{"\\.", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "~", "!", "@", "#", "$", "%", "^", "&", "\\*", "\\(", "\\)", "-", "=", "\\+",
            "`", "_", "\"", "№", ";", "%", ":", "\\?", "\\*", ",", "'", "\\[", "]", "\\{", "}", "\\|", "/","—"};

    @Override
    public NavigableMap<String, Integer> countEntries(String words) {
        ArrayList<String> list = getWordsAsArrayList(words);
        TreeMap<String, Integer> map = new TreeMap<>();
        int counts;
        int i,j = 0;
        String name;

        while(j<list.size()) {
            name = list.get(j);
            counts = 0;
            i=0;
            while (i < list.size()) {
                if (name.equalsIgnoreCase(list.get(i))) {
                    list.remove(i);
                    counts++;
                }else{
                    i++;
                }
            }
            map.put(name, counts);
            j++;
        }
        return map;
    }

    private  ArrayList<String> getWordsAsArrayList(String str){
        String aux = str;
        ArrayList<String> list = new ArrayList<>();
        for (String s : regex) {
            aux = aux.replaceAll(s, " ");
        }
        String[] words = aux.split(" ");
        for (String s : words) {
            if (!s.isEmpty()) {
                list.add(s);
            }
        }
        return list;
    }
}
