package com.franc1s.SpringBootFileUpload;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class FileController1 {

    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");

    //单文件上传
    @PostMapping("/upload")
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
        String realPath = request.getServletContext().getRealPath("/");
        String format=sdf.format(new Date());
        String path = realPath+format;
        File file1=new java.io.File(path);
        if (!file1.exists()){
            file1.mkdirs();
        }
        String originalFilename = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        file.transferTo(new File(file1,newName));
        String s = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + format + newName;
        return s;
    }
}
