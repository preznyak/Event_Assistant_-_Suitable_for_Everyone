package hu.charmanthere.ease.controller;

import hu.charmanthere.ease.dao.entity.Article;
import hu.charmanthere.ease.exception.ArticleWithIdDoesNotExistException;
import hu.charmanthere.ease.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/article")
public class ArticleController {
    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<?> findAllArticle() {
        return new ResponseEntity<>(articleService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(articleService.findById(id), HttpStatus.OK);
        } catch (ArticleWithIdDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createArticle(@RequestBody Article article) {
        articleService.save(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/{id}")
    public ResponseEntity<?> updateArticleById(@PathVariable Long id, @RequestBody Article article) {
        try {
            articleService.update(id, article);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ArticleWithIdDoesNotExistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{id}")
    public ResponseEntity<?> deleteAddressById(@PathVariable Long id) {
        articleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
