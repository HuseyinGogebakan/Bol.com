package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ArticleSearchPage {



    public SelenideElement articleNotFound(){
       return  $(By.xpath("//div[@data-test='no-result-content']"));
    }
    public SelenideElement firstArticle(){
         return  $(By.xpath("(//a[@aria-label='In winkelwagen'])[1]"));
    }

    public SelenideElement closeArticlePopUp(){
        return  $(By.xpath("//div[@data-test='modal-window-close']"));
    }

    public  String firstElementTitle(){
        return $(By.xpath("(//a[@data-list-page-product-click-location='title'])[1]")).getText();
    }
    public String addToBasket(){
        firstArticle().click();

        closeArticlePopUp().shouldBe(Condition.visible);
        String article_name = $(By.xpath("//p[@class='add-on-page-header__message']")).getText();
        closeArticlePopUp().click();
        return article_name;
    }

    public void closeArticlePopUpWindow(){

    }
}
