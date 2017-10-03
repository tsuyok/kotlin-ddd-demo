package example.infrastracture.datasource.user

import example.domain.fundamental.user.*
import example.domain.model.user.User

data class UserRecordDTO(val userIdentifierNumber: Int,
                    val userIdentifierName: String,
                    val userMailAddress: String,
                    val userFirstName: String,
                    val userLastName: String){
    fun toUser(): User {
        return User(UserIdentifierNumber(this.userIdentifierNumber),
                UserIdentifierName(this.userIdentifierName),
                UserMailAddress(this.userMailAddress),
                UserFirstName(this.userFirstName),
                UserLastName(this.userLastName))
    }
}