package com.hg.prenotami;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.ReCaptcha;
import examples.ReCaptchaV2Example;

public class TwoCaptchaFacade {
    public static final String TWO_CAPTCHA_AP_KEY = "8fb3ebf0f95738d5b54f884e88d36ba7";

    public void resolve(String dataSiteKey, String dataSiteUrl){
        TwoCaptcha solver = new TwoCaptcha(TWO_CAPTCHA_AP_KEY);
        ReCaptcha captcha = new ReCaptcha();
        captcha.setSiteKey(dataSiteKey);
        captcha.setUrl(dataSiteUrl);

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception var4) {
            System.out.println("Error occurred: " + var4.getMessage());
        }
//        captcha.setInvisible(true);
//        captcha.setAction("verify");
//        captcha.setProxy("HTTPS", "login:password@IP_address:PORT");
    }
}
