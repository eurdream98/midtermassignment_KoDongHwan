package com.ohgiraffers.midtermassignmentkodonghwan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class BoardController {


    @PostMapping(value = {"/board/regist", "/board/regist/file"})
    public String handleFormSubmission(@ModelAttribute("board") BoardDTO boardDTO,
                                       @ModelAttribute("singleFile") MultipartFile singleFile,
                                       String singleFileDescription, Model model) {
        // 게시글 등록 로직 처리

        if (!singleFile.isEmpty()) {
            String root = "src/main/resources/static";
            String filePath = root + "/uploadFiles";
            File dir = new File(filePath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String originFileName = singleFile.getOriginalFilename();
            try {
                singleFile.transferTo(new File(filePath + "/" + originFileName));
                model.addAttribute("message", "파일 업로드 성공!");
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("message", "파일 업로드 실패!!");
            }
        }

        return "result";
    }



}
