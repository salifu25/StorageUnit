package com.groupsix.documentarchive.dto;

public class FileResponse {

    private String filename;

    private String fileType;

    private String url;

    public FileResponse(String filename, String fileType, String url) {
        this.filename = filename;
        this.fileType = fileType;
        this.url = url;
    }

    public FileResponse() {
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "FileResponse{" +
                "filename='" + filename + '\'' +
                ", fileType='" + fileType + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
