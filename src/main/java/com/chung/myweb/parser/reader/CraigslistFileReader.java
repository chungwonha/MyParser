package com.chung.myweb.parser.reader;

import com.chung.myweb.parser.entity.ParsingClue;
import org.springframework.stereotype.Component;

@Component
public class CraigslistFileReader extends FileReader {

    @Override
    public void init(ParsingClue clue) {
        super.setFileFullPathAndName(clue.getFileFullPathAndName());
        super.setArea(clue.getArea());
        super.setHousingInfo(clue.getHousingInfo());
        super.setPrice(clue.getPrice());
        super.setTitle(clue.getTitle());
        super.setMainContainingSection(clue.getMainContainingSection());

    }
}
