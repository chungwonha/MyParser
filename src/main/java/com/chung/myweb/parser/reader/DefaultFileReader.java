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


public abstract class DefaultFileReader implements FileReader{
    Logger logger = LoggerFactory.getLogger(DefaultFileReader.class);
    private String fileFullPathAndName;
    private String priceClue;
    private String housingInfoClue;
    private String titleClue;
    private String areaClue;
    private String mainContainingSectionClue;

    public  void read(){

        File file = new File(this.getFileFullPathAndName());
        try {
            Document document = Jsoup.parse(file, Charset.defaultCharset().name());
            Elements resultRowElements = document.getElementsByClass(this.getMainContainingSectionClue());
            Iterator<Element> elementIterator = resultRowElements.iterator();
            while(elementIterator.hasNext()){
                Element element = elementIterator.next();
                String price = element.getElementsByClass(this.getPriceClue()).text();
                String title = element.getElementsByClass(this.getTitleClue()).text();
                String area = element.getElementsByClass(this.getAreaClue()).text();
                String housing = element.getElementsByClass(this.getHousingInfoClue()).text();
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

    public String getMainContainingSectionClue() {
        return mainContainingSectionClue;
    }

    public void setMainContainingSectionClue(String mainContainingSectionClue) {
        this.mainContainingSectionClue = mainContainingSectionClue;
    }

    public String getPriceClue() {
        return priceClue;
    }

    public void setPriceClue(String priceClue) {
        this.priceClue = priceClue;
    }

    public String getHousingInfoClue() {
        return housingInfoClue;
    }

    public void setHousingInfoClue(String housingInfoClue) {
        this.housingInfoClue = housingInfoClue;
    }

    public String getTitleClue() {
        return titleClue;
    }

    public void setTitleClue(String titleClue) {
        this.titleClue = titleClue;
    }

    public String getAreaClue() {
        return areaClue;
    }

    public void setAreaClue(String areaClue) {
        this.areaClue = areaClue;
    }

    public abstract void init(ParsingClue clue);
}
