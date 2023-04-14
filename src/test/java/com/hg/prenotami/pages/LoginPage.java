package com.hg.prenotami.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class LoginPage extends BasePage {

    public static final String CLASS="LoginPage";

    @FindBy(css="input[id=login-email]")
    public WebElement txtLoginMail;

    @FindBy(id ="login-password")
    public WebElement txtLoginPwd;

    @FindBy(css="button[type=submit]")
    public WebElement btnSumbit;

    public void Login(String userName, String password) throws Exception {
        System.out.println(LOG(CLASS+BREADCRUM+"Login", START));
        System.out.println("Sending login keys...");
        takeSnapShot(getWebDriverInstace(), "pre-login.png");
        txtLoginMail.sendKeys(userName);
        txtLoginPwd.sendKeys(password);
        String attrClass = btnSumbit.getAttribute("class");
        System.out.println(LOG(CLASS+BREADCRUM+"Login","btnSubmit : "+attrClass));
        removeAttr(getWebDriverInstace(),btnSumbit);
        System.out.println(LOG(CLASS+BREADCRUM+"Login","Driver.PageSource : "+getWebDriverInstace().getPageSource()));
        System.out.println(LOG(CLASS+BREADCRUM+"Login", END));
    }

    public UserAreaPage ClickLogin()
    {
        System.out.println(LOG(CLASS+BREADCRUM+"ClickLogin", START));
        System.out.println("Trying login");
        btnSumbit.click();
        System.out.println("Login Done!!!");
        System.out.println(LOG(CLASS+BREADCRUM+"ClickLogin", END));
        return new UserAreaPage(super.Driver);
    }



}
