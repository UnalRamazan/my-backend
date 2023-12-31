package org.example.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "like_table")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class Like {

    @Id
    @SequenceGenerator(name = "seq_like_table", allocationSize = 1)
    @GeneratedValue(generator = "seq_like_table", strategy =  GenerationType.SEQUENCE)
    private long id;

    @Column(name = "userId")
    private long userId;

    @Column(name = "postId")
    private long postId;

    @Column(name = "dateTime")
    private LocalDateTime dateTime;
}