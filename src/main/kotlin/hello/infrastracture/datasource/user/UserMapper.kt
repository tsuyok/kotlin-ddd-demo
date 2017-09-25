package hello.infrastracture.datasource.user

import hello.domain.model.user.User
import org.apache.ibatis.annotations.*

@Mapper
interface UserMapper {
    @Insert("""
        INSERT INTO users (id, user_name, mail_address, first_name, last_name, created_at) VALUES
        (#{userIdentifierNumber.value}, #{userIdentifierName.value}, #{userMailAddress.value}, #{userFirstName.value}, #{userLastName.value}, now())
        """
    )
    fun insert(user: User)

    @Select("""
        SELECT id, user_name, mail_address, first_name, last_name
        FROM users
        """
    )
    fun findAll(): List<UserRecordDTO>
}
