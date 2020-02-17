package hu.charmanthere.ease.dao.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "serviceDetails")
@Table(name = "service_details")
@SequenceGenerator(name = "service_details_seq")
public class ServiceDetails {

    private static final long serialVersionUID = 3128187257579278210L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_details_seq")
    private Long id;

    private Double rating;

    private Integer ratingNumber;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Comment> commentList;

    public ServiceDetails() {
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getRatingNumber() {
        return ratingNumber;
    }

    public void setRatingNumber(Integer ratingNumber) {
        this.ratingNumber = ratingNumber;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceDetails that = (ServiceDetails) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ServiceDetails{" +
                "id=" + id +
                ", rating=" + rating +
                ", ratingNumber=" + ratingNumber +
                '}';
    }
}
