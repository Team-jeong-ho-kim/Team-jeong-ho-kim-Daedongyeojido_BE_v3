//package org.example.daedongyeojido_be.domain.like.presentation;
//
//import lombok.RequiredArgsConstructor;
//import org.example.daedongyeojido_be.domain.like.service.DeleteLikeService;
//import org.example.daedongyeojido_be.domain.like.service.LikeService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/like")
//@RequiredArgsConstructor
//public class LikeController {
//
//    private final LikeService likeService;
//    private final DeleteLikeService deleteLikeService;
//
//    @PostMapping("/{feed-id}")
//    public void likeFeed(@PathVariable("feed-id") Long feedId) {
//        likeService.liked(feedId);
//    }
//
//    @DeleteMapping("/{feed-id}")
//    public void deleteFeed(@PathVariable("feed-id") Long feedId) {
//        deleteLikeService.deleteLike(feedId);
//    }
//
//}
