package org.example.daedongyeojido_be.domain.file.service;

import io.awspring.cloud.s3.ObjectMetadata;
import io.awspring.cloud.s3.S3Operations;
import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.infrastructure.s3.AwsS3Properties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@RequiredArgsConstructor
class FileUploadService {

    private final S3Operations s3Operations;
    private final AwsS3Properties s3Properties;

    void uploadFile(MultipartFile multipartFile, String key) throws IOException {

            s3Operations.upload(
                    s3Properties.bucket(),
                    key,
                    multipartFile.getInputStream(),
                    ObjectMetadata.builder()
                            .contentType(multipartFile.getContentType())
                            .build()
            );
    }

}
