package com.hg.prenotami;

import com.hg.prenotami.pages.UserAreaPage;
import com.hg.prenotami.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import java.util.List;

import static com.hg.prenotami.pages.BasePage.WAITING_TIME;

@SpringBootTest(classes = SpringStartApplication.class)
@Profile("second")
class SpringStartApplicationTests {

	@Autowired
	private LoginPage loginPage;


	@Value("${app.url}")
	private String appUrl;

	@Value("${login.mail}")
	private String loginMail;

	@Value("${login.pwd}")
	private String loginPwd;

	@Value("chrome,firefox,edge")
	private List<String> browsers;

	@Value("testing")
	private String environment;

	@Test
	void justLoginTest() throws Exception {
		System.out.println(appUrl);
		loginPage.Navigate(appUrl);
		loginPage.Login(loginMail, loginPwd);
		UserAreaPage homePage = loginPage.ClickLogin();
		homePage.sayHello();
	}

	@Test
	void contextLoads2() {
		System.out.println(appUrl);
//		homePage.Navigate(appUrl);
//		homePage.ClickLogin();
//		loginPage.Login("admin", "password");
//		loginPage.ClickLogin();
	}


	@Test
	void contextLoads3() {
		System.out.println(appUrl);
//		homePage.Navigate(appUrl);
//		homePage.ClickLogin();
//		loginPage.Login("admin", "password");
//		loginPage.ClickLogin();
	}


	@Test
	@Profile("!qa")
	void contextLoads() {


		System.out.println(appUrl);
//		homePage.Navigate(appUrl);
//		homePage.ClickLogin();
//		loginPage.Login("admin", "password");
//		loginPage.ClickLogin();
	}

}
