package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

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
    $(".auth-modal__social-buttons .auth-modal__social-button_type_facebook").shouldBe(Condition.visible);
    return this;
  }

  @Step("Проверка что Кнопка войти через фейсбук отображается на форме логин")
  public MainPage checkThatGoogleShowInLoginPage() {
    $x("//*[@href=\"#icon-google-colored\"]/../..").shouldBe(Condition.visible);
    return this;
  }

}


