package com.chung.myweb.parser.reader;

import com.chung.myweb.parser.entity.ParsingClue;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;


public abstract class FileReader {
    Logger logger = LoggerFactory.getLogger(FileReader.class);
    private String fileFullPathAndName;
    private String price;
    private String housingInfo;
    private String title;
    private String area;
    private String mainContainingSection;

    public  void read(){

        File file = new File(this.getFileFullPathAndName());
        try {
            Document document = Jsoup.parse(file, Charset.defaultCharset().name());
            Elements resultRowElements = document.getElementsByClass(this.getMainContainingSection());
            Iterator<Element> elementIterator = resultRowElements.iterator();
            while(elementIterator.hasNext()){
                Element element = elementIterator.next();
                String price = element.getElementsByClass(this.getPrice()).text();
                String title = element.getElementsByClass(this.getTitle()).text();
                String area = element.getElementsByClass(this.getArea()).text();
                String housing = element.getElementsByClass(this.getHousingInfo()).text();
                logger.debug(title+" "+housing+" "+price+" "+area);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFileFullPathAndName(String fileFullPathAndName) {
        this.fileFullPathAndName = fileFullPathAndName;
    }

    public String getFileFullPathAndName() {
        return this.fileFullPathAndName;
    }

    public String getMainContainingSection() {
        return mainContainingSection;
    }

    public void setMainContainingSection(String mainContainingSection) {
        this.mainContainingSection = mainContainingSection;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHousingInfo() {
        return housingInfo;
    }

    public void setHousingInfo(String housingInfo) {
        this.housingInfo = housingInfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public abstract void init(ParsingClue clue);
}
