package org.example.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
//Bu anotasyon, sınıfın bir JPA(Java Persistence API) varlık sınıfı olduğunu belirtir. Veritabanında bir tabloya karşılık geleceğini gösterir.
@Table(name = "user_table") //Bu anotasyon, JPA varlığının hangi veritabanı tablosuna karşılık geleceğini belirtir. name özelliği, tablo adını belirtir.
//@AllArgsConstructor ve @NoArgsConstructor: Lombok anotasyonlarıdır ve sırasıyla tüm parametreleri alan bir constructor ve parametresiz bir constructor oluştururlar.
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode: Bu anotasyon, nesne denkliği ve hash kodunu oluşturur. of özelliği, hangi alanların bu işlemlere dahil edileceğini belirtir.
@EqualsAndHashCode(of = {"id"})
@ToString
public class User {

    @Id//Bu anotasyon, birincil anahtar (primary key) alanını belirtir. Bu alan, veritabanındaki benzersiz kimliği temsil eder.
    //@SequenceGenerator:Bu anotasyon, bir dizi üreteci (sequence generator) tanımlamak için kullanılır.
    // name özelliği, üretecin adını belirtir. allocationSize, her çağrıda kaç değer alınacağını belirtir.
    @SequenceGenerator(name = "seq_user_table", allocationSize = 1)
    //@GeneratedValue: Bu anotasyon, bir alanın otomatik olarak nasıl arttırılacağını belirtir.
    //generator özelliği, kullanılacak üreteciyi belirtir. strategy, artış stratejisini belirler
    @GeneratedValue(generator = "seq_user_table", strategy =  GenerationType.SEQUENCE)
    private long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "bio")
    private String bio;

    @Lob
    @Column(name="profileImage", length = 300000)
    private byte[] profileImage;

    @Column(name = "booleanAdmin")
    private boolean booleanAdmin;
}