package Steps;

import pages.MainPage;


public class MainPageSteps {
    MainPage mainPage;

    public MainPageSteps(MainPage mainPage) {
        this.mainPage = mainPage;
    }

   
    public void clickOrderButtonFromHeader() {
        mainPage.clickOrderButton();
    }

   
    public void clickOrderButtonAndCloseCookiesPopup() {
        mainPage.clickToSecondOrderButton();
    }

   
    public void scrollToBottomOfPage() {
        mainPage.scrollDownToBottom();
    }

    
    public boolean checkFaqAnswerPar(String questionLocator, String expectedAnswerText) {
        return mainPage.verifyFaqAnswer(questionLocator, expectedAnswerText);
    }

    
    public void clickOnScooterLogo(){
        mainPage.clickToScooterLogo();
    }

   
    public void verifyFaqTextDisplayed(){
        mainPage.isFaqTextDisplayed();
    }

}

