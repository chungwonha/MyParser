package com.chung.myweb.parser.dao;

import com.chung.myweb.parser.util.ParserConstants;
import com.chung.myweb.parser.entity.ParsingClue;
import org.springframework.stereotype.Component;

@Component
public class ParserDao {
    /*TODO:
        Modified to get ParsingClue from DB
        Modified to have DAO for each site. This ParserDao needs to be an interface.
     */
    public ParsingClue getPasringClue(String siteToParse){
        ParsingClue clue = new ParsingClue();
        if(ParserConstants.SITE_NAME_CRIAGSLIST.equals(siteToParse)) {
            clue.setFileFullPathAndName("C:\\temp\\CraigsList-nvaFebruary_54_2019_14_18_42.html");
            clue.setArea("result-hood");
            clue.setHousingInfo("housing");
            clue.setPrice("result-price");
            clue.setTitle("result-title hdrlnk");
            clue.setMainContainingSection("result-row");
        }else if(ParserConstants.SITE_NAME_DOORSTEP.equals(siteToParse)){
            clue.setFileFullPathAndName("C:\\temp\\Doorsteps-Herndon-VAFebruary_54_2019_14_19_03.html");
            clue.setArea("listing-item__text listing-item__text--small");
            clue.setHousingInfo("listing-item__text");
            clue.setPrice("listing-item__text listing-item__text--bold");
            clue.setTitle("listing-item__title");
            clue.setMainContainingSection("listing-item__info-container");
        }
        return clue;
    }
}
