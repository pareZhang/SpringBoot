package com.zjm.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 多文件上传
 */
@RestController
public class FilesUploadController {
    SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd");
    @PostMapping("/uploads")
    public String upload(MultipartFile[] uploadFiles, HttpServletRequest request) {
        for (MultipartFile uploadFile : uploadFiles) {
            String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/");
            String format = sdf.format(new Date());
            File folder = new File(realPath + format);
            if (!folder.isDirectory()) {
                folder.mkdirs();
            }
            String oldName = uploadFile.getOriginalFilename();
            String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
            try {
                uploadFile.transferTo(new File(folder, newName));//保存文件操作
                String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/uploadFile/" + format + newName;
                System.out.println(filePath);
                return filePath;  //生成上传文件的路径，并将访问路径返回。
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "上传失败！";
    }
}
