package ru.lsan.htmlweb.database.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "word")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = true)
    private String value;

    @Column(nullable = true)
    private long count;

    @ManyToOne
    @JoinColumn(name = "page_id", nullable = false)
    private Page page;


}
