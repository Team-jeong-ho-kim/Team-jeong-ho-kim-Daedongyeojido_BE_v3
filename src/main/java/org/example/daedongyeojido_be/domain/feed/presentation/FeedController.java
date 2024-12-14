package org.example.daedongyeojido_be.domain.feed.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.request.FeedRequest;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.response.FeedDetailResponse;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.response.FeedListResponse;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.response.TemporaryFeedListResponse;
import org.example.daedongyeojido_be.domain.feed.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {

    private final CreateFeedService createFeedService;
    private final UpdateFeedService updateFeedService;
    private final DeleteFeedService deleteFeedService;
    private final QueryMyAllFeedsService queryMyAllFeedsService;
    private final QueryFeedDetailService queryFeedDetailService;
    private final TemporarySaveFeedService temporarySaveFeedService;
    private final QueryTemporarySaveFeedsService queryTemporarySaveFeedsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createFeed(@RequestBody @Valid FeedRequest request) {
        createFeedService.createFeed(request);
    }

    @PatchMapping("/{feed-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateFeed(@PathVariable("feed-id") Long feedId, @RequestBody @Valid FeedRequest request) {
        updateFeedService.updateFeed(feedId, request);
    }

    @DeleteMapping("/{feed-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFeed(@PathVariable("feed-id") Long feedId) {
        deleteFeedService.deleteFeed(feedId);
    }

    @GetMapping
    public List<FeedListResponse> getMyPosts() {
        return queryMyAllFeedsService.getAllMyFeeds();
    }

    @GetMapping("/{feed-id}")
    public FeedDetailResponse getFeed(@PathVariable("feed-id") Long feedId) {
        return queryFeedDetailService.getFeedDetail(feedId);
    }

    @PostMapping("/temporary")
    @ResponseStatus(HttpStatus.CREATED)
    public void temporarySave(@RequestBody FeedRequest request) {
        temporarySaveFeedService.temporarySave(request);
    }

    @GetMapping("/temporary")
    public List<TemporaryFeedListResponse> temporaryList() {
        return queryTemporarySaveFeedsService.getTemporaryFeeds();
    }

}
