package hello.domain.model.user

interface UserRepository {
    fun register(user: User)
    fun list() : Users
}