package com.example.hw4part7.Controller;

import com.example.hw4part7.Util.RandomString;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RandomstrController {
    ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    @RequestMapping("/randomstr")
    public ModelAndView getString() {

        ModelAndView modelAndView = new ModelAndView("random-string");
        RandomString randomStringUtil = context.getBean("RandomString", RandomString.class);
        System.out.println("18 line Bean is " + randomStringUtil);
        modelAndView.addObject("message", randomStringUtil.generate());
        return modelAndView;
    }
}
