package org.example.daedongyeojido_be.domain.comment.presentation;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.comment.presentation.dto.request.CommentRequest;
import org.example.daedongyeojido_be.domain.comment.presentation.dto.response.CommentResponse;
import org.example.daedongyeojido_be.domain.comment.service.CreateCommentService;
import org.example.daedongyeojido_be.domain.comment.service.DeleteCommentService;
import org.example.daedongyeojido_be.domain.comment.service.QueryCommentService;
import org.example.daedongyeojido_be.domain.comment.service.UpdateCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CreateCommentService createCommentService;
    private final UpdateCommentService updateCommentService;
    private final QueryCommentService queryCommentService;
    private final DeleteCommentService deleteCommentService;

    @PostMapping("/{feed-id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@PathVariable ("feed-id") Long feedId, @RequestBody CommentRequest request) {
        createCommentService.createComment(feedId, request);
    }

    @PatchMapping("/{comment-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateComment(@PathVariable("comment-id") Long commentId, @RequestBody CommentRequest request) {
        updateCommentService.updateComment(commentId, request);
    }

    @GetMapping("/{feed-id}")
    public List<CommentResponse> getComment(@PathVariable("feed-id") Long feedId) {
        return queryCommentService.getComments(feedId);
    }

    @DeleteMapping("/{comment-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable("comment-id") Long commentId) {
        deleteCommentService.deleteComment(commentId);
    }

}
