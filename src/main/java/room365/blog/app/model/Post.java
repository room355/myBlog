package room365.blog.app.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "title", nullable = false)
    @Length(min = 5)
    private String title;

    @Lob // Specifies that a persistent property or field should be persisted as a large object to a database-supported large object type.
    @Column(name = "body", columnDefinition = "CLOB")
    private String body;

}
