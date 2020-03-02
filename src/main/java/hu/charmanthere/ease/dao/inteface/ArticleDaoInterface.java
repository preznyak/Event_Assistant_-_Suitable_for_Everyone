package hu.charmanthere.ease.dao.inteface;

import hu.charmanthere.ease.dao.entity.Article;
import hu.charmanthere.ease.exception.ArticleWithIdDoesNotExistException;

import java.util.List;

public interface ArticleDaoInterface {

    void deleteById(Long id);

    void save(Article article);

    List<Article> findAll();

    Article findById(Long id) throws ArticleWithIdDoesNotExistException;

    void update(Long id, Article article) throws ArticleWithIdDoesNotExistException;
}
