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
    @PostMapping("board/regist")
    public String registBoard(@ModelAttribute("board") BoardDTO boardDTO) {


        return "result";


    }

    @PostMapping("board/regist")
    public String singleFileUpload(@ModelAttribute MultipartFile singleFile,
                                   String singleFileDescription, Model model) {
        System.out.println("singleFile : " + singleFile);
        System.out.println("singleFileDescription : " + singleFileDescription);
        /* 파일을 저장할 경로 설정 */
        String root = "src/main/resources/static";
        String filePath = root + "/uploadFiles";
        File dir = new File(filePath);
        System.out.println(dir.getAbsolutePath());
        if(!dir.exists()) {
            dir.mkdirs();
        }
//        /* 파일명 변경 처리 */
        String originFileName = singleFile.getOriginalFilename();

        try {
            singleFile.transferTo(new File(filePath + "/" + originFileName));
            model.addAttribute("message", "파일 업로드 성공!");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "파일 업로드 실패!!");
        }
        return "result";
    }
}
