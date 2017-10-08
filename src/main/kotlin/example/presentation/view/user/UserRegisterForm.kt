package example.presentation.view.user

import example.domain.fundamental.user.*
import example.domain.model.user.User
import lombok.ToString
import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.NotBlank

@ToString
class UserRegisterForm {
    @NotBlank(message = "必ず入力してください")
    var userIdentifierName: String = ""

    @Email(message = "メールアドレスが正しくありません。")
    @NotBlank(message = "必ず入力してください")
    var userMailAddress: String = ""

    @NotBlank(message = "必ず入力してください")
    var userPassword: String = ""

    @NotBlank(message = "必ず入力してください")
    var userFirstName: String = ""

    @NotBlank(message = "必ず入力してください")
    var userLastName: String = ""

    fun toUser(): User {
        return User(
                UserIdentifierNumber(null),
                UserIdentifierName(userIdentifierName),
                UserMailAddress(userMailAddress),
                UserPassword(userPassword),
                UserFirstName(userFirstName),
                UserLastName(userLastName)
        )
    }
}