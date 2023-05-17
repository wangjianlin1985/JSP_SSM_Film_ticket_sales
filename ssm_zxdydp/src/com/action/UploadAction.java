// 
// 
// 

package com.action;

import java.io.File;
import com.util.VeDate;
import org.springframework.ui.ModelMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/upload" })
public class UploadAction
{
    @RequestMapping({ "/image.action" })
    public String upload(@RequestParam(value = "image", required = false) final MultipartFile file, final HttpServletRequest request, final ModelMap model) {
        final String path = String.valueOf(request.getSession().getServletContext().getRealPath("/")) + "upfiles/";
        String fileName = file.getOriginalFilename();
        final int i = fileName.lastIndexOf(".");
        final String name = String.valueOf(VeDate.getStringDatex());
        final String type = fileName.substring(i + 1);
        fileName = String.valueOf(name) + "." + type;
        final File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("imageFileName", (Object)fileName);
        return "saveimage";
    }
    
    @RequestMapping({ "/files.action" })
    public String files(@RequestParam(value = "image", required = false) final MultipartFile file, final HttpServletRequest request, final ModelMap model) {
        final String path = String.valueOf(request.getSession().getServletContext().getRealPath("/")) + "upfiles/";
        String fileName = file.getOriginalFilename();
        final int i = fileName.lastIndexOf(".");
        final String name = String.valueOf(VeDate.getStringDatex());
        final String type = fileName.substring(i + 1);
        fileName = String.valueOf(name) + "." + type;
        final File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("imageFileName", (Object)fileName);
        return "savefile";
    }
}
