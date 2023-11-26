package web_api_client;

import config.BaseConfig;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import models.User;
import static io.restassured.RestAssured.given;

public class UserClient extends Client {

    private final String REGISTER_PATH = BaseConfig.REGISTER_PATH;
    private final String LOGIN_PATH = BaseConfig.LOGIN_PATH;
    private final String USER_PATH = BaseConfig.USER_PATH;

    @Step("Создание пользователя")
    public ValidatableResponse create(User user) {
        return given()
                .spec(getSpec())
                .body(user)
                .when()
                .post(REGISTER_PATH)
                .then();
    }

    @Step("Авторизация пользователя")
    public ValidatableResponse login(User user) {
        return given()
                .spec(getSpec())
                .body(user)
                .when()
                .post(LOGIN_PATH)
                .then();
    }

    @Step("Удаление пользователя")
    public ValidatableResponse delete(String accessToken) {
        return given()
                .spec(getSpec())
                .header("Authorization", accessToken)
                .when()
                .delete(USER_PATH)
                .then();
    }
    @Step("Обновление данных авторизированного пользователя")
    public ValidatableResponse updateAuthorizedUser(String accessToken, User user) {
        return given()
                .spec(getSpec())
                .header("Authorization", accessToken)
                .body(user)
                .when()
                .patch(USER_PATH)
                .then();
    }

    @Step("Обновление данных неавторизированного пользователя")
    public ValidatableResponse updateUnauthorizedUser(User user) {
        return given()
                .spec(getSpec())
                .body(user)
                .when()
                .patch(USER_PATH)
                .then();
    }
}
