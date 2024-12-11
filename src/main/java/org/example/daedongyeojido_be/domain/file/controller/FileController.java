package org.example.daedongyeojido_be.domain.file.controller;


import lombok.RequiredArgsConstructor;
import org.example.daedongyeojido_be.domain.file.controller.dto.FileResponse;
import org.example.daedongyeojido_be.domain.file.domain.type.ImageType;
import org.example.daedongyeojido_be.domain.file.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {

    private final ImageService imageService;

    @PostMapping("/image")
    @ResponseStatus(HttpStatus.CREATED)
    FileResponse uploadImage(@RequestPart("file") MultipartFile filePart, @RequestParam("type") ImageType imageType) {
        String path = imageService.saveImage(filePart, imageType);
        return new FileResponse(imageService.getFileBaseUrl() + path, filePart.getOriginalFilename());
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteImage(@RequestParam String url) {
        imageService.deleteImage(url);
    }

}
