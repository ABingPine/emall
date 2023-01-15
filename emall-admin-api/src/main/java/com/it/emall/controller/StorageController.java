package com.it.emall.controller;

/**
 * @author libingyang
 * @create 2023/1/13 16:07
 */

import com.it.emall.constants.FileUploadConstants;
import com.it.emall.util.AjaxResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 文件上传Controller
 */
@RestController
public class StorageController {

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/admin/storage/create")
    public Object upload(MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            // 保存目录
            File saveDir = new File(FileUploadConstants.SAVE_DIR);
            // 目录不存在就创建
            if (!saveDir.exists()) {
                saveDir.mkdirs();
            }
            // 文件名
            String originFilename = file.getOriginalFilename(); // 原文件名
            String filename = UUID.randomUUID() + file.getOriginalFilename().substring(originFilename.lastIndexOf("."));
            // 保存
            File saveFile = new File(saveDir,filename);
            try {
                file.transferTo(saveFile);
                Map<String,Object> data = new HashMap<>();
                data.put("url",FileUploadConstants.SERVER_HOST + FileUploadConstants.FILE_URL + filename);
                return AjaxResult.success(data);
            } catch (IOException e) {
                e.printStackTrace();
                return AjaxResult.fail();
            }
        } else {
            return AjaxResult.fail(1,"上传文件为空~~");
        }
    }

}
