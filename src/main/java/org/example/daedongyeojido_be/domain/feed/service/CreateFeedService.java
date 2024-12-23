package org.example.daedongyeojido_be.domain.feed.service;

import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.feed.domain.Feed;
import org.example.daedongyeojido_be.domain.feed.domain.repository.FeedRepository;
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
public class CreateFeedService {

    private final FeedRepository feedRepository;
    private final ImageService imageService;

    @Transactional
    public void createFeed(FeedRequest request, MultipartFile file) {
        String previewImageUrl = null;

        if (file != null && !file.isEmpty()) {
            try {
                String key = imageService.saveImage(file, ImageType.PREVIEW_IMAGE_FOLDER);
                previewImageUrl = imageService.getFileBaseUrl() + key;
            } catch (IOException e) {
                throw FailFileException.EXCEPTION;
            }
        }

        feedRepository.save(Feed.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .userName(request.getUserName())
                        .createdAt(request.getCreatedAt())
                        .previewImageUrl(previewImageUrl)
                .build());
    }

}
