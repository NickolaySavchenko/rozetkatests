import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static constans.Urls.BASE_URL_ROZETKA;

public class RozetkaTests {
  @Test
  @Description("Проверка что корзина без добавления товаров пуста")
  public void checkThatCartIsEmpty() {
    open(BASE_URL_ROZETKA);
    new MainPage()
            .openTheCart()
            .verifyThatCardHaveHeaderText("Корзина пуста");
  }

  @Test
  @Description("Проверка что поля Логин и Пароль отображаються на форме логина")
  public void checkThatLoginFormHaveLoginAndPasswordFields() {
    open(BASE_URL_ROZETKA);
    new MainPage()
            .openTheAuthForm()
            .checkThatEmailAndPasswordFieldIsDisplayed();

  }

  @Test
  @Description("Проверка что Поля Формы регистрации отображаються на форме")
  public void checkRegistrationForm() {
    open(BASE_URL_ROZETKA);
    new MainPage()
            .openTheAuthForm()
            .openTheRegisterForm()
            .checkThatRegistrationFieldsIsDisplayed();
  }

  @Test
  @Description("Проверка что Поля Формы восстановления Пароля отображаються на форме")
  public void checkRestorePasswordForm() {
    open(BASE_URL_ROZETKA);
    new MainPage()
            .openTheAuthForm()
            .openTheRestorePasswordForm()
            .checkThatEmailFieldIsDisplayedOnRestorePasswordForm();
  }

  @Test
  @Description("Проверка что Ошибка Валидации отображается под полем имя")
  public void checkThatValidationErrorIsShownInNameField() {
    open(BASE_URL_ROZETKA);
    new MainPage()
            .openTheAuthForm()
            .openTheRegisterForm()
            .checkThatValidationErrorIsShownInNameField("Введите свое имя на кириллице");
  }

  @Test
  @Description("Маска кода номера телефона +380 отображается на форме регистрации")
  public void checkThatPhoneNumberHasACountryCodeInRegisterField() {
    open(BASE_URL_ROZETKA);
    new MainPage()
            .openTheAuthForm()
            .openTheRegisterForm()
            .checkPhoneCodeIsShownInRegistationForm();
  }

  @Test
  @Description("Проверка Отображения пароля просле нажатия на кнопку показать пароль")
  public void checkThatPasswordIsShowIfUserClickTheShowPasswordButton() {
    open(BASE_URL_ROZETKA);
    new MainPage()
            .openTheAuthForm()
            .checkThatPasswordIsShownAfterClickInShowPasswordButton();
  }

  @Test
  @Description("Проверка Отображения пароля просле нажатия на кнопку показать пароль")
  public void checkThatFacebookLoginButtonIsShown() {
    open(BASE_URL_ROZETKA);
    new MainPage()
            .openTheAuthForm()
            .checkThatFaceBookShowInLoginPage();
  }

  @Test
  @Description("Проверка Отображения пароля просле нажатия на кнопку показать пароль")
  public void checkThatGoogleLoginButtonIsShown() {
    open(BASE_URL_ROZETKA);
    new MainPage()
            .openTheAuthForm()
            .checkThatGoogleShowInLoginPage();
  }

}
