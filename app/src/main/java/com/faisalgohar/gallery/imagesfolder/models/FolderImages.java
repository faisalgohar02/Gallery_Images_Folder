package com.faisalgohar.gallery.imagesfolder.models;

public class FolderImages {
    private  String pathFolder;
    private  String folderName;
    private int totalImg = 0;
    private String thumbNail;

    public FolderImages(){

    }

    public FolderImages(String pathFolder, String folderName) {
        this.pathFolder = pathFolder;
        this.folderName = folderName;
    }

    public String getPath() {
        return pathFolder;
    }

    public void setPath(String path) {
        this.pathFolder = path;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public int getTotalImages() {
        return totalImg;
    }

    public void setTotalImages(int totalImg) {
        this.totalImg = totalImg;
    }

    public void addImgs(){
        this.totalImg++;
    }

    public String getThumbNail() {
        return thumbNail;
    }

    public void setThumbNail(String thumbNail) {
        this.thumbNail = thumbNail;
    }
}
