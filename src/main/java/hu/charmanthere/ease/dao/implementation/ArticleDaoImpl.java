package hu.charmanthere.ease.dao.implementation;

import hu.charmanthere.ease.dao.entity.Article;
import hu.charmanthere.ease.dao.inteface.ArticleDaoInterface;
import hu.charmanthere.ease.dao.repository.ArticleRepository;
import hu.charmanthere.ease.exception.ArticleWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleDaoImpl implements ArticleDaoInterface {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleDaoImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void deleteById(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void save(Article article) {
        articleRepository.save(article);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article findById(Long id) throws ArticleWithIdDoesNotExistException {
        Article article =  articleRepository.findById(id).orElse(null);
        if(article == null){
            throw new ArticleWithIdDoesNotExistException("Article with id "+id+" does not exist.");
        }
        return article;
    }

    @Override
    public void update(Long id, Article article) throws ArticleWithIdDoesNotExistException {
        Article articleToBeUpdated =  articleRepository.findById(id).orElse(null);
        if(articleToBeUpdated == null){
            throw new ArticleWithIdDoesNotExistException("Article with id "+id+" does not exist.");
        }
        articleToBeUpdated.setYoutubeLink(article.getYoutubeLink());
        articleToBeUpdated.setContent(article.getContent());
        articleToBeUpdated.setTitle(article.getTitle());
        articleRepository.save(articleToBeUpdated);
    }
}
