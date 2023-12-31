package org.example.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "comment_table")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString

public class Comment {

    @Id
    @SequenceGenerator(name = "seq_comment_table", allocationSize = 1)
    @GeneratedValue(generator = "seq_comment_table", strategy =  GenerationType.SEQUENCE)
    private long id;

    @Column(name = "userId")
    private long userId;

    @Column(name = "postId")
    private long postId;

    @Column(name = "content")
    private String content;

    @Column(name = "dateTime")
    private LocalDateTime dateTime;
}