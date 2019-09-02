package com.shop.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by admin on 2019/9/2.
 */
public interface IFileService {

    String upload(MultipartFile file, String path);
}
