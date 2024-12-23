package org.example.daedongyeojido_be.infrastructure.s3;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "aws.s3")
public record AwsS3Properties(
        String bucket,
        String url,
        String clubImageFolder,
        String bannerFolder,
        String profileImageFolder,
        String previewImageFolder
)
{

}

