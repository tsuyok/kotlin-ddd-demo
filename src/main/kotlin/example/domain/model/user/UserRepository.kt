package example.domain.model.user

import example.domain.fundamental.user.UserIdentifierName
import example.domain.fundamental.user.UserMailAddress

interface UserRepository {
    fun register(user: User)
    fun list(): Users
    fun isExists(userIdentifierName: UserIdentifierName): Boolean
    fun isExists(userMailAddress: UserMailAddress): Boolean
}