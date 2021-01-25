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
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldReturnErrorIfInvalidName() {

        $(".form_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("Andrey");
        $("[data-test-id=phone] input").setValue("+79101234567");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $(".input_type_text .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void shouldReturnErrorIfInvalidTel() {

        $(".form_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("Новикова Ирина");
        $("[data-test-id=phone] input").setValue("4843277");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $(".input_type_tel .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

    }

    @Test
    public void shouldReturnErrorIfFieldNameIsEmpty() {
        $(".form_theme_alfa-on-white");
        $("[data-test-id=name] input").setValue("");
        $("[data-test-id=phone] input").setValue("+79101234567");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $(".input_type_text .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }
}
