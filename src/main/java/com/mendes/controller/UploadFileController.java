package com.mendes.controller;

import com.mendes.model.dto.Organization;
import com.mendes.service.UploadFileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by mendesmustafa on 11.03.2021.
 */

@Controller
public class UploadFileController {


    private UploadFileService uploadFileService;

    public UploadFileController(UploadFileService uploadFileService) {
        this.uploadFileService = uploadFileService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

        List<Organization> organizations = uploadFileService.readFile(file.getInputStream());
        uploadFileService.saveData(organizations);
        return "index";
    }
}