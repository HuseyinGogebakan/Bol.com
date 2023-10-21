package Pages;

import Utilities.ConfigurationReader;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CookiesPopup {



    public SelenideElement cookiesAcceptButton (){
        return  $("#js-first-screen-accept-all-button");
    }


    public SelenideElement belgiumLocationSelectionSpan(){
      return $(By.xpath("//span[@class='c-radio__label js-country-belgium']"));
    }


    public SelenideElement languageDutchSpan(){
        return  $(By.xpath("(//span[@class='c-radio__label'])[1]"));
    }


    public SelenideElement resumeButton(){
        return $(By.xpath("//button[@data-test='continue-button']"));
    }


    public void  clickAcceptCookies(){ cookiesAcceptButton().click();}
    public void  clickLanguageDutch(){ languageDutchSpan().click();}
    public void  clickBelgiumLocation(){ belgiumLocationSelectionSpan().click();}
    public void  clickresumeCookies(){ resumeButton().click();}







}
