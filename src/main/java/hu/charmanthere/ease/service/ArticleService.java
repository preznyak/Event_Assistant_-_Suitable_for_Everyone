package hu.charmanthere.ease.service;

import hu.charmanthere.ease.dao.entity.Article;
import hu.charmanthere.ease.dao.implementation.ArticleDaoImpl;
import hu.charmanthere.ease.exception.ArticleWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private ArticleDaoImpl articleDao;

    @Autowired
    public ArticleService(ArticleDaoImpl articleDao) {
        this.articleDao = articleDao;
    }

    public void deleteById(Long id) {
        articleDao.deleteById(id);
    }

    public void save(Article article) {
        articleDao.save(article);
    }

    public List<Article> findAll() {
        return articleDao.findAll();
    }

    public Article findById(Long id) throws ArticleWithIdDoesNotExistException {
        return articleDao.findById(id);
    }

    public void update(Long id, Article article) throws ArticleWithIdDoesNotExistException {
        articleDao.update(id, article);
    }
}
