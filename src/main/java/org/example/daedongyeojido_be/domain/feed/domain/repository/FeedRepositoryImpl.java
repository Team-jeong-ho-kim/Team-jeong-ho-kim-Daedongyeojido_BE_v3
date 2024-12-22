package org.example.daedongyeojido_be.domain.feed.domain.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.feed.domain.QFeed;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.response.FeedDetailResponse;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.response.FeedListResponse;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.response.QFeedDetailResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FeedRepositoryImpl implements FeedRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final QFeed qFeed = QFeed.feed;

    // 자신이 작성한 글 목록 조회
//    @Override
//    public List<FeedListResponse> findMyFeedsByUserId(Long userId) {
//        return queryFactory
//                .select(Projections.constructor(FeedListResponse.class, qFeed.id, qFeed.user.username, qFeed.title, qFeed.introduction,
//                        qFeed.isPublished, qFeed.createdAt, qFeed.heart))
//                .from(qFeed)
//                .where(qFeed.user.id.eq(userId).and(qFeed.isPublished.eq(true)))
//                .groupBy(qFeed.id)
//                .orderBy(qFeed.createdAt.desc())
//                .fetch();
//    }

    @Override
    public FeedDetailResponse findByFeedUrl(String feedUrl) {
        return queryFactory
                .select(new QFeedDetailResponse(qFeed.id, qFeed.userName, qFeed.title, qFeed.content, qFeed.createdAt))
                .from(qFeed)
                .where(qFeed.feedUrl.eq(feedUrl))
                .fetchOne();
    }

//    @Override
//    public List<TemporaryFeedListResponse> findTemporaryFeedsByUserId(Long userId) {
//        return queryFactory
//                .select(Projections.constructor(TemporaryFeedListResponse.class, qFeed.id, qFeed.title, qFeed.introduction, qFeed.updatedAt))
//                .from(qFeed)
//                .where(qFeed.user.id.eq(userId).and(qFeed.isPublished.eq(false)))
//                .orderBy(qFeed.updatedAt.desc())
//                .fetch();
//    }

    @Override
    public List<FeedListResponse> getFeeds() {
        return queryFactory
                .select(Projections.constructor(FeedListResponse.class, qFeed.id, qFeed.userName,
                        qFeed.title, qFeed.createdAt))
                .from(qFeed)
                .fetch();
    }

}
