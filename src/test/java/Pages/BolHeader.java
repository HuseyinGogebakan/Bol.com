package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BolHeader {


    public SelenideElement searchInput(){
        return $("#searchfor");
    }

    public SelenideElement basketIcon(){
        return $("#basket");
    }

    public void searchItem(String article){
        searchInput().setValue(article).pressEnter();
    }
    public void goToBasket(){
        basketIcon().click();
    }
}
