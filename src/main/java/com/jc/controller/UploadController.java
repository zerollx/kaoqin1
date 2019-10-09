package com.jc.controller;

import com.jc.util.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UploadController {
    @RequestMapping("/upload")
    @ResponseBody
    public ResultMap upload ( MultipartFile file ) throws IOException {
        System.out.println ( file.getName () );
        System.out.println ( file.getSize () );
        System.out.println ( file.getOriginalFilename () );
        String realPath = "F:\\test\\img\\";
        String fileName = null;
        String saveFile = null;
        fileName = UUID.randomUUID ().toString () + file.getOriginalFilename ();
        saveFile = realPath + fileName;
        file.transferTo ( new File ( saveFile ) );
//        "F:\\test\\" + UUID.randomUUID ().toString () +file.getOriginalFilename () )
        ResultMap rs = ResultMap.srcOk ( "/img/" + fileName );
        return ResultMap.ok ( rs );
    }
}