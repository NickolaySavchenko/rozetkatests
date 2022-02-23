package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
  private final By cartButton = By.xpath("//*[@href='#icon-header-basket']/../..");
  private final By cartHeader = By.cssSelector(".cart-dummy .cart-dummy__heading");
  private final By loginFormButton = By.xpath("//*[@href='#icon-user-simple']/../..");
  private final By loginField = By.xpath("//*[@formcontrolname='login']");
  private final By passwordField = By.xpath("//*[@formcontrolname='password']");
  private final By registrationButton = By.cssSelector("button.auth-modal__register-link");
  private final By nameRegisterFormField = By.xpath("//*[@formcontrolname='name']");
  private final By surnameRegisterFormField = By.xpath("//*[@formcontrolname='surname']");
  private final By phoneNumberRegisterFormField = By.xpath("//*[@formcontrolname='phone']");
  private final By emailAddressRegisterFormField = By.xpath("//*[@formcontrolname='email']");
  private final By passwordRegisterFormField = By.xpath("//*[@formcontrolname='password']");
  private final By restorePasswordButton = By.cssSelector(".link-dotted.auth-modal__restore-link");
  private final By validationErrorMessage = By.cssSelector(".validation-message .ng-star-inserted");
  private final By phoneNumberField = By.cssSelector("#registerUserPhone");
  private final By faceBookIcon = By.cssSelector(".auth-modal__social-buttons .auth-modal__social-button_type_facebook");
  private final By googleIcon = By.xpath("//*[@href=\"#icon-google-colored\"]/../..");
  private final By listMenuItems = By.cssSelector(".side-menu__list .side-menu__item");
  private final By menuNavigator = By.cssSelector("*[aria-label='Открыть меню']");
  private final By langButton = By.cssSelector(".lang-header .lang__link");

  @Step("Открыть Корзину")
  public MainPage openTheCart() {
    $(cartButton).should(Condition.enabled).click();
    return this;
  }

  @Step("Открыть страницу авторизации")
  public MainPage openTheAuthForm() {
    $(loginFormButton).should(Condition.enabled).click();
    return this;
  }

  @Step("Проверка что корзина пуста,и текст {text} отображается")
  public MainPage verifyThatCardHaveHeaderText(String text) {
    $(cartHeader).shouldBe(Condition.visible);
    Assert.assertEquals($(cartHeader).getText(), text);
    return this;
  }

  @Step("Проверка что Email и Password поля отображаются на форме логин")
  public MainPage checkThatEmailAndPasswordFieldIsDisplayed() {
    $(loginField).shouldBe(Condition.visible);
    $(passwordField).shouldBe(Condition.visible);
    return this;
  }

  @Step("Открыть форму регистрации")
  public MainPage openTheRegisterForm() {
    $(registrationButton).shouldBe(Condition.visible).click();
    return this;
  }

  @Step("Проверить что поля формы регистрации отображаются")
  public MainPage checkThatRegistrationFieldsIsDisplayed() {
    $(nameRegisterFormField).shouldBe(Condition.visible);
    $(surnameRegisterFormField).shouldBe(Condition.visible);
    $(phoneNumberRegisterFormField).shouldBe(Condition.visible);
    $(emailAddressRegisterFormField).shouldBe(Condition.visible);
    $(passwordRegisterFormField).shouldBe(Condition.visible);
    return this;
  }

  @Step("Открыть форму восстановление пароля")
  public MainPage openTheRestorePasswordForm() {
    $(restorePasswordButton).shouldBe(Condition.visible).click();
    return this;
  }

  @Step("Проверить что поле Эл. почта отображается на форме восстановления пароля")
  public MainPage checkThatEmailFieldIsDisplayedOnRestorePasswordForm() {
    $(loginField).shouldBe(Condition.visible);
    return this;
  }

  @Step("Проверить что ошибка валидации отображается под полем Имя")
  public MainPage checkThatValidationErrorIsShownInNameField(String text) {
    $(nameRegisterFormField).shouldBe(Condition.visible).sendKeys("Test");
    $(validationErrorMessage).shouldBe(Condition.visible);
    Assert.assertEquals($(validationErrorMessage).getText(), text);
    return this;
  }

  @Step("Проверка отображения маски +380 на форме регистрации")
  public MainPage checkPhoneCodeIsShownInRegistationForm() {
    $(phoneNumberField).shouldBe(Condition.visible);
    String value = $(phoneNumberField).getValue();
    Assert.assertEquals(value, "+380");
    return this;
  }

  @Step("Проверка отображения пароль после нажатия кнопки показать пароль")
  public MainPage checkThatPasswordIsShownAfterClickInShowPasswordButton() {
    $(passwordField).shouldBe(Condition.visible).sendKeys("Test");
    $(".button_type_link.form__toggle-password").shouldBe(Condition.visible).click();
    String actualValue = $(passwordField).getValue();
    Assert.assertEquals(actualValue, "Test");
    return this;
  }

  @Step("Проверка что Кнопка войти через фейсбук отображается на форме логин")
  public MainPage checkThatFaceBookShowInLoginPage() {
    $(faceBookIcon).shouldBe(Condition.visible);
    return this;
  }

  @Step("Проверка что Кнопка войти через фейсбук отображается на форме логин")
  public MainPage checkThatGoogleShowInLoginPage() {
    $(googleIcon).shouldBe(Condition.visible);
    return this;
  }

  @Step("Проверить кнопка каталог товаров отображается в меню")
  public MainPage catalogButtonIsShownInMenu() {
    $(menuNavigator).shouldBe(Condition.visible).click();
    $$(listMenuItems).get(0).shouldHave(Condition.text("Каталог товаров"));
    return this;
  }

  @Step("Проверить кнопка Корзина товаров отображается в меню")
  public MainPage cartButtonIsShownInMenu() {
    $(menuNavigator).shouldBe(Condition.visible).click();
    $$(listMenuItems).get(1).shouldHave(Condition.text("Корзина"));
    return this;
  }

  @Step("Проверить кнопка скачивания приложения в Google Pay отображается")
  public MainPage googlePayApp() {
    $(menuNavigator).shouldBe(Condition.visible).click();
    $("*[alt='Google Play']").shouldBe(Condition.visible);
    return this;
  }

  @Step("Проверить кнопка скачивания приложения в Google Pay отображается")
  public MainPage appStoreApp() {
    $(menuNavigator).shouldBe(Condition.visible).click();
    $("*[alt='AppStore']").shouldBe(Condition.visible);
    return this;
  }

  @Step("Проверить первая кнопка смены языка имеет текст RU")
  public MainPage changeLangButtonShownRU() {
    $$(langButton).get(0).shouldHave(Condition.text("RU"));
    return this;
  }

  @Step("Проверить кнопка скачивания приложения в Google Pay отображается")
  public MainPage changeLangButtonShownUA() {
    $$(langButton).get(1).shouldHave(Condition.text("UA"));
    return this;
  }

}


