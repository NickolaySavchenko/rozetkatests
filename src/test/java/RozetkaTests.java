import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static constans.Urls.BASE_URL_ROZETKA;
import static constans.Urls.CART;

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
  @Test
  @Description("Проверить кнопка каталог товаров отображается в меню")
  public void checkThatCatalogButtonIsShownInMenu() {
    open(BASE_URL_ROZETKA);
    new MainPage()
            .catalogButtonIsShownInMenu();
  }

  @Test
  @Description("Проверить кнопка Корзина отображается в меню")
  public void checkThatCartButtonIsShownInMenu() {
    open(BASE_URL_ROZETKA);
    new MainPage()
            .cartButtonIsShownInMenu();
  }
  @Test
  @Description("Проверить кнопка Google App отображается в корзине")
  public void googleAppIsShown() {
    open(CART);
    new MainPage()
            .googlePayApp();
  }
 @Test
  @Description("Проверить кнопка AppStore App отображается в корзине")
  public void appleAppIsShown() {
    open(CART);
    new MainPage()
            .appStoreApp();
  }
  @Test
  @Description("Проверить Первой кнопкой смены языка должна быть RU")
  public void firstButtonChangeLangShouldBeRU() {
    open(CART);
    new MainPage()
            .changeLangButtonShownRU();
  }
  @Test
  @Description("Проверить Второй кнопкой смены языка должна быть UA")
  public void secondButtonChangeLangShouldBeUA() {
    open(CART);
    new MainPage()
            .changeLangButtonShownUA();
  }

}
