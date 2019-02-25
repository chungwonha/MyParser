package com.chung.myweb.parser.service;

import com.chung.myweb.parser.reader.DoorstepsFileReader;
import com.chung.myweb.parser.util.ParserConstants;
import com.chung.myweb.parser.dao.ParserDao;
import com.chung.myweb.parser.entity.ParsingClue;
import org.springframework.beans.factory.annotation.Autowired;

public class DoorstepsParsingService implements ParsingService {

    @Autowired
    ParserDao parserDao;

    @Autowired
    DoorstepsFileReader doorstepsFileReader;

    @Override
    public void parse() {
        ParsingClue clue = this.parserDao.getPasringClue(ParserConstants.SITE_NAME_DOORSTEP);
        this.doorstepsFileReader.init(clue);
        this.doorstepsFileReader.read();
    }
}
