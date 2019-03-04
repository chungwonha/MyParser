package com.chung.myweb.parser;

import com.chung.myweb.parser.dao.ParserDao;
import com.chung.myweb.parser.entity.ParsingClue;
import com.chung.myweb.parser.reader.CraigslistDefaultFileReader;
import com.chung.myweb.parser.reader.DoorstepsDefaultFileReader;
import com.chung.myweb.parser.reader.RealtorDotComFileReader;
import com.chung.myweb.parser.util.ParserConstants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParserApplicationTests {

	@Autowired
	CraigslistDefaultFileReader craigslistFileReader;

	@Autowired
	DoorstepsDefaultFileReader doorstepsFileReader;

	@Autowired
	RealtorDotComFileReader realtorDotComFileReader;

	@Autowired
	ParserDao parserDao;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCraigslistFileReader(){

		ParsingClue parsingClue = parserDao.getPasringClue(ParserConstants.SITE_NAME_CRIAGSLIST);
		craigslistFileReader.init(parsingClue);
		craigslistFileReader.read();
	}

	@Test
	public void testDoorstepsFileReader(){
		ParsingClue parsingClue = parserDao.getPasringClue(ParserConstants.SITE_NAME_CRIAGSLIST);
		doorstepsFileReader.init(parsingClue);
		doorstepsFileReader.read();
	}

	@Test
	public void testRealtorocmFileReader(){
		ParsingClue parsingClue = parserDao.getPasringClue(ParserConstants.SITE_NAME_REALTORCOM);
		realtorDotComFileReader.init(parsingClue);
		realtorDotComFileReader.read();
	}
}
