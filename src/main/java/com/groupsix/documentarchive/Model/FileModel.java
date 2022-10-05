package com.groupsix.documentarchive.Model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class FileModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String filename;

    private String fileType;

    @Lob
    private byte[] fileData;

    private String level;

    private String faculty;

    private String url;

    public FileModel(String filename, String fileType, byte[] fileData, String level, String faculty) {
        this.filename = filename;
        this.fileType = fileType;
        this.fileData = fileData;
        this.level = level;
        this.faculty = faculty;
    }

    public FileModel(String filename, String fileType, String url) {
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FileModel fIleModel = (FileModel) o;
        return id != null && Objects.equals(id, fIleModel.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
