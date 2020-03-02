package hu.charmanthere.ease.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "article")
@Table(name = "articles")
@SequenceGenerator(name = "article_seq")
public class Article implements Serializable {

    private static final long serialVersionUID = -11655116L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_seq")
    private Long id;

    private String title;

    @Column(columnDefinition="TEXT")
    private String content;

    private String youtubeLink;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    private User user;

    private LocalDateTime creationTime;

    public Article() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
}
