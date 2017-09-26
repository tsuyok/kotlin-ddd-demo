package example.presentation.view.user

import example.domain.fundamental.user.UserIdentifierName
import example.domain.fundamental.user.UserMailAddress
import example.domain.model.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.validation.BindingResult

@Component
class UserRegisterValidation(@Autowired private val userRepository: UserRepository) {

    fun validate(userRegisterForm: UserRegisterForm, result: BindingResult): Boolean {
        if (result.hasErrors()) return false;

        if (userRepository.isExists(UserIdentifierName(userRegisterForm.userIdentifierName)))
            return alreadyExists("userIdentifierName", userRegisterForm.userIdentifierName, result)

        if (userRepository.isExists(UserMailAddress(userRegisterForm.userMailAddress)))
            return alreadyExists("userMailAddress", userRegisterForm.userMailAddress, result)

        return true
    }

    private fun alreadyExists(rejectedPath: String, value: String, result: BindingResult): Boolean {
        val messageKey = "error.id.already.exists"
        val arguments = arrayOf<Any>(value)
        val defaultMessage = "{0}は登録済みです"
        result.rejectValue(rejectedPath, messageKey, arguments, defaultMessage)
        return false
    }
}