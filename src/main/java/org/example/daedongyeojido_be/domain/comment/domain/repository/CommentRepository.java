package org.example.daedongyeojido_be.domain.comment.domain.repository;

import org.example.daedongyeojido_be.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> , CommentRepositoryCustom{
}
