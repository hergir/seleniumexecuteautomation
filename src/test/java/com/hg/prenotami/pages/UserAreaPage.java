package com.hg.prenotami.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
public class UserAreaPage extends BasePage {

    public static final String CLASS="UserAreaPage";

    public UserAreaPage(WebDriver webDriver) {
        System.out.println(LOG(CLASS+BREADCRUM, START));
        super.Driver = webDriver;
        System.out.println(LOG(CLASS+BREADCRUM, END));
    }

    public void sayHello() throws Exception {
        System.out.println(LOG(CLASS+BREADCRUM+"sayHello", START));
        System.out.println("Hello from HomePage.sayHello()");
        takeSnapShot(getWebDriverInstace(), "login.png");
        System.out.println(LOG(CLASS+BREADCRUM+"sayHello", END));
    }
}
