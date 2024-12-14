package org.example.daedongyeojido_be.domain.comment.domain.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.comment.domain.QComment;
import org.example.daedongyeojido_be.domain.comment.presentation.dto.response.CommentResponse;
import org.example.daedongyeojido_be.domain.user.domain.User;
import org.example.daedongyeojido_be.domain.user.facade.UserFacade;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    private final QComment qComment = QComment.comment1;
    private final UserFacade userFacade;

    @Override
    public List<CommentResponse> findByFeedId(Long feedId, User user) {

        return queryFactory
                .select(Projections.constructor(CommentResponse.class, qComment.id,
                        qComment.comment, qComment.user.username, qComment.isPublic, qComment.createdAt))
                .from(qComment)
                .where(qComment.feed.id.eq(feedId).and(user != null ?
                        qComment.isPublic.eq(true).or(qComment.user.id.eq(user.getId()))
                        : qComment.isPublic.eq(true)))
                .orderBy(qComment.createdAt.desc())
                .fetch();
    }

}
