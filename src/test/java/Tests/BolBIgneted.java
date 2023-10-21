package Tests;

import Pages.ArticleSearchPage;
import Pages.BasketPage;
import Pages.BolHeader;
import Pages.CookiesPopup;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BolBIgneted {

    private  static  List<String> addedProducts = new ArrayList<>();

    @BeforeTest
    public void prerequisite() throws InterruptedException {
        Driver.setup();
       String current =  WebDriverRunner.getWebDriver().getCurrentUrl();

        Assert.assertEquals(current, ConfigurationReader.getProperty("url"),"Driver lead to a wrong page!");

        CookiesPopup cookies = new CookiesPopup();
        // I consider that  default timeout value is enough
        cookies.cookiesAcceptButton().shouldBe(Condition.visible);

        cookies.clickAcceptCookies();
        cookies.resumeButton().shouldBe(Condition.visible);
        cookies.clickBelgiumLocation();
        cookies.clickLanguageDutch();
        cookies.clickresumeCookies();
        cookies.resumeButton().shouldBe(Condition.disappear);
        
    }
    @Test(priority = 1,dataProvider = "articles")
    public void searchArticleAndAdd(String searchKeyWord){
        BolHeader head =  new BolHeader();
        ArticleSearchPage article = new ArticleSearchPage();
        boolean flagfounded = false;
        while (!flagfounded){
            flagfounded = true;
            head.searchItem(searchKeyWord);
             try{
                 article.firstArticle().shouldBe(Condition.visible);
                 article.articleNotFound().shouldBe(Condition.disappear);
             }
             catch (Exception e){
                 System.out.println("the random article couldnt find lets try something else ... ");
                 flagfounded = false;
                 searchKeyWord = Faker.instance().book().title();

             }

            addedProducts.add(article.addToBasket());

        }
    }




    @Test(priority = 2)
    public void  verifyArticle(){
//        System.out.println(addedProducts);
        BolHeader header = new BolHeader();
        header.goToBasket();

        BasketPage basket = new BasketPage();
        basket.basketTitle().shouldBe(Condition.visible);
        Assert.assertTrue(addedProducts.get(0).contains(basket.addedItemString(1)) || basket.addedItemString(1).contains(addedProducts.get(0)),"wrong item added");
        Assert.assertTrue(addedProducts.get(1).contains(basket.addedItemString(2)) || basket.addedItemString(2).contains(addedProducts.get(1)),"wrong item added");

        Driver.teardown();

    }


    @DataProvider(name = "articles")
    public Object[][] articles() {
        return new Object[][] {{Faker.instance().book().title()}, {Faker.instance().book().title()}};


    }
}
