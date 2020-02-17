package hu.charmanthere.ease.dao.repository;

import hu.charmanthere.ease.dao.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepositoryInterface extends JpaRepository<Comment,Long> {
}
