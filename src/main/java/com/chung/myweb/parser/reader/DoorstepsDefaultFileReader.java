package com.chung.myweb.parser.reader;

import com.chung.myweb.parser.entity.ParsingClue;
import org.springframework.stereotype.Component;

@Component
public class DoorstepsDefaultFileReader extends DefaultFileReader {

    @Override
    public void init(ParsingClue clue) {
        super.setFileFullPathAndName(clue.getFileFullPathAndName());
        super.setAreaClue(clue.getArea());
        super.setHousingInfoClue(clue.getHousingInfo());
        super.setPriceClue(clue.getPrice());
        super.setTitleClue(clue.getTitle());
        super.setMainContainingSectionClue(clue.getMainContainingSection());
    }
}
