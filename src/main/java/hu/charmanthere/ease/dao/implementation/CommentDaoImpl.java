package hu.charmanthere.ease.dao.implementation;

import hu.charmanthere.ease.dao.entity.Comment;
import hu.charmanthere.ease.dao.inteface.CommentDaoInterface;
import hu.charmanthere.ease.dao.repository.CommentRepositoryInterface;
import hu.charmanthere.ease.exception.CommentWithIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentDaoImpl implements CommentDaoInterface {

    private CommentRepositoryInterface commentRepositoryInterface;

    @Autowired
    public CommentDaoImpl(CommentRepositoryInterface commentRepositoryInterface) {
        this.commentRepositoryInterface = commentRepositoryInterface;
    }

    public List<Comment> findAll() {
        return commentRepositoryInterface.findAll();
    }

    public Comment findById(Long id) throws CommentWithIdDoesNotExistException {
        Comment comment = commentRepositoryInterface.findById(id).orElse(null);
        if(comment == null){
            System.out.println("Comment with "+ id + " does not exist!");
            throw new CommentWithIdDoesNotExistException("Comment with "+ id + " does not exist!");
        }
        return comment;
    }

    public void save(Comment comment) {
        commentRepositoryInterface.save(comment);
    }

    public void update(Long id, Comment comment) throws CommentWithIdDoesNotExistException {
        Comment commentToBeUpdated = commentRepositoryInterface.findById(id).orElse(null);
        if(comment == null){
            System.out.println("Comment with "+ id + " does not exist!");
            throw new CommentWithIdDoesNotExistException("Comment with "+ id + " does not exist!");
        }
        commentToBeUpdated.setCommenter(comment.getCommenter());
        commentToBeUpdated.setDate(comment.getDate());
        commentToBeUpdated.setMessage(comment.getMessage());
        commentRepositoryInterface.save(commentToBeUpdated);
    }

    public void deleteById(Long commentId) {
        commentRepositoryInterface.deleteById(commentId);
    }
}

