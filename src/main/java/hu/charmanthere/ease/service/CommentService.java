package hu.charmanthere.ease.service;

import hu.charmanthere.ease.dao.entity.Comment;
import hu.charmanthere.ease.dao.implementation.CommentDaoImpl;
import hu.charmanthere.ease.exception.CommentWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    public CommentDaoImpl commentDao;

    @Autowired
    public CommentService(CommentDaoImpl commentDao) {
        this.commentDao = commentDao;
    }

    public List<Comment> findAllComment() {
        return commentDao.findAll();
    }

    public Comment findById(Long id) throws CommentWithIdDoesNotExistException {
        return commentDao.findById(id);
    }

    public void createComment(Comment comment) {
        commentDao.save(comment);
    }

    public void update(Long id, Comment comment) throws CommentWithIdDoesNotExistException {
        commentDao.update(id,comment);
    }

    public void deleteById(Long id) {
        commentDao.deleteById(id);
    }
}
