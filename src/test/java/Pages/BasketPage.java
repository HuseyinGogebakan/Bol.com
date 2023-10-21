package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasketPage {


    public SelenideElement basketTitle(){
        return $(By.xpath("//h1[@class='bol_header']"));
    }

    private SelenideElement basketaddedItemSpecific(Integer index){
        return  $(By.xpath("((//div[@data-testid='item-row'])["+index+"]//a)[2]"));
    }
    public  String addedItemString(Integer index){
      return   basketaddedItemSpecific(index).getText();
    }
}
