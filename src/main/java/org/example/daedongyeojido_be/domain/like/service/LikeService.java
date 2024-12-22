//package org.example.daedongyeojido_be.domain.like.service;
//
//import lombok.RequiredArgsConstructor;
//import org.example.daedongyeojido_be.domain.feed.domain.Feed;
//import org.example.daedongyeojido_be.domain.feed.facade.FeedFacade;
//import org.example.daedongyeojido_be.domain.like.domain.Like;
//import org.example.daedongyeojido_be.domain.like.domain.repository.LikeRepository;
//import org.example.daedongyeojido_be.domain.like.exception.LikeExistException;
//import org.example.daedongyeojido_be.domain.like.facade.LikeFacade;
//import org.example.daedongyeojido_be.domain.user.domain.User;
//import org.example.daedongyeojido_be.domain.user.facade.UserFacade;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@RequiredArgsConstructor
//public class LikeService {
//
//    private final LikeRepository likeRepository;
//    private final FeedFacade feedFacade;
//    private final UserFacade userFacade;
//    private final LikeFacade likeFacade;
//
//    @Transactional
//    public void liked(Long feedId) {
//        User user = userFacade.currentUser();
//        Feed feed = feedFacade.getFeed(feedId);
//
//        if(likeFacade.checkLiked(user, feed)) {
//            throw LikeExistException.EXCEPTION;
//        }
//
//        feed.plusLike();
//        likeRepository.save(Like.builder()
//                .feed(feed)
//                .user(user)
//                .build());
//    }
//
//}
