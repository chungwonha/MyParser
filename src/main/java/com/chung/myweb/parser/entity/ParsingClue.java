package com.chung.myweb.parser.entity;

public class ParsingClue {

       private String area;
       private String housingInfo;
       private String price;
       private String title;
       private String mainContainingSection;
       private String fileFullPathAndName;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getHousingInfo() {
        return housingInfo;
    }

    public void setHousingInfo(String housingInfo) {
        this.housingInfo = housingInfo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainContainingSection() {
        return mainContainingSection;
    }

    public void setMainContainingSection(String mainContainingSection) {
        this.mainContainingSection = mainContainingSection;
    }

    public String getFileFullPathAndName() {
        return fileFullPathAndName;
    }

    public void setFileFullPathAndName(String fileFullPathAndName) {
        this.fileFullPathAndName = fileFullPathAndName;
    }
}
