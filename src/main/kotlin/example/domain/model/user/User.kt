package example.domain.model.user

import example.domain.fundamental.user.*
import lombok.ToString

@ToString
class User(val userIdentifierNumber: UserIdentifierNumber,
           val userIdentifierName: UserIdentifierName,
           val userMailAddress: UserMailAddress,
           val userPassword: UserPassword,
           val userFirstName: UserFirstName,
           val userLastName: UserLastName) {
}