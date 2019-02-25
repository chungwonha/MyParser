package com.chung.myweb.parser.service;

import com.chung.myweb.parser.reader.CraigslistFileReader;
import com.chung.myweb.parser.util.ParserConstants;
import com.chung.myweb.parser.dao.ParserDao;
import com.chung.myweb.parser.entity.ParsingClue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CraigslistParsingService implements ParsingService{

    @Autowired
    CraigslistFileReader craigslistFileReader;

    @Autowired
    ParserDao parserDao;

    @Override
    public void parse() {
        ParsingClue clue = parserDao.getPasringClue(ParserConstants.SITE_NAME_CRIAGSLIST);
        craigslistFileReader.init(clue);
        craigslistFileReader.read();
    }
}
