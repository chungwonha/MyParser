package com.chung.myweb.parser.service;

import com.chung.myweb.parser.dao.ParserDao;
import com.chung.myweb.parser.entity.ParsingClue;
import com.chung.myweb.parser.reader.RealtorDotComFileReader;
import com.chung.myweb.parser.util.ParserConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealtorcomParsingService implements ParsingService {

    @Autowired
    ParserDao parserDao;

    @Autowired
    RealtorDotComFileReader realtorDotComFileReader;

    @Override
    public void parse() {
        ParsingClue clue = this.parserDao.getPasringClue(ParserConstants.SITE_NAME_REALTORCOM);
        this.realtorDotComFileReader.init(clue);
        this.realtorDotComFileReader.read();
    }
}
