package hu.charmanthere.ease.dao.repository;

import hu.charmanthere.ease.dao.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
