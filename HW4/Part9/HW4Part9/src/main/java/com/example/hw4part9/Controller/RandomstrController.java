package com.example.hw4part9.Controller;

import com.example.hw4part9.Util.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RandomstrController {
    // ApplicationContext context =
    //         new ClassPathXmlApplicationContext("applicationContext.xml");

    @Autowired
    @Qualifier("randomStringProxy")
    private RandomString randomStringUtil;

    @RequestMapping("/randomstr")
    public ModelAndView getString() {
        ModelAndView modelAndView = new ModelAndView("random-string");
        // RandomString randomStringUtil = context.getBean("RandomString", RandomString.class);
        System.out.println("[RandomstrController] Get Bean which is " + randomStringUtil);  // Test Result: Use same the object in diff requests
        modelAndView.addObject("message", randomStringUtil.generate());
        return modelAndView;
    }
}
