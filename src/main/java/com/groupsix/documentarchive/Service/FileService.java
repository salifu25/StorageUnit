package com.groupsix.documentarchive.Service;

import com.groupsix.documentarchive.Controller.FileController;
import com.groupsix.documentarchive.Model.FileModel;
import com.groupsix.documentarchive.Repository.FileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class FileService {

    @Autowired
    FileRepo fileRepo;
    public FileModel saveFile(MultipartFile file, FileModel fileModel) throws FileNotFoundException {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if (filename.contains("...")) {
                throw new FileNotFoundException("invalid");
            }
           // String url = MvcUriComponentsBuilder.fromMethodName(FileController.class,
                   // "downloadFile", fileModel.getFilename()).build().toString();
            //FileModel model = new FileModel(filename, file.getContentType(), file.getBytes(), );
            fileModel.setFilename(filename);
            fileModel.setFileType(file.getContentType());
            fileModel.setFileData(file.getBytes());
            fileModel.setLevel(fileModel.getLevel());
            fileModel.setFaculty(fileModel.getFaculty());
           // fileModel.setUrl(url);
            return fileRepo.save(fileModel);

        } catch (Exception e) {
            throw new FileNotFoundException("file not found");
        }
    }

    public Optional<FileModel> getFile(Long id) {
        return fileRepo.findById(id);
    }
    public List<FileModel> getListOfFiles(){
        return fileRepo.findAll();
    }
}
