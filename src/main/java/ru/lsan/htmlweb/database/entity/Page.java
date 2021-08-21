package ru.lsan.htmlweb.database.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="page")
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = true)
    private String url;

    @OneToMany(mappedBy = "page", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private Set<Word> words;
}
