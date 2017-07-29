package com.yacongliu.controller;

import com.yacongliu.controller.common.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * 文件管理
 *
 * @author yacongliu on 2017/7/21.
 * @since v1.0.0
 */
@Controller
@RequestMapping("file")
public class FileController extends BaseController {

        @RequestMapping(value = "view", method = RequestMethod.GET)
        public String fileUpload() {
                return "fileupload";
        }

        @RequestMapping(value = "/upload", method = RequestMethod.POST)
        public String upload(@RequestParam MultipartFile myfile, HttpSession session) throws IOException {
                // 如果有多个文件上传的话，就需要用 MultipartFile[]

                if (myfile.isEmpty()) {
                        System.out.println("文件未上传");
                } else {
                        String fileName = myfile.getOriginalFilename();
                        String path = session.getServletContext().getRealPath("upload");
                        System.out.println(path);
                        File localFile = new File(path, fileName);
                        myfile.transferTo(localFile);
                }

                return "welcome";
        }

}
