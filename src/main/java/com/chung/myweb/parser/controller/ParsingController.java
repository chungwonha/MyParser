package com.chung.myweb.parser.controller;

import com.chung.myweb.parser.service.CraigslistParsingService;
import com.chung.myweb.parser.service.DoorstepsParsingService;
import com.chung.myweb.parser.service.RealtorcomParsingService;
import com.chung.myweb.parser.util.ParserConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("parser")
public class ParsingController {
    Logger logger = LoggerFactory.getLogger(ParsingController.class);

    @Autowired
    CraigslistParsingService craigslistParsingService;

    @Autowired
    DoorstepsParsingService doorstepsParsingService;

    @Autowired
    RealtorcomParsingService realtorcomParsingService;

    /*
        TODO: alot more room to improve to make this controller more dynamically and seamlessly work with various requests.
     */
    @RequestMapping("parse")
    public String parse(@RequestParam String siteName){
        logger.debug("parse: "+siteName);
        if(ParserConstants.SITE_NAME_CRIAGSLIST.equals(siteName)) {
            this.craigslistParsingService.parse();
        }else if(ParserConstants.SITE_NAME_DOORSTEP.equals(siteName)){
            this.doorstepsParsingService.parse();
        }else if(ParserConstants.SITE_NAME_REALTORCOM.equals(siteName)){
            this.realtorcomParsingService.parse();
        }
        return "parse";
    }

}
