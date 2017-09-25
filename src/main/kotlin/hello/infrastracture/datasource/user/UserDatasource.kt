package hello.infrastracture.datasource.user

import hello.domain.model.user.User
import hello.domain.model.user.UserRepository
import hello.domain.model.user.Users
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UserDatasource(@Autowired private val userMapper: UserMapper) : UserRepository {
    override fun list(): Users {
        return Users(userMapper.findAll().map { it.toUser() })
    }

    override fun register(user: User) {
        userMapper.insert(user)
    }
}