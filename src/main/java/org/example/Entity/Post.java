package org.example.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "post_table")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class Post {

    @Id
    @SequenceGenerator(name = "seq_post_table", allocationSize = 1)
    @GeneratedValue(generator = "seq_post_table", strategy =  GenerationType.SEQUENCE)
    private long id;

    @Column(name = "userId")
    private long userId;

    @Lob
    @Column(name="image", length = 300000)
    private byte[] image;

    @Column(name = "content")
    private String content;

    @Column(name = "dateTime")
    private LocalDateTime dateTime;
}