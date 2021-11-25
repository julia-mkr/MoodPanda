package pages;

import static com.codeborne.selenide.Selenide.$;

public class MoodUpdatedModalPage {

    public static final String GO_TO_MY_DIARY = ".ButtonMyDiary";
    public static final String DONE_BUTTON = ".ButtonOk.btn-dsm";

    public MyDiaryPage clickOnGoToMyDiaryButton() {
        $(GO_TO_MY_DIARY).click();
        return new MyDiaryPage();
    }
    public void clickOnDoneButton() {
        $(DONE_BUTTON).click();
    }
}
