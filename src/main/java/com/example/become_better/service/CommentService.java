package com.example.become_better.service;

import com.example.become_better.model.Comment;
import com.example.become_better.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public Comment findCommentById(int id) {
        return commentRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("comment Id를 찾을 수 없습니다.");
        });
    }

    @Transactional
    public Comment writeComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Transactional
    public Comment updateComment(int commentId, Comment updateComment) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> {
            return new IllegalArgumentException("comment Id를 찾을 수 없습니다.");
        });
        comment.setContent(updateComment.getContent());
        return comment;
    }

    @Transactional
    public String deleteComment(int commentId) {
        commentRepository.deleteById(commentId);
        return "삭제 완료!";
    }
}
