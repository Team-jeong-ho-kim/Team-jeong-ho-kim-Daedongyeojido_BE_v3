package org.example.daedongyeojido_be.domain.feed.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.request.FeedRequest;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.response.FeedDetailResponse;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.response.FeedListResponse;
import org.example.daedongyeojido_be.domain.feed.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {

    private final CreateFeedService createFeedService;
    private final UpdateFeedService updateFeedService;
    private final DeleteFeedService deleteFeedService;
    private final QueryFeedDetailService queryFeedDetailService;
    private final QueryFeedListService queryFeedListService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createFeed(@RequestPart("request") @Valid FeedRequest request,
                           @RequestPart(value = "file", required = false) MultipartFile file) {
        createFeedService.createFeed(request, file);
    }

    @PatchMapping("/{feed-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateFeed(@PathVariable("feed-id") Long feedId, @RequestPart @Valid FeedRequest request) {
        updateFeedService.updateFeed(feedId, request);
    }

    @DeleteMapping("/{feed-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFeed(@PathVariable("feed-id") Long feedId) {
        deleteFeedService.deleteFeed(feedId);
    }

    @GetMapping("/{feed-url}")
    public FeedDetailResponse getFeed(@PathVariable("feed-url") String feedUrl) {
        return queryFeedDetailService.getFeedDetail(feedUrl);
    }

    @GetMapping
    public List<FeedListResponse> getFeedList() {
        return queryFeedListService.getFeedList();
    }

}
