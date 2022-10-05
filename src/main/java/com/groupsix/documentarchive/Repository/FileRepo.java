package com.groupsix.documentarchive.Repository;

import com.groupsix.documentarchive.Model.FileModel;
import com.groupsix.documentarchive.dto.FileResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepo extends JpaRepository<FileModel, Long> {
    FileModel findByFilename(String filename);

    //@Query(value = "SELECT new com.groupsix.documentarchive.dto.FileResponse(f.filename,f.fileType)" + "FROM FileModel f, WHERE level = 100")
    @Query( value = "SELECT * FROM file_model WHERE faculty = 'BIT' AND level = '100'",nativeQuery = true)
    List<FileModel> getBITLevelHundredFiles();

    @Query( value = "SELECT * FROM file_model WHERE faculty = 'BIT' AND level = '200'",nativeQuery = true)
    List<FileModel> getBITLevelTwoHundredFiles();

    @Query( value = "SELECT * FROM file_model WHERE faculty = 'BIT' AND level = '300'",nativeQuery = true)
    List<FileModel> getBITLevelThreeHundredFiles();

    @Query( value = "SELECT * FROM file_model WHERE faculty = 'BIT' AND level = '400'",nativeQuery = true)
    List<FileModel> getBITLevelFourHundredFiles();


}
