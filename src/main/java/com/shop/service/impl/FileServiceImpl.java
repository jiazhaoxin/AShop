package com.shop.service.impl;

import com.google.common.collect.Lists;
import com.shop.service.IFileService;
import com.shop.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by admin on 2019/9/2.
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    /**
     * 文件上传
     * @param file
     * @param path
     * @return 返回文件名
     */
    public String upload(MultipartFile file, String path){
        String fileName = file.getOriginalFilename();//上传文件原始文件名
        String fileSuffixName = fileName.substring(fileName.lastIndexOf(".") + 1);
        String uploadFileName = UUID.randomUUID().toString() + "." + fileSuffixName;
        logger.info("开始上传文件，上传文件名{}，路径{}，新文件名{}", fileName, path, uploadFileName);

        //没有文件夹则创建
        File fileDir = new File(path);
        if (!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }

        File targetFile = new File(path, uploadFileName);

        try {
            file.transferTo(targetFile);//文件已经上传成功
            //targetFile上传到ftp服务器
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //上传完成后删除upload下的文件
            targetFile.delete();
        } catch (IOException e) {
            logger.error("上传文件异常", e);
            return null;
        }
        return targetFile.getName();
    }

    public static void main(String[] args) {
        String fileName = "asd.jpg";
        String fileSuffixName = fileName.substring(fileName.lastIndexOf(".") + 1);
        System.out.print(fileSuffixName);
    }
}
