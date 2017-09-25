package hello.domain.model.user

import hello.domain.fundamental.user.*
import lombok.ToString

@ToString
class User(val userIdentifierNumber: UserIdentifierNumber,
           val userIdentifierName: UserIdentifierName,
           val userMailAddress: UserMailAddress,
           val userFirstName: UserFirstName,
           val userLastName: UserLastName) {
}