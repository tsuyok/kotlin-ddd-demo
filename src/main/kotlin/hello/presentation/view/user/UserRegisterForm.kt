package hello.presentation.view.user

import hello.domain.fundamental.user.*
import hello.domain.model.user.User
import lombok.ToString

@ToString
class UserRegisterForm(var userIdentifierName: String,
                       var userMailAddress: String,
                       var userFirstName: String,
                       var userLastName: String) {
    constructor() : this("", "", "", "")

    fun toUser(): User {
        return User(
                UserIdentifierNumber(null),
                UserIdentifierName(userIdentifierName),
                UserMailAddress(userMailAddress),
                UserFirstName(userFirstName),
                UserLastName(userLastName)
        )
    }
}