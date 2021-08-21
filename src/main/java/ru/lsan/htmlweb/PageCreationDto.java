package ru.lsan.htmlweb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.lsan.htmlweb.database.entity.Page;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageCreationDto {

    private List<Page> pages = new ArrayList<>();

    public void addPage(Page page){
        this.pages.add(page);
    }
}
