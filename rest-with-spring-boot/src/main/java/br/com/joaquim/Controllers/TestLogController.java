package br.com.joaquim.Controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/test/v1")
public class TestLogController {

    private final Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());


    public String testLog() {
        logger.debug("This is a teste log mensage");
        logger.info("This is an info log mensage");
        logger.warn("This is a teste log mensage");
        logger.error("This is an error log mensage");
        return "Test log";
    }
}
