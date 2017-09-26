package example.infrastracture.datasource.user

import example.domain.fundamental.user.UserIdentifierName
import example.domain.fundamental.user.UserMailAddress
import example.domain.model.user.User
import example.domain.model.user.UserRepository
import example.domain.model.user.Users
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UserDatasource(@Autowired private val userMapper: UserMapper) : UserRepository {
    override fun isExists(userIdentifierName: UserIdentifierName): Boolean {
        if (userMapper.findByUserIdentifyName(userIdentifierName) == null) return false
        return true
    }

    override fun isExists(userMailAddress: UserMailAddress): Boolean {
        if (userMapper.findByUserMailAddress(userMailAddress) == null) return false
        return true
    }

    override fun list(): Users {
        return Users(userMapper.findAll().map { it.toUser() })
    }

    override fun register(user: User) {
        userMapper.insert(user)
    }
}