package com.springcloud.upload.web.photo;

import com.springcloud.upload.ajax.APIResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

@RestController
@RequestMapping("upload")
public class PhotoController {

    @Value("${spring.servlet.multipart.location}")
    private String UPLOAD_PATH;

    @RequestMapping(value = "/single", method = RequestMethod.POST)
    public APIResponse upload(@RequestParam("file") MultipartFile photo) throws IOException {
        if (photo.isEmpty()) {
            return APIResponse.fail("file is null!");
        }
        String fileName = photo.getOriginalFilename();
        File dest = new File(fileName);
        photo.transferTo(dest);
        return APIResponse.success();
    }


    @RequestMapping(value = "/batch", method = RequestMethod.POST)
    public APIResponse batch(@RequestParam("file") MultipartFile [] files) throws IOException {
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.length; ++i) {
            file = files[i];
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                stream = new BufferedOutputStream(new FileOutputStream(new File(UPLOAD_PATH+file.getOriginalFilename())));
                stream.write(bytes);
                stream.close();
            }
        }
        return  APIResponse.success();

    }

}
