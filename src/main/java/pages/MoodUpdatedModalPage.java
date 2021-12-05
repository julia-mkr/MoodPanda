package pages;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class MoodUpdatedModalPage extends BasePage {

    public static final String GO_TO_MY_DIARY = ".ButtonMyDiary";
    public static final String DONE_BUTTON = ".ButtonOk.btn-dsm";

    public MyDiaryPage clickOnGoToMyDiaryButton() {
        log.info("Click on the 'Go to my diary' button on the 'Mood Updated' modal");
        $(GO_TO_MY_DIARY).click();
        return new MyDiaryPage();
    }
    public void clickOnDoneButton() {
        log.info("Click on the 'Done' button on the 'Mood Updated' modal");
        $(DONE_BUTTON).click();
    }
}
