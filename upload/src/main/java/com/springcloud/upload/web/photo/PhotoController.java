package com.springcloud.upload.web.photo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

@RestController
@RequestMapping("photo")
public class PhotoController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("photo") MultipartFile photo) throws IOException {
        if (photo.isEmpty()) {
            return "photo is null!";
        }
        String fileName = photo.getOriginalFilename();
        File dest = new File(fileName);
        photo.transferTo(dest);

        return "upload successfully!";
    }

}
