package org.example.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "follower_following_table")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class FollowerFollowing {

    @Id
    @SequenceGenerator(name = "seq_follower_following_table", allocationSize = 1)
    @GeneratedValue(generator = "seq_follower_following_table", strategy =  GenerationType.SEQUENCE)
    private long id;

    @Column(name = "followerId")
    private long followerId;

    @Column(name = "followingId")
    private long followingId;
}