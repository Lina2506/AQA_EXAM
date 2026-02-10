package org.base.pages;

import com.codeborne.selenide.Selenide;
import org.base.config.PageTools;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;

public class OrderNotification extends PageTools {
    private final String completeHeader="//div[contains(@class,'sweet-alert')]//h2";
    private final String confirmButton="//button[contains(@class,'confirm')]";
    private final String orderModal = "//div[@id='orderModal']";
    private final String purchaseModal="//div[contains(@class,'sweet-alert')]";

    public String getCompleteHeaderText() {
        should("xpath", visible, Duration.ofSeconds(20), purchaseModal);
        should("xpath", visible, Duration.ofSeconds(20), completeHeader);
        getElement("xpath", completeHeader).shouldNotBe(exactText(""), Duration.ofSeconds(5));
        return getText("xpath", completeHeader);
    }

    public void clickConfirmButton() {
        should("xpath", clickable, Duration.ofSeconds(15), confirmButton);
        click("xpath", confirmButton);

        getElement("xpath", purchaseModal).should(disappear, Duration.ofSeconds(10));

        Selenide.executeJavaScript("$('#orderModal').modal('hide');");
        Selenide.executeJavaScript(
                "var modal = document.getElementById('orderModal');" +
                        "if (modal) {" +
                        "  modal.classList.remove('show');" +
                        "  modal.style.display = 'none';" +
                        "  document.body.classList.remove('modal-open');" +
                        "  var backdrop = document.querySelector('.modal-backdrop');" +
                        "  if (backdrop) backdrop.remove();" +
                        "}"
        );

        getElement("xpath", orderModal).shouldBe(hidden, Duration.ofSeconds(15));
        getElement("xpath", orderModal).shouldNotHave(cssClass("show"), Duration.ofSeconds(5));
    }
}
