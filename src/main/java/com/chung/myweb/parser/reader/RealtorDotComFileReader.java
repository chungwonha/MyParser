package com.chung.myweb.parser.reader;

import com.chung.myweb.parser.entity.ParsingClue;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;


@Component
public class RealtorDotComFileReader implements FileReader {

    Logger logger = LoggerFactory.getLogger(RealtorDotComFileReader.class);

    private String fileFullPathAndName;
    private String priceClue;
    private String housingInfoClue;
    private String titleClue;
    private String areaClue;
    private String mainContainingSection;

    @Override
    public void read() {
        File file = new File(this.fileFullPathAndName);//"C:\\temp\\Realtor.com-Herndon-VAFebruary_54_2019_14_18_55.html");//this.getFileFullPathAndName());
        try {
            /*TODO:
                1. Need to improve this to use stream.This is too verbose
                2. Need to come up with a way to separate the parsing clues from the logic
             */
            Document document = Jsoup.parse(file, Charset.defaultCharset().name());
            Elements detaiLWrapNoCta = document.getElementsByClass("detail-wrap no-cta");
            Iterator<Element> detailWrapNoCtaIterator = detaiLWrapNoCta.iterator();
            String price="";
            String title="";
            String area="";
            String housing="";

            while(detailWrapNoCtaIterator.hasNext()) {
                Element detailWrapNoCtaElement = detailWrapNoCtaIterator.next();

                Elements priceClassElements = detailWrapNoCtaElement.getElementsByClass("price");
                Iterator<Element> elementIterator = priceClassElements.iterator();
                while (elementIterator.hasNext()) {
                    Element element = elementIterator.next();
                    Elements metaTagElements = element.getElementsByTag("meta");
                    Iterator metaTagIterator = metaTagElements.iterator();
                    while (metaTagIterator.hasNext()) {
                        Element tagElement = (Element) metaTagIterator.next();

                        Elements elementsAttr = tagElement.getElementsByAttribute("itemprop");
                        Iterator elementsAttrIterator = elementsAttr.iterator();
                        while (elementsAttrIterator.hasNext()) {
                            Element eachAttrElement = (Element) elementsAttrIterator.next();
                            if ("price".equals(eachAttrElement.attributes().get("itemprop"))) {
                                price = eachAttrElement.attributes().get("content");
                            }
                            if ("name".equals(eachAttrElement.attributes().get("itemprop"))) {
                                title = eachAttrElement.attributes().get("content");
                                area = title.substring(title.indexOf(',') + 1);
                                                            }
                        }
                    }
                }

                Elements propmetaElements = detailWrapNoCtaElement.getElementsByClass("prop-meta ellipsis");
                Iterator<Element> propmetaElementsIterator = propmetaElements.iterator();
                while (propmetaElementsIterator.hasNext()) {
                    Element eachPropmetaElement = propmetaElementsIterator.next();
                    housing = eachPropmetaElement.getElementsByClass("data-value meta-beds-display").text();
                    housing += " bed " + eachPropmetaElement.getElementsByClass("data-value").text() + " bath";
                }

                logger.debug(title +" | "+housing+" | "+ price +" | "+ area);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void init(ParsingClue clue) {
        this.setFileFullPathAndName(clue.getFileFullPathAndName());
        this.setAreaClue(clue.getArea());
        this.setHousingInfoClue(clue.getHousingInfo());
        this.setPriceClue(clue.getPrice());
        this.setTitleClue(clue.getTitle());
        this.setMainContainingSection(clue.getMainContainingSection());
    }

    public String getFileFullPathAndName() {
        return fileFullPathAndName;
    }

    public void setFileFullPathAndName(String fileFullPathAndName) {
        this.fileFullPathAndName = fileFullPathAndName;
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

    public String getMainContainingSection() {
        return mainContainingSection;
    }

    public void setMainContainingSection(String mainContainingSection) {
        this.mainContainingSection = mainContainingSection;
    }

    public static void main(String... s){
        RealtorDotComFileReader realtorDotComFileReader = new RealtorDotComFileReader();
        ParsingClue clue = new ParsingClue();
        clue.setFileFullPathAndName("C:\\temp\\Realtor.com-Herndon-VAFebruary_54_2019_14_18_55.html");
        realtorDotComFileReader.init(clue);
        realtorDotComFileReader.read();
    }
}
