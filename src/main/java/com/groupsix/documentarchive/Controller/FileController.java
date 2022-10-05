package com.groupsix.documentarchive.Controller;

import com.groupsix.documentarchive.Model.FileModel;
import com.groupsix.documentarchive.Repository.FileRepo;
import com.groupsix.documentarchive.Service.FileService;
import com.groupsix.documentarchive.dto.FileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FileController {

    @Autowired
    FileService fileService;

    @Autowired
    FileRepo fileRepo;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, FileModel fileModel, Model m) throws FileNotFoundException {

        FileModel model = fileService.saveFile(file,fileModel);

        m.addAttribute("model",model);
        return "Upload";
    }

    @GetMapping("/uploadForm")
    public String Redirect() {
        return "Upload";
    }

    /*
     * Download Files
     */
    @GetMapping("/downloadFile/{id}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long id){
        FileModel doc = fileService.getFile(id).get();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(doc.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getFilename()+"\"")
                .body(new ByteArrayResource(doc.getFileData()));

    }


    @GetMapping("/files")
    public String get100ListFiles(Model model) {
        List<FileModel> list = fileRepo.getBITLevelHundredFiles();
        model.addAttribute("list", list);
        return "LevelHun";
    }

    @GetMapping("/files2")
    public String get200ListFiles(Model model) {
        List<FileModel> list = fileRepo.getBITLevelTwoHundredFiles();
        model.addAttribute("list", list);
        return "LevelTwo";
    }

    @GetMapping("/files3")
    public String get300ListFiles(Model model) {
        List<FileModel> list = fileRepo.getBITLevelThreeHundredFiles();
        model.addAttribute("list", list);
        return "LevelThree";
    }

    @GetMapping("/files4")
    public String get400ListFiles(Model model) {
        List<FileModel> list = fileRepo.getBITLevelFourHundredFiles();
        model.addAttribute("list", list);
        return "LevelFour";
    }
}
