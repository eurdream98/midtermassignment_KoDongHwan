package com.ohgiraffers.midtermassignmentkodonghwan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Controller
public class MainController {
    @GetMapping("/")
    public String defaultLocation(){return "main";};
    @GetMapping("main")
    public String regist() {
        return "main";

    }

}
