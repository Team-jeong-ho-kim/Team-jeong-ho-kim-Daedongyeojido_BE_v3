package org.example.daedongyeojido_be.domain.feed.service;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.feed.domain.Feed;
import org.example.daedongyeojido_be.domain.feed.facade.FeedFacade;
import org.example.daedongyeojido_be.domain.feed.presentation.dto.request.FeedRequest;
import org.example.daedongyeojido_be.domain.file.domain.type.ImageType;
import org.example.daedongyeojido_be.domain.file.exception.FailFileException;
import org.example.daedongyeojido_be.domain.file.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UpdateFeedService {

    private final FeedFacade feedFacade;
    private final ImageService imageService;

    @Transactional
    public void updateFeed(Long feedId, FeedRequest request, MultipartFile file) {
        Feed feed = feedFacade.getFeed(feedId);

        if (file != null && !file.isEmpty()) {
            try {
                String key = imageService.saveImage(file, ImageType.PREVIEW_IMAGE_FOLDER);

                String previewImageUrl = imageService.getFileBaseUrl() + key;

                feed.setPreviewImageUrl(previewImageUrl);
            } catch (IOException e) {
                throw FailFileException.EXCEPTION;
            }
        }

        feed.updateFeed(request.getTitle(), request.getContent(), request.getUserName(), request.getCreatedAt(), request.getPreviewImageUrl());
    }

}
