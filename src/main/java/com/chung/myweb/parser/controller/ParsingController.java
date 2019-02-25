package com.chung.myweb.parser.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("parser")
public class ParsingController {
    Logger logger = LoggerFactory.getLogger(ParsingController.class);

    @RequestMapping("parse")
    public String parse(){
        logger.debug("parse this");
        return "parse";
    }

}
