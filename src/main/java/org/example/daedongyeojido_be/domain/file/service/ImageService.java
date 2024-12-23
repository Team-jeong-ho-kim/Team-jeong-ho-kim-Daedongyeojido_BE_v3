package org.example.daedongyeojido_be.domain.file.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.daedongyeojido_be.domain.file.domain.type.ImageType;
import org.example.daedongyeojido_be.infrastructure.s3.AwsS3Properties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageService {

    private static final Set<String> TYPE_PHOTO = Set.of(".jpg", ".jpeg", ".png",".heic",".svg",".gif");

    private final AwsS3Properties awsS3Properties;
    private final FileUploadService fileUploadService;
    private final FileDeleteService fileDeleteService;

    @Transactional
    public String saveImage(MultipartFile multipartFile, ImageType imageType) throws IOException {
        String originalFilename = multipartFile.getOriginalFilename();
        if(originalFilename == null || !isValidExtension(getExtension(originalFilename))){
            throw new RuntimeException("Invalid file extension");
        }
            String key = generateFile(imageType);

            fileUploadService.uploadFile(multipartFile, key);

            return key;
    }

    public String getFileBaseUrl() {
        return awsS3Properties.url();
    }

    @Transactional
    public void deleteImage(String url){

        final var key = url.substring(awsS3Properties.url().length());

        fileDeleteService.deleteKey(key);

    }

    private boolean isValidExtension(String contains){
        return TYPE_PHOTO.contains(contains);
    }

    private String getExtension(String filename){
        return filename.substring(filename.lastIndexOf(".")).toLowerCase();
    }

    private String generateFile(ImageType imageType){
        String folder;

        switch (imageType) {
            case CLUB_IMAGE_FOLDER -> folder = awsS3Properties.clubImageFolder();
            case BANNER_FOLDER -> folder = awsS3Properties.bannerFolder();
            case PROFILE_IMAGE_FOLDER -> folder = awsS3Properties.profileImageFolder();
            case PREVIEW_IMAGE_FOLDER -> folder = awsS3Properties.previewImageFolder();
            default -> throw new IllegalStateException("Unexpected value: " + imageType);
        }
        return folder + "/" + UUID.randomUUID();
    }

}
