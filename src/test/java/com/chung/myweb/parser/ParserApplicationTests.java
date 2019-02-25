package com.chung.myweb.parser;

import com.chung.myweb.parser.dao.ParserDao;
import com.chung.myweb.parser.entity.ParsingClue;
import com.chung.myweb.parser.reader.CraigslistFileReader;
import com.chung.myweb.parser.reader.DoorstepsFileReader;
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
	CraigslistFileReader craigslistFileReader;

	@Autowired
	DoorstepsFileReader doorstepsFileReader;

	@Autowired
	ParserDao parserDao;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCraigslistFileReader(){

		ParsingClue parsingClue = parserDao.getPasringClue(ParserConstants.SITE_NAME_CRIAGSLIST);

		craigslistFileReader.init(parsingClue);
		craigslistFileReader.setFileFullPathAndName("C:\\temp\\CraigsList-nvaFebruary_54_2019_14_18_42.html");
		craigslistFileReader.read();
	}

	@Test
	public void testDoorstepsFileReader(){
		ParsingClue parsingClue = parserDao.getPasringClue(ParserConstants.SITE_NAME_CRIAGSLIST);
		doorstepsFileReader.init(parsingClue);
		doorstepsFileReader.setFileFullPathAndName("C:\\temp\\Doorsteps-Herndon-VAFebruary_54_2019_14_19_03.html");
		doorstepsFileReader.read();
	}
}
