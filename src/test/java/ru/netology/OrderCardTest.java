package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class OrderCardTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    public void shouldReturnSuccessfullyForm() {

        $(".form_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("Новикова Ирина");
        $("[data-test-id=phone] input").setValue("+79101234567");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена!"));
    }

}
